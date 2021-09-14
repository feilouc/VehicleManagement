package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.*;

import javax.swing.border.EtchedBorder;
import javax.swing.*;
import DataBase.*;
import Module.*;
import tools.*;
import java.sql.*;


public class userChangePW extends JPanel {
	private JTextField idField;
	private JTextField oldField;
	private JTextField newField;
	public String id = null;
	public String oldPW = null;
	public String newPW = null;
	public String uid = null;
	public String password = null;

	/**
	 * Create the panel.
	 */
	public userChangePW(User u) {
		

			setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			setBackground(Color.WHITE);
			setLayout(null);
			
			JLabel L_id = new JLabel("\u8BF7\u8F93\u5165\u8EAB\u4EFD\u8BC1\u53F7");
			L_id.setFont(new Font("΢���ź� Light", Font.PLAIN, 16));
			L_id.setBounds(83, 100, 134, 57);
			add(L_id);
			
			JLabel L_oldPW = new JLabel("\u8BF7\u8F93\u5165\u65E7\u7684\u5BC6\u7801");
			L_oldPW.setFont(new Font("΢���ź� Light", Font.PLAIN, 16));
			L_oldPW.setBounds(83, 200, 134, 57);
			add(L_oldPW);
			
			JLabel L_newPW = new JLabel("\u8BF7\u8F93\u5165\u65B0\u7684\u5BC6\u7801");
			L_newPW.setFont(new Font("΢���ź� Light", Font.PLAIN, 16));
			L_newPW.setBounds(83, 300, 134, 57);
			add(L_newPW);
			
			idField = new JTextField();
			idField.setBounds(298, 105, 437, 42);
			add(idField);
			idField.setColumns(10);
			
			oldField = new JTextField();
			oldField.setColumns(10);
			oldField.setBounds(298, 209, 437, 42);
			add(oldField);
			
			newField = new JTextField();
			newField.setColumns(10);
			newField.setBounds(298, 305, 437, 42);
			add(newField);
			
			JButton jb = new JButton("\u786E  \u8BA4");
			
		
			
			//���ȷ����������
			jb.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {	
					//��ȡ���������
					id=idField.getText().trim();
					oldPW=oldField.getText().trim();
					newPW=newField.getText().trim();
					uid=u.getId();
					password=u.getPassword();
					System.out.println("userid��"+uid);
					System.out.println("password��"+password);
					System.out.println("����id��"+id);
					System.out.println("����oldPW��"+oldPW);
					if(id.equals(uid) &&  oldPW.equals(password)){
						
					changePW.change(id, oldPW, newPW);
					JOptionPane.showMessageDialog(null, "�����޸ĳɹ�");
					
					}else{
						JOptionPane.showMessageDialog(null, "�˺Ż����벻��ȷ�������˺����������֤��");
					}	
					
				}
			});
			jb.setForeground(Color.BLACK);
			jb.setFont(new Font("΢���ź� Light", Font.PLAIN, 16));
			jb.setBackground(Color.WHITE);
			jb.setBounds(313, 427, 134, 38);
			add(jb);
	}

}
