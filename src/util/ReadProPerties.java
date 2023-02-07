package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProPerties { //∂¡≈‰÷√Œƒº˛
	private static ReadProPerties rp;
	public String dbUrl;
	public String dbUsername;
	public String dbPassword;
	
	private ReadProPerties() {
		loadProperties();
	}
	
	public static ReadProPerties initial() {
		if(rp==null) {
			rp=new ReadProPerties();
		}
		return rp;
	}
	
	private void loadProperties() {
		InputStream ips = getClass().getResourceAsStream("/images/db.properties");
		Properties properties = new Properties();
		
		try {
			properties.load(ips);
			this.dbUrl = properties.getProperty("dbUrl");
			this.dbUsername = properties.getProperty("dbUsername");
			this.dbPassword = properties.getProperty("dbPassword");	
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
