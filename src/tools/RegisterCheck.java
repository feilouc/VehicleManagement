package tools;

import DataBase.*;
import java.sql.*;

public class RegisterCheck {
	public  static boolean checkId;
	public  static boolean check_carno;

	// �ж�id�Ƿ��ظ�
	public static boolean check_id(String id) {

		// �������û���ظ�
		checkId = true;

		// ��ѯ���ݿ�
		Connection conn;
		PreparedStatement ps = null;
		ResultSet rs = null;

		ConnectDB connect = new ConnectDB();
		conn = connect.getConnection();

		try {

			String sql = "select * from vehicle_management.user where id='" + id + "'";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				// ���ڼ��ظ�
				checkId = false;
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}

		connect.closeConection(ps, rs, conn);
		return checkId;

	}

	// �жϳ��ƺ��Ƿ��ظ�
	public  static boolean check_carno(String carno) {

		// �������û���ظ�
		check_carno = true;

		// ��ѯ���ݿ�
		Connection conn;
		PreparedStatement ps = null;
		ResultSet rs = null;

		ConnectDB connect = new ConnectDB();
		conn = connect.getConnection();

		try {

			String sql = "select * from vehicle_management.user where car_no='" + carno + "'";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				// ���ڼ��ظ�
				check_carno = false;
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}

		connect.closeConection(ps, rs, conn);
		return check_carno;

	}

	//�ж����֤��ʽ�Ƿ���ȷ
	
	
}
