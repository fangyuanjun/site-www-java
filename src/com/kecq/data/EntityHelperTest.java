package com.kecq.data;



public class EntityHelperTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
//		DataInfo info = new DataInfo();
//		info.setDirverName("com.mysql.jdbc.Driver");
//		info.setConStr("jdbc:mysql://localhost:3306/db_fyj?characterEncoding=utf-8");
//		info.setUsername("root");
//		info.setPassword("fangfang");
//		IDbHelper db = new DbHelper(info);
//
//		EntityHelperG<blog_tb_blog> h=new EntityHelperG<blog_tb_blog>(blog_tb_blog.class,"blog_tb_blog",true,db,"blogID");
//		
//		blog_tb_blog b = h.getEntity("222");
//
//	
//	
//		b.setBlogName("fyj3333");
//		int result = h.update(b);

		/*
		 * blog_tb_blog b=new blog_tb_blog(); blog_tb_blog i=
		 * EntityHelper.getEntity(blog_tb_blog.class);
		 * System.out.print(i.getblogName());
		 */
		// EntityHelper.insert(b);
		/*
		 * blog_tb_blog b = new blog_tb_blog(); Class<?> c = blog_tb_blog.class;
		 * 
		 * Method[] ms = c.getMethods(); for (Method m : ms) {
		 * System.out.println(m.getName()); }
		 * 
		 * Method m = c.getMethod("setAddress", String.class); m.invoke(b, "1");
		 */
		/*
		 * // 取得本类的全部属性 Field[] field = c.getDeclaredFields(); for (int i = 0; i
		 * < field.length; i++) { // 权限修饰符 int mo = field[i].getModifiers();
		 * String priv = Modifier.toString(mo); // 属性类型 Class<?> type =
		 * field[i].getType(); System.out.println(priv + " " + type.getName() +
		 * " " + field[i].getName() + ";");
		 * 
		 * 
		 * 
		 * PropertyDescriptor pd = new PropertyDescriptor(field[i].getName(),
		 * c); Method wM = pd.getWriteMethod();//获得写方法
		 * 
		 * if(field[i].getName().equals("blogID")) { wM.invoke(b, type.cast(1));
		 * }
		 * 
		 * }
		 */
	}

}
