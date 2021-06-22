package com.tokyomethod.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.tokyomethod.beans.Employee;

import db.DBManager;

public class EmployeeDao {
	public static ArrayList<Employee> getEmployeeList() {
		ArrayList<Employee> empList = new ArrayList<Employee>();
		//
		String sql = "SELECT * FROM employee ORDER BY emp_id";
		empList = executeQueryEmployee(sql);
		return empList;
	}

	public static ArrayList<Employee> getEmployeeListById(String id) {
		//idで検索して検索結果を表示、更新するjspを呼び出す
		ArrayList<Employee> empList = new ArrayList<Employee>();
		//
		String sql = "SELECT * FROM employee where emp_id = " + id + "order by emp_id asc";
		empList = executeQueryEmployee(sql);
		return empList;
	}

	/** フォーマット */
	static public final String DATE_PATTERN = "yyyy/MM/dd";

	public static int insertEmployee(Employee emp) {
		String convertDate = (new SimpleDateFormat(DATE_PATTERN)).format(emp.getBirthday());
		String sql = "INSERT INTO employee " +
				"VALUES (emp_seq.nextval," +
				"'" + emp.getEmp_pass() + "'," +
				"'" + emp.getEmp_name() + "'," +
				emp.getGender() + "," +
				"'" + emp.getAddress() + "'," +
				"'" + convertDate + "'," +
				emp.getPost_id() + ")";
		//本来はprepare文で検討する
		//\ps = conn.prepareStatement(sql);
		//ps.setString(1, postId);
		//ps.setString(2, postName);
		//int cnt = ps.executeUpdate();
		return executeUpdate(sql);
	}

	private static int executeUpdate(String sql) {
		DBManager manager = new DBManager();
		Connection conn = null;
		Statement stmt = null;
		int rs = 0;
		try {
			conn = manager.getConn("jdbcuser", "12345");
			stmt = conn.createStatement();
			rs = stmt.executeUpdate(sql);
			if (rs == 1) {
				System.out.println("更新を行いました");
			} else {
				System.out.println("更新に失敗");
			}
		} catch (SQLException | ClassNotFoundException e) {
			System.err.println("Oracleエラーコード:" + ((SQLException) e).getErrorCode());
			System.err.println("SQLStateコード:" + ((SQLException) e).getSQLState());
			System.err.println("エラーメッセージ:" + e.getMessage());
			e.printStackTrace();
		} finally {
			// 切断処理
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
				}
			}
		}
		return rs;
	}

	private static ArrayList<Employee> executeQueryEmployee(String sql) {

		DBManager manager = new DBManager();
		Connection conn = null;
		Statement stmt = null;
		ArrayList<Employee> empList = new ArrayList<Employee>();
		try {
			//
			// 接続する
			conn = manager.getConn("jdbcuser", "12345");
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			//
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setEmp_id(rs.getInt("emp_id"));
				emp.setEmp_pass(rs.getString("emp_pass"));
				emp.setEmp_name(rs.getString("emp_name"));
				emp.setGender(rs.getInt("gender"));
				emp.setAddress(rs.getString("address"));
				emp.setBirthday(rs.getDate("birthday"));
				emp.setPost_id(rs.getInt("post_id"));
				empList.add(emp);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("Oracleエラーコード:" + e.getErrorCode());
			System.err.println("SQLStateコード:" + e.getSQLState());
			System.err.println("エラーメッセージ:" + e.getMessage());
			e.printStackTrace();
		} finally {
			// 切断処理
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
				}
			}
		}
		return empList;
	}

	public static int deleteEmployee(String id) {
		String sql = "DELETE FROM employee where emp_id = " + id;
		return executeUpdate(sql);
	}

	public static int updateEmployee(Employee emp) {
		String convertDate = (new SimpleDateFormat(DATE_PATTERN)).format(emp.getBirthday());
		String sql = "UPDATE employee set emp_pass='" + emp.getEmp_pass() + "', emp_name='" + emp.getEmp_name() +
				"', gender=" + emp.getGender() +
				", address='" + emp.getAddress() +
				"', birthday='" + convertDate +
				"', post_id=" + emp.getPost_id() +
				" WHERE emp_id =" + emp.getEmp_id();
		return executeUpdate(sql);
	}

}
