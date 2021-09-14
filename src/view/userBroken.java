package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import DataBase.*;
import Module.*;
import tools.*;
import java.sql.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class userBroken extends JPanel {
	Vector rowData,columnNames;//表格内容
	private JTable table;
	private JTextField timeField;
	String carno ;
	String cityno ;
	/**
	 * Create the panel.
	 */
	public userBroken(User u) {
		//设置user属性
		carno = u.getCar_no();
		cityno = u.getCity_no();
		
		
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel label_1 = new JLabel("\u8FDD\u7AE0\u8BB0\u5F55");
		label_1.setFont(new Font("微软雅黑 Light", Font.PLAIN, 16));
		label_1.setBounds(28, 89, 80, 35);
		add(label_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(28, 134, 774, 285);
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		/*
		 * 设置中间表的初始内容
		 * 刚开始应该全部显示该车主的全部违章记录
		 * 
		 */
		String sql = "select * from vehicle_management.break where Car_city_no = '"+cityno+"' and Car_no = '"+carno+"'";
		breakModel bt = new breakModel(sql);
		
		
		table = new JTable(bt);
		table.setColumnSelectionAllowed(true);
		table.setFillsViewportHeight(true);
		table.setSurrendersFocusOnKeystroke(true);
		table.setRowSelectionAllowed(false);
		table.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		table.setBackground(Color.WHITE);
		scrollPane.setViewportView(table);
		
		JLabel label_2 = new JLabel("\u8FDD\u89C4\u65F6\u95F4");
		label_2.setFont(new Font("微软雅黑 Light", Font.PLAIN, 16));
		label_2.setBounds(137, 33, 86, 35);
		add(label_2);
		
		timeField = new JTextField();
		timeField.setFont(new Font("微軟正黑體 Light", Font.PLAIN, 16));
		timeField.setBounds(233, 33, 331, 35);
		add(timeField);
		timeField.setColumns(10);
		
		JButton search = new JButton("\u67E5  \u8BE2");
		search.addMouseListener(new MouseAdapter() {
			//通过搜寻栏搜寻某时间发生的违规
			public void mouseClicked(MouseEvent e) {	
				String time=timeField.getText().trim();
				if(time.equals("")||time.length()!=10) {
					JOptionPane.showMessageDialog(null, "请正确填写时间！格式为yyyy-mm-dd");
				}else {
				String sql = "select * from vehicle_management.break where Car_city_no = '"+cityno+"' and Car_no = '"+carno+"' and Break_time = '"+time+"'";
				//创建新的数据模型类并更新
				breakModel bt = new breakModel(sql);
				//更新table
				table.setModel(bt);	
				}
			}
		});
		search.setBackground(Color.WHITE);
		search.setBounds(636, 33, 69, 32);
		add(search);
		
		JButton refresh = new JButton("\u5237  \u65B0");
		refresh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String sql = "select * from vehicle_management.break where Car_city_no = '"+cityno+"' and Car_no = '"+carno+"'";
				breakModel bt = new breakModel(sql);
				table.setModel(bt);
			}
		});
		refresh.setBackground(Color.WHITE);
		refresh.setBounds(733, 33, 69, 32);
		add(refresh);
		
		
		
		
		
		

	}
}
