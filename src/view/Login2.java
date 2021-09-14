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
		frame.getContentPane().setFont(new Font("΢���ź�", Font.PLAIN, 12));
		frame.getContentPane().setForeground(Color.BLACK);
		frame.setForeground(Color.WHITE);
		frame.setTitle("����Υ�¹���ϵͳ");
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
		
		JLabel label = new JLabel("��ӭ��¼����Υ�¹���ϵͳ��");
		label.setFont(new Font("�����ֺ��μ���", Font.PLAIN, 14));
		label.setBounds(485, 160, 202, 49);
		frame.getContentPane().add(label);
		
		//��¼���ѡ��
		JComboBox choose = new JComboBox();
		choose.setBackground(Color.WHITE);
		choose.setModel(new DefaultComboBoxModel(new String[] {"����Ա", "�û�"}));
		choose.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		choose.setBounds(455, 214, 232, 35);
		frame.getContentPane().add(choose);
		
		//�����˺�
		JLabel id = new JLabel("��  ��");
		id.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		id.setBounds(455, 265, 58, 15);
		frame.getContentPane().add(id);
		
		idField = new JTextField();
		idField.setBounds(455, 290, 232, 35);
		frame.getContentPane().add(idField);
		idField.setColumns(10);
		
		
		//��������
		JLabel password = new JLabel("��  ��");
		password.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		password.setBounds(455, 349, 58, 15);
		frame.getContentPane().add(password);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(455, 374, 232, 35);
		frame.getContentPane().add(passwordField);
		
		//ע��
		JButton register = new JButton("\u7528\u6237\u6CE8\u518C");
		register.setBackground(Color.WHITE);
		register.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Register reg = new Register();
				reg.frame.setVisible(true);
			}
		});
		register.setBounds(456, 430, 97, 23);
		frame.getContentPane().add(register);
		
		//��������
		JButton forget = new JButton("��������");
		forget.setBackground(Color.WHITE);
		forget.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		forget.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ForgetPW fpw = new ForgetPW();
				
			}
		});
		forget.setBounds(588, 430, 97, 23);
		frame.getContentPane().add(forget);
		
		
		//��¼
		JButton signUp = new JButton("��    ¼");
		signUp.setBackground(Color.WHITE);
		signUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//����Ա��¼
				if(choose.getSelectedItem().toString()=="����Ա")
				{
					
					//�����id������
					get_id=idField.getText().trim();
					String get_password=new String(passwordField.getPassword());
				
					
					//���ݿ��е�id������
					String id = null;
					String password=null;
					
					//��������id�ǿ�
					if(!get_id.isEmpty()) {
						Connection con;
						PreparedStatement ps=null;
						ResultSet rs=null;
						
						ConnectDB connect =new ConnectDB();
						con=connect.getConnection();
						try {
							//��ѯ���ݿ�
							String sql="select * from vehicle_management.admin where id ='"+get_id+"'";
							ps=con.prepareStatement(sql);
							rs=ps.executeQuery();
						
							while(rs.next()) {
								
								id=rs.getString("id");//�ó����ݿ��е��û�id
								password=rs.getString("password").trim();//�ó����ݿ��е��û�password
							}
							
							if(get_password.equals(password)) {
								AdminHall admin=new AdminHall();
								System.out.println("����Ա��¼�ɹ�");
								System.out.println("����Ա������" + id);
								System.out.println("����Ա���룺" + password);
								dispose();
								
							}else {
								JOptionPane.showMessageDialog(null, "�û��������벻��ȷ��");
							}
							
							
						}catch(Exception e1) {
							e1.printStackTrace();
						}
						
						connect.closeConection(ps,rs,con);
					}
				}

				//�û���¼
				else
				{
					//�����id������
					get_id=idField.getText().trim();
					String get_password=new String(passwordField.getPassword());

					//���ݿ��е�id������
					String id = null;
					String password=null;
					String license=null;
					String city_no=null;
					String car_no=null;
					String car_type=null;
					String car_color=null;
					

					//id��ʽ��ȷ�Ҳ�Ϊ��
					if(!get_id.isEmpty()) {
						
						Connection conn;
						PreparedStatement ps=null;
						ResultSet rs=null;
						
						ConnectDB connect =new ConnectDB();
						conn=connect.getConnection();
						
						try {
							//��ѯ���ݿ�
							String sql="select * from vehicle_management.user where id ='"+get_id+"'";
							ps=conn.prepareStatement(sql);
							rs=ps.executeQuery();
						
							//�ó����ݿ��е��û�����
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
									
								//��½�ɹ����װUser����
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
								
								
								System.out.println("�û���¼�ɹ�");
								System.out.println("�û�������" + get_name);
								System.out.println("�û�id��" + get_id);
								System.out.println("�û����룺" + password);
								
								}else {
								JOptionPane.showMessageDialog(null, "�˺Ż����벻��ȷ�������˺����������֤��");
								}
							
							
							}catch(Exception e2) {
							e2.printStackTrace();
						}
						
						connect.closeConection(ps,rs,conn);
					}else {
						JOptionPane.showMessageDialog(null, "�û���Ϊ�ջ��ʽ����ȷ��");
					}
				}
					
				
			
			
			}});
		
		signUp.setBounds(514,460,114,32);
		frame.getContentPane().add(signUp);
		
}
}
