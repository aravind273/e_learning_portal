package project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import dao.userLoginDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.UserLoginModel;

@WebServlet("/userLogin")
public class UserLogin extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * This method is used to get the required parameters from the UserLogin.html
	 * and insert the data into the database using DAO class and Model class
	 * 
	 * @param req
	 * @param res
	 * @return
	 */

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		int userId = Integer.parseInt(req.getParameter("userid"));
		String password = req.getParameter("password");
		userLoginDAO userDao;
		try {
			userDao = new userLoginDAO();
			UserLoginModel user = new UserLoginModel();
			user.setUserId(userId);
			user.setPassword(password);
			if (!userDao.register(user, req, res)) {
				PrintWriter out = res.getWriter();
				out.println("<div style=text-align:center>" + "<h1>Invalid Cerdentials</h1>" + "</div>");
			} else {
				RequestDispatcher rd = req.getRequestDispatcher("UserHome.jsp");
				rd.forward(req, res);

			}
		} catch (ClassNotFoundException | SQLException | ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
