package control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Film;
import model.Producer;
import view.IndexFrame;
import view.ProducerFrame;

public class Producercontrol extends Basecontrol{
	//��¼
	public Producer selectproducer(String name,String password) {
		String sqlStr = "select * from producer Where Producer_name=? and Producer_password=?" ;
		Producer producer=null;
		try {
			this.Pstatement = this.con.prepareStatement(sqlStr);
			this.Pstatement.setString(1, name);
			this.Pstatement.setString(2, password);
			
			ResultSet executeQuery = this.Pstatement.executeQuery();
			if(executeQuery.next()) {
				producer=new Producer(executeQuery.getInt(1),executeQuery.getString(2),executeQuery.getInt(3),executeQuery.getString(4),executeQuery.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally { //�ر����ݿ�
			this.close();
		}
		return producer;
	}
    
	//���¸�����Ϣ
	public String revisePassword(Producer producer, String name, int age, String gender, String password) {
		// TODO Auto-generated method stub
		String resultStr="����ʧ��";
		String sqlStr="update producer set Producer_name=?,Producer_age=?,Producer_gender=?,Producer_password=?where Producer_id=?";
		try {
			this.Pstatement =this.con.prepareStatement(sqlStr);
			this.Pstatement.setString(1, name);
			this.Pstatement.setInt(2, age);
			this.Pstatement.setString(3, gender);
			this.Pstatement.setString(4, password);
			this.Pstatement.setInt(5, producer.getId());
			if(this.Pstatement.executeUpdate() > 0) {
				resultStr="�����ɹ�!";
				ProducerFrame.producer.setName(name);
				ProducerFrame.producer.setAge(age);
				ProducerFrame.producer.setGender(gender);
				ProducerFrame.producer.setPassword(password);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultStr +=" "+e.getMessage();
		}finally {//�ر����ݿ�
			this.close();
		}
		return resultStr;
	}
    
	//�г�������Ƭ����Ϣ
	public ArrayList<Producer> queryAllproducer() {
		ArrayList <Producer> array=new ArrayList<Producer>();
		String sqlStr ="select * from producer";
		try {
			this.Pstatement =this.con.prepareStatement(sqlStr);
			ResultSet executeQuery=this.Pstatement.executeQuery();
			while(executeQuery.next()) {
				Producer tempproducer=new Producer();
				tempproducer.setId(executeQuery.getInt(1));
				tempproducer.setName(executeQuery.getString(2));
				tempproducer.setAge(executeQuery.getInt(3));
				tempproducer.setGender(executeQuery.getString(4));
				tempproducer.setPassword(executeQuery.getString(5));
				array.add(tempproducer);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.close();
		}
		return array;
	}
    //�����Ƭ��
	public String insertProducer(int ID, String name, int age, String gender, String password) {
		// TODO Auto-generated method stub
		String resultStr="����ʧ��";
		String sqlStr="insert into producer(Producer_id,Producer_name,Producer_age,Producer_gender,Producer_password) values (?,?,?,?,?)";
		try {
			this.Pstatement =this.con.prepareStatement(sqlStr);
			this.Pstatement.setInt(1, ID);
			this.Pstatement.setString(2, name);
			this.Pstatement.setInt(3, age);
			this.Pstatement.setString(4, gender);
			this.Pstatement.setString(5, password);
			if(this.Pstatement.executeUpdate() > 0) {
				resultStr="�����ɹ�!";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultStr +=" "+e.getMessage();
		}finally {//�ر����ݿ�
			this.close();
		}
		return resultStr;
	}
    //������Ƭ��
	public String updateProducer(int ID, String name, int age, String gender, String password) {
		// TODO Auto-generated method stub
		String resultStr="����ʧ��";
		String sqlStr="update producer set Producer_name=?,Producer_age=?,Producer_gender=?,Producer_password=? where Producer_id=?";
		try {
			this.Pstatement =this.con.prepareStatement(sqlStr);
			this.Pstatement.setString(1, name);
			this.Pstatement.setInt(2, age);
			this.Pstatement.setString(3, gender);
			this.Pstatement.setString(4, password);
			this.Pstatement.setInt(5, ID);
			if(this.Pstatement.executeUpdate() > 0) {
				resultStr="�����ɹ�!";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultStr +=" "+e.getMessage();
		}finally {//�ر����ݿ�
			this.close();
		}
		return resultStr;
	}
    //ɾ����Ƭ��
	public String deleteProducer(int ID) {
		// TODO Auto-generated method stub
		String resultStr="����ʧ��";
		String sqlStr="delete from producer where Producer_id=?";
		try {
			this.Pstatement =this.con.prepareStatement(sqlStr);
			this.Pstatement.setInt(1, ID);
			if(this.Pstatement.executeUpdate() > 0) {
				resultStr="�����ɹ�!";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {//�ر����ݿ�
			this.close();
		}
		return resultStr;
	}

	public ArrayList<Producer> selectProducer(String name) {
		// TODO Auto-generated method stub
		ArrayList <Producer> array=new ArrayList<Producer>();
		String sqlStr ="select * from producer where Producer_name=?";
		try {
			this.Pstatement =this.con.prepareStatement(sqlStr);
			this.Pstatement.setString(1, name);
			ResultSet executeQuery=this.Pstatement.executeQuery();
			while(executeQuery.next()) {
				Producer tempproducer=new Producer();
				tempproducer.setId(executeQuery.getInt(1));
				tempproducer.setName(executeQuery.getString(2));
				tempproducer.setAge(executeQuery.getInt(3));
				tempproducer.setGender(executeQuery.getString(4));
				tempproducer.setPassword(executeQuery.getString(5));
				array.add(tempproducer);
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
