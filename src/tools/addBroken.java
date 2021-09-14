package tools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DataBase.ConnectDB;

public class addBroken {
	public static void add(String city_no, String car_no, String color, String car_type, String time,
			String broken_type, String fine, String debt, String score, String location) {

		// 查询数据库
		Connection conn;
		PreparedStatement ps = null;
		ResultSet rs = null;

		ConnectDB connect = new ConnectDB();
		conn = connect.getConnection();

		try {
			//String sql = "insert into vehicle_management.break values(?,?,?,?,?,?,?,?,?,?)";	
			//ps.setString(1, city_no);
			//ps.setString(2, car_no);
			//ps.setString(3, color);
			//ps.setString(4, car_type);
			//ps.setString(5, time);
			//ps.setString(6, broken_type);
			//ps.setString(7, fine);
			//ps.setString(8, debt);
			//ps.setString(9, score);
			//ps.setString(10, location);
			String sql = "insert into vehicle_management.break values('" + city_no + "',"+"'"+car_no+ "',"+"'"+color+ "',"+"'"+car_type+"',"+"'" + time + "',"+"'" + broken_type + "',"+"'" + fine + "',"+"'" + debt + "',"+"'" + score + "',"+"'" + location + "')";
			ps = conn.prepareStatement(sql);
			
			int i = ps.executeUpdate(sql);
			if(i>0){
                System.out.println("插入成功");
               
            }else {
                System.out.println("插入失败");
               
            }
		} catch (Exception e2) {
			e2.printStackTrace();
		}

		connect.closeConection(ps, rs, conn);

	}
}
