package view;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import DataBase.*;
import Module.*;
import tools.*;
import java.sql.*;
import java.util.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class adminAddBroken extends JPanel {
	private JTextField F_carno;
	private JTextField F_color;
	private JTextField F_time;
	private JTextField F_breaktype;
	private JTextField F_fine;
	private JTextField F_score;
	private JTextField F_location;

	public String city_no;
	public String car_no;
	public String color;
	public String car_type;
	public String time;
	public String broken_type;
	public String fine;
	public String debt;
	public String score;
	public String location;

	/**
	 * Create the panel.
	 */
	public adminAddBroken() {
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setBackground(Color.WHITE);
		setLayout(null);

		JLabel L_head = new JLabel("\u8FDD\u7AE0\u8BB0\u5F55\u6DFB\u52A0");
		L_head.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		L_head.setBounds(10, 10, 130, 42);
		add(L_head);

		JLabel L_cityno = new JLabel("\u8F66\u8F86\u57CE\u5E02\u53F7\u7801");
		L_cityno.setBackground(Color.WHITE);
		L_cityno.setFont(new Font("微软雅黑 Light", Font.PLAIN, 14));
		L_cityno.setBounds(10, 85, 91, 26);
		add(L_cityno);

		JComboBox C_cityno = new JComboBox();
		C_cityno.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		C_cityno.setBackground(Color.WHITE);
		C_cityno.setModel(new DefaultComboBoxModel(new String[] {"\u7CA4A", "\u7CA4B", "\u9C81A", "\u9C81B"}));
		C_cityno.setBounds(111, 83, 80, 30);
		add(C_cityno);

		JLabel L_carno = new JLabel("\u8F66\u724C\u53F7\u7801");
		L_carno.setFont(new Font("微软雅黑 Light", Font.PLAIN, 14));
		L_carno.setBackground(Color.WHITE);
		L_carno.setBounds(301, 85, 66, 26);
		add(L_carno);

		F_carno = new JTextField();
		F_carno.setBounds(377, 83, 142, 30);
		add(F_carno);
		F_carno.setColumns(10);

		JLabel L_color = new JLabel("\u8F66\u8F86\u989C\u8272");
		L_color.setFont(new Font("微软雅黑 Light", Font.PLAIN, 14));
		L_color.setBackground(Color.WHITE);
		L_color.setBounds(598, 85, 66, 26);
		add(L_color);

		F_color = new JTextField();
		F_color.setColumns(10);
		F_color.setBounds(683, 83, 101, 30);
		add(F_color);

		JLabel L_cartype = new JLabel("\u8F66\u8F86\u7C7B\u578B");
		L_cartype.setFont(new Font("微软雅黑 Light", Font.PLAIN, 14));
		L_cartype.setBackground(Color.WHITE);
		L_cartype.setBounds(10, 176, 91, 26);
		add(L_cartype);

		JComboBox C_cartype = new JComboBox();
		C_cartype.setModel(
				new DefaultComboBoxModel(new String[] {"\u5C0F\u6C7D\u8F66", "\u5927\u8D27\u8F66"}));
		C_cartype.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		C_cartype.setBackground(Color.WHITE);
		C_cartype.setBounds(111, 176, 80, 30);
		add(C_cartype);

		JLabel L_time = new JLabel("\u8FDD\u7AE0\u65F6\u95F4");
		L_time.setFont(new Font("微软雅黑 Light", Font.PLAIN, 14));
		L_time.setBackground(Color.WHITE);
		L_time.setBounds(301, 176, 66, 26);
		add(L_time);

		F_time = new JTextField();
		F_time.setColumns(10);
		F_time.setBounds(377, 176, 142, 30);
		add(F_time);

		JLabel L_brokentype = new JLabel("\u8FDD\u7AE0\u7C7B\u578B");
		L_brokentype.setFont(new Font("微软雅黑 Light", Font.PLAIN, 14));
		L_brokentype.setBackground(Color.WHITE);
		L_brokentype.setBounds(598, 176, 66, 26);
		add(L_brokentype);

		F_breaktype = new JTextField();
		F_breaktype.setColumns(10);
		F_breaktype.setBounds(683, 176, 101, 30);
		add(F_breaktype);

		JLabel L_fine = new JLabel("\u7F5A\u6B3E\u91D1\u989D");
		L_fine.setFont(new Font("微软雅黑 Light", Font.PLAIN, 14));
		L_fine.setBackground(Color.WHITE);
		L_fine.setBounds(301, 267, 66, 26);
		add(L_fine);

		F_fine = new JTextField();
		F_fine.setColumns(10);
		F_fine.setBounds(377, 269, 142, 30);
		add(F_fine);

		JLabel L_debt = new JLabel("\u7F5A\u91D1\u662F\u5426\u7F34\u7EB3");
		L_debt.setFont(new Font("微软雅黑 Light", Font.PLAIN, 14));
		L_debt.setBackground(Color.WHITE);
		L_debt.setBounds(10, 267, 91, 26);
		add(L_debt);

		JComboBox C_debt = new JComboBox();
		C_debt.setModel(new DefaultComboBoxModel(new String[] {"\u5426", "\u662F"}));
		C_debt.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		C_debt.setBackground(Color.WHITE);
		C_debt.setBounds(111, 269, 80, 30);
		add(C_debt);

		JLabel L_score = new JLabel("\u8FDD\u7AE0\u6263\u5206");
		L_score.setFont(new Font("微软雅黑 Light", Font.PLAIN, 14));
		L_score.setBackground(Color.WHITE);
		L_score.setBounds(598, 267, 66, 26);
		add(L_score);

		F_score = new JTextField();
		F_score.setColumns(10);
		F_score.setBounds(683, 269, 101, 30);
		add(F_score);

		JLabel L_location = new JLabel("\u8FDD\u7AE0\u5730\u70B9");
		L_location.setFont(new Font("微软雅黑 Light", Font.PLAIN, 14));
		L_location.setBackground(Color.WHITE);
		L_location.setBounds(10, 347, 91, 26);
		add(L_location);

		F_location = new JTextField();
		F_location.setColumns(10);
		F_location.setBounds(111, 336, 673, 42);
		add(F_location);

		// 添加违章信息
		JButton add = new JButton("\u6DFB   \u52A0");
		add.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				// 获取填入的信息
				city_no = (String) C_cityno.getSelectedItem();
				car_no = F_carno.getText();
				color = F_color.getText();
				car_type = (String) C_cartype.getSelectedItem();
				time = F_time.getText();
				broken_type = F_breaktype.getText();
				fine = F_fine.getText();
				debt = (String) C_debt.getSelectedItem();
				score = F_score.getText();
				location = F_location.getText();
				int get_score = 0;
				if(!score.isEmpty()) 
					{ get_score = Integer.parseInt(score);}
				

				// 当信息全部完整填完时
				if (!city_no.isEmpty() && !car_no.isEmpty() && !color.isEmpty() && !car_type.isEmpty()
						&& !time.isEmpty() && !broken_type.isEmpty() && !fine.isEmpty() && !debt.isEmpty()
						&& !score.isEmpty() && !location.isEmpty()) {
								if(car_no.length()==5) {
									if(color.length()==1) {
										if(get_score>0&&get_score<=12) {
											if(time.length()==10) {
												addBroken.add(city_no,car_no,color,car_type,time,broken_type,fine, debt,score,location);
												JOptionPane.showMessageDialog(null, "添加成功！");
											}else {
												JOptionPane.showMessageDialog(null, "请以yyyy-mm-dd的形式填写日期！");
											}
										}else {
											JOptionPane.showMessageDialog(null, "请以正确填写违规扣分！单次违规不得超过12分！");
										}
									}else {
										JOptionPane.showMessageDialog(null, "请以正确的格式填写车辆颜色！");
									}
								}else {
									JOptionPane.showMessageDialog(null, "车牌号码未正确填写！");
								}
				} else {
					JOptionPane.showMessageDialog(null, "请完善所有的相关信息！");
				}

			}
		});
		add.setFont(new Font("微软雅黑 Light", Font.PLAIN, 16));
		add.setBackground(Color.WHITE);
		add.setBounds(377, 388, 124, 40);
		add(add);

		JButton help = new JButton("\u5E2E  \u52A9 ");
		help.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		help.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null,
						"用例展示：\n  城市号码：粤A       车牌号码：12345       颜色：黑\n "
								+ " 类型：小汽车       时间：2021-08-04       违规：闯红灯\n "
								+ " 罚金：200       是否缴纳：是        扣分：12        地点：经十路");
			}
		});
		help.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		help.setBackground(Color.WHITE);
		help.setBounds(687, 22, 97, 23);
		add(help);

	}
}
