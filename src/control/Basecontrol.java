package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.DButil;

public abstract class Basecontrol { //∏∏¿‡
	protected Connection con = DButil.getConnection();
	protected PreparedStatement Pstatement = null;
	protected void close() {
		try {
			this.con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
