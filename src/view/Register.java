package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import tools.RegisterCheck;
import java.util.*;
import java.sql.*;
import DataBase.*;
import Module.*;
import tools.*;

public class Register extends JFrame {

	public JFrame frame;
	private JTextField idField;
	private JTextField nameField;
	private JTextField pwField;
	private JTextField car_no;
	private JTextField car_color;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register window = new Register();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//�ж��Ƿ�Ϊ������
	public static boolean isNumeric(String str){
	   for (int i = str.length();--i>=0;){
	       if (!Character.isDigit(str.charAt(i))){
	           return false;
	       }
	   }
	   return true;
	}
	/**
	 * Create the application.
	 */
	public Register() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u7528\u6237\u6CE8\u518C\u754C\u9762");
		frame.setBounds(550, 160, 462, 547);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// �������֤��
		JLabel id = new JLabel("\u8BF7\u8F93\u5165\u8EAB\u4EFD\u8BC1");
		id.setForeground(Color.BLACK);
		id.setBounds(29, 32, 107, 28);
		frame.getContentPane().add(id);

		idField = new JTextField();
		idField.setBounds(29, 59, 386, 45);
		frame.getContentPane().add(idField);
		idField.setColumns(10);

		// ��������
		JLabel name = new JLabel("\u8BF7\u8F93\u5165\u59D3\u540D");
		name.setForeground(Color.BLACK);
		name.setBounds(29, 114, 107, 28);
		frame.getContentPane().add(name);

		// ��������
		JLabel password = new JLabel("\u8BF7\u8F93\u5165\u5BC6\u7801");
		password.setForeground(Color.BLACK);
		password.setBounds(29, 196, 107, 28);
		frame.getContentPane().add(password);

		// ע������˳�����ʵ��
		JButton close = new JButton("\u9000  \u51FA");
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Login2 l2 = new Login2();
				l2.frame.setVisible(true);

			}
		});
		close.setBounds(277, 458, 115, 42);
		frame.getContentPane().add(close);

		// ע���������ʵ��
		JButton help = new JButton("\u5E2E   \u52A9");
		help.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == help) {
					JOptionPane.showMessageDialog(null, "�������֤���˺���ͬ�����μǣ�");
				}
			}
		});
		help.setBounds(341, 10, 97, 23);
		frame.getContentPane().add(help);

		nameField = new JTextField();
		nameField.setColumns(10);
		nameField.setBounds(29, 141, 386, 45);
		frame.getContentPane().add(nameField);

		pwField = new JTextField();
		pwField.setColumns(10);
		pwField.setBounds(29, 224, 386, 45);
		frame.getContentPane().add(pwField);

		JLabel lic = new JLabel("\u8BF7\u9009\u62E9\u9A7E\u7167\u7C7B\u578B");
		lic.setForeground(Color.BLACK);
		lic.setBounds(29, 279, 107, 28);
		frame.getContentPane().add(lic);

		JComboBox licence = new JComboBox();
		licence.setModel(new DefaultComboBoxModel(new String[] { "A1", "B1", "C1", "C2" }));
		licence.setBounds(29, 306, 87, 33);
		frame.getContentPane().add(licence);

		JLabel city = new JLabel("\u8BF7\u9009\u62E9\u8F66\u8F86\u6240\u5728\u57CE\u5E02");
		city.setForeground(Color.BLACK);
		city.setBounds(160, 279, 148, 28);
		frame.getContentPane().add(city);

		JComboBox city_no = new JComboBox();
		city_no.setModel(new DefaultComboBoxModel(new String[] { "\u7CA4A", "\u7CA4B", "\u9C81A", "\u9C81B" }));
		city_no.setBounds(160, 306, 107, 33);
		frame.getContentPane().add(city_no);

		JLabel no = new JLabel("\u8BF7\u8F93\u5165\u8F66\u724C\u53F7");
		no.setForeground(Color.BLACK);
		no.setBounds(300, 279, 148, 28);
		frame.getContentPane().add(no);

		car_no = new JTextField();
		car_no.setBounds(300, 306, 115, 33);
		frame.getContentPane().add(car_no);
		car_no.setColumns(10);

		JLabel type = new JLabel("\u8BF7\u9009\u62E9\u8F66\u8F86\u7C7B\u578B");
		type.setForeground(Color.BLACK);
		type.setBounds(29, 356, 107, 28);
		frame.getContentPane().add(type);

		JComboBox car_type = new JComboBox();
		car_type.setModel(new DefaultComboBoxModel(new String[] { "\u5C0F\u6C7D\u8F66", "\u5927\u8D27\u8F66" }));
		car_type.setBounds(29, 386, 87, 33);
		frame.getContentPane().add(car_type);

		JLabel color = new JLabel("\u8BF7\u8F93\u5165\u8F66\u8F86\u989C\u8272");
		color.setForeground(Color.BLACK);
		color.setBounds(160, 356, 107, 28);
		frame.getContentPane().add(color);

		car_color = new JTextField();
		car_color.setColumns(10);
		car_color.setBounds(160, 386, 255, 33);
		frame.getContentPane().add(car_color);
		
				// ע�ᰴť
				JButton reg = new JButton("\u6CE8   \u518C");
				reg.setBounds(62, 458, 115, 42);
				frame.getContentPane().add(reg);
				reg.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						// ��ȡ���֤
						String input_id = idField.getText().trim();
						// ��ȡ����
						String input_name = nameField.getText().trim();
						// ��ȡ����
						String input_pw = pwField.getText().trim();
						// ��ȡ��������
						String input_lic = licence.getSelectedItem().toString();
						// ��ȡ�������ڳ���
						String input_city_no = city_no.getSelectedItem().toString();
						// ��ȡ���ƺ�
						String input_car_no = car_no.getText().trim();
						// ��ȡ��������
						String input_type = car_type.getSelectedItem().toString();
						// ��ȡ������ɫ
						String input_color = car_color.getText().trim();

						// �ж���Ϣ�Ƿ��������
						if (input_id.isEmpty() || input_name.isEmpty() || input_pw.isEmpty() || input_lic.isEmpty()
								|| input_city_no.isEmpty() || input_car_no.isEmpty() || input_type.isEmpty() || input_color.isEmpty()) {
							JOptionPane.showMessageDialog(null, "����Ϣδ�");
						}else {
							//�ж�id��ʽ�Ƿ���ȷ
							if (input_id.length()!=18 && isNumeric(input_id)) {
								JOptionPane.showMessageDialog(null, "���֤��ʽ����ȷ��");
							}
							//�жϳ��ƺŸ�ʽ�Ƿ���ȷ
							else if (input_car_no.length()!=5) {
								JOptionPane.showMessageDialog(null, "���ƺŸ�ʽ����ȷ��");
							}else {
								//����id�Ƿ��ظ�
								boolean repeat1;
								repeat1 = RegisterCheck.check_id(input_id);//���ظ���true ���ظ���false
								
								//���鳵�ƺ��Ƿ��ظ�
								boolean repeat2;
								repeat2 = RegisterCheck.check_carno (input_id);//���ظ���true ���ظ���false
								System.out.println(repeat1+" "+repeat2);
								if(repeat1&&repeat2) {
									Connection conn_insert;
									PreparedStatement ps_insert=null;
									ResultSet rs_insert=null;
											
									ConnectDB connect_insert =new ConnectDB();
									conn_insert=connect_insert.getConnection();

									try {
										//�������ݿ���
										String sql="insert into vehicle_management.user values ('"+input_id+"','"+input_name+"','"+input_pw+"','"+input_lic+"','"+input_city_no+"','"+input_car_no+"','"+input_type+"','"+input_color+ "')";
										ps_insert=conn_insert.prepareStatement(sql);
										boolean test;
										test=ps_insert.execute(sql);
										//rs_insert=ps_insert.executeQuery(sql);

									}catch(Exception e_insert) {
										e_insert.printStackTrace();
									}
									
									
									connect_insert.closeConection(ps_insert,rs_insert,conn_insert);												
									JOptionPane.showMessageDialog(null, "��ӳɹ���");
									frame.dispose();
								}else {
									JOptionPane.showMessageDialog(null, "���˺��Ѵ��ڣ������������֤�Ż��ƺ��Ƿ���ȷ");
								}
								
							}
							
							
						}

					}
				});

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\huang\\Desktop\\image\\register1.jpg"));
		lblNewLabel.setBounds(0, 0, 448, 510);
		frame.getContentPane().add(lblNewLabel);
	}
}
