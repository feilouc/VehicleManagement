package tools;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import DataBase.ConnectDB;
public class searchCar {
	public static Vector  searchTable(Vector row) {
		// ��ѯ���ݿ�
		Connection conn;
		PreparedStatement ps = null;
		ResultSet rs = null;

		ConnectDB connect = new ConnectDB();
		conn = connect.getConnection();
		
		try {
			 String sql = "select * from vehicle_management.break";
			 ps = conn.prepareStatement(sql);
			 rs = ps.executeQuery();
			 
			 //ȡ��������е�ȫ������
			 while(rs.next()) {
				 Vector rowData = new Vector();
				 
				 rowData.add(rs.getString(1));
				 rowData.add(rs.getString(2));
				 rowData.add(rs.getString(3));
				 rowData.add(rs.getString(4));
				 rowData.add(rs.getString(5));
				 rowData.add(rs.getString(6));
				 rowData.add(rs.getString(7));
				 rowData.add(rs.getString(8));
				 rowData.add(rs.getString(9));
				 rowData.add(rs.getString(10));
				 
				//����õ����ݼ��뵽���е�ÿһ��
					row.add(rowData);
						 
			 }
			 	
		}catch(Exception e) {
			e.printStackTrace();
		}
		connect.closeConection(ps, rs, conn);
		return row;
	}

}
