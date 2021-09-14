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
import javax.swing.border.BevelBorder;
import javax.swing.*;
import DataBase.*;
import Module.*;
import tools.*;
import java.sql.*;


public class AdminHall {

	public JFrame frame;
	private final JPanel headPan = new JPanel();
	private final JLabel bigTitle = new JLabel(" \u8F66 \u8F86 \u8FDD \u7AE0 \u7BA1 \u7406 \u7CFB \u7EDF");
	private final JLabel welcome = new JLabel("Admin");
	private final JLabel exit = new JLabel("\u9000\u51FA\u767B\u5F55");
	private final JPanel function = new JPanel();
	private final JPanel fview = new JPanel();
	private final JLabel addBroken = new JLabel("        \u6DFB \u52A0 \u8FDD \u7AE0");
	private final JLabel changePW = new JLabel("        \u4FEE \u6539 \u5BC6 \u7801");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminHall window = new AdminHall();
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
	public AdminHall() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		
		//����ͷ����ӭ����
		headPan.setBackground(new Color(0, 204, 255));
		headPan.setBounds(0, 0, 1000, 80);
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
		welcome.setBounds(816, 55, 74, 25);
		headPan.add(welcome);
		welcome.setFont(new Font("΢���ź� Light", Font.PLAIN, 18));
		welcome.setForeground(Color.BLACK);
		welcome.setBackground(new Color(192, 192, 192));
		
		
		
		//�����ұ߹��������
		CardLayout c1 = new CardLayout();
		fview.setLayout(c1);
		fview.setBackground(Color.WHITE);
		fview.setBounds(166, 82, 820, 482);
		
		
		//���ÿ�Ƭ1--���·��������
		adminLaws p_Law = new adminLaws();
		
		
		
		//���ÿ�Ƭ2--Υ�²�ѯ������
		adminSearchCar p_search = new adminSearchCar();
		
		
		//���ÿ�Ƭ3--���Υ�µ�����
		adminAddBroken p_add = new adminAddBroken();

				
		//���ÿ�Ƭ4--�޸����������
		adminChangePW p_changPW = new adminChangePW();
		
		//���뿨Ƭ
		fview.add(p_Law, "���·���");
		fview.add(p_search, "Υ�²�ѯ");
		fview.add(p_add, "���Υ��");
		fview.add(p_changPW, "�޸�����");
		
		frame.getContentPane().add(fview);
		
		//������߹���ѡ���
		function.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		function.setBackground(Color.WHITE);
		function.setBounds(0, 81, 165, 481);
		frame.getContentPane().add(function);
		function.setLayout(null);
		
		
		//���·���
		JLabel raw = new JLabel("        \u6700 \u65B0 \u6CD5 \u89C4");
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
			//��ʾ��Ƭ1--���·��������
			public void mouseClicked(MouseEvent e) {
				c1.show(fview,"���·���");
			}
		});
		raw.setFont(new Font("΢���ź� Light", Font.PLAIN, 16));
		raw.setBounds(3, 5, 156, 75);
		function.add(raw);
		
		//Υ�²�ѯ
		JLabel search = new JLabel("        \u8FDD \u7AE0 \u67E5 \u8BE2");
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
			//��ʾ��Ƭ2--Υ�²�ѯ������
			public void mouseClicked(MouseEvent e) {
				c1.show(fview,"Υ�²�ѯ");
			}
		});
		search.setFont(new Font("΢���ź� Light", Font.PLAIN, 16));
		search.setBounds(3, 80, 156, 75);
		function.add(search);
		
		//���Υ��
		addBroken.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				addBroken.setOpaque(true);  //�˾����ص㣬���ñ�����ɫ�����Ƚ�������Ϊ��͸���ģ���ΪĬ����͸���ġ�����
				addBroken.setBackground(new Color(0,130,255));
				addBroken.setForeground(Color.white);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				addBroken.setOpaque(true); 
				addBroken.setBackground(new Color(255,255,255));
				addBroken.setForeground(Color.black);
			}
			//��ʾ��Ƭ��--���Υ�µ�����
			public void mouseClicked(MouseEvent e) {
				c1.show(fview,"���Υ��");
			}
		});

		addBroken.setFont(new Font("΢���ź� Light", Font.PLAIN, 16));
		addBroken.setBounds(2, 155, 157, 75);
		
		function.add(addBroken);
		
		
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
			//��ʾ��Ƭ��--�޸����������
			public void mouseClicked(MouseEvent e) {
				c1.show(fview,"�޸�����");
				
			}
		});
		changePW.setFont(new Font("΢���ź� Light", Font.PLAIN, 16));
		changePW.setBounds(2, 230, 157, 75);
		
		function.add(changePW);
		
		frame.setBackground(Color.GRAY);
		frame.setTitle("\u7BA1\u7406\u5458\u5927\u5385");
		frame.setBounds(300, 150, 1000, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		
		
	
	
	}
}
