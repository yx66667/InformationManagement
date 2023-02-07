package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Admincontrol;
import control.Producercontrol;
import control.Usercontrol;
import model.Admin;
import model.Producer;
import model.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.UIManager;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private int select=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setTitle("\u767B\u9646\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(222, 184, 135));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5F71\u89C6\u4FE1\u606F\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel.setFont(new Font("华文行楷", Font.PLAIN, 30));
		lblNewLabel.setBounds(96, 20, 264, 45);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(" \u7528\u6237\u540D \uFF1A");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(90, 75, 69, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u5BC6\u7801 \uFF1A");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(95, 105, 63, 25);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();//用户名
		textField.setBounds(157, 75, 122, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();//密码
		textField_1.setBounds(157, 105, 122, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("\u7BA1\u7406\u5458");//管理员
		rdbtnNewRadioButton.setBackground(new Color(222, 184, 135));
		rdbtnNewRadioButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				select=1;
			}
			
		});
		rdbtnNewRadioButton.setBounds(96, 163, 69, 29);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("\u7528\u6237"); //用户
		rdbtnNewRadioButton_1.setBackground(new Color(222, 184, 135));
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				select=2;
			}
			
		});
		rdbtnNewRadioButton_1.setBounds(174, 164, 69, 26);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("\u5236\u7247\u4EBA"); //制片人
		rdbtnNewRadioButton_2.setBackground(new Color(222, 184, 135));
		rdbtnNewRadioButton_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				select=3;
			}
			
		});
		rdbtnNewRadioButton_2.setBounds(245, 166, 121, 23);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnNewRadioButton);
		group.add(rdbtnNewRadioButton_1);
		group.add(rdbtnNewRadioButton_2);
		
		contentPane.add(rdbtnNewRadioButton_1);
		contentPane.add(rdbtnNewRadioButton);
		contentPane.add(rdbtnNewRadioButton_2);
		
		JButton confirmButton = new JButton("\u767B\u5F55");
		confirmButton.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				confirm(e);
			}

		});
		confirmButton.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		confirmButton.setBounds(236, 212, 93, 23);
		contentPane.add(confirmButton);
				
	}

	protected void confirm(ActionEvent e) {
		// TODO Auto-generated method stub
		String name =this.textField.getText();
		String password =this.textField_1.getText();
		if(select==1) { //管理员
			Admincontrol admincontrol=new Admincontrol(); //去连接数据库
			Admin admin=admincontrol.selectAdmin(name,password);
			if(admin==null) {
					JOptionPane.showMessageDialog(this, "登陆失败");
					return;
			}
			IndexFrame indexframe =new IndexFrame(1,admin);
			indexframe.setVisible(true);
			this.dispose();

		}else if(select==2) { //用户
			Usercontrol usercontrol=new Usercontrol();//连接数据库
			User user=usercontrol.selectuser(name, password);
			if(user==null) {
				JOptionPane.showMessageDialog(this, "登陆失败");
				return;
		    }
			UserFrame userframe=new UserFrame(2,user);
			userframe.setVisible(true);
			this.dispose();
		
		}else {//制片人
			Producercontrol producercontrol=new Producercontrol();
			Producer producer=producercontrol.selectproducer(name, password);
			if(producer==null) {
				JOptionPane.showMessageDialog(this, "登陆失败");
				return;
		    }
			ProducerFrame producerframe=new ProducerFrame(3,producer);
			producerframe.setVisible(true);
			this.dispose();
		}
		
	}
}
