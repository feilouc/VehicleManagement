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
	//得到选中行的数据
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
		label.setFont(new Font("微软雅黑 Light", Font.PLAIN, 16));
		label.setBounds(28, 36, 104, 35);
		add(label);
		
		JComboBox C_cityno = new JComboBox();
		C_cityno.setBackground(Color.WHITE);
		C_cityno.setModel(new DefaultComboBoxModel(new String[] {"\u7CA4A", "\u7CA4B", "\u9C81A", "\u9C81B"}));
		C_cityno.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		C_cityno.setBounds(154, 38, 55, 32);
		add(C_cityno);
		
		JLabel label_1 = new JLabel("\u8F66\u724C\u53F7\u7801\r\n");
		label_1.setFont(new Font("微软雅黑 Light", Font.PLAIN, 16));
		label_1.setBounds(276, 36, 80, 35);
		add(label_1);
		
		F_carno = new JTextField();
		F_carno.setBounds(378, 39, 221, 35);
		add(F_carno);
		F_carno.setColumns(10);
		
		
		//搜索功能的实现
		JButton search = new JButton("\u67E5  \u8BE2");
		search.addMouseListener(new MouseAdapter() {
			//通过搜索栏查询
			public void mouseClicked(MouseEvent e) {
				String cityno=(String)C_cityno.getSelectedItem();
				String carno=F_carno.getText();
				if(carno.equals("")) {
					JOptionPane.showMessageDialog(null, "车牌号不能为空！");
				}else {
				String sql = "select * from vehicle_management.break where Car_city_no = '"+cityno+"' and Car_no = '"+carno+"'";
				System.out.println(sql);
				//创建新的数据模型类并更新
				bt = new breakModel(sql);
				//更新table
				table.setModel(bt);	
				}
				}
		});
		search.setBackground(Color.WHITE);
		search.setBounds(640, 40, 69, 32);
		add(search);
		
		
		//修改功能的实现
		JButton change = new JButton("\u4FEE   \u6539");
		change.addMouseListener(new MouseAdapter() {
			//选中某一行进行修改
			public void mouseClicked(MouseEvent e) {
				//获得选中的行号
				int rowNum = table.getSelectedRow();
				if(rowNum==-1) {
					//未选中给予提示
					JOptionPane.showMessageDialog(null, "请选择一行");
					return;
				}
				//得到修改行的数据
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
				
				//创建修改窗口
				adminAlter delete = new adminAlter(city_no, car_no, color, car_type, time, broken_type, fine, debt, score, location);
				alterBroken.alter(city_no, car_no, color, car_type, time, broken_type, fine, debt, score, location);
				//更新数据模型
				bt = new breakModel();
				//更新table
				table.setModel(bt);	
			}
		});
		change.setBackground(Color.WHITE);
		change.setBounds(110, 424, 112, 32);
		add(change);
		
		
		//删除功能的实现
		JButton delete = new JButton("\u5220   \u9664");
		delete.addMouseListener(new MouseAdapter() {
			//删除所选中的记录
			public void mouseClicked(MouseEvent e) {
				//获得选中的行号
				int rowNum = table.getSelectedRow();
				if(rowNum==-1) {
					//未选中给予提示
					JOptionPane.showMessageDialog(null, "请选择一行");
					return;
				}
				//得到删除行的数据
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
				
				//更新数据模型
				bt = new breakModel();
				//更新table
				table.setModel(bt);	
				JOptionPane.showMessageDialog(null, "删除成功！");
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
		
		
		/**设置中间的表格内容
		 */
		bt = new breakModel();
		
		
		table = new JTable(bt);
		table.setFillsViewportHeight(true);
		table.setSurrendersFocusOnKeystroke(true);
		table.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		table.setBackground(Color.WHITE);
		scrollPane.setViewportView(table);
		
		JButton refresh = new JButton("\u5237  \u65B0");
		refresh.addMouseListener(new MouseAdapter() {
			//刷新页面
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
