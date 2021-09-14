package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.EtchedBorder;

import tools.addBroken;
import tools.alterBroken;

public class adminAlter {

	private JFrame frame;
	private JTextField F_cityno;
	private JTextField F_carno;
	private JTextField F_color;
	private JTextField F_cartype;
	private JTextField F_time;
	private JTextField F_breakType;
	private JTextField F_fine;
	private JTextField F_debt;
	private JTextField F_score;
	private JTextField F_location;
	
	//修改后的数据
	String a_city_no;
	String a_car_no;
	String a_color;
	String a_car_type;
	String a_time;
	String a_broken_type;
	String a_fine;
	String a_debt;
	String a_score;
	String a_location;
	
	/**
	 * Create the application.
	 */
	public adminAlter(String city_no, String car_no, String color, String car_type, String time, String broken_type,
			String fine, String debt, String score, String location) {
		initialize(city_no, car_no, color, car_type, time, broken_type, fine, debt, score, location);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String city_no, String car_no, String color, String car_type, String time,
			String broken_type, String fine, String debt, String score, String location) {
		frame = new JFrame();
		frame.setTitle("\u4FE1\u606F\u4FEE\u6539");
		frame.setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 719, 488);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 703, 451);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel L_cityno = new JLabel("\u57CE\u5E02\u53F7\u7801");
		L_cityno.setFont(new Font("微软雅黑 Light", Font.PLAIN, 14));
		L_cityno.setBounds(10, 24, 66, 37);
		panel.add(L_cityno);

		JLabel L_carno = new JLabel("\u8F66\u724C\u53F7\u7801");
		L_carno.setFont(new Font("微软雅黑 Light", Font.PLAIN, 14));
		L_carno.setBounds(236, 24, 66, 37);
		panel.add(L_carno);

		JLabel L_color = new JLabel("\u8F66\u8F86\u989C\u8272");
		L_color.setFont(new Font("微软雅黑 Light", Font.PLAIN, 14));
		L_color.setBounds(508, 24, 66, 37);
		panel.add(L_color);

		JLabel L_cartype = new JLabel("\u8F66\u8F86\u7C7B\u578B");
		L_cartype.setFont(new Font("微软雅黑 Light", Font.PLAIN, 14));
		L_cartype.setBounds(10, 132, 66, 37);
		panel.add(L_cartype);

		JLabel L_time = new JLabel("\u8FDD\u89C4\u65F6\u95F4");
		L_time.setFont(new Font("微软雅黑 Light", Font.PLAIN, 14));
		L_time.setBounds(236, 132, 66, 37);
		panel.add(L_time);

		JLabel L_breakType = new JLabel("\u8FDD\u89C4\u7C7B\u578B");
		L_breakType.setFont(new Font("微软雅黑 Light", Font.PLAIN, 14));
		L_breakType.setBounds(508, 132, 66, 37);
		panel.add(L_breakType);

		JLabel L_fine = new JLabel("\u7F5A\u91D1\u7F34\u7EB3");
		L_fine.setFont(new Font("微软雅黑 Light", Font.PLAIN, 14));
		L_fine.setBounds(10, 229, 66, 37);
		panel.add(L_fine);

		JLabel L_give = new JLabel("\u662F\u5426\u7F34\u7EB3");
		L_give.setFont(new Font("微软雅黑 Light", Font.PLAIN, 14));
		L_give.setBounds(236, 229, 66, 37);
		panel.add(L_give);

		JLabel L_score = new JLabel("\u8FDD\u7AE0\u6263\u5206");
		L_score.setFont(new Font("微软雅黑 Light", Font.PLAIN, 14));
		L_score.setBounds(508, 229, 66, 37);
		panel.add(L_score);

		JLabel L_location = new JLabel("\u8FDD\u7AE0\u5730\u70B9");
		L_location.setFont(new Font("微软雅黑 Light", Font.PLAIN, 14));
		L_location.setBounds(10, 325, 66, 37);
		panel.add(L_location);

		F_cityno = new JTextField();
		F_cityno.setBounds(75, 24, 66, 31);
		panel.add(F_cityno);
		F_cityno.setColumns(10);

		F_carno = new JTextField();
		F_carno.setColumns(10);
		F_carno.setBounds(322, 24, 134, 31);
		panel.add(F_carno);

		F_color = new JTextField();
		F_color.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				F_color.setText(null);
			}
		});
		F_color.setColumns(10);
		F_color.setBounds(579, 24, 92, 31);
		panel.add(F_color);

		F_cartype = new JTextField();
		F_cartype.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				F_cartype.setText(null);
			}
		});
		F_cartype.setColumns(10);
		F_cartype.setBounds(75, 132, 66, 31);
		panel.add(F_cartype);

		F_time = new JTextField();
		F_time.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				F_time.setText(null);
			}
		});
		F_time.setColumns(10);
		F_time.setBounds(322, 132, 134, 31);
		panel.add(F_time);

		F_breakType = new JTextField();
		F_breakType.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				F_breakType.setText(null);
			}
		});
		F_breakType.setColumns(10);
		F_breakType.setBounds(579, 132, 92, 31);
		panel.add(F_breakType);

		F_fine = new JTextField();
		F_fine.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				F_fine.setText(null);
			}
		});
		F_fine.setColumns(10);
		F_fine.setBounds(75, 234, 66, 31);
		panel.add(F_fine);

		F_debt = new JTextField();
		F_debt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				F_debt.setText(null);
			}
		});
		F_debt.setColumns(10);
		F_debt.setBounds(322, 234, 134, 31);
		panel.add(F_debt);

		F_score = new JTextField();
		F_score.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				F_score.setText(null);
			}
		});
		F_score.setColumns(10);
		F_score.setBounds(579, 234, 92, 31);
		panel.add(F_score);

		F_location = new JTextField();
		F_location.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				F_location.setText(null);
			}
		});
		F_location.setColumns(10);
		F_location.setBounds(75, 327, 596, 37);
		panel.add(F_location);
		
		//设置原来的数据
		F_cityno.setText(city_no);
		F_carno.setText(car_no);
		F_color.setText(color);
		F_cartype.setText(car_type);
		F_time.setText(time);
		F_breakType.setText(broken_type);
		F_fine.setText(fine);
		F_debt.setText(debt);
		F_score.setText(score);
		F_location.setText(location);
		
		F_cityno.setEditable(false);
		F_carno.setEditable(false);
		
		//对原来数据进行修改
		JButton B_alter = new JButton("\u4FEE  \u6539");
		B_alter.setForeground(Color.RED);
		B_alter.setBackground(Color.WHITE);
		B_alter.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				
				//获得输入的数据
				 a_city_no = F_cityno.getText();
				 a_car_no  = F_carno.getText();
				 a_color   = F_color.getText();
				 a_car_type = F_cartype.getText(); 
				 a_time = F_time.getText();
				 a_broken_type = F_breakType.getText();
				 a_fine = F_fine.getText();
				 a_debt = F_debt.getText();
				 a_score = F_score.getText();
				 a_location = F_location.getText();
				 int get_score = Integer.parseInt(a_score);
				 
				// 当信息全部完整填完时
					if (!a_city_no.isEmpty() && !a_car_no.isEmpty() && !a_color.isEmpty() && !a_car_type.isEmpty()
							&& !a_time.isEmpty() && !a_broken_type.isEmpty() && !a_fine.isEmpty() && !a_debt.isEmpty()
							&& !a_score.isEmpty() && !a_location.isEmpty()) {
									if(a_car_no.length()==5) {
										if(a_color.length()==1) {
											if(get_score>0&&get_score<=12) {
												if(a_time.length()==10) {
													alterBroken.alter(a_city_no,a_car_no,a_color,a_car_type,a_time,a_broken_type,a_fine, a_debt,a_score,a_location);
													JOptionPane.showMessageDialog(null, "修改成功！");
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
		frame.dispose();
			}
		});
		B_alter.setFont(new Font("微软雅黑 Light", Font.PLAIN, 14));
		B_alter.setBounds(153, 390, 108, 31);
		panel.add(B_alter);
		
		JButton back = new JButton("\u53D6  \u6D88");
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
		back.setForeground(Color.RED);
		back.setFont(new Font("微软雅黑 Light", Font.PLAIN, 14));
		back.setBackground(Color.WHITE);
		back.setBounds(466, 390, 108, 31);
		panel.add(back);
		frame.setVisible(true);
	}
}
