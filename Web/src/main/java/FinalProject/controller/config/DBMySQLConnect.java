package FinalProject.controller.config;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBMySQLConnect {
	private static String DB_URL = "jdbc:mysql://localhost:3306/laptrinhweb2025";
	private static String USER_NAME = "root";
	private static String PASSWORD = "12345";
	private static Connection conn;
	
	
	public static Connection getConnection() throws IOException {
        conn = null;
        try {
            // Đăng ký driver MySQL
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

            // Tạo kết nối
            conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            System.out.println("Kết nối thành công tới MySQL!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return conn;
    }
	
	
	public static void main(String[] args) {
		try {
			// connnect to database 'testdb'
			 Connection conn = new DBMySQLConnect().getConnection();
			 // crate statement
			 PreparedStatement stmt = conn.prepareStatement("INSERT INTO GiaoVien VALUES(?, ?, ?)");
			 stmt.setInt(1, 3);
			 stmt.setString(2, "Minh");
			 stmt.setString(3, "HCM");
			 stmt.execute();
			 // get data from table ‘GiaoVien'
//			 ResultSet rs = stmt.executeQuery("SELECT * FROM GiaoVien");
			 stmt = conn.prepareStatement("SELECT * FROM GiaoVien");
			 ResultSet rs = stmt.executeQuery();
			 // show data
			 while (rs.next()) {
			 System.out.println(rs.getInt("id") + " " + rs.getString("name") 
			+ " " + rs.getString("address"));
			 }
			 conn.close(); // close connection
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
