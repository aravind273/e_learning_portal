package project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import dao.UserRegistrationDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.UserRegistrationModel;

public class AddServlet extends HttpServlet {
	/**
	 * 
	 * This method is used to get the required parameters from the
	 * UserRegistration.html and insert the data into the database using DAO class
	 * and Model class
	 * 
	 * @param req
	 * @param res
	 * @return
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		int userId = Integer.parseInt(req.getParameter("userid"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		int phone = Integer.parseInt(req.getParameter("phone"));
		String address = req.getParameter("address");
		UserRegistrationModel userReg = new UserRegistrationModel();
		userReg.setName(name);
		userReg.setEmail(email);
		userReg.setAddress(address);
		userReg.setPassword(password);
		userReg.setUserId(userId);
		userReg.setPhone(phone);
		req.setAttribute("name", name);
		UserRegistrationDAO userDao;
		try {
			userDao = new UserRegistrationDAO();
			if (userDao.register(userReg) > 0) {
				RequestDispatcher rd = req.getRequestDispatcher("UserHome.jsp");
				rd.forward(req, res);
			} else {
				PrintWriter out = res.getWriter();
				out.println("<div style=text-align:center>" + "<h1>TRY AGAIN!</h1>" + "</div>");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
