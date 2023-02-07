package view.systemManage;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import control.Admincontrol;
import control.Producercontrol;
import util.StrUtil;
import view.IndexFrame;
import view.ProducerFrame;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReviseProducerIFM extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the frame.
	 */
	public ReviseProducerIFM() {
		getContentPane().setBackground(new Color(255, 240, 245));
		setClosable(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u4FEE\u6539\u540D\u5B57\uFF1A");
		lblNewLabel.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		lblNewLabel.setBounds(60, 41, 72, 19);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(142, 42, 135, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u4FEE\u6539\u5E74\u9F84\uFF1A");
		lblNewLabel_1.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(60, 81, 72, 15);
		getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(142, 80, 135, 21);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u4FEE\u6539\u6027\u522B\uFF1A");
		lblNewLabel_2.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(60, 125, 72, 15);
		getContentPane().add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(142, 124, 135, 21);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u4FEE\u6539\u5BC6\u7801\uFF1A");
		lblNewLabel_3.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(60, 170, 72, 15);
		getContentPane().add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(142, 169, 135, 21);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("\u786E\u8BA4\u4FEE\u6539");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirm();
			}
		});
		btnNewButton.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 15));
		btnNewButton.setBounds(99, 220, 105, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetbutton();
			}
		});
		btnNewButton_1.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 15));
		btnNewButton_1.setBounds(214, 220, 105, 23);
		getContentPane().add(btnNewButton_1);

	}
	protected void confirm() {
		// TODO Auto-generated method stub
		String name=this.textField.getText();
		int age=Integer.parseInt(this.textField_1.getText());
		String gender=this.textField_2.getText();
		String password=this.textField_3.getText();
		if(StrUtil.isEmpty(name)) {
			JOptionPane.showMessageDialog(this, "«Î ‰»Î–ﬁ∏ƒ∫Ûµƒ√˚◊÷");
			return;
		}
		if(StrUtil.isEmpty(this.textField_1.getText())) {
			JOptionPane.showMessageDialog(this, "«Î ‰»Î–ﬁ∏ƒ∫ÛµƒƒÍ¡‰");
			return;
		}
		if(StrUtil.isEmpty(gender)) {
			JOptionPane.showMessageDialog(this, "«Î ‰»Î–ﬁ∏ƒ∫Ûµƒ–‘±");
			return;
		}
		if(StrUtil.isEmpty(password)) {
			JOptionPane.showMessageDialog(this, "«Î ‰»Î–ﬁ∏ƒ∫Ûµƒ√‹¬Î");
			return;
		}
		
		Producercontrol producercontrol=new Producercontrol();
		JOptionPane.showMessageDialog(this, producercontrol.revisePassword(ProducerFrame.producer,name,age,gender,password));
		return;
		
	}
	//÷ÿ÷√
	protected void resetbutton() {
		// TODO Auto-generated method stub
		this.textField.setText("");
		this.textField_1.setText("");
		this.textField_2.setText("");
		this.textField_3.setText("");
	}
	public void doDefaultCloseAction() {
		setVisible(false);
		resetbutton();
	}
}
