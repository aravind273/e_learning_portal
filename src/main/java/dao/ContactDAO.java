package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.ContactModel;
import project.DatabaseConnection;

/**
 * This Data Access Object class is used to connect servlet with MySQL Database
 */

public class ContactDAO {
	Connection con = null;

	public ContactDAO() throws ClassNotFoundException, SQLException {
		con = DatabaseConnection.initializeDatabase();
	}

	public int register(ContactModel contact) {

		try {

			String query = "insert into contact values(?,?,?,?,?)";
			Connection con = DatabaseConnection.initializeDatabase();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, contact.getContactId());
			ps.setInt(2, contact.getUserId());
			ps.setString(3, contact.getName());
			ps.setString(4, contact.getEmail());
			ps.setString(5, contact.getPhone());

			int count = ps.executeUpdate();
			ps.close();
			con.close();
			return count;

		} catch (ClassNotFoundException | SQLException e) {

		}
		return 0;

	}

}
