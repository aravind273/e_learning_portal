package project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import dao.UserCourseEnrollDAO;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.CourseModel;

public class UserCourseEnrollServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * This method is used to get the required parameters from the EnrollCourse.html
	 * and insert the data into the database using DAO class and Model class
	 * 
	 * @param req
	 * @param res
	 * @return
	 */

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String CourseId = req.getParameter("course_id");
		String CourseName = req.getParameter("course_name");
		String CourseDesc = req.getParameter("course_description");
		String CourseResources = req.getParameter("course_resources");
		int CourseFees = Integer.parseInt(req.getParameter("course_fees"));

		try {
			CourseModel course = new CourseModel();
			course.setCourseId(CourseId);
			course.setCourseName(CourseName);
			course.setCourseDesc(CourseDesc);
			course.setCourseResources(CourseResources);
			course.setCourseFees(CourseFees);
			UserCourseEnrollDAO courseDao = new UserCourseEnrollDAO();
			if (courseDao.register(course, req, res) > 0) {
				PrintWriter out = res.getWriter();
				out.println("<div style=text-align:center>" + "<h1>Successfully Enrolled</h1>" + "</div>");
			} else {
				PrintWriter out = res.getWriter();
				out.println("<div style=text-align:center>" + "<h1>Try Again!</h1>" + "</div>");
			}

		} catch (ClassNotFoundException | SQLException e) {
			PrintWriter out = res.getWriter();
			out.println(e.getMessage());
		}

	}
}
