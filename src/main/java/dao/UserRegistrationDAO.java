package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.UserRegistrationModel;
import project.DatabaseConnection;

/**
 * This Data Access Object class is used to connect servlet with MySQL Database
 */

public class UserRegistrationDAO {
	Connection con = null;

	public UserRegistrationDAO() throws ClassNotFoundException, SQLException {
		con = DatabaseConnection.initializeDatabase();
	}

	public int register(UserRegistrationModel user) {

		try {

			java.util.Date date = new java.util.Date();
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());

			String query = "insert into users values(?,?,?,?,?,?,?)";
			Connection con = DatabaseConnection.initializeDatabase();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, user.getUserId());
			ps.setString(2, user.getName());
			ps.setInt(3, user.getPhone());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getAddress());
			ps.setDate(6, sqlDate);
			ps.setString(7, user.getPassword());

			int count = ps.executeUpdate();
			ps.close();
			con.close();
			return count;

		} catch (ClassNotFoundException | SQLException e) {

		}
		return 0;

	}
}
