package com.kecq.data;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EntityHelper {

	private static Object Cast(Class<?> type, ResultSet rs,int index)
			throws ParseException, SQLException {
		if (type == int.class) {
			return  rs.getInt(index);
		}

		if (type == double.class) {
			return rs.getDouble(index);
		}

		if (type == String.class) {
			return rs.getString(index);
		}

		if (type == Date.class) {
		  //return rs.getDate(index);
		  
		  return rs.getTimestamp(index);
		}

		return rs.getObject(index);
	}

	
	public static <T> List<T> GetEntityList(Class<T> c,ResultSet rs)throws Exception
	{
		List<String> fields = new ArrayList<String>();
		for (Field field : c.getDeclaredFields()) {
			fields.add(field.getName());
		}

		List<String> methods = new ArrayList<String>();
		for (Method method : c.getMethods()) {
			methods.add(method.getName());
		}
		
		List<T> list=new ArrayList<T>();
		
		
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnCount = rsmd.getColumnCount();

		while (rs.next()) {
			T t = c.newInstance();

			for (int i = 1; i <= columnCount; i++) {
				String columnName = rsmd.getColumnName(i);
				if (fields.contains(columnName)) {
					Field f = c.getDeclaredField(columnName);
					// 权限修饰符
					int mo = f.getModifiers();
					String priv = Modifier.toString(mo);
					if (priv.equals("public")) {
						f.set(t, Cast(f.getType(), rs,i));
					}

					String methodEnd = "set"
							+ columnName.substring(0, 1).toUpperCase()
							+ columnName.substring(1);
					if (methods.contains(methodEnd)) {
						Method m = c.getMethod(methodEnd, f.getType());
						m.invoke(t, Cast(f.getType(), rs,i));
					}
				}

			}

			list.add(t);
		}

		return list;
	}
	
	public static <T> T getEntity(Class<T> c,ResultSet rs)  throws Exception
	{
		List<T> list=GetEntityList(c,rs);
		if(list.size()>0)
		{
			return list.get(0);
		}
		
		return null;
	}
	
	public static <T> T getEntity(Class<T> c, Object id, String tableName,
			String primary, IDbHelper db) throws Exception {

		String sql = "select * from " + tableName + " where " + primary + "=?   limit 0,1";
		ResultSet rs = db.GetResultSet(sql,id);
		
		T obj= getEntity(c,rs);
		db.closeResultSet(rs);
		
		return obj;
	}

	public static <T> int insert(T t, String tableName, String primary,
			Boolean isAddPrimary, IDbHelper db) throws Exception {
		Class<?> c = t.getClass();
		String sql = "insert into " + tableName + "(";
		String v = "";
		List<Object> vlist = new ArrayList<Object>();

		List<String> methods = new ArrayList<String>();
		for (Method method : c.getMethods()) {
			methods.add(method.getName());
		}

		// 取得本类的全部属性
		Field[] field = c.getDeclaredFields();
		for (int i = 0; i < field.length; i++) {
			String name = field[i].getName();
			if (isAddPrimary == false && name.equalsIgnoreCase(primary)) {
				continue;
			}

			sql += name + ",";
			v += "?,";

			Object value = null;
			// 权限修饰符
			int mo = field[i].getModifiers();
			String priv = Modifier.toString(mo);
			if (priv.equals("public")) {
				value = field[i].get(t);
			}

			String methodEnd = "get" + name.substring(0, 1).toUpperCase()
					+ name.substring(1);
			if (methods.contains(methodEnd)) {
				Method m = c.getMethod(methodEnd);
				value = m.invoke(t);
			}

			vlist.add(value);
		}

		sql = sql.substring(0, sql.length() - 1) + ")";
		v = v.substring(0, v.length() - 1);
		sql = sql + " values (" + v + ")";

		int result = db.execute(sql, vlist.toArray());

		return result;
	}

	private static Boolean isPrimary(String name, String... primary) {
		for (String s : primary) {
			if (s.equalsIgnoreCase(name)) {
				return true;
			}
		}

		return false;
	}

	public static <T> int update(T t, String tableName, IDbHelper db,
			String... primary) throws Exception {
		Class<?> c = t.getClass();
		String sql = "update  " + tableName + " set ";

		List<Object> vlist = new ArrayList<Object>();

		List<String> methods = new ArrayList<String>();
		for (Method method : c.getMethods()) {
			methods.add(method.getName());
		}

		String w = " where 1=1  ";

		// 取得本类的全部属性
		Field[] field = c.getDeclaredFields();
		for (int i = 0; i < field.length; i++) {
			String name = field[i].getName();
			if (isPrimary(name, primary)) {
				continue;
			}

			sql += name + "=?,";

			Object value = null;
			// 权限修饰符
			int mo = field[i].getModifiers();
			String priv = Modifier.toString(mo);
			if (priv.equals("public")) {
				value = field[i].get(t);
			}

			String methodEnd = "get" + name.substring(0, 1).toUpperCase()
					+ name.substring(1);
			if (methods.contains(methodEnd)) {
				Method m = c.getMethod(methodEnd);
				value = m.invoke(t);
			}

			vlist.add(value);
		}

		for (int i = 0; i < field.length; i++) {
			String name = field[i].getName();
			if (isPrimary(name, primary)) {
				w += " and " + name + "=?,";

				Object value = null;
				// 权限修饰符
				int mo = field[i].getModifiers();
				String priv = Modifier.toString(mo);
				if (priv.equals("public")) {
					value = field[i].get(t);
				}

				String methodEnd = "get" + name.substring(0, 1).toUpperCase()
						+ name.substring(1);
				if (methods.contains(methodEnd)) {
					Method m = c.getMethod(methodEnd);
					value = m.invoke(t);
				}

				vlist.add(value);
			}
		}

		w = w.substring(0, w.length() - 1);

		sql = sql.substring(0, sql.length() - 1);

		sql = sql + w;

		int result = db.execute(sql, vlist.toArray());

		return result;
	}

}
