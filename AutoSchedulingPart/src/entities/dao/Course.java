package entities.dao;

// Generated Apr 11, 2011 8:27:09 PM by Hibernate Tools 3.4.0.CR1

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.faces.model.SelectItem;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Course generated by hbm2java
 */
public class Course implements java.io.Serializable {

	private Integer courseId;
	private TypeofCourse typeofCourse;
	private Department department;
	private String courseCode;
	private String courseName;
	private int teoricLectureHours;
	private int practiceLectureHourse;
	private boolean attendance;
	private int grade;
	private String precondition;
	private String courseDescription;
	private Set syllabuses = new HashSet(0);

	public Course() {
	}

	public Course(TypeofCourse typeofCourse, Department department,
			String courseCode, String courseName, int teoricLectureHours,
			int practiceLectureHourse, boolean attendance, int grade) {
		this.typeofCourse = typeofCourse;
		this.department = department;
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.teoricLectureHours = teoricLectureHours;
		this.practiceLectureHourse = practiceLectureHourse;
		this.attendance = attendance;
		this.grade = grade;
	}

	public Course(TypeofCourse typeofCourse, Department department,
			String courseCode, String courseName, int teoricLectureHours,
			int practiceLectureHourse, boolean attendance, int grade,
			String precondition, String courseDescription, Set syllabuses) {
		this.typeofCourse = typeofCourse;
		this.department = department;
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.teoricLectureHours = teoricLectureHours;
		this.practiceLectureHourse = practiceLectureHourse;
		this.attendance = attendance;
		this.grade = grade;
		this.precondition = precondition;
		this.courseDescription = courseDescription;
		this.syllabuses = syllabuses;
	}

//****************************************************************************************
	
	@SuppressWarnings("unchecked")
	public ArrayList<Course> getDepartmentCourseNameList()
	{
		Session session = null;
		ArrayList<Course> departmentCourseNameList = new ArrayList<Course>();
		try
		{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			session = sessionFactory.openSession();
			Query query = session.getNamedQuery("getDeptFreshmanCourseName");
			departmentCourseNameList = (ArrayList<Course>)query.list();
		}
		catch(Exception ex)
		{
			ex.getMessage();
		}
		
		return departmentCourseNameList;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Course> getDeanCourses()
	{
		Session session = null;
		ArrayList<Course> deanCourseNameList = null;
		try
		{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			session = sessionFactory.openSession();
			Query query = session.getNamedQuery("getDeanCourseName");
			deanCourseNameList = (ArrayList<Course>)query.list();
		}
		catch(Exception ex)
		{
			ex.getMessage();
		}
		return deanCourseNameList;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Syllabus> getLecturerNameByCourseId()
	{
		Session session = null;
		ArrayList<Syllabus> deanLecturerNameList = new ArrayList<Syllabus>();
		try
		{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			session = sessionFactory.openSession();
			Query query = session.getNamedQuery("getLecturerNameByCourseId");
			query.setParameter("pCourseId", courseId);
			deanLecturerNameList = (ArrayList<Syllabus>)query.list();
		}
		catch(Exception ex)
		{
			ex.getMessage();
		}
		return deanLecturerNameList;
	}
	
//****************************************************************************************
	
	public Integer getCourseId() {
		return this.courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public TypeofCourse getTypeofCourse() {
		return this.typeofCourse;
	}

	public void setTypeofCourse(TypeofCourse typeofCourse) {
		this.typeofCourse = typeofCourse;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getCourseCode() {
		return this.courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getCourseName() {
		return this.courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getTeoricLectureHours() {
		return this.teoricLectureHours;
	}

	public void setTeoricLectureHours(int teoricLectureHours) {
		this.teoricLectureHours = teoricLectureHours;
	}

	public int getPracticeLectureHourse() {
		return this.practiceLectureHourse;
	}

	public void setPracticeLectureHourse(int practiceLectureHourse) {
		this.practiceLectureHourse = practiceLectureHourse;
	}

	public boolean isAttendance() {
		return this.attendance;
	}

	public void setAttendance(boolean attendance) {
		this.attendance = attendance;
	}

	public int getGrade() {
		return this.grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getPrecondition() {
		return this.precondition;
	}

	public void setPrecondition(String precondition) {
		this.precondition = precondition;
	}

	public String getCourseDescription() {
		return this.courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	public Set getSyllabuses() {
		return this.syllabuses;
	}

	public void setSyllabuses(Set syllabuses) {
		this.syllabuses = syllabuses;
	}

}
