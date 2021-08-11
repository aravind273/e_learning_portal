package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.AdminRegistrationModel;
import project.DatabaseConnection;

/**
 * This Data Access Object class is used to connect servlet with MySQL Database
 */
public class AdminRegistrationDAO {
	Connection con = null;

	public AdminRegistrationDAO() throws ClassNotFoundException, SQLException {
		con = DatabaseConnection.initializeDatabase();
	}

	public int register(AdminRegistrationModel adminreg) {

		try {

			String query = "insert into admin values(?,?,?,?)";
			Connection con = DatabaseConnection.initializeDatabase();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, adminreg.getAdminId());
			ps.setString(2, adminreg.getName());
			ps.setString(3, adminreg.getEmail());
			ps.setString(4, adminreg.getPassword());

			int count = ps.executeUpdate();
			ps.close();
			con.close();
			return count;

		} catch (ClassNotFoundException | SQLException e) {

		}
		return 0;

	}

}
