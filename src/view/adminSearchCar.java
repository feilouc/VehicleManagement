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


public class adminSearchCar extends JPanel {
	private JTextField F_carno;
	breakModel bt;
	//�õ�ѡ���е�����
	String city_no ;
	String car_no; 
	String color ;
	String car_type;
	String time;
	String broken_type;
	String fine;
	String debt;
	String score;
	String location;

	private JTable table;
	/**
	 * Create the panel.
	 */
	public adminSearchCar() {
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
		
		
		//�������ܵ�ʵ��
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
				System.out.println(sql);
				//�����µ�����ģ���ಢ����
				bt = new breakModel(sql);
				//����table
				table.setModel(bt);	
				}
				}
		});
		search.setBackground(Color.WHITE);
		search.setBounds(640, 40, 69, 32);
		add(search);
		
		
		//�޸Ĺ��ܵ�ʵ��
		JButton change = new JButton("\u4FEE   \u6539");
		change.addMouseListener(new MouseAdapter() {
			//ѡ��ĳһ�н����޸�
			public void mouseClicked(MouseEvent e) {
				//���ѡ�е��к�
				int rowNum = table.getSelectedRow();
				if(rowNum==-1) {
					//δѡ�и�����ʾ
					JOptionPane.showMessageDialog(null, "��ѡ��һ��");
					return;
				}
				//�õ��޸��е�����
				city_no = (String)bt.getValueAt(rowNum, 0);
				car_no = (String)bt.getValueAt(rowNum, 1); 
				color = (String)bt.getValueAt(rowNum, 2);
				car_type = (String)bt.getValueAt(rowNum, 3);
				time  = (String)bt.getValueAt(rowNum, 4);
				broken_type  = (String)bt.getValueAt(rowNum, 5);
				fine  = (String)bt.getValueAt(rowNum, 6);
				debt  = (String)bt.getValueAt(rowNum, 7);
				score  = (String)bt.getValueAt(rowNum, 8);
				location  = (String)bt.getValueAt(rowNum, 9);
				
				//�����޸Ĵ���
				adminAlter delete = new adminAlter(city_no, car_no, color, car_type, time, broken_type, fine, debt, score, location);
				alterBroken.alter(city_no, car_no, color, car_type, time, broken_type, fine, debt, score, location);
				//��������ģ��
				bt = new breakModel();
				//����table
				table.setModel(bt);	
			}
		});
		change.setBackground(Color.WHITE);
		change.setBounds(110, 424, 112, 32);
		add(change);
		
		
		//ɾ�����ܵ�ʵ��
		JButton delete = new JButton("\u5220   \u9664");
		delete.addMouseListener(new MouseAdapter() {
			//ɾ����ѡ�еļ�¼
			public void mouseClicked(MouseEvent e) {
				//���ѡ�е��к�
				int rowNum = table.getSelectedRow();
				if(rowNum==-1) {
					//δѡ�и�����ʾ
					JOptionPane.showMessageDialog(null, "��ѡ��һ��");
					return;
				}
				//�õ�ɾ���е�����
				city_no = (String)bt.getValueAt(rowNum, 0);
				car_no = (String)bt.getValueAt(rowNum, 1); 
				color = (String)bt.getValueAt(rowNum, 2);
				car_type = (String)bt.getValueAt(rowNum, 3);
				time  = (String)bt.getValueAt(rowNum, 4);
				broken_type  = (String)bt.getValueAt(rowNum, 5);
				fine  = (String)bt.getValueAt(rowNum, 6);
				debt  = (String)bt.getValueAt(rowNum, 7);
				score  = (String)bt.getValueAt(rowNum, 8);
				location  = (String)bt.getValueAt(rowNum, 9);
				
				//System.out.println(city_no+"  "+car_no+"  "+color+"  "+car_type+"  "+time+"  "+broken_type+"  "+fine+"  "+debt+"  "+score+"  "+location);
				
				deleteBroken.delete(city_no, car_no, color, car_type, time, broken_type, fine, debt, score, location);	
				
				//��������ģ��
				bt = new breakModel();
				//����table
				table.setModel(bt);	
				JOptionPane.showMessageDialog(null, "ɾ���ɹ���");
			}
		});
		delete.setBackground(Color.WHITE);
		delete.setBounds(616, 424, 112, 32);
		add(delete);
		
		JPanel panel = new JPanel();
		panel.setBounds(28, 99, 774, 315);
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		
		/**�����м�ı������
		 */
		bt = new breakModel();
		
		
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
				bt = new breakModel();
				table.setModel(bt);
			}
		});
		refresh.setBackground(Color.WHITE);
		refresh.setBounds(738, 40, 69, 32);
		add(refresh);
		
		
		
		
		
		

	}
}
