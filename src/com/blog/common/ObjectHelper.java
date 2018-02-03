package com.blog.common;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class ObjectHelper {

	/**
	 * 从列表中查找忽略大小写的项 如果没有找到则返回null
	 * 
	 * @param list
	 * @param item
	 * @return
	 */
	private static String ListItem(List<String> list, String item) {
		for (String s : list) {
			if (s.equalsIgnoreCase(item)) {
				return s;
			}
		}

		return null;
	}

	public static void Copy(Object src, Object dest) throws Exception {
		if (src == null) {
			return;
		}

		Class<?> c = src.getClass();
		List<String> fields = new ArrayList<String>();
		for (Field field : c.getDeclaredFields()) {
			fields.add(field.getName());
		}

		List<String> methods = new ArrayList<String>();
		for (Method method : c.getMethods()) {
			methods.add(method.getName());
		}

		Class<?> d = dest.getClass();

		List<String> methods2 = new ArrayList<String>();
		for (Method method : d.getMethods()) {
			methods2.add(method.getName());
		}

		for (Field field : d.getDeclaredFields()) {
			// 如果源包含这个名称的字段
			String item = ListItem(fields, field.getName());
			if (item == null) {
				continue;
			}

			Object srcValue = null;
			Field f = c.getDeclaredField(item);
			// 权限修饰符
			int mo = f.getModifiers();
			String priv = Modifier.toString(mo);
			// 如果源字段可读
			if (priv.equals("public")) {
				srcValue = f.get(src);
			}

			String methodEnd = "get" + item.substring(0, 1).toUpperCase()
					+ item.substring(1);
			if (methods.contains(methodEnd)) {
				Method m = c.getMethod(methodEnd);
				srcValue = m.invoke(src);
			}

			if (srcValue == null) {
				continue;
			}

			
			// 如果目标字段可写
			if (Modifier.toString(field.getModifiers()).equals("public")) {
				field.set(dest, srcValue);
			}

			methodEnd = "set" + field.getName().substring(0, 1).toUpperCase()
					+ field.getName().substring(1);
			if (methods2.contains(methodEnd)) {
				Method m = d.getMethod(methodEnd, field.getType());
				m.invoke(dest, srcValue);
			}
		}
	}
}
