package entities.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.validator.Email;
import org.hibernate.validator.Length;
import org.hibernate.validator.NotEmpty;
import org.hibernate.validator.Pattern;
// Generated Apr 11, 2011 11:14:09 PM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Lecturer generated by hbm2java
 */
public class Lecturer implements java.io.Serializable {

	private Integer lecturerId;
	private Department department;
	
	@NotEmpty
    @Pattern(regex=".*[^\\s].*", message="This string contain only spaces")
    @Length(min=3,max=12)
	private String lecturerName;
	
	@NotEmpty
    @Pattern(regex=".*[^\\s].*", message="This string contain only spaces")
    @Length(min=3,max=12)
	private String title;
	
	@Email
    @NotEmpty
    @Pattern(regex="^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message="Invalid Email Address")
	private String email;
	
	
	// pattern regex doldurulacak
    @NotEmpty
    @Pattern(regex="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid Phone Number")
	private String telephone;
    
	private Set syllabuses = new HashSet(0);

	public Lecturer() {
	}

	public Lecturer(Department department, String lecturerName, String title) {
		this.department = department;
		this.lecturerName = lecturerName;
		this.title = title;
	}

	public Lecturer(Department department, String lecturerName, String title,
			String email, String telephone, Set syllabuses) {
		this.department = department;
		this.lecturerName = lecturerName;
		this.title = title;
		this.email = email;
		this.telephone = telephone;
		this.syllabuses = syllabuses;
	}

	/*Copy constructor added by Erhun 16.04.2011*/
	public Lecturer(Lecturer lecturer){
		this.lecturerId = lecturer.lecturerId;
		this.department = lecturer.department;
		this.lecturerName = lecturer.lecturerName;
		this.title = lecturer.title;
		this.email = lecturer.email;
		this.telephone = lecturer.telephone;
		this.syllabuses = lecturer.syllabuses;
	}
	
	@SuppressWarnings("unchecked")
	public List<Lecturer> getIdByLecturerName(){
		List<Lecturer> lecturerNameList = null;
		
        Session session = null;
        
        try {
                SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
                session = sessionFactory.openSession();
                
                Query query = session.getNamedQuery("getIdByLecturerName");
                
                query.setParameter("pLecturerName", lecturerName);
                lecturerNameList = (List<Lecturer>) query.list();
                
        } catch (Exception e) {
                // TODO: handle exception
                e.getMessage();
        } 
        return lecturerNameList;
	}
	
	public List<Lecturer> getAllLecturer(){
		List<Lecturer> allLecturerList = null;
		Session session = null;
		
		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			session = sessionFactory.openSession();
			
			Query query = session.getNamedQuery("getAllLecturer");
			allLecturerList = (List<Lecturer>) query.list();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return allLecturerList;
	}
	
	public void addLecturer(){
        Session session=null;
        try{
                
                SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
                session = sessionFactory.openSession();
                Transaction tx = session.beginTransaction();
                Query query = session.getNamedQuery("addLecturer");
                query.setParameter("pLecturerName", lecturerName);
                query.setParameter("pTitle", title);
                query.setParameter("pDepartment", department);
                query.setParameter("pEmail", email);
                query.setParameter("pTelephone",telephone);
                query.executeUpdate();
                tx.commit();
                
        }catch(Exception e){
                System.err.print(e.getMessage());
        }
        finally{
        	session.close();
        }
   }
	
public void deleteLecturer(){
		
		Session session=null;
		try{
			
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			Query query = session.getNamedQuery("deleteLecturer");
			query.setParameter("pLecturerId", lecturerId);
			query.executeUpdate();
			tx.commit();
		}catch(Exception e){
			System.err.print(e.getMessage());
		}
		finally{
			session.close();
		}
	}
	
public void updateLecturer(){
		
		Session session=null;
		try{
			
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			Query query = session.getNamedQuery("updateLecturer");
			query.setParameter("pLecturerId",lecturerId);
            query.setParameter("pLecturerName", lecturerName);
            query.setParameter("pTitle", title);
            query.setParameter("pDepartment", department);
            query.setParameter("pEmail", email);
            query.setParameter("pTelephone",telephone);
			query.executeUpdate();
			tx.commit();
		}catch(Exception e){
			System.err.print(e.getMessage());
		}
		finally{
			session.close();
		}
	}
	
	public Integer getLecturerId() {
		return this.lecturerId;
	}

	public void setLecturerId(Integer lecturerId) {
		this.lecturerId = lecturerId;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getLecturerName() {
		return this.lecturerName;
	}

	public void setLecturerName(String lecturerName) {
		this.lecturerName = lecturerName;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Set getSyllabuses() {
		return this.syllabuses;
	}

	public void setSyllabuses(Set syllabuses) {
		this.syllabuses = syllabuses;
	}

}
