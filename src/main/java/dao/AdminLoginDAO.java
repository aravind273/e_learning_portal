package dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.AdminLoginModel;
import project.DatabaseConnection;

/**
 * This Data Access Object class is used to connect servlet with MySQL Database
 */

public class AdminLoginDAO {

	Connection con = null;

	public AdminLoginDAO() throws ClassNotFoundException, SQLException {
		con = DatabaseConnection.initializeDatabase();
	}

	public boolean register(AdminLoginModel adminLogin, HttpServletRequest req, HttpServletResponse res)
			throws IOException {
		try {

			String query = "select name from admin where admin_id=" + "'" + adminLogin.getAdminId() + "'"
					+ "and password=" + "'" + adminLogin.getAdminPassword() + "'";
			Connection con = DatabaseConnection.initializeDatabase();
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

		} catch (ClassNotFoundException | SQLException e) {
			PrintWriter out = res.getWriter();
			out.println(e.getMessage());
		}

		return false;

	}

}
