package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Admin;
import model.Film;
import model.FilmProducer;
import model.Producer;
import model.User;
import util.StrUtil;
import view.systemManage.RevisePWD;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.Filmcontrol;
import control.Producercontrol;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class UserFrame extends JFrame {
	private JPanel contentPane;
	private JDesktopPane desktopPane;

	private RevisePWD revisepwd = null;

	public static int usertype;
	public static User user;
	private JTable ProducerTable;
	private JTable FilmTable;
	private JTextField textField;
	private JTextField textField_1;
	
	
	private static DefaultTableModel Filmdtm = null;
	private static DefaultTableModel Pdcdtm = null;
	public UserFrame(int u, User a) {
		usertype = u;
		user = a;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setLocationRelativeTo(null);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("\u7528\u6237\u7BA1\u7406");
		mnNewMenu.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("\u7528\u6237\u4FEE\u6539\u5BC6\u7801");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				revisePWD(ae);
			}
		});
		mntmNewMenuItem.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		mnNewMenu.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u9000\u51FA\u7CFB\u7EDF");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);// 退出系统
			}
		});
		mntmNewMenuItem_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		mnNewMenu.add(mntmNewMenuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		desktopPane = new JDesktopPane();
		desktopPane.setBounds(5, 5, 783, 529);
		desktopPane.setBackground(new Color(245, 222, 179));
		contentPane.add(desktopPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 37, 580, 175);
		desktopPane.add(scrollPane);
		
		ProducerTable = new JTable();
		ProducerTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5236\u7247\u4EBAID", "\u5236\u7247\u4EBA\u59D3\u540D", "\u5236\u7247\u4EBA\u5E74\u9F84", "\u5236\u7247\u4EBA\u6027\u522B"
			}
		));
		scrollPane.setViewportView(ProducerTable);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 253, 580, 266);
		desktopPane.add(scrollPane_1);
		
		FilmTable = new JTable();
		FilmTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5F71\u7247ID", "\u5F71\u7247\u540D\u79F0", "\u5F71\u7247\u7C7B\u578B", "\u4E0A\u6620\u65F6\u95F4", "\u5236\u7247\u4EBA\u59D3\u540D", "\u5236\u7247\u4EBA\u5E74\u9F84", "\u5236\u7247\u4EBA\u6027\u522B"
			}
		));
		scrollPane_1.setViewportView(FilmTable);
		
		JLabel lblNewLabel = new JLabel("\u5236\u7247\u4EBA\u4FE1\u606F");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 10, 82, 17);
		desktopPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5F71\u7247\u4FE1\u606F");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 228, 82, 15);
		desktopPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(600, 78, 162, 25);
		desktopPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u8BF7\u8F93\u5165\u8981\u67E5\u8BE2\u7684\u5236\u7247\u4EBA\u7684\u59D3\u540D\uFF1A");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(600, 46, 173, 20);
		desktopPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2\u5236\u7247\u4EBA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectProducer();
			}
		});
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		btnNewButton.setBounds(600, 123, 120, 30);
		desktopPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u5C55\u793A\u6240\u6709\u5236\u7247\u4EBA");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				queryAllProducer();
			}
		});
		btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		btnNewButton_1.setBounds(600, 169, 139, 30);
		desktopPane.add(btnNewButton_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(600, 293, 162, 25);
		desktopPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u8BF7\u8F93\u5165\u8981\u67E5\u8BE2\u7684\u5F71\u7247\u540D\u79F0\uFF1A");
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(600, 259, 162, 15);
		desktopPane.add(lblNewLabel_3);
		
		JButton btnNewButton_2 = new JButton("\u67E5\u8BE2\u5F71\u7247");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectFilm();
			}
		});
		btnNewButton_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		btnNewButton_2.setBounds(600, 347, 93, 30);
		desktopPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\u5C55\u793A\u6240\u6709\u5F71\u7247");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				queryAllFilmProducer();
			}
		});
		btnNewButton_3.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		btnNewButton_3.setBounds(600, 393, 139, 30);
		desktopPane.add(btnNewButton_3);
		
		this.Filmdtm =(DefaultTableModel) FilmTable.getModel();
		this.Pdcdtm =(DefaultTableModel) ProducerTable.getModel();
		queryAllFilmProducer();
		queryAllProducer();
	}
	//查询制片人，同时把该制片人的作品也展示出来
	protected void selectProducer() {
		// TODO Auto-generated method stub
		String name=this.textField.getText();
		if(StrUtil.isEmpty(name)) {
			JOptionPane.showMessageDialog(this, "请输入查询的制片人的姓名");
			return;
		}
		Producercontrol producercontrol=new Producercontrol();
		List<Producer> ProducerList=producercontrol.selectProducer(name);
		Pdcdtm.setRowCount(0);
		if(ProducerList.isEmpty()) {
			JOptionPane.showMessageDialog(this, "没有找到该制片人");
		}else {
			for(Producer pro :ProducerList) {
				Vector v=new Vector();
				v.add(pro.getId());
				v.add(pro.getName());
				v.add(pro.getAge());
				v.add(pro.getGender());
				Pdcdtm.addRow(v);
			}
			Filmcontrol filmcontrol=new Filmcontrol();
			List<FilmProducer> FilmList=filmcontrol.selectProducerFilm(name);
			Filmdtm.setRowCount(0);
			if(FilmList.isEmpty()) {
				JOptionPane.showMessageDialog(this, "该制片人还没有上传作品");
			}else {
				for(FilmProducer flm :FilmList) {
					Vector v=new Vector();
					v.add(flm.getFilm_id());
					v.add(flm.getFilm_name());
					v.add(flm.getFilm_type());
					v.add(flm.getShowtime());
					v.add(flm.getProducer_name());
					v.add(flm.getProducer_age());
					v.add(flm.getProducer_gender());
					Filmdtm.addRow(v);
				}
			}
		}
		return;
	}

	//查询影片视图
	protected void selectFilm() {
		// TODO Auto-generated method stub
		String name=this.textField_1.getText();
		if(StrUtil.isEmpty(name)) {
			JOptionPane.showMessageDialog(this, "请输入查询的影片的名称");
			return;
		}
		Filmcontrol filmcontrol=new Filmcontrol();
		List<FilmProducer> allFilmList=filmcontrol.selectFilm(name);
		Filmdtm.setRowCount(0);
		if(allFilmList.isEmpty()) {
			JOptionPane.showMessageDialog(this, "没有找到该影片");
		}else {
			for(FilmProducer flm :allFilmList) {
				Vector v=new Vector();
				v.add(flm.getFilm_id());
				v.add(flm.getFilm_name());
				v.add(flm.getFilm_type());
				v.add(flm.getShowtime());
				v.add(flm.getProducer_name());
				v.add(flm.getProducer_age());
				v.add(flm.getProducer_gender());
				Filmdtm.addRow(v);
			}
		}
		return;
	}
	
	//修改个人密码
	protected void revisePWD(ActionEvent ae) {
		// TODO Auto-generated method stub
		if (revisepwd == null) {
			revisepwd = new RevisePWD(2);
			desktopPane.add(revisepwd);
		} else {
			revisepwd.setVisible(true);
		}
	}
	
	// 显示所有影片制片人视图里的信息
		public static void queryAllFilmProducer() {
			Filmdtm.setRowCount(0);
			Filmcontrol filmcontrol=new Filmcontrol();
			List<FilmProducer> allFilmList=filmcontrol.queryAllFilmProducer();
			for(FilmProducer flm :allFilmList) {
				Vector v=new Vector();
				v.add(flm.getFilm_id());
				v.add(flm.getFilm_name());
				v.add(flm.getFilm_type());
				v.add(flm.getShowtime());
				v.add(flm.getProducer_name());
				v.add(flm.getProducer_age());
				v.add(flm.getProducer_gender());
				Filmdtm.addRow(v);
			}
		}
		
		   //显示所有制片人
		public static void queryAllProducer() {
			// TODO Auto-generated method stub
			Pdcdtm.setRowCount(0);
			Producercontrol producercontrol=new Producercontrol();
			List<Producer> allProducerList=producercontrol.queryAllproducer();
			for(Producer pro :allProducerList) {
				Vector v=new Vector();
				v.add(pro.getId());
				v.add(pro.getName());
				v.add(pro.getAge());
				v.add(pro.getGender());
				Pdcdtm.addRow(v);
			}
		}
}
