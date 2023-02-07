package view.systemManage;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import control.Filmcontrol;
import util.StrUtil;
import view.IndexFrame;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FilmDelete extends JInternalFrame {
	private JTextField textField;


	public FilmDelete() {
		getContentPane().setBackground(new Color(240, 248, 255));
		setClosable(true);
		setBounds(100, 100, 426, 274);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u8981\u5220\u9664\u5F71\u7247\u7684ID:");
		lblNewLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		lblNewLabel.setBounds(64, 49, 162, 31);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(64, 103, 240, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u786E\u8BA4\u5220\u9664");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteFilm();
			}
		});
		btnNewButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		btnNewButton.setBounds(236, 169, 116, 23);
		getContentPane().add(btnNewButton);

	}

    //É¾³ýÓ°Æ¬
	protected void deleteFilm() {
		// TODO Auto-generated method stub
		String id=this.textField.getText();
		if(StrUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(this, "ÇëÊäÈëÒªÉ¾³ýµÄÓ°Æ¬µÄID");
			return;
		}
		int ID=Integer.parseInt(this.textField.getText());
		Filmcontrol filmcontrol=new Filmcontrol();
		JOptionPane.showMessageDialog(this, filmcontrol.deleteFilm(ID));
		IndexFrame.queryAllFilm();
		return;
	}
	//ÖØÐ´¹Ø±Õ°´Å¥
	public void doDefaultCloseAction() {
		setVisible(false);
	}
}
