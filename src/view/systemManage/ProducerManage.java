package view.systemManage;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import control.Filmcontrol;
import control.Producercontrol;
import util.StrUtil;
import view.IndexFrame;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;

public class ProducerManage extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;


	public ProducerManage() {
		getContentPane().setBackground(new Color(240, 248, 255));
		setClosable(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5236\u7247\u4EBAID\uFF1A");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		lblNewLabel.setBounds(38, 45, 84, 25);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5236\u7247\u4EBA\u59D3\u540D\uFF1A");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(38, 80, 84, 25);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u5236\u7247\u4EBA\u5E74\u9F84\uFF1A");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(38, 115, 84, 25);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u5236\u7247\u4EBA\u6027\u522B\uFF1A");
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(38, 156, 84, 15);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_4.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(37, 181, 54, 27);
		getContentPane().add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(140, 49, 130, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(140, 84, 130, 21);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(140, 119, 130, 21);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(140, 155, 130, 21);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(140, 186, 130, 21);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0\u5236\u7247\u4EBA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addProducer();
			}
		});
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		btnNewButton.setBounds(38, 218, 116, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u66F4\u65B0\u5236\u7247\u4EBA\u4FE1\u606F");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateProducer();
			}
		});
		btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		btnNewButton_1.setBounds(164, 217, 153, 23);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u91CD\u7F6E");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetbutton();
			}
		});
		btnNewButton_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		btnNewButton_2.setBounds(327, 217, 93, 23);
		getContentPane().add(btnNewButton_2);

	}
	//更新制片人信息
	protected void updateProducer() {
		// TODO Auto-generated method stub
		String id=this.textField.getText();
		String name=this.textField_1.getText();
		String age01=this.textField_2.getText();
		String gender=this.textField_3.getText();
		String password=this.textField_4.getText();
		
		if(StrUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(this, "请输入制片人ID");
			return;
		}
		if(StrUtil.isEmpty(name)) {
			JOptionPane.showMessageDialog(this, "请输入制片人姓名");
			return;
		}
		if(StrUtil.isEmpty(age01)) {
			JOptionPane.showMessageDialog(this, "请输入制片人年龄");
			return;
		}
		if(StrUtil.isEmpty(gender)) {
			JOptionPane.showMessageDialog(this, "请输入制片人性别");
			return;
		}
		if(StrUtil.isEmpty(password)) {
			JOptionPane.showMessageDialog(this, "请输入密码");
			return;
		}
		int ID=Integer.parseInt(id);
		int age=Integer.parseInt(age01);
		Producercontrol producercontrol=new Producercontrol();
		JOptionPane.showMessageDialog(this, producercontrol.updateProducer(ID,name,age,gender,password));
		IndexFrame.queryAllProducer();
		return;
	}
	//添加制片人
	protected void addProducer() {
		// TODO Auto-generated method stub
		String id=this.textField.getText();
		String name=this.textField_1.getText();
		String age01=this.textField_2.getText();
		String gender=this.textField_3.getText();
		String password=this.textField_4.getText();
		
		if(StrUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(this, "请输入制片人ID");
			return;
		}
		if(StrUtil.isEmpty(name)) {
			JOptionPane.showMessageDialog(this, "请输入制片人姓名");
			return;
		}
		if(StrUtil.isEmpty(age01)) {
			JOptionPane.showMessageDialog(this, "请输入制片人年龄");
			return;
		}
		if(StrUtil.isEmpty(gender)) {
			JOptionPane.showMessageDialog(this, "请输入制片人性别");
			return;
		}
		if(StrUtil.isEmpty(password)) {
			JOptionPane.showMessageDialog(this, "请输入密码");
			return;
		}
		int ID=Integer.parseInt(id);
		int age=Integer.parseInt(age01);
		Producercontrol producercontrol=new Producercontrol();
		JOptionPane.showMessageDialog(this, producercontrol.insertProducer(ID,name,age,gender,password));
		IndexFrame.queryAllProducer();
		return;
	}
	//重置
	protected void resetbutton() {
		// TODO Auto-generated method stub
		this.textField.setText("");
		this.textField_1.setText("");
		this.textField_2.setText("");
		this.textField_3.setText("");
		this.textField_4.setText("");
	}
	public void doDefaultCloseAction() {
		setVisible(false);
		resetbutton();
	}

}
