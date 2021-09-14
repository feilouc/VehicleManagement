/*
 * 这是break表的数据模型，用来更新创建Jtable
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

	// 表格的行数据和列名
	Vector row, columnNames;

	// 查询数据库
	ConnectDB connect = new ConnectDB();
	Connection conn = connect.getConnection();
	PreparedStatement ps = null;
	ResultSet rs = null;
	String sql;

	// 初始化break表的数据模型
	public void init(String sql) {

		if (sql.equals("")) {
			sql = "select * from vehicle_management.break";
		}
		columnNames = new Vector();
		// 设置列名
		columnNames.add("城市号码");
		columnNames.add("车牌号码");
		columnNames.add("车辆颜色");
		columnNames.add("车辆类型");
		columnNames.add("违规时间");
		columnNames.add("违规类型");
		columnNames.add("罚金金额");
		columnNames.add("是否缴纳");
		columnNames.add("违规扣分");
		columnNames.add("违规地点");

		row = new Vector();
		try {

			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			// 取出结果集中的全部数据
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

				// 将获得的数据加入到表中的每一行
				row.add(rowData);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		connect.closeConection(ps, rs, conn);

	}

	// 根据sql语句选择创建的需要的table
	public breakModel() {
		init("");
	}

	public breakModel(String sql) {
		init(sql);
	}

	
	
	
	// 获取列数
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.row.size();
	}

	// 获取行数
	public int getColumnCount() {
		// TODO Auto-generated method stub

		return this.columnNames.size();
	}

	// 获取某行某列的值
	public Object getValueAt(int row, int column) {
		// 这里是因为每一个单元格是储存在每一行中的，所以要先通过索引找到行，转换为容器类型后再得到该行的某一列，从而获得单元格数据
		return ((Vector) this.row.get(row)).get(column);
	}

	// 设置列名
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return (String) this.columnNames.get(column);
	}

}
