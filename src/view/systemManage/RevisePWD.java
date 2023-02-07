package view.systemManage;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;

import control.Admincontrol;
import control.Usercontrol;
import util.StrUtil;
import view.IndexFrame;
import view.UserFrame;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RevisePWD extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
    private int usertype;
    private String usertypename;

	/**
	 * Create the frame.
	 */
	public RevisePWD(int u) {
		usertype=u;
		getContentPane().setBackground(new Color(255, 240, 245));
		setClosable(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 13));
		lblNewLabel.setBounds(77, 37, 143, 18);
		getContentPane().add(lblNewLabel);
		
		String Name;
		if(usertype==1) {
			Name=IndexFrame.admin.getName();
			usertypename="π‹¿Ì‘±";
		}
		else {
			Name=UserFrame.user.getName();
			usertypename="”√ªß";
		}
		JLabel lblNewLabel_1 = new JLabel(usertypename+": "+Name);
		lblNewLabel_1.setForeground(new Color(160, 82, 45));
		lblNewLabel_1.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(168, 39, 76, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u539F\u5BC6\u7801\uFF1A");
		lblNewLabel_2.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(77, 82, 54, 18);
		getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(158, 82, 103, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u4FEE\u6539\u540E\u5BC6\u7801\uFF1A");
		lblNewLabel_3.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(77, 121, 94, 15);
		getContentPane().add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(158, 119, 103, 21);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("\u786E\u8BA4\u4FEE\u6539");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				confirmbutton(ae);
			}
		});
		btnNewButton.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 15));
		btnNewButton.setBounds(89, 169, 117, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetbutton();
			}
		});
		btnNewButton_1.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 15));
		btnNewButton_1.setBounds(232, 169, 117, 23);
		getContentPane().add(btnNewButton_1);
		
		setVisible(true);

	}
	//»∑»œ∞¥≈•
	protected void confirmbutton(ActionEvent e) {
		// TODO Auto-generated method stub
		String oldpassword=this.textField.getText();
		String newpassword=this.textField_1.getText();
		if(StrUtil.isEmpty(oldpassword)) {
			JOptionPane.showMessageDialog(this, "«Î ‰»Î‘≠√‹¬Î");
			return;
		}
		if(StrUtil.isEmpty(newpassword)) {
			JOptionPane.showMessageDialog(this, "«Î ‰»Î–ﬁ∏ƒ∫Ûµƒ√‹¬Î");
			return;
		}
		if(usertype==1) {
			Admincontrol admincontrol=new Admincontrol();
			JOptionPane.showMessageDialog(this, admincontrol.revisePassword(IndexFrame.admin, newpassword));
			return;
		}
		else {
			Usercontrol usercontrol=new Usercontrol();
			JOptionPane.showMessageDialog(this, usercontrol.revisePassword(UserFrame.user, newpassword));
			return;
		}
		
	}
	//÷ÿ÷√
	protected void resetbutton() {
		// TODO Auto-generated method stub
		this.textField.setText("");
		this.textField_1.setText("");
	}
	//÷ÿ–¥πÿ±’
	public void doDefaultCloseAction() {
		setVisible(false);
		resetbutton();
	}
}
