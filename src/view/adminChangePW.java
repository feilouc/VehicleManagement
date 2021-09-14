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
import tools.*;

public class adminChangePW extends JPanel {
	private JTextField idField;
	private JTextField oldField;
	private JTextField newField;
	
	public String oldPW = null;
	public String newPW = null;

	/**
	 * Create the panel.
	 */
	public adminChangePW() {
		

			setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			setBackground(Color.WHITE);
			setLayout(null);
			
			JLabel L_id = new JLabel("\u8BF7\u8F93\u5165\u7BA1\u7406\u8D26\u53F7");
			L_id.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.PLAIN, 16));
			L_id.setBounds(83, 100, 134, 57);
			add(L_id);
			
			JLabel L_oldPW = new JLabel("\u8BF7\u8F93\u5165\u65E7\u7684\u5BC6\u7801");
			L_oldPW.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.PLAIN, 16));
			L_oldPW.setBounds(83, 200, 134, 57);
			add(L_oldPW);
			
			JLabel L_newPW = new JLabel("\u8BF7\u8F93\u5165\u65B0\u7684\u5BC6\u7801");
			L_newPW.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.PLAIN, 16));
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
			
			///µã»÷È·¶¨¸ü¸ÄÃÜÂë
			JButton jb = new JButton("\u786E  \u8BA4");
			jb.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					oldPW=oldField.getText().trim();
					newPW=newField.getText().trim();	
					AdminChangePW.change(oldPW, newPW);
					JOptionPane.showMessageDialog(null, "ÃÜÂëÐÞ¸Ä³É¹¦");
						
							
					
				}
			});
			jb.setForeground(Color.BLACK);
			jb.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.PLAIN, 16));
			jb.setBackground(Color.WHITE);
			jb.setBounds(313, 427, 134, 38);
			add(jb);
	}

}
