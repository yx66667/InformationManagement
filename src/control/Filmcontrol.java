package control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mysql.cj.jdbc.CallableStatement;

import model.Film;
import model.FilmProducer;
import view.ProducerFrame;

public class Filmcontrol extends Basecontrol{

	//列出所有影片信息
	public ArrayList <Film> queryAllFilm(){
		ArrayList <Film> array=new ArrayList<Film>();
		String sqlStr ="select * from film";
		try {
			this.Pstatement =this.con.prepareStatement(sqlStr);
			ResultSet executeQuery=this.Pstatement.executeQuery();
			while(executeQuery.next()) {
				Film tempFilm=new Film();
				tempFilm.setId(executeQuery.getInt(1));
				tempFilm.setName(executeQuery.getString(2));
				tempFilm.setType(executeQuery.getString(3));
				tempFilm.setShowtime(executeQuery.getDate(4));
				tempFilm.setProducer_id(executeQuery.getInt(5));
				array.add(tempFilm);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.close();
		}
		return array;
	}
	
	//列出所有影片、制片人视图信息
	public ArrayList <FilmProducer> queryAllFilmProducer(){
		ArrayList <FilmProducer> array=new ArrayList<FilmProducer>();
		String sqlStr ="select * from FilmProducer";
		try {
			this.Pstatement =this.con.prepareStatement(sqlStr);
			ResultSet executeQuery=this.Pstatement.executeQuery();
			while(executeQuery.next()) {
				FilmProducer tempFilm=new FilmProducer();
				tempFilm.setFilm_id(executeQuery.getInt(1));
				tempFilm.setFilm_name(executeQuery.getString(2));
				tempFilm.setFilm_type(executeQuery.getString(3));
				tempFilm.setShowtime(executeQuery.getDate(4));
				tempFilm.setProducer_name(executeQuery.getString(5));
				tempFilm.setProducer_age(executeQuery.getInt(6));
				tempFilm.setProducer_gender(executeQuery.getString(7));
				array.add(tempFilm);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.close();
		}
		return array;
	}
	
	
	//添加影片
	public String insertFilm(int ID, String name, String type, java.sql.Date showtime, int producer_id) {
		// TODO Auto-generated method stub
		String resultStr="操作失败";
		String sqlStr="insert into film(Film_id,Film_name,Film_type,showtime,Producer_id) values (?,?,?,?,?)";
		try {
			this.Pstatement =this.con.prepareStatement(sqlStr);
			this.Pstatement.setInt(1, ID);
			this.Pstatement.setString(2, name);
			this.Pstatement.setString(3, type);
			this.Pstatement.setDate(4, showtime);
			this.Pstatement.setInt(5, producer_id);
			if(this.Pstatement.executeUpdate() > 0) {
				resultStr="操作成功!";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {//关闭数据库
			this.close();
		}
		return resultStr;
	}

	//更新影片
	public String updateFilm(int ID, String name, String type, java.sql.Date showtime, int producer_id) {
		// TODO Auto-generated method stub
		String resultStr="操作失败";
		String sqlStr="update film set Film_name=?,Film_type=?,showtime=?,Producer_id=? where Film_id=?";
		try {
			this.Pstatement =this.con.prepareStatement(sqlStr);
			this.Pstatement.setString(1, name);
			this.Pstatement.setString(2, type);
			this.Pstatement.setDate(3, showtime);
			this.Pstatement.setInt(4, producer_id);
			this.Pstatement.setInt(5, ID);
			if(this.Pstatement.executeUpdate() > 0) {
				resultStr="操作成功!";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {//关闭数据库
			this.close();
		}
		return resultStr;
	}

	//删除影片
	public String deleteFilm(int ID) {
		// TODO Auto-generated method stub
		String resultStr="操作失败";
		String sqlStr="delete from film where Film_id=?";
		try {
			this.Pstatement =this.con.prepareStatement(sqlStr);
			this.Pstatement.setInt(1, ID);
			if(this.Pstatement.executeUpdate() > 0) {
				resultStr="操作成功!";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {//关闭数据库
			this.close();
		}
		return resultStr;
	}
    //通过影片ID获取对应的制片人ID
	public int getProducer_id(int iD) {
		// TODO Auto-generated method stub
		String sqlStr ="select * from film where Film_id=?";
		int producer_id=0;
		try {
			this.Pstatement =this.con.prepareStatement(sqlStr);
			this.Pstatement.setInt(1, iD);
			ResultSet executeQuery=this.Pstatement.executeQuery();
			while(executeQuery.next()) {
				producer_id=executeQuery.getInt("Producer_id");	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.close();
		}
		return producer_id;
	}
    //制片人更新影片
	public String producer_updateFilm(int iD, String name, String type, int showtime, int id2) {
		// TODO Auto-generated method stub
		String resultStr="操作失败";
		int res=1;
		String sqlStr ="call updatefilm01(?,?,?,?,?,?)";
		try {
			java.sql.CallableStatement callstatement = con.prepareCall(sqlStr);
			callstatement.setInt(1, iD);
			callstatement.setString(2, name);
			callstatement.setString(3, type);
			callstatement.setInt(4, showtime);
			callstatement.setInt(5, id2);
			callstatement.setInt(6, res);
			callstatement.registerOutParameter(6,Types.INTEGER);
			callstatement.execute();  
			res=callstatement.getInt(6);
			if(res==1) {
				resultStr="操作成功!";
			}
			else {
				resultStr="没有更新该影片的权限!";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.close();
	    }
		return resultStr;
		
	}
    //利用影片的名称来查询视图
	public ArrayList <FilmProducer> selectFilm(String name) {
		// TODO Auto-generated method stub
		ArrayList <FilmProducer> array=new ArrayList<FilmProducer>();
		String sqlStr ="select * from FilmProducer where Film_name=?";
		try {
			this.Pstatement =this.con.prepareStatement(sqlStr);
			this.Pstatement.setString(1, name);
			ResultSet executeQuery=this.Pstatement.executeQuery();	
			while(executeQuery.next()) {
				FilmProducer tempFilm=new FilmProducer();
				tempFilm.setFilm_id(executeQuery.getInt(1));
				tempFilm.setFilm_name(executeQuery.getString(2));
				tempFilm.setFilm_type(executeQuery.getString(3));
				tempFilm.setShowtime(executeQuery.getDate(4));
				tempFilm.setProducer_name(executeQuery.getString(5));
				tempFilm.setProducer_age(executeQuery.getInt(6));
				tempFilm.setProducer_gender(executeQuery.getString(7));
				array.add(tempFilm);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.close();
		}
		return array;
	}
    //利用制片人的姓名来查询视图
	public ArrayList<FilmProducer> selectProducerFilm(String name) {
		// TODO Auto-generated method stub
		ArrayList <FilmProducer> array=new ArrayList<FilmProducer>();
		String sqlStr ="select * from FilmProducer where Producer_name=?";
		try {
			this.Pstatement =this.con.prepareStatement(sqlStr);
			this.Pstatement.setString(1, name);
			ResultSet executeQuery=this.Pstatement.executeQuery();	
			while(executeQuery.next()) {
				FilmProducer tempFilm=new FilmProducer();
				tempFilm.setFilm_id(executeQuery.getInt(1));
				tempFilm.setFilm_name(executeQuery.getString(2));
				tempFilm.setFilm_type(executeQuery.getString(3));
				tempFilm.setShowtime(executeQuery.getDate(4));
				tempFilm.setProducer_name(executeQuery.getString(5));
				tempFilm.setProducer_age(executeQuery.getInt(6));
				tempFilm.setProducer_gender(executeQuery.getString(7));
				array.add(tempFilm);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.close();
		}
		return array;
	}

}
