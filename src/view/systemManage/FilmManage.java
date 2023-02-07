package view.systemManage;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import control.Filmcontrol;
import control.Producercontrol;
import util.StrUtil;
import view.IndexFrame;
import view.ProducerFrame;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class FilmManage extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	
    public SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");



	public FilmManage() {
		getContentPane().setBackground(new Color(240, 248, 255));
		setClosable(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5F71\u7247ID\uFF1A");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		lblNewLabel.setBounds(28, 26, 67, 19);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5F71\u7247\u540D\u79F0\uFF1A");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(29, 61, 79, 24);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u5F71\u7247\u7C7B\u578B\uFF1A");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(29, 95, 89, 28);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u4E0A\u6620\u65F6\u95F4\uFF1A");
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(28, 133, 80, 21);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u5236\u7247\u4EBAID\uFF1A");
		lblNewLabel_4.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(28, 169, 80, 19);
		getContentPane().add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(120, 27, 150, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(120, 65, 150, 21);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(120, 101, 150, 21);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(120, 133, 150, 21);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(120, 170, 150, 21);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0\u5F71\u7247");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addFilm();
			}
		});
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		btnNewButton.setBounds(39, 218, 110, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u66F4\u6539\u5F71\u7247\u4FE1\u606F");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateFilm();
			}
		});
		btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		btnNewButton_1.setBounds(160, 218, 130, 23);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u91CD\u7F6E");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetbutton();
			}
		});
		btnNewButton_2.setBounds(304, 218, 93, 23);
		getContentPane().add(btnNewButton_2);

	}
	
	   //更新影片
	protected void updateFilm() {
		// TODO Auto-generated method stub
		String id=this.textField.getText();
		String name=this.textField_1.getText();
		String type=this.textField_2.getText();
		String show=this.textField_3.getText();
		String producer=this.textField_4.getText();
		
		if(StrUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(this, "请输入影片ID");
			return;
		}
		if(StrUtil.isEmpty(name)) {
			JOptionPane.showMessageDialog(this, "请输入影片名称");
			return;
		}
		if(StrUtil.isEmpty(type)) {
			JOptionPane.showMessageDialog(this, "请输入影片类型");
			return;
		}
		if(StrUtil.isEmpty(show)) {
			JOptionPane.showMessageDialog(this, "请输入影片上映时间");
			return;
		}
		if(StrUtil.isEmpty(producer)) {
			JOptionPane.showMessageDialog(this, "请输入制片人ID");
			return;
		}
		int ID=Integer.parseInt(id);
		Date showtime = java.sql.Date.valueOf(show);
		int producer_id=Integer.parseInt(producer);
		Filmcontrol filmcontrol=new Filmcontrol();
		JOptionPane.showMessageDialog(this, filmcontrol.updateFilm(ID,name,type,showtime,producer_id));
		IndexFrame.queryAllFilm();
		return;
		
	}

        //增加影片
	protected void addFilm() {
		// TODO Auto-generated method stub
		String id=this.textField.getText();
		String name=this.textField_1.getText();
		String type=this.textField_2.getText();
		String show=this.textField_3.getText();
		String producer=this.textField_4.getText();
		
		if(StrUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(this, "请输入影片ID");
			return;
		}
		if(StrUtil.isEmpty(name)) {
			JOptionPane.showMessageDialog(this, "请输入影片名称");
			return;
		}
		if(StrUtil.isEmpty(type)) {
			JOptionPane.showMessageDialog(this, "请输入影片类型");
			return;
		}
		if(StrUtil.isEmpty(show)) {
			JOptionPane.showMessageDialog(this, "请输入影片上映时间");
			return;
		}
		if(StrUtil.isEmpty(producer)) {
			JOptionPane.showMessageDialog(this, "请输入制片人ID");
			return;
		}
		int ID=Integer.parseInt(id);
		Date showtime = java.sql.Date.valueOf(show);
		int producer_id=Integer.parseInt(producer);
		Filmcontrol filmcontrol=new Filmcontrol();
		JOptionPane.showMessageDialog(this, filmcontrol.insertFilm(ID,name,type,showtime,producer_id));
		IndexFrame.queryAllFilm();
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
