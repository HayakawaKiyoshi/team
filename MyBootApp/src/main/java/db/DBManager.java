package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
	/**
	* DBと接続する
	*
	* @return DBコネクション
	* @throws ClassNotFoundException
	* @throws SQLException
	*/
	public Connection getConn(String user, String passwd) throws ClassNotFoundException, SQLException {
		// JDBCドライバクラスをJVMに登録
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// DBへ接続
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", user, passwd);
		System.out.println("DBに接続しました");
		return conn;
	}

	/**
	* DB接続を切断する
	*
	* @param conn
	* DBコネクション
	*/
	public void close(Connection conn) {
		try {
			// 切断処理
			if (conn != null) {
				conn.close();
				//System.out.println("切断しました");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
