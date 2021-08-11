package project;

import java.io.IOException;
import java.io.PrintWriter;

import dao.AdminRegistrationDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.AdminRegistrationModel;

@WebServlet("/adminRegistration")
public class AdminRegistrationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * This method is used to get the required parameters from the
	 * AdminRegistrationk.html and insert the data into the database using DAO class
	 * and Model class
	 * 
	 * @param req
	 * @param res
	 * @return
	 */

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		int adminId = Integer.parseInt(req.getParameter("adminId"));
		String name = req.getParameter("adminName");
		String email = req.getParameter("adminEmail");
		String password = req.getParameter("adminPassword");

		try {
			AdminRegistrationModel adminModel = new AdminRegistrationModel();
			adminModel.setAdminId(adminId);
			adminModel.setName(name);
			adminModel.setEmail(email);
			adminModel.setPassword(password);

			AdminRegistrationDAO adminDao = new AdminRegistrationDAO();
			if (adminDao.register(adminModel) > 0) {
				PrintWriter out = res.getWriter();
				out.println("<div style=text-align:center>" + "<h1>Admin Registered Successfully</h1>" + "</div>");
			}
		} catch (Exception e) {

			PrintWriter out = res.getWriter();
			out.println("<div style=text-align:center>" + "<h1>Try Again!</h1>" + "</div>");
		}

	}

}
