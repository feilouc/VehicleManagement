package tools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DataBase.ConnectDB;

public class deleteBroken {
	
	public static void delete(String city_no, String car_no, String color, String car_type, String time,
			String broken_type, String fine, String debt, String score, String location) {

		// 查询数据库
		Connection conn;
		PreparedStatement ps = null;
		ResultSet rs = null;

		ConnectDB connect = new ConnectDB();
		conn = connect.getConnection();

		try {
			//String sql ="DELETE FROM `vehicle_management`.`break` WHERE `Car_city_no` = '"+city_no+"' AND `Car_no` = '"+car_no+"' AND `Break_time` = '"+time+ "' AND `Break_location` = '"+location+"'";
			String sql = "delete from vehicle_management.break where Car_city_no='"+city_no+"' and Car_no='"+car_no+"' and Car_color='"+color+"' and Car_type='"+car_type+"' and Break_time='"+time+"' and Break_type='"+broken_type+"' and fine='"+fine+"' and debt='"+debt+"' and score='"+score+"' and Break_location='"+location+"' LIMIT 1";
			System.out.println(sql);
			
			/*
			ps = conn.prepareStatement(sql);
			ps.setString(1, city_no);
			ps.setString(2, car_no);
			ps.setString(3, color);
			ps.setString(4, car_type);
			ps.setString(5, time);
			ps.setString(6, broken_type);
			ps.setString(7, fine);
			ps.setString(8, debt);
			ps.setString(9, score);
			ps.setString(10, location);
			*/
			
			ps = conn.prepareStatement(sql);
			int i = ps.executeUpdate(sql);
			if(i>0){
                System.out.println("删除成功");
               
            }else {
                System.out.println("删除失败");
               
            }
		} catch (Exception e2) {
			e2.printStackTrace();
		}

		connect.closeConection(ps, rs, conn);

	}
}

