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


public class userSearchCar extends JPanel {
	private JTextField F_carno;

	private JTable table;
	/**
	 * Create the panel.
	 */
	public userSearchCar() {
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel label = new JLabel("\u8F66\u8F86\u57CE\u5E02\u53F7\u7801");
		label.setFont(new Font("΢���ź� Light", Font.PLAIN, 16));
		label.setBounds(28, 36, 104, 35);
		add(label);
		
		JComboBox C_cityno = new JComboBox();
		C_cityno.setBackground(Color.WHITE);
		C_cityno.setModel(new DefaultComboBoxModel(new String[] {"\u7CA4A", "\u7CA4B", "\u9C81A", "\u9C81B"}));
		C_cityno.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		C_cityno.setBounds(154, 38, 55, 32);
		add(C_cityno);
		
		JLabel label_1 = new JLabel("\u8F66\u724C\u53F7\u7801\r\n");
		label_1.setFont(new Font("΢���ź� Light", Font.PLAIN, 16));
		label_1.setBounds(276, 36, 80, 35);
		add(label_1);
		
		F_carno = new JTextField();
		F_carno.setBounds(378, 39, 221, 35);
		add(F_carno);
		F_carno.setColumns(10);
		
		JButton search = new JButton("\u67E5  \u8BE2");
		search.addMouseListener(new MouseAdapter() {
			//ͨ����������ѯ
			public void mouseClicked(MouseEvent e) {
				String cityno=(String)C_cityno.getSelectedItem();
				String carno=F_carno.getText();
				if(carno.equals("")) {
					JOptionPane.showMessageDialog(null, "���ƺŲ���Ϊ�գ�");
				}else {
				String sql = "select * from vehicle_management.break where Car_city_no = '"+cityno+"' and Car_no = '"+carno+"'";
				//�����µ�����ģ���ಢ����
				breakModel bt = new breakModel(sql);
				//����table
				table.setModel(bt);	
				}
				}
		});
		search.setBackground(Color.WHITE);
		search.setBounds(640, 40, 69, 32);
		add(search);
		
		JPanel panel = new JPanel();
		panel.setBounds(28, 99, 774, 350);
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		
		/**�����м�ı������
		 */
		breakModel bt = new breakModel();
		
		
		
		
		table = new JTable(bt);
		table.setFillsViewportHeight(true);
		table.setSurrendersFocusOnKeystroke(true);
		table.setFont(new Font("΢���ź�", Font.PLAIN, 13));
		table.setBackground(Color.WHITE);
		scrollPane.setViewportView(table);
		
		JButton refresh = new JButton("\u5237  \u65B0");
		refresh.addMouseListener(new MouseAdapter() {
			//ˢ��ҳ��
			public void mouseClicked(MouseEvent e) {
				breakModel bt = new breakModel();
				table.setModel(bt);
			}
		});
		refresh.setBackground(Color.WHITE);
		refresh.setBounds(738, 40, 69, 32);
		add(refresh);
		
		
		
		
		
		

	}
}
