package DataBase;

import java.sql.*;

public class ConnectDB {

	String url = "jdbc:mysql://127.0.0.1:3306/Vehicle_Management?useSSL=false&&allowPublicKeyRetrieval=true";
	String user = "root";
	String password = "123456";

	public ConnectDB() {
		// 加载驱动
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//System.out.println("驱动加载成功");
		} catch (Exception e) {
			System.out.println("驱动加载失败");
			e.printStackTrace();
		}

	}

	// 连接url;
	public Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, password);
			//if (!con.isClosed()) 
				//System.out.println("数据库连接成功");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("数据库连接失败");
		}
		return con;
	}

	// 关闭链接资源
	public void closeConection(PreparedStatement ps, ResultSet rs, Connection con) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (con != null) {
				con.close();
			}
			//System.out.println("关闭连接");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
