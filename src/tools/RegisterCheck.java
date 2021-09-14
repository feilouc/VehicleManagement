package tools;

import DataBase.*;
import java.sql.*;

public class RegisterCheck {
	public  static boolean checkId;
	public  static boolean check_carno;

	// 判断id是否重复
	public static boolean check_id(String id) {

		// 假设最初没有重复
		checkId = true;

		// 查询数据库
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
				// 存在即重复
				checkId = false;
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}

		connect.closeConection(ps, rs, conn);
		return checkId;

	}

	// 判断车牌号是否重复
	public  static boolean check_carno(String carno) {

		// 假设最初没有重复
		check_carno = true;

		// 查询数据库
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
				// 存在即重复
				check_carno = false;
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}

		connect.closeConection(ps, rs, conn);
		return check_carno;

	}

	//判断身份证格式是否正确
	
	
}
