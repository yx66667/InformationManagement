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
import java.awt.event.ActionEvent;

public class ProducerDelete extends JInternalFrame {
	private JTextField textField;

	public ProducerDelete() {
		getContentPane().setBackground(new Color(240, 248, 255));
		setClosable(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u8981\u5220\u9664\u7684\u5236\u7247\u4EBAID\uFF1A\uFF08\u6CE8\u610F\u4F1A\u5220\u9664\u5176\u6240\u6709\u4F5C\u54C1\uFF09");
		lblNewLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		lblNewLabel.setBounds(28, 23, 390, 40);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(28, 76, 188, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u786E\u8BA4\u5220\u9664");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteProducer();
			}
		});
		btnNewButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		btnNewButton.setBounds(255, 96, 105, 29);
		getContentPane().add(btnNewButton);

	}

	protected void deleteProducer() {
		// TODO Auto-generated method stub
		String id=this.textField.getText();
		if(StrUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(this, "ÇëÊäÈëÒªÉ¾³ýµÄÖÆÆ¬ÈËµÄID");
			return;
		}
		int ID=Integer.parseInt(this.textField.getText());
		Producercontrol producercontrol=new Producercontrol();
		JOptionPane.showMessageDialog(this, producercontrol.deleteProducer(ID));
		IndexFrame.queryAllProducer();
		IndexFrame.queryAllFilm();
		return;
	}
	//ÖØÐ´¹Ø±Õ°´Å¥
		public void doDefaultCloseAction() {
			setVisible(false);
		}

}
