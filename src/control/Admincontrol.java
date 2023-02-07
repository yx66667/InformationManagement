package control;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Admin;
import view.IndexFrame;

public class Admincontrol extends Basecontrol{ 
	//连接数据库
	public Admin selectAdmin(String name,String password) {
		String sqlStr = "select * from admin Where Admin_name=? and Admin_password=?" ;
		Admin admin=null;
		try {
			this.Pstatement = this.con.prepareStatement(sqlStr);
			this.Pstatement.setString(1, name);
			this.Pstatement.setString(2, password);
			
			ResultSet executeQuery = this.Pstatement.executeQuery();
			if(executeQuery.next()) {
				admin=new Admin(executeQuery.getInt(1),executeQuery.getString(2),executeQuery.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally { //关闭数据库
			this.close();
		}
		return admin;
	}
	//修改管理员密码
	public String revisePassword(Admin admin,String newpassword) {
		String resultStr="操作失败";
		String sqlStr="update admin set Admin_password=? where Admin_name=? and Admin_password=?";
		try {
			this.Pstatement =this.con.prepareStatement(sqlStr);
			this.Pstatement.setString(1, newpassword);
			this.Pstatement.setString(2, admin.getName());
			this.Pstatement.setString(3, admin.getPassword());
			if(this.Pstatement.executeUpdate() > 0) {
				resultStr="操作成功!";
				IndexFrame.admin.setPassword(newpassword);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {//关闭数据库
			this.close();
		}
		return resultStr;
		
	}
	
	

}
