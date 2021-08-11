package project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import dao.ContactDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ContactModel;

@WebServlet("/contact")
public class ContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * This method is used to get the required parameters from the Contact.html and
	 * insert the data into the database using DAO class and Model class
	 * 
	 * @param req
	 * @param res
	 * @return
	 */

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		int contactId = Integer.parseInt(req.getParameter("contactId"));
		int userId = Integer.parseInt(req.getParameter("userId"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");

		try {
			ContactModel contact = new ContactModel();
			contact.setContactId(contactId);
			contact.setUserId(userId);
			contact.setName(name);
			contact.setEmail(email);
			contact.setPhone(phone);
			ContactDAO contactDao = new ContactDAO();
			if (contactDao.register(contact) > 0) {
				PrintWriter out = res.getWriter();
				out.println("<div style=text-align:center>" + "<h1>Request Sent</h1>" + "</div>");
			} else {
				PrintWriter out = res.getWriter();
				out.println("<div style=text-align:center>" + "<h1>Try Again!</h1>" + "</div>");
			}

		} catch (ClassNotFoundException | SQLException e) {

		}

	}

}
