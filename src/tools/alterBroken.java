package tools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DataBase.ConnectDB;

public class alterBroken {
	public static void alter(String city_no, String car_no, String color, String car_type, String time,
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
			String sql = "update vehicle_management.break set Car_color='"+color+"' , Car_type='"+car_type+"' , Break_time='"+time+"' , Break_type='"+broken_type+"' , fine='"+fine+"' , debt='"+debt+"' ,score='"+score+"' , Break_location='"+location+"' where Car_city_no='"+city_no+"' and Car_no='"+car_no+"'";
			ps = conn.prepareStatement(sql);
			//Car_city_no='"+city_no+"' and Car_no='"+car_no+"'
			int i = ps.executeUpdate(sql);
			if(i>0){
                System.out.println("修改成功");
               
            }else {
                System.out.println("修改失败");
               
            }
		} catch (Exception e2) {
			e2.printStackTrace();
		}

		connect.closeConection(ps, rs, conn);

	}
}
