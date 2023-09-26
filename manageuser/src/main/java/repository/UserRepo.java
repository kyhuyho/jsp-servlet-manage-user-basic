package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.PreparableStatement;

import model.User;

public class UserRepo {
	public static void createUser(User user) {
		Connection cnn = JDBCConnection.getConnection();
		String sql = "insert into user(id, name, username, password) values(?, ?, ?, ?)";
		try {
			PreparedStatement ppstm = cnn.prepareStatement(sql);
			ppstm.setInt(1, user.getId());
			ppstm.setString(2, user.getName());
			ppstm.setString(3, user.getUsername());
			ppstm.setString(4, user.getPassword());
			ppstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void updateUser(User user) {
		Connection cnn = JDBCConnection.getConnection();
		String sql = "update user set name = ?, username = ?, password = ? where id = ?";
		try {
			PreparedStatement ppstm = cnn.prepareStatement(sql);
			ppstm.setString(1, user.getName());
			ppstm.setString(2, user.getUsername());
			ppstm.setString(3, user.getPassword());
			ppstm.setInt(4, user.getId());
			ppstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void deleteUser(int id) {
		Connection cnn = JDBCConnection.getConnection();
		String sql = "delete from user where id = ?";
		try {
			PreparedStatement ppstm = cnn.prepareStatement(sql);
			ppstm.setInt(1, id);
			ppstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static List<User> getAllUser() {
		Connection cnn = JDBCConnection.getConnection();
		String sql = "select * from user";
		List<User> list = new ArrayList<User>();
		try {
			PreparedStatement ppstm = cnn.prepareStatement(sql);
			ResultSet rs = ppstm.executeQuery();

			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				list.add(user);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}

	public static User getUserById(int id) {
		Connection cnn = JDBCConnection.getConnection();
		String sql = "select id,name,username,password from user where id = ?";
		User user = new User();
		try {
			PreparedStatement ppstm = cnn.prepareStatement(sql);
			ppstm.setInt(1, id);
			ResultSet rs = ppstm.executeQuery();
			while (rs.next()) {
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;

	}

	public static List<User> search(String name) {
		Connection cnn = JDBCConnection.getConnection();
		String sql = "select id, name, username, password from user where name like ?";
		List<User> list = new ArrayList<User>();
		try {
			PreparedStatement ppstm = cnn.prepareStatement(sql);
			ppstm.setString(1, "%" + name + "%");
			ResultSet rs = ppstm.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				list.add(user);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}

}