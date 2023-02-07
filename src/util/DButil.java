package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DButil {
	private static String jdbcDriver = "com.mysql.cj.jdbc.Driver";
	private static ReadProPerties rp = ReadProPerties.initial();
	
	public static Connection getConnection() {
		try {
			Class.forName(jdbcDriver); //加载数据库驱动
			
			//获取数据库连接，连接数据库时使用的用户名和密码必须是原来数据库中有的用户
			Connection connection = DriverManager.getConnection(rp.dbUrl, rp.dbUsername, rp.dbPassword);
			return connection;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
