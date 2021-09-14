package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.Color;
import DataBase.*;
import Module.*;
import tools.*;

public class ForgetPW {

	private JFrame frame;
	private JTextField idField;
	private JTextField nameField;
	private JTextField phoneField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForgetPW window = new ForgetPW();
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
	public ForgetPW() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u627E\u56DE\u5BC6\u7801");
		frame.setBounds(500, 250, 507, 396);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel id = new JLabel("\u8BF7\u8F93\u5165\u8D26\u53F7");
		id.setForeground(Color.WHITE);
		id.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		id.setBounds(34, 23, 106, 37);
		frame.getContentPane().add(id);
		
		idField = new JTextField();
		idField.setBounds(34, 56, 431, 48);
		frame.getContentPane().add(idField);
		idField.setColumns(10);
		
		JLabel name = new JLabel("\u8BF7\u8F93\u5165\u59D3\u540D");
		name.setForeground(Color.WHITE);
		name.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		name.setBounds(34, 114, 106, 37);
		frame.getContentPane().add(name);
		
		nameField = new JTextField();
		nameField.setColumns(10);
		nameField.setBounds(34, 152, 431, 48);
		frame.getContentPane().add(nameField);
		
		JLabel phone = new JLabel("\u8BF7\u8F93\u5165\u624B\u673A\u53F7");
		phone.setForeground(Color.WHITE);
		phone.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		phone.setBounds(34, 208, 106, 37);
		frame.getContentPane().add(phone);
		
		phoneField = new JTextField();
		phoneField.setColumns(10);
		phoneField.setBounds(34, 243, 431, 48);
		frame.getContentPane().add(phoneField);
		
		JButton find = new JButton("\u627E\u56DE\u5BC6\u7801");
		find.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//获取输入的id
				String input_id=idField.getText().trim();
				//获取输入的名字
				String input_name=nameField.getText().trim();
				//获取输入的手机号
				String input_phone=phoneField.getText().trim();
				if(input_id.isEmpty()||input_name.isEmpty()||input_phone.isEmpty()) 
				{
					JOptionPane.showMessageDialog(null, "有信息未填！");
				}
				else {
					String pwd = null;
					boolean find = false ;
					
					Connection con;
					PreparedStatement ps =null;
					ResultSet rs = null;
					
					ConnectDB connect =new ConnectDB();
					con=connect.getConnection();
					
					//查询数据库
					try {
						String sql = "select * from vehicle_management.user where id = '"+input_id+"' and name = '"+input_name+"'";
						ps = con.prepareStatement(sql);
						rs=ps.executeQuery();
						
						while(rs.next()) {
							find=true;
							pwd=rs.getString("password").trim();
						}
						
					}catch(Exception e1) {
						e1.printStackTrace();
						}
					//关闭资源
					connect.closeConection(ps, rs, con);
					if(find) {
						JOptionPane.showMessageDialog(null, "您的密码已经发送到您的手机，请注意查收！");
						System.out.println("你的密码是"+pwd);
					}else {
						JOptionPane.showMessageDialog(null, "无查找数据！请检查输入信息是否有误！");
					}
					
				}
				
			}
		});
		find.setBounds(180, 312, 125, 37);
		frame.getContentPane().add(find);
		
		JLabel background = new JLabel("New label");
		background.setIcon(new ImageIcon("C:\\Users\\huang\\Desktop\\image\\register2.jpg"));
		background.setHorizontalAlignment(SwingConstants.TRAILING);
		background.setBounds(-20, 0, 569, 376);
		frame.getContentPane().add(background);
		frame.setVisible(true);
	}
}
