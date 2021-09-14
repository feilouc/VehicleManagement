package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;
import DataBase.*;
import Module.*;
import tools.*;

public class Login2 extends JFrame {

	public JFrame frame;
	public JTextField idField;
	public JPasswordField passwordField;
	static String get_id;
	static String get_name;
	static String get_licence;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login2 window = new Login2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setFont(new Font("微软雅黑", Font.PLAIN, 12));
		frame.getContentPane().setForeground(Color.BLACK);
		frame.setForeground(Color.WHITE);
		frame.setTitle("车辆违章管理系统");
		frame.setBounds(400, 170, 701, 532);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel bg = new JLabel("New label");
		bg.setIcon(new ImageIcon("C:\\Users\\huang\\Desktop\\image\\login.jpg"));
		bg.setBounds(0, 0, 445, 495);
		frame.getContentPane().add(bg);
		
		JLabel car = new JLabel("New label");
		car.setIcon(new ImageIcon("C:\\Users\\huang\\Desktop\\image\\car.png"));
		car.setBounds(468, 0, 191, 150);
		frame.getContentPane().add(car);
		
		JLabel label = new JLabel("欢迎登录车辆违章管理系统！");
		label.setFont(new Font("方正粗黑宋简体", Font.PLAIN, 14));
		label.setBounds(485, 160, 202, 49);
		frame.getContentPane().add(label);
		
		//登录身份选择
		JComboBox choose = new JComboBox();
		choose.setBackground(Color.WHITE);
		choose.setModel(new DefaultComboBoxModel(new String[] {"管理员", "用户"}));
		choose.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		choose.setBounds(455, 214, 232, 35);
		frame.getContentPane().add(choose);
		
		//输入账号
		JLabel id = new JLabel("账  号");
		id.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		id.setBounds(455, 265, 58, 15);
		frame.getContentPane().add(id);
		
		idField = new JTextField();
		idField.setBounds(455, 290, 232, 35);
		frame.getContentPane().add(idField);
		idField.setColumns(10);
		
		
		//输入密码
		JLabel password = new JLabel("密  码");
		password.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		password.setBounds(455, 349, 58, 15);
		frame.getContentPane().add(password);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(455, 374, 232, 35);
		frame.getContentPane().add(passwordField);
		
		//注册
		JButton register = new JButton("\u7528\u6237\u6CE8\u518C");
		register.setBackground(Color.WHITE);
		register.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Register reg = new Register();
				reg.frame.setVisible(true);
			}
		});
		register.setBounds(456, 430, 97, 23);
		frame.getContentPane().add(register);
		
		//忘记密码
		JButton forget = new JButton("忘记密码");
		forget.setBackground(Color.WHITE);
		forget.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		forget.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ForgetPW fpw = new ForgetPW();
				
			}
		});
		forget.setBounds(588, 430, 97, 23);
		frame.getContentPane().add(forget);
		
		
		//登录
		JButton signUp = new JButton("登    录");
		signUp.setBackground(Color.WHITE);
		signUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//管理员登录
				if(choose.getSelectedItem().toString()=="管理员")
				{
					
					//输入的id和密码
					get_id=idField.getText().trim();
					String get_password=new String(passwordField.getPassword());
				
					
					//数据库中的id和密码
					String id = null;
					String password=null;
					
					//假如输入id非空
					if(!get_id.isEmpty()) {
						Connection con;
						PreparedStatement ps=null;
						ResultSet rs=null;
						
						ConnectDB connect =new ConnectDB();
						con=connect.getConnection();
						try {
							//查询数据库
							String sql="select * from vehicle_management.admin where id ='"+get_id+"'";
							ps=con.prepareStatement(sql);
							rs=ps.executeQuery();
						
							while(rs.next()) {
								
								id=rs.getString("id");//拿出数据库中的用户id
								password=rs.getString("password").trim();//拿出数据库中的用户password
							}
							
							if(get_password.equals(password)) {
								AdminHall admin=new AdminHall();
								System.out.println("管理员登录成功");
								System.out.println("管理员姓名：" + id);
								System.out.println("管理员密码：" + password);
								dispose();
								
							}else {
								JOptionPane.showMessageDialog(null, "用户名或密码不正确！");
							}
							
							
						}catch(Exception e1) {
							e1.printStackTrace();
						}
						
						connect.closeConection(ps,rs,con);
					}
				}

				//用户登录
				else
				{
					//输入的id和密码
					get_id=idField.getText().trim();
					String get_password=new String(passwordField.getPassword());

					//数据库中的id和密码
					String id = null;
					String password=null;
					String license=null;
					String city_no=null;
					String car_no=null;
					String car_type=null;
					String car_color=null;
					

					//id格式正确且不为空
					if(!get_id.isEmpty()) {
						
						Connection conn;
						PreparedStatement ps=null;
						ResultSet rs=null;
						
						ConnectDB connect =new ConnectDB();
						conn=connect.getConnection();
						
						try {
							//查询数据库
							String sql="select * from vehicle_management.user where id ='"+get_id+"'";
							ps=conn.prepareStatement(sql);
							rs=ps.executeQuery();
						
							//拿出数据库中的用户属性
								while(rs.next()) {
								get_name=rs.getString("name");
								id=rs.getString("id");
								password=rs.getString("password").trim();
								license=rs.getString("license").trim();
								city_no=rs.getString("city_no").trim();
							    car_no=rs.getString("car_no").trim();
								car_type=rs.getString("car_type").trim();
								car_color=rs.getString("car_color").trim();
								}
							
								if(get_password.equals(password)) {
									
								//登陆成功后封装User属性
								User u = new User();
								u.setId(id);
								u.setName(get_name);
								u.setPassword(password);
								u.setLicence(license);
								u.setCity_no(city_no);
								u.setCar_no(car_no);
								u.setCar_type(car_type);
								u.setCar_color(car_color);
								
								frame.dispose();
								UserHall userHall=new UserHall(u);
								
								
								System.out.println("用户登录成功");
								System.out.println("用户姓名：" + get_name);
								System.out.println("用户id：" + get_id);
								System.out.println("用户密码：" + password);
								
								}else {
								JOptionPane.showMessageDialog(null, "账号或密码不正确！您的账号是您的身份证号");
								}
							
							
							}catch(Exception e2) {
							e2.printStackTrace();
						}
						
						connect.closeConection(ps,rs,conn);
					}else {
						JOptionPane.showMessageDialog(null, "用户名为空或格式不正确！");
					}
				}
					
				
			
			
			}});
		
		signUp.setBounds(514,460,114,32);
		frame.getContentPane().add(signUp);
		
}
}
