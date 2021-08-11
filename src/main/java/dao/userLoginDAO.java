package dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.UserLoginModel;
import project.DatabaseConnection;

/**
 * This Data Access Object class is used to connect servlet with MySQL Database
 */

public class userLoginDAO {
	Connection con = null;

	public userLoginDAO() throws ClassNotFoundException, SQLException {
		con = DatabaseConnection.initializeDatabase();
	}

	public boolean register(UserLoginModel user, HttpServletRequest req, HttpServletResponse res) throws IOException {
		try {

			String query = "select name from users where user_id=" + "'" + user.getUserId() + "'" + "and password="
					+ "'" + user.getPassword() + "'";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			boolean temp = false;
			while (rs.next()) {
				req.setAttribute("name", rs.getString(1));
				temp = true;
				if (temp) {
					break;
				}
			}
			st.close();
			con.close();
			return temp;

		} catch (SQLException e) {
			PrintWriter out = res.getWriter();
			out.println(e.getMessage());
		}
		return false;

	}

}
