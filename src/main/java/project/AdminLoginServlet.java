package project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import dao.AdminLoginDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.AdminLoginModel;

@WebServlet("/adminLogin")
public class AdminLoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * This method is used to get the required parameters from the AdminLogin.html
	 * and insert the data into the database using DAO class and Model class
	 * 
	 * @param req
	 * @param res
	 * @return
	 */

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String adminId = req.getParameter("adminId");
		String adminPassword = req.getParameter("adminPassword");

		AdminLoginModel adminLoginModel = new AdminLoginModel();
		adminLoginModel.setAdminId(adminId);
		adminLoginModel.setAdminPassword(adminPassword);
		AdminLoginDAO adminLoginDao;
		try {
			adminLoginDao = new AdminLoginDAO();
			if (!adminLoginDao.register(adminLoginModel, req, res)) {
				PrintWriter out = res.getWriter();
				out.println("<div style=text-align:center>" + "<h1>INVALID CERDENTIALS</h1>" + "</div>");
			} else {
				RequestDispatcher rd = req.getRequestDispatcher("AdminHome.jsp");
				rd.forward(req, res);

			}
		} catch (ClassNotFoundException | SQLException | ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
