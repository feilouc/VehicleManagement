package tools;
import DataBase.*;
import java.sql.*;
public class changePW {

	public static void change(String id, String oldPW, String newPW) {
		
		
			// ��ѯ���ݿ�
			Connection conn;
			PreparedStatement ps = null;
			ResultSet rs = null;

			ConnectDB connect = new ConnectDB();
			conn = connect.getConnection();

			try {

				String sql = "update vehicle_management.user set password ='" + newPW + "' where id = '"+id+"'";
				ps = conn.prepareStatement(sql);
				ps.executeUpdate(sql);
				
				String sql2="select * from vehicle_management.user where id ='"+id+"'";
				rs=ps.executeQuery(sql2);
				while (rs.next()) {
					
					System.out.println("�޸ĺ��������"+rs.getString("password"));
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}

			connect.closeConection(ps, rs, conn);


			}

		
		
	}
	

