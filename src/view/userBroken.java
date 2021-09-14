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
	Vector rowData,columnNames;//�������
	private JTable table;
	private JTextField timeField;
	String carno ;
	String cityno ;
	/**
	 * Create the panel.
	 */
	public userBroken(User u) {
		//����user����
		carno = u.getCar_no();
		cityno = u.getCity_no();
		
		
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel label_1 = new JLabel("\u8FDD\u7AE0\u8BB0\u5F55");
		label_1.setFont(new Font("΢���ź� Light", Font.PLAIN, 16));
		label_1.setBounds(28, 89, 80, 35);
		add(label_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(28, 134, 774, 285);
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		/*
		 * �����м��ĳ�ʼ����
		 * �տ�ʼӦ��ȫ����ʾ�ó�����ȫ��Υ�¼�¼
		 * 
		 */
		String sql = "select * from vehicle_management.break where Car_city_no = '"+cityno+"' and Car_no = '"+carno+"'";
		breakModel bt = new breakModel(sql);
		
		
		table = new JTable(bt);
		table.setColumnSelectionAllowed(true);
		table.setFillsViewportHeight(true);
		table.setSurrendersFocusOnKeystroke(true);
		table.setRowSelectionAllowed(false);
		table.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		table.setBackground(Color.WHITE);
		scrollPane.setViewportView(table);
		
		JLabel label_2 = new JLabel("\u8FDD\u89C4\u65F6\u95F4");
		label_2.setFont(new Font("΢���ź� Light", Font.PLAIN, 16));
		label_2.setBounds(137, 33, 86, 35);
		add(label_2);
		
		timeField = new JTextField();
		timeField.setFont(new Font("΢ܛ�����w Light", Font.PLAIN, 16));
		timeField.setBounds(233, 33, 331, 35);
		add(timeField);
		timeField.setColumns(10);
		
		JButton search = new JButton("\u67E5  \u8BE2");
		search.addMouseListener(new MouseAdapter() {
			//ͨ����Ѱ����Ѱĳʱ�䷢����Υ��
			public void mouseClicked(MouseEvent e) {	
				String time=timeField.getText().trim();
				if(time.equals("")||time.length()!=10) {
					JOptionPane.showMessageDialog(null, "����ȷ��дʱ�䣡��ʽΪyyyy-mm-dd");
				}else {
				String sql = "select * from vehicle_management.break where Car_city_no = '"+cityno+"' and Car_no = '"+carno+"' and Break_time = '"+time+"'";
				//�����µ�����ģ���ಢ����
				breakModel bt = new breakModel(sql);
				//����table
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
