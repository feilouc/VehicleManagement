package view;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import DataBase.*;
import Module.*;
import tools.*;
import java.sql.*;

public class userLaws extends JPanel {

	/**
	 * Create the panel.
	 */
	public userLaws() {
		setForeground(Color.BLACK);
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setBackground(Color.WHITE);
		setLayout(null);
		
		JPanel p_head = new JPanel();
		p_head.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.RED, null));
		p_head.setBackground(Color.WHITE);
		p_head.setBounds(73, 10, 706, 100);
		add(p_head);
		p_head.setLayout(null);
		
		JLabel head = new JLabel("             \u6700              \u65B0              \u6CD5              \u89C4");
		head.setForeground(new Color(255, 0, 51));
		head.setFont(new Font("方正粗黑宋简体", Font.PLAIN, 26));
		head.setBounds(55, 18, 600, 60);
		p_head.add(head);
		
		JPanel p_body = new JPanel();
		p_body.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		p_body.setBackground(Color.WHITE);
		p_body.setBounds(73, 141, 706, 287);
		add(p_body);
		p_body.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		textArea.setRows(10);
		textArea.setLineWrap(true);
		textArea.setBounds(5, 5, 696, 277);
		//从数据库中获取法规
		getLaws.get(textArea);
		p_body.add(textArea);
		
		

	}
}
