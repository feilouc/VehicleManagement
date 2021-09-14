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
		
		/**设置头部欢迎标语
		 */
		headPan.setBackground(new Color(0, 204, 255));
		headPan.setBounds(0, 0, 997, 80);
		frame.getContentPane().add(headPan);
		headPan.setLayout(null);
		bigTitle.setVerticalAlignment(SwingConstants.BOTTOM);
		bigTitle.setFont(new Font("微軟正黑體 Light", Font.PLAIN, 40));
		bigTitle.setForeground(Color.WHITE);
		bigTitle.setBounds(242, 0, 508, 80);
		headPan.add(bigTitle);
		
		exit.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		exit.setBounds(900, 55, 90, 25);
		exit.addMouseListener(new MouseAdapter() {
			//点击退出登录，退出并回到登录界面
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
		welcome = new JLabel("欢迎您，"+u.getName());
		welcome.setBounds(760, 56, 121, 25);
		welcome.setFont(new Font("微软雅黑 Light", Font.PLAIN, 16));
		welcome.setForeground(Color.BLACK);
		welcome.setBackground(new Color(192, 192, 192));
		headPan.add(welcome);
		function.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		function.setBackground(Color.WHITE);
		function.setBounds(0, 82, 152, 482);
		frame.getContentPane().add(function);
		function.setLayout(null);
		
		/**设置右边功能主体框
		 * 
		 */
		CardLayout c1 = new CardLayout();
		fview.setBackground(Color.WHITE);
		fview.setBounds(157, 82, 829, 482);
		fview.setLayout(c1);
		
		//设置卡片1--最新法规的内容
		userLaws p_law = new userLaws();
		
		//设置卡片2--违章查询的内容
		userSearchCar p_search = new userSearchCar();
		
		
		//设置卡片3--个人违章的内容
		userBroken p_broken = new userBroken(u);
		
				
		//设置卡片4--修改密码的内容
		userChangePW p_changPW = new userChangePW(u);
		
		//加入卡片
		fview.add(p_law, "最新法规");
		fview.add(p_search, "违章查询");
		fview.add(p_broken, "个人违章");
		fview.add(p_changPW, "修改密码");
		
		
		
		frame.getContentPane().add(fview);
		
		
		
		/**设置左边功能选择框
		 */
		//最新法规
		JLabel raw = new JLabel("    \u6700 \u65B0 \u6CD5 \u89C4");
		raw.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				raw.setOpaque(true);  //此句是重点，设置背景颜色必须先将它设置为不透明的，因为默认是透明的。。。
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
				c1.show(fview,"最新法规");
			}
		});
		raw.setFont(new Font("微软雅黑 Light", Font.PLAIN, 16));
		raw.setBounds(1, 5, 146, 75);
		function.add(raw);
		
		//违章查询
		JLabel search = new JLabel("    \u8FDD \u7AE0 \u67E5 \u8BE2");
		search.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				search.setOpaque(true);  //此句是重点，设置背景颜色必须先将它设置为不透明的，因为默认是透明的。。。
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
				c1.show(fview,"违章查询");
			}
		});
		search.setFont(new Font("微软雅黑 Light", Font.PLAIN, 16));
		search.setBounds(1, 85, 146, 75);
		function.add(search);
		
		
		//个人违章
		userBroken.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				userBroken.setOpaque(true);  //此句是重点，设置背景颜色必须先将它设置为不透明的，因为默认是透明的。。。
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
				c1.show(fview,"个人违章");
			}
		});
		userBroken.setFont(new Font("微软雅黑 Light", Font.PLAIN, 16));
		userBroken.setBounds(0, 170, 147, 75);
		
		function.add(userBroken);
		
		
		//修改密码
		changePW.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				changePW.setOpaque(true);  //此句是重点，设置背景颜色必须先将它设置为不透明的，因为默认是透明的。。。
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
				c1.show(fview,"修改密码");
			}
		});
		changePW.setFont(new Font("微软雅黑 Light", Font.PLAIN, 16));
		changePW.setBounds(1, 255, 146, 75);
		
		function.add(changePW);
		
		
		
		
		
		
		
		frame.setBackground(Color.GRAY);
		frame.setTitle("\u7528\u6237\u5927\u5385");
		frame.setBounds(300, 150, 1000, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	
	}
}
