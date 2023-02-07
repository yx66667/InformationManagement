package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
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

import model.Film;
import model.Producer;
import util.StrUtil;
import view.systemManage.ReviseProducerIFM;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.Filmcontrol;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;


public class ProducerFrame extends JFrame {
	private JPanel contentPane;
	private JDesktopPane desktopPane;

	private ReviseProducerIFM reviseIFM = null;

	public static int usertype;
	public static Producer producer;
	private JTable FilmListTable;
	
	private static DefaultTableModel Filmdtm = null;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the frame.
	 */
	public ProducerFrame(int u, Producer a) {
		usertype = u;
		producer = a;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setLocationRelativeTo(null);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("\u4E2A\u4EBA\u4E2D\u5FC3");
		mnNewMenu.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("\u4FEE\u6539\u4E2A\u4EBA\u4FE1\u606F");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				reviseInformation(ae);
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
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(245, 222, 179));
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 10, 716, 272);
		desktopPane.add(scrollPane);
		
		FilmListTable = new JTable();
		FilmListTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5F71\u7247ID", "\u5F71\u7247\u540D\u79F0", "\u5F71\u7247\u7C7B\u578B", "\u4E0A\u6620\u65F6\u95F4", "\u5236\u7247\u4EBAID"
			}
		));
		scrollPane.setViewportView(FilmListTable);
		
		JLabel lblNewLabel = new JLabel("\u5F71\u7247ID\uFF1A");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		lblNewLabel.setBounds(31, 321, 65, 22);
		desktopPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(110, 322, 135, 21);
		desktopPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u5F71\u7247\u540D\u79F0\uFF1A");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(31, 367, 80, 22);
		desktopPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(110, 368, 135, 21);
		desktopPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u5F71\u7247\u7C7B\u578B\uFF1A");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(313, 321, 85, 22);
		desktopPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(408, 322, 135, 21);
		desktopPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u4E0A\u6620\u65F6\u95F4\uFF1A");
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(313, 367, 85, 22);
		desktopPane.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(408, 367, 135, 21);
		desktopPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("\u4E0A\u4F20\u5F71\u7247");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addFilm();
			}
		});
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		btnNewButton.setBounds(70, 430, 120, 30);
		desktopPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u66F4\u65B0\u5F71\u7247");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateFilm();
			}
		});
		btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		btnNewButton_1.setBounds(225, 430, 120, 30);
		desktopPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u5220\u9664\u5F71\u7247");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteFilm();
			}
		});
		btnNewButton_2.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		btnNewButton_2.setBounds(393, 430, 120, 30);
		desktopPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\u91CD\u7F6E");
		btnNewButton_3.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetbutton();
			}
		});
		btnNewButton_3.setBounds(544, 430, 93, 30);
		desktopPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u53EA\u80FD\u7BA1\u7406\u81EA\u5DF1\u7684\u5F71\u7247\u5594~");
		lblNewLabel_4.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(55, 492, 228, 27);
		desktopPane.add(lblNewLabel_4);
		
		this.Filmdtm =(DefaultTableModel) FilmListTable.getModel();
		queryAllFilm();

	}
	//制片人更新影片
    protected void updateFilm() {
		// TODO Auto-generated method stub
    	String id=this.textField.getText();
		String name=this.textField_1.getText();
		String type=this.textField_2.getText();
		String show=this.textField_3.getText();
		
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
		int ID=Integer.parseInt(id);
	    int showtime = Integer.parseInt(show);
		Filmcontrol filmcontrol=new Filmcontrol();
		JOptionPane.showMessageDialog(this, filmcontrol.producer_updateFilm(ID,name,type,showtime,producer.getId()));
		queryAllFilm();
		return;
		
	}
	//制片人删除影片
	protected void deleteFilm() {
		// TODO Auto-generated method stub
		String id=this.textField.getText();
		if(StrUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(this, "请输入要删除的影片的ID");
			return;
		}
		int ID=Integer.parseInt(id);
		Filmcontrol filmcontrol=new Filmcontrol();
		int producer_id=filmcontrol.getProducer_id(ID);
		if(producer_id!=producer.getId()) {
			JOptionPane.showMessageDialog(this, "没有删除该影片的权限");
			return;
		}
		Filmcontrol filmcontrol01=new Filmcontrol();
		JOptionPane.showMessageDialog(this, filmcontrol01.deleteFilm(ID));
		queryAllFilm();
		return;
	}
    //制片人增加影片
	protected void addFilm() {
		// TODO Auto-generated method stub
		String id=this.textField.getText();
		String name=this.textField_1.getText();
		String type=this.textField_2.getText();
		String show=this.textField_3.getText();
		
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
		int ID=Integer.parseInt(id);
		Date showtime = java.sql.Date.valueOf(show);
		Filmcontrol filmcontrol=new Filmcontrol();
		JOptionPane.showMessageDialog(this, filmcontrol.insertFilm(ID,name,type,showtime,producer.getId()));
		queryAllFilm();
		return;
	}

	// 系统管理修改个人信息
	protected void reviseInformation(ActionEvent ae) {
		// TODO Auto-generated method stub
		if (reviseIFM == null) {
			reviseIFM = new ReviseProducerIFM();
			reviseIFM.setVisible(true);
			desktopPane.add(reviseIFM);
		} else {
			reviseIFM.setVisible(true);
		}
	}
	//显示所有影片
	public static void queryAllFilm() {
		Filmdtm.setRowCount(0);
		Filmcontrol filmcontrol=new Filmcontrol();
		List<Film> allFilmList=filmcontrol.queryAllFilm();
		for(Film flm :allFilmList) {
			Vector v=new Vector();
			v.add(flm.getId());
			v.add(flm.getName());
			v.add(flm.getType());
			v.add(flm.getShowtime());
			v.add(flm.getProducer_id());
			Filmdtm.addRow(v);
		}
	}
	//重置
		protected void resetbutton() {
			// TODO Auto-generated method stub
			this.textField.setText("");
			this.textField_1.setText("");
			this.textField_2.setText("");
			this.textField_3.setText("");
		}
}
