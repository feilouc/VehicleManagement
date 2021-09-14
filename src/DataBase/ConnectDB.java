package DataBase;

import java.sql.*;

public class ConnectDB {

	String url = "jdbc:mysql://127.0.0.1:3306/Vehicle_Management?useSSL=false&&allowPublicKeyRetrieval=true";
	String user = "root";
	String password = "123456";

	public ConnectDB() {
		// ��������
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//System.out.println("�������سɹ�");
		} catch (Exception e) {
			System.out.println("��������ʧ��");
			e.printStackTrace();
		}

	}

	// ����url;
	public Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, password);
			//if (!con.isClosed()) 
				//System.out.println("���ݿ����ӳɹ�");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("���ݿ�����ʧ��");
		}
		return con;
	}

	// �ر�������Դ
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
			//System.out.println("�ر�����");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
