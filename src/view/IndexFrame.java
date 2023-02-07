package view;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Admin;
import model.Film;
import model.Producer;
import view.systemManage.FilmDelete;
import view.systemManage.FilmManage;
import view.systemManage.ProducerDelete;
import view.systemManage.ProducerManage;
import view.systemManage.RevisePWD;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JMenuItem;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.Filmcontrol;
import control.Producercontrol;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextPane;

public class IndexFrame extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;

	private RevisePWD revisepwd = null;

	public static int usertype;
	public static Admin admin;
	private JTable filmListTable;
	private JTable producerListTable;
	
	private static DefaultTableModel Filmdtm = null;
	private static DefaultTableModel Pdcdtm = null;
	
	private FilmManage filmmanage=null;
	private FilmDelete filmdelete=null;
	private ProducerManage producermanage=null;
	private ProducerDelete producerdelete=null;
	 
	
	/**
	 * Create the frame.
	 */
	public IndexFrame(int u, Admin a) {
		usertype = u;
		admin = a;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setLocationRelativeTo(null);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("\u7CFB\u7EDF\u7BA1\u7406");
		mnNewMenu.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("\u7BA1\u7406\u5458\u4FEE\u6539\u5BC6\u7801");
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
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(245, 222, 179));
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 594, 259);
		desktopPane.add(scrollPane);
		
		filmListTable = new JTable();
		filmListTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5F71\u7247ID", "\u5F71\u7247\u540D\u79F0", "\u5F71\u7247\u7C7B\u578B", "\u4E0A\u6620\u65F6\u95F4", "\u5236\u7247\u4EBAID"
			}
		));
		scrollPane.setViewportView(filmListTable);
		
		JButton btnNewButton_1 = new JButton("\u5220\u9664\u5F71\u7247");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteFilm();
			}
		});
		btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		btnNewButton_1.setBounds(614, 166, 130, 30);
		desktopPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u63D2\u5165\\\u66F4\u65B0\u5F71\u7247");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateFilm();
			}
			
		});
		btnNewButton_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		btnNewButton_2.setBounds(614, 219, 130, 30);
		desktopPane.add(btnNewButton_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 279, 595, 240);
		desktopPane.add(scrollPane_1);
		
		producerListTable = new JTable();
		producerListTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5236\u7247\u4EBAID", "\u5236\u7247\u4EBA\u59D3\u540D", "\u5236\u7247\u4EBA\u5E74\u9F84", "\u5236\u7247\u4EBA\u6027\u522B", "\u5236\u7247\u4EBA\u5BC6\u7801"
			}
		));
		scrollPane_1.setViewportView(producerListTable);
		
		JButton btnNewButton_4 = new JButton("\u5220\u9664\u5236\u7247\u4EBA");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteProducer();
			}
		});
		btnNewButton_4.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		btnNewButton_4.setBounds(614, 392, 140, 30);
		desktopPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("\u63D2\u5165\\\u66F4\u65B0\u5236\u7247\u4EBA");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateProducer();
			}
		});
		btnNewButton_5.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		btnNewButton_5.setBounds(614, 440, 140, 30);
		desktopPane.add(btnNewButton_5);
		
		this.Filmdtm =(DefaultTableModel) filmListTable.getModel();
		this.Pdcdtm =(DefaultTableModel) producerListTable.getModel();
		queryAllFilm();
		queryAllProducer();

	}
	//删除制片人
	protected void deleteProducer() {
		// TODO Auto-generated method stub
		if (producerdelete == null) {
			producerdelete = new ProducerDelete();
			desktopPane.add(producerdelete);
			producerdelete.setVisible(true);
		} else {
			producerdelete.setVisible(true);
		}
	}
	//插入或更新制片人
    protected void updateProducer() {
		// TODO Auto-generated method stub
    	if (producermanage == null) {
    		producermanage = new ProducerManage();
			desktopPane.add(producermanage);
			producermanage.setVisible(true);
		} else {
			producermanage.setVisible(true);
		}
	}
	//删除影片
	protected void deleteFilm() {
		// TODO Auto-generated method stub
		if (filmdelete == null) {
			filmdelete = new FilmDelete();
			desktopPane.add(filmdelete);
			filmdelete.setVisible(true);
		} else {
			filmdelete.setVisible(true);
		}
	}
    //更新或者插入影片
	protected void updateFilm() {
		// TODO Auto-generated method stub
		if (filmmanage == null) {
			filmmanage = new FilmManage();
			desktopPane.add(filmmanage);
			filmmanage.setVisible(true);
		} else {
			filmmanage.setVisible(true);
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
			v.add(pro.getPassword());
			Pdcdtm.addRow(v);
		}
	}

	// 系统管理修改密码
	protected void revisePWD(ActionEvent ae) {
		// TODO Auto-generated method stub
		if (revisepwd == null) {
			revisepwd = new RevisePWD(1);
			desktopPane.add(revisepwd);
			revisepwd.setVisible(true);
		} else {
			revisepwd.setVisible(true);
		}
	}
	// 显示所有影片
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
}
