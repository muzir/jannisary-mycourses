package entities.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
// Generated Apr 11, 2011 11:14:09 PM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

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
	
	//Copy constructor added by Erdi 
	public Course(Course course){
		this.typeofCourse = course.typeofCourse;
		this.department = course.department;
		this.attendance = course.attendance;
		this.courseCode = course.courseCode;
		this.courseName = course.courseName;
		this.teoricLectureHours = course.teoricLectureHours;
		this.practiceLectureHourse = course.practiceLectureHourse;
		this.grade = course.grade;
		this.precondition = course.precondition;
		this.courseDescription = course.courseDescription;
		
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

	public void AddCourse(){
		Session session=null;
		try{
			
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			//System.out.println("Lecturer: AddLecturer1");
			Query query = session.getNamedQuery("AddCourse");
			//System.out.println("Lecturer: AddLecturer2");
			query.setParameter("pCourseCode", courseCode);
			query.setParameter("pCourseName", courseName);
			query.setParameter("pTeoricLectureHours", teoricLectureHours);
			query.setParameter("pPracticeLectureHours", practiceLectureHourse);
			query.setParameter("pAttendance", attendance);
			query.setParameter("pGrade", grade);
			query.setParameter("pTypeofCourseId", typeofCourse);
			query.setParameter("pDepartmentId", department);
			query.setParameter("pPrecondition", precondition);
			query.setParameter("pCourseDescription", courseDescription);
			query.executeUpdate();
			tx.commit();
			//System.out.println("Lecturer: AddLecturer3");
			
		}catch(Exception e){
			System.err.print(e.getMessage());
		}
	}
	
	public void updateCourse() throws Exception{
		Session session=null;
		try{
			
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			Query query = session.getNamedQuery("updateCourse");
			query.setParameter("pCourseId", courseId);
			query.setParameter("pCourseCode", courseCode);
			query.setParameter("pCourseName", courseName);
			query.setParameter("pTeoricLectureHours", teoricLectureHours);
			query.setParameter("pPracticeLectureHourse", practiceLectureHourse);
			query.setParameter("pAttendance", attendance);
			query.setParameter("pGrade", grade);
			query.setParameter("pTypeofCourse", typeofCourse);
			query.setParameter("pDepartment", department);
			query.setParameter("pPrecondition", precondition);
			query.setParameter("pCourseDescription", courseDescription);
			
			query.executeUpdate();
			tx.commit();
		}catch(Exception e){
			System.err.print(e.getMessage());
			throw new Exception(e);
		}
		finally{
			session.close();
		}
	}
	
	public void deleteCourse(){
		Session session=null;
		try{
			
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			Query query = session.getNamedQuery("deleteCourse");
			query.setParameter("pCourseId", courseId);
			query.executeUpdate();
			tx.commit();
		}catch(Exception e){
			System.err.print(e.getMessage());
		}
		finally{
			session.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Course> getCourseCodeById(){
		List<Course> courseCodeList = null;
		
        Session session = null;
        
        try {
                SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
                session = sessionFactory.openSession();
                
                Query query = session.getNamedQuery("getCourseCodeById");
                
                query.setParameter("pCourseId", courseId);
                courseCodeList = (List<Course>) query.list();
                
        } catch (Exception e) {
                // TODO: handle exception
                e.getMessage();
        } 
        return courseCodeList;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Course> getCourseCodeList(){
		List<Course> courseCodeList = null;
		
        Session session = null;
        
        try {
                SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
                session = sessionFactory.openSession();
                
                Query query = session.getNamedQuery("getCourseCodeList");
                courseCodeList = (List<Course>) query.list();
                
        } catch (Exception e) {
                // TODO: handle exception
                e.getMessage();
        } 
        return courseCodeList;
	}
	
	public List<Course> getAllCourses(){
		List<Course> allCoursesList = null;
		Session session = null;
		
		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			session = sessionFactory.openSession();
			
			Query query = session.getNamedQuery("getAllCourses");
			allCoursesList = (List<Course>) query.list();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return allCoursesList;
	}
	
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
