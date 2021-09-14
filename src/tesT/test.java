package tesT;


import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.*;
import java.awt.*;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
 
public class test extends JFrame implements ActionListener{
 
	
	        JFrame jf;  
	        JPanel jpanel;  
	        JButton jb1, jb2, jb3;  
	        JTextArea jta = null;  
	        JScrollPane jscrollPane;  
	  
	    public test() {  
	  
	        setTitle("JTextAreaTest");  
	        setLayout(new BorderLayout());  
	 
	        jta = new JTextArea(10, 15);  
	        jta.setTabSize(4);  
	        jta.setFont(new Font("标楷体", Font.BOLD, 16));  
	        jta.setLineWrap(true);// 激活自动换行功能  
	        jta.setWrapStyleWord(true);// 激活断行不断字功能  
	        jta.setBackground(Color.CYAN);  
	  
	        jscrollPane = new JScrollPane(jta);  
	        jpanel = new JPanel();  
	        jpanel.setLayout(new GridLayout(1, 3));  
	 
	        jb1 = new JButton("复制");  
	        jb1.addActionListener(this);  
	        jb2 = new JButton("粘贴");  
	        jb2.addActionListener(this);  
	        jb3 = new JButton("剪切");  
	        jb3.addActionListener(this);  
	  
	        jpanel.add(jb1);  
	        jpanel.add(jb2);  
	        jpanel.add(jb3);  
	 
	      add(jscrollPane, BorderLayout.CENTER);  
	      add(jpanel, BorderLayout.SOUTH);  
	 
	       setSize(400, 300);  
	       setLocation(400, 200); 
	       setLocationRelativeTo(null);
	       setDefaultCloseOperation(EXIT_ON_CLOSE);
	       setVisible(true);  
	 
	        
	   }  
	  
	   // 覆盖接口ActionListener的方法actionPerformed  
	   public void actionPerformed(ActionEvent e) {  
		   
	        if (e.getSource() == jb1) {  
	            jta.copy();  
	        } else if (e.getSource() == jb2) {  
	           jta.paste();  
	       } else if (e.getSource() == jb3) {  
	           jta.cut();  
	       }  
	   }  
	  
	    public static void main(String[] args) {  
	       new test();  
	    }  
}

	
	
