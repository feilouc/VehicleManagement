package tools;

import DataBase.*;
import java.sql.*;
import javax.swing.*;
import java.util.*;

public class getLaws {

	// 获得法规
	public static void get(JTextArea t) {

		Connection conn;
		PreparedStatement ps = null;
		ResultSet rs = null;
		// 查询数据库
		ConnectDB connect = new ConnectDB();
		conn = connect.getConnection();

		try {
			String sql = "select * from vehicle_management.laws";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			//为每条法规起编号
			int id = 1;
			String laws = "";
			while (rs.next()) {
				laws += id;
				id += 1;
				laws += ". ";
				laws += rs.getString(2);
				laws += "\n";
			}
			System.out.println("获得laws表成功！");
			t.setText(laws);
		} catch (Exception e2) {
			e2.printStackTrace();

		}

		connect.closeConection(ps, rs, conn);

	}

	// 添加法规
	public static void add(JTextArea t) {
		Connection conn;
		PreparedStatement ps = null;
		ResultSet rs = null;
		// 查询数据库
		ConnectDB connect = new ConnectDB();
		conn = connect.getConnection();

		try {
			String message = t.getText();
			System.out.println(message);
			String sql = "insert into vehicle_management.laws values(null,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, message);
			if (ps.executeUpdate() == 1) {
				JOptionPane.showMessageDialog(null, "添加成功！");
				t.setText(null);
			} else {
				JOptionPane.showMessageDialog(null, "添加失败！");
			}
			;
		} catch (Exception e2) {
			e2.printStackTrace();

		}

		connect.closeConection(ps, rs, conn);

	}
}
