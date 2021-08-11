package model;

public class CourseModel {

	/**
	 * This Model class is used to set and get attributes
	 */
	private String courseId;
	private String courseName;
	private String courseDesc;
	private String courseResources;
	private int courseFees;

	public int getCourseFees() {
		return courseFees;
	}

	public void setCourseFees(int courseFees) {
		this.courseFees = courseFees;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseDesc() {
		return courseDesc;
	}

	public void setCourseDesc(String courseDesc) {
		this.courseDesc = courseDesc;
	}

	public String getCourseResources() {
		return courseResources;
	}

	public void setCourseResources(String courseResources) {
		this.courseResources = courseResources;
	}

}
