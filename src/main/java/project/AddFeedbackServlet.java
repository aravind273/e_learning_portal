package project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import dao.FeedbackDAO;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.FeedbackModel;

public class AddFeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * This method is used to get the required parameters from the AddFeedback.html
	 * and insert the data into the database using DAO class and Model class
	 * 
	 * @param req
	 * @param res
	 * @return
	 */

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String name = req.getParameter("name");
		String userId = req.getParameter("userId");
		String email = req.getParameter("email");
		String feedback_desc = req.getParameter("feedback_desc");
		try {
			FeedbackModel feedback = new FeedbackModel();
			feedback.setName(name);
			feedback.setUserId(userId);
			feedback.setEmail(email);
			feedback.setFeedback(feedback_desc);
			FeedbackDAO feedbackDao = new FeedbackDAO();
			if (feedbackDao.register(feedback) > 0) {
				PrintWriter out = res.getWriter();
				out.println("<div style=text-align:center>" + "<h1>Thanks for your feedback</h1>" + "</div>");
			} else {
				PrintWriter out = res.getWriter();
				out.println("<div style=text-align:center>" + "<h1>TRY AGAIN!</h1>" + "</div>");
			}

		} catch (ClassNotFoundException | SQLException e) {
			PrintWriter out = res.getWriter();
			out.println(e.getMessage());
		}

	}
}
