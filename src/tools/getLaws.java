package tools;

import DataBase.*;
import java.sql.*;
import javax.swing.*;
import java.util.*;

public class getLaws {

	// ��÷���
	public static void get(JTextArea t) {

		Connection conn;
		PreparedStatement ps = null;
		ResultSet rs = null;
		// ��ѯ���ݿ�
		ConnectDB connect = new ConnectDB();
		conn = connect.getConnection();

		try {
			String sql = "select * from vehicle_management.laws";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			//Ϊÿ����������
			int id = 1;
			String laws = "";
			while (rs.next()) {
				laws += id;
				id += 1;
				laws += ". ";
				laws += rs.getString(2);
				laws += "\n";
			}
			System.out.println("���laws��ɹ���");
			t.setText(laws);
		} catch (Exception e2) {
			e2.printStackTrace();

		}

		connect.closeConection(ps, rs, conn);

	}

	// ��ӷ���
	public static void add(JTextArea t) {
		Connection conn;
		PreparedStatement ps = null;
		ResultSet rs = null;
		// ��ѯ���ݿ�
		ConnectDB connect = new ConnectDB();
		conn = connect.getConnection();

		try {
			String message = t.getText();
			System.out.println(message);
			String sql = "insert into vehicle_management.laws values(null,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, message);
			if (ps.executeUpdate() == 1) {
				JOptionPane.showMessageDialog(null, "��ӳɹ���");
				t.setText(null);
			} else {
				JOptionPane.showMessageDialog(null, "���ʧ�ܣ�");
			}
			;
		} catch (Exception e2) {
			e2.printStackTrace();

		}

		connect.closeConection(ps, rs, conn);

	}
}
