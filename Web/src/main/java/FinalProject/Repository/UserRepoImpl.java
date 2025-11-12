package FinalProject.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import FinalProject.Model.User;
import FinalProject.controller.config.DBMySQLConnect;

public class UserRepoImpl implements UserRepo {
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	public User get(String username) {
		 String sql = "SELECT * FROM user WHERE user_name = ? ";
		 try {
			 conn = new DBMySQLConnect().getConnection();
			 ps = conn.prepareStatement(sql);
			 ps.setString(1, username);
			 rs = ps.executeQuery();
			 while (rs.next()) {
				 User user = new User();
				 user.setId(rs.getInt("id"));
				 user.setEmail(rs.getString("email"));
				 user.setUserName(rs.getString("user_name"));
				 user.setFullName(rs.getString("full_name"));
				 user.setPassWord(rs.getString("password"));
				 user.setAvatar(rs.getString("avatar"));
				 user.setRoleid(Integer.parseInt(rs.getString("role_id")));
				 user.setPhone(rs.getString("phone"));
				 user.setCreatedDate(rs.getDate("created_date"));
				 return user; 
			 }
		 } catch (Exception e) {e.printStackTrace(); }
		 return null;
	}
}
