package control;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;
import view.IndexFrame;
import view.UserFrame;

public class Usercontrol extends Basecontrol {
	public User selectuser(String name,String password) {
		String sqlStr = "select * from user Where User_name=? and User_password=?" ;
		User user=null;
		try {
			this.Pstatement = this.con.prepareStatement(sqlStr);
			this.Pstatement.setString(1, name);
			this.Pstatement.setString(2, password);
			
			ResultSet executeQuery = this.Pstatement.executeQuery();
			if(executeQuery.next()) {
				user=new User(executeQuery.getInt(1),executeQuery.getString(2),executeQuery.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally { //关闭数据库
			this.close();
		}
		return user;
	}

	public Object revisePassword(User user, String newpassword) {
		// TODO Auto-generated method stub
		String resultStr="操作失败";
		String sqlStr="update user set User_password=? where User_name=? and User_password=?";
		try {
			this.Pstatement =this.con.prepareStatement(sqlStr);
			this.Pstatement.setString(1, newpassword);
			this.Pstatement.setString(2, user.getName());
			this.Pstatement.setString(3, user.getPassword());
			if(this.Pstatement.executeUpdate() > 0) {
				resultStr="操作成功!";
				UserFrame.user.setPassword(newpassword);
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
