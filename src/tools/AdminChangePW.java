package tools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import DataBase.*;
import java.sql.*;

import DataBase.ConnectDB;

public class AdminChangePW {

	
	public static void change(String oldPW, String newPW) {
		
		
		// 查询数据库
		Connection conn;
		PreparedStatement ps = null;
		ResultSet rs = null;

		ConnectDB connect = new ConnectDB();
		conn = connect.getConnection();

		try {

			String sql = "update vehicle_management.admin set password ='" + newPW + "'";
			ps = conn.prepareStatement(sql);
			ps.executeUpdate(sql);
			
			String sql2="select * from vehicle_management.admin ";
			rs=ps.executeQuery(sql2);
			while (rs.next()) {
				
				System.out.println("修改后的密码是"+rs.getString("password"));
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}

		connect.closeConection(ps, rs, conn);


		}

	
	
}

