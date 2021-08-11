package dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.CourseModel;
import project.DatabaseConnection;

/**
 * This Data Access Object class is used to connect servlet with MySQL Database
 */
public class UserCourseEnrollDAO {
	Connection con = null;

	public UserCourseEnrollDAO() throws ClassNotFoundException, SQLException {
		con = DatabaseConnection.initializeDatabase();
	}

	public int register(CourseModel course, HttpServletRequest req, HttpServletResponse res) throws IOException {
		try {
			String query = "insert into course values(?,?,?,?,?)";
			Connection con = DatabaseConnection.initializeDatabase();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, course.getCourseId());
			ps.setString(2, course.getCourseName());
			ps.setString(3, course.getCourseDesc());
			InputStream in = new FileInputStream(
					"" + "C:\\Users\\Aravind\\OneDrive\\Pictures\\Screenshots\\Screenshot (23).png");
			ps.setBlob(4, in);
			ps.setInt(5, course.getCourseFees());

			int count = ps.executeUpdate();
			ps.close();
			con.close();
			return count;

		} catch (ClassNotFoundException | SQLException | FileNotFoundException e) {
			PrintWriter out = res.getWriter();
			out.println(e.getMessage());
		}
		return 0;

	}
}
