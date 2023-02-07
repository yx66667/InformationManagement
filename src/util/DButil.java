package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DButil {
	private static String jdbcDriver = "com.mysql.cj.jdbc.Driver";
	private static ReadProPerties rp = ReadProPerties.initial();
	
	public static Connection getConnection() {
		try {
			Class.forName(jdbcDriver); //�������ݿ�����
			
			//��ȡ���ݿ����ӣ��������ݿ�ʱʹ�õ��û��������������ԭ�����ݿ����е��û�
			Connection connection = DriverManager.getConnection(rp.dbUrl, rp.dbUsername, rp.dbPassword);
			return connection;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
