package view;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import DataBase.*;
import Module.*;
import tools.*;
import java.sql.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class adminLaws extends JPanel {

	/**
	 * Create the panel.
	 */
	public adminLaws() {
		setForeground(Color.BLACK);
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setBackground(Color.WHITE);
		setLayout(null);
		
		JPanel p_head = new JPanel();
		p_head.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.RED, null));
		p_head.setBackground(Color.WHITE);
		p_head.setBounds(73, 29, 706, 42);
		add(p_head);
		p_head.setLayout(null);
		
		JLabel head = new JLabel("             \u6700              \u65B0              \u6CD5              \u89C4");
		head.setForeground(new Color(255, 0, 51));
		head.setFont(new Font("方正粗黑宋简体", Font.PLAIN, 26));
		head.setBounds(42, 0, 600, 42);
		p_head.add(head);
		
		JPanel p_body = new JPanel();
		p_body.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		p_body.setBackground(Color.WHITE);
		p_body.setBounds(73, 81, 706, 179);
		add(p_body);
		p_body.setLayout(null);
		
		JTextArea laws = new JTextArea();
		laws.setBounds(5, 5, 696, 158);
		p_body.add(laws);
		laws.setEditable(false);
		
		JLabel lblNewLabel = new JLabel("\u65B0\u589E\u6CD5\u89C4");
		lblNewLabel.setFont(new Font("微软雅黑 Light", Font.PLAIN, 14));
		lblNewLabel.setBounds(73, 270, 78, 19);
		add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(73, 299, 706, 123);
		add(panel);
		panel.setLayout(null);
		
		JTextArea addLaws = new JTextArea();
		addLaws.setBounds(10, 7, 686, 106);
		panel.add(addLaws);
		
		//添加法规
		JButton add = new JButton("\u6DFB   \u52A0");
		add.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				getLaws.add(addLaws);
			}
		});
		add.setBackground(Color.WHITE);
		add.setFont(new Font("微软雅黑 Light", Font.PLAIN, 14));
		add.setBounds(135, 440, 97, 23);
		add(add);
		
		//更新法规界面，重新从数据库中拿出法规
		JButton refresh = new JButton("\u5237  \u65B0");
		refresh.addMouseListener(new MouseAdapter() {	
			public void mouseClicked(MouseEvent e) {
				getLaws.get(laws);
			}
		});
		refresh.setBackground(Color.WHITE);
		refresh.setFont(new Font("微软雅黑 Light", Font.PLAIN, 14));
		refresh.setBounds(576, 440, 97, 23);
		add(refresh);
		
		//从数据库中获取法规，设置初始版面
		getLaws.get(laws);

	}
}
