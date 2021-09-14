/*
 * ����break�������ģ�ͣ��������´���Jtable
 */
package Module;

import javax.swing.table.AbstractTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import java.util.*;
import tools.*;
import DataBase.*;

public class breakModel extends AbstractTableModel {

	// ���������ݺ�����
	Vector row, columnNames;

	// ��ѯ���ݿ�
	ConnectDB connect = new ConnectDB();
	Connection conn = connect.getConnection();
	PreparedStatement ps = null;
	ResultSet rs = null;
	String sql;

	// ��ʼ��break�������ģ��
	public void init(String sql) {

		if (sql.equals("")) {
			sql = "select * from vehicle_management.break";
		}
		columnNames = new Vector();
		// ��������
		columnNames.add("���к���");
		columnNames.add("���ƺ���");
		columnNames.add("������ɫ");
		columnNames.add("��������");
		columnNames.add("Υ��ʱ��");
		columnNames.add("Υ������");
		columnNames.add("������");
		columnNames.add("�Ƿ����");
		columnNames.add("Υ��۷�");
		columnNames.add("Υ��ص�");

		row = new Vector();
		try {

			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			// ȡ��������е�ȫ������
			while (rs.next()) {
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

				// ����õ����ݼ��뵽���е�ÿһ��
				row.add(rowData);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		connect.closeConection(ps, rs, conn);

	}

	// ����sql���ѡ�񴴽�����Ҫ��table
	public breakModel() {
		init("");
	}

	public breakModel(String sql) {
		init(sql);
	}

	
	
	
	// ��ȡ����
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.row.size();
	}

	// ��ȡ����
	public int getColumnCount() {
		// TODO Auto-generated method stub

		return this.columnNames.size();
	}

	// ��ȡĳ��ĳ�е�ֵ
	public Object getValueAt(int row, int column) {
		// ��������Ϊÿһ����Ԫ���Ǵ�����ÿһ���еģ�����Ҫ��ͨ�������ҵ��У�ת��Ϊ�������ͺ��ٵõ����е�ĳһ�У��Ӷ���õ�Ԫ������
		return ((Vector) this.row.get(row)).get(column);
	}

	// ��������
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return (String) this.columnNames.get(column);
	}

}
