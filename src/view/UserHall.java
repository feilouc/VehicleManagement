package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import java.awt.CardLayout;
import javax.swing.JTextField;
import DataBase.*;
import Module.*;
import tools.*;
import java.sql.*;

public class UserHall {

	public JFrame frame;
	private final JPanel headPan = new JPanel();
	private final JLabel bigTitle = new JLabel(" \u8F66 \u8F86 \u8FDD \u7AE0 \u7BA1 \u7406 \u7CFB \u7EDF");
	private final JLabel exit = new JLabel("\u9000\u51FA\u767B\u5F55");
	private final JPanel function = new JPanel();
	private final JPanel fview = new JPanel();
	private final JLabel userBroken = new JLabel("    \u4E2A \u4EBA \u8FDD \u7AE0");
	private final JLabel changePW = new JLabel("    \u4FEE \u6539 \u5BC6 \u7801");
	private  JLabel welcome = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//UserHall window = new UserHall(u);
					//window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public UserHall(User u) {
		initialize(u);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(User u) {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		
		/**����ͷ����ӭ����
		 */
		headPan.setBackground(new Color(0, 204, 255));
		headPan.setBounds(0, 0, 997, 80);
		frame.getContentPane().add(headPan);
		headPan.setLayout(null);
		bigTitle.setVerticalAlignment(SwingConstants.BOTTOM);
		bigTitle.setFont(new Font("΢ܛ�����w Light", Font.PLAIN, 40));
		bigTitle.setForeground(Color.WHITE);
		bigTitle.setBounds(242, 0, 508, 80);
		headPan.add(bigTitle);
		
		exit.setFont(new Font("΢���ź� Light", Font.PLAIN, 18));
		exit.setBounds(900, 55, 90, 25);
		exit.addMouseListener(new MouseAdapter() {
			//����˳���¼���˳����ص���¼����
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				Login2 l = new Login2();
				l.frame.setVisible(true);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				exit.setForeground(Color.red);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				exit.setForeground(Color.BLACK);
			}
		});
		
		headPan.add(exit);
		welcome = new JLabel("��ӭ����"+u.getName());
		welcome.setBounds(760, 56, 121, 25);
		welcome.setFont(new Font("΢���ź� Light", Font.PLAIN, 16));
		welcome.setForeground(Color.BLACK);
		welcome.setBackground(new Color(192, 192, 192));
		headPan.add(welcome);
		function.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		function.setBackground(Color.WHITE);
		function.setBounds(0, 82, 152, 482);
		frame.getContentPane().add(function);
		function.setLayout(null);
		
		/**�����ұ߹��������
		 * 
		 */
		CardLayout c1 = new CardLayout();
		fview.setBackground(Color.WHITE);
		fview.setBounds(157, 82, 829, 482);
		fview.setLayout(c1);
		
		//���ÿ�Ƭ1--���·��������
		userLaws p_law = new userLaws();
		
		//���ÿ�Ƭ2--Υ�²�ѯ������
		userSearchCar p_search = new userSearchCar();
		
		
		//���ÿ�Ƭ3--����Υ�µ�����
		userBroken p_broken = new userBroken(u);
		
				
		//���ÿ�Ƭ4--�޸����������
		userChangePW p_changPW = new userChangePW(u);
		
		//���뿨Ƭ
		fview.add(p_law, "���·���");
		fview.add(p_search, "Υ�²�ѯ");
		fview.add(p_broken, "����Υ��");
		fview.add(p_changPW, "�޸�����");
		
		
		
		frame.getContentPane().add(fview);
		
		
		
		/**������߹���ѡ���
		 */
		//���·���
		JLabel raw = new JLabel("    \u6700 \u65B0 \u6CD5 \u89C4");
		raw.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				raw.setOpaque(true);  //�˾����ص㣬���ñ�����ɫ�����Ƚ�������Ϊ��͸���ģ���ΪĬ����͸���ġ�����
				raw.setBackground(new Color(0,130,255));
				raw.setForeground(Color.white);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				raw.setOpaque(true); 
				raw.setBackground(new Color(255,255,255));
				raw.setForeground(Color.black);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				c1.show(fview,"���·���");
			}
		});
		raw.setFont(new Font("΢���ź� Light", Font.PLAIN, 16));
		raw.setBounds(1, 5, 146, 75);
		function.add(raw);
		
		//Υ�²�ѯ
		JLabel search = new JLabel("    \u8FDD \u7AE0 \u67E5 \u8BE2");
		search.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				search.setOpaque(true);  //�˾����ص㣬���ñ�����ɫ�����Ƚ�������Ϊ��͸���ģ���ΪĬ����͸���ġ�����
				search.setBackground(new Color(0,130,255));
				search.setForeground(Color.white);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				search.setOpaque(true); 
				search.setBackground(new Color(255,255,255));
				search.setForeground(Color.black);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				c1.show(fview,"Υ�²�ѯ");
			}
		});
		search.setFont(new Font("΢���ź� Light", Font.PLAIN, 16));
		search.setBounds(1, 85, 146, 75);
		function.add(search);
		
		
		//����Υ��
		userBroken.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				userBroken.setOpaque(true);  //�˾����ص㣬���ñ�����ɫ�����Ƚ�������Ϊ��͸���ģ���ΪĬ����͸���ġ�����
				userBroken.setBackground(new Color(0,130,255));
				userBroken.setForeground(Color.white);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				userBroken.setOpaque(true); 
				userBroken.setBackground(new Color(255,255,255));
				userBroken.setForeground(Color.black);

			}
			@Override
			public void mouseClicked(MouseEvent e) {
				c1.show(fview,"����Υ��");
			}
		});
		userBroken.setFont(new Font("΢���ź� Light", Font.PLAIN, 16));
		userBroken.setBounds(0, 170, 147, 75);
		
		function.add(userBroken);
		
		
		//�޸�����
		changePW.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				changePW.setOpaque(true);  //�˾����ص㣬���ñ�����ɫ�����Ƚ�������Ϊ��͸���ģ���ΪĬ����͸���ġ�����
				changePW.setBackground(new Color(0,130,255));
				changePW.setForeground(Color.white);

			}
			@Override
			public void mouseExited(MouseEvent e) {
				changePW.setOpaque(true); 
				changePW.setBackground(new Color(255,255,255));
				changePW.setForeground(Color.black);

			}
			@Override
			public void mouseClicked(MouseEvent e) {
				c1.show(fview,"�޸�����");
			}
		});
		changePW.setFont(new Font("΢���ź� Light", Font.PLAIN, 16));
		changePW.setBounds(1, 255, 146, 75);
		
		function.add(changePW);
		
		
		
		
		
		
		
		frame.setBackground(Color.GRAY);
		frame.setTitle("\u7528\u6237\u5927\u5385");
		frame.setBounds(300, 150, 1000, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	
	}
}
