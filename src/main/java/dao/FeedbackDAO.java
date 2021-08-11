package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.FeedbackModel;
import project.DatabaseConnection;

/**
 * This Data Access Object class is used to connect servlet with MySQL Database
 */
public class FeedbackDAO {
	Connection con = null;

	public FeedbackDAO() throws ClassNotFoundException, SQLException {
		con = DatabaseConnection.initializeDatabase();
	}

	public int register(FeedbackModel feedback) {

		try {

			String query = "insert into feedback values(?,?,?,?)";
			Connection con = DatabaseConnection.initializeDatabase();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, feedback.getName());
			ps.setString(2, feedback.getUserId());
			ps.setString(3, feedback.getEmail());
			ps.setString(4, feedback.getFeedback());

			int count = ps.executeUpdate();
			ps.close();
			con.close();
			return count;

		} catch (ClassNotFoundException | SQLException e) {

		}
		return 0;

	}

}
