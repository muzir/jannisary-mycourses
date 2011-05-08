package entities.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entities.util.BasicScheduleUtilBean;


// Generated Apr 11, 2011 11:14:09 PM by Hibernate Tools 3.4.0.CR1

/**
 * Schedule generated by hbm2java
 */
public class Schedule implements java.io.Serializable {

	private static final long serialVersionUID = -7396140986296435245L;

	private Integer scheduleId;
	
	private Syllabus syllabus=new Syllabus();
	private SyllabusArchive syllabusArchive = new SyllabusArchive();
	private String courseType;
	private int timeofCourse;
	private int hours;
	
	//Manual Scheduling de gösterimde kullanılan alan, veritabanında tanımı yoktur.
	private String courseTheoricOrPraticName;
	
	private BasicScheduleUtilBean[][] firstGradeSchedule = new BasicScheduleUtilBean[5][8];
	private BasicScheduleUtilBean[][] secondGradeSchedule = new BasicScheduleUtilBean[5][8];
	private BasicScheduleUtilBean[][] thirdGradeSchedule = new BasicScheduleUtilBean[5][8];
	private BasicScheduleUtilBean[][] fourthGradeSchedule = new BasicScheduleUtilBean[5][8];
	
	private ArrayList<Schedule> scheduleList = new ArrayList<Schedule>(); //2. bölüm sonunda otomatik olrak belirlenen ders programını Schedule tablosuna atmak için kullanılan metod
	
	public Schedule() {
	}

	public Schedule(Schedule schedule){
		
		this.scheduleId = schedule.getScheduleId();
		this.syllabus = schedule.getSyllabus();
		this.courseType = schedule.getCourseType();
		this.timeofCourse = schedule.getTimeofCourse();
		this.hours = schedule.getHours();
		
	}
	/*07.05.2011 AutoScheduling tamamlandıktan sonra Scheduling tablosuna veri ekeleyen metod (Erhun) */
	public void addScheduleList(){
		Session session=null;
		try{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			
			for(int i=0; i<scheduleList.size(); i++){
				
				Query query = session.getNamedQuery("AddSchedule");
				query.setParameter("pCourseType", scheduleList.get(i).courseType);
				query.setParameter("pTimeofCourse", scheduleList.get(i).timeofCourse);
				query.setParameter("pHours", scheduleList.get(i).hours);
				query.setParameter("pSyllabusId", scheduleList.get(i).syllabus);
				query.setParameter("pSyllabusArchiveId", scheduleList.get(i).syllabusArchive);
				
				query.executeUpdate();
			}
			
			tx.commit();
		}catch(Exception ex){
			System.err.println(ex.getMessage());
		}
		finally{
			session.close();
		}
	}
	
public void addScheduleMatrix(){
		
		Session session=null;
		try{
			
			
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			
			
			for(int i = 0; i < 5;i++){
				for(int j = 0;j < 8 ;j++){
					//Kontrol diğer if lerde de uyugulanmalaı.
					if(!firstGradeSchedule[i][j].getLecturerName().equals("Lecturer")){
						
						syllabus.setSyllabusId(firstGradeSchedule[i][j].getSyllabusId());
						courseType = firstGradeSchedule[i][j].getCourseType();
						timeofCourse = firstGradeSchedule[i][j].getTimeofCourse();
						hours = firstGradeSchedule[i][j].getHours();
						
						Query query = session.getNamedQuery("AddSchedule");
						query.setParameter("pCourseType", courseType);
						query.setParameter("pTimeofCourse", timeofCourse);
						query.setParameter("pHours", hours);
						query.setParameter("pSyllabusId", syllabus);
						query.executeUpdate();
						
						
				    }
					
					if(!secondGradeSchedule[i][j].getLecturerName().equals("Lecturer")){
						
						syllabus = new Syllabus();
						courseType="";
					    timeofCourse = -1;
					    hours = -1;
						
						syllabus.setSyllabusId(secondGradeSchedule[i][j].getSyllabusId());
						courseType = secondGradeSchedule[i][j].getCourseType();
						timeofCourse = secondGradeSchedule[i][j].getTimeofCourse();
						hours = secondGradeSchedule[i][j].getHours();
						
						Query query = session.getNamedQuery("AddSchedule");
						query.setParameter("pCourseType", courseType);
						query.setParameter("pTimeofCourse", timeofCourse);
						query.setParameter("pHours", hours);
						query.setParameter("pSyllabusId", syllabus);
						query.executeUpdate();
					}
					
					if(!thirdGradeSchedule[i][j].getLecturerName().equals("Lecturer")){
						
						syllabus = new Syllabus();
						courseType="";
					    timeofCourse = -1;
					    hours = -1;
						
						syllabus.setSyllabusId(thirdGradeSchedule[i][j].getSyllabusId());
						courseType = thirdGradeSchedule[i][j].getCourseType();
						timeofCourse = thirdGradeSchedule[i][j].getTimeofCourse();
						hours = thirdGradeSchedule[i][j].getHours();
						
						Query query = session.getNamedQuery("AddSchedule");
						query.setParameter("pCourseType", courseType);
						query.setParameter("pTimeofCourse", timeofCourse);
						query.setParameter("pHours", hours);
						query.setParameter("pSyllabusId", syllabus);
						query.executeUpdate();
					}
					
					if(!fourthGradeSchedule[i][j].getLecturerName().equals("Lecturer")){
						
						syllabus = new Syllabus();
						courseType="";
					    timeofCourse = -1;
					    hours = -1;
						
						syllabus.setSyllabusId(fourthGradeSchedule[i][j].getSyllabusId());
						courseType = fourthGradeSchedule[i][j].getCourseType();
						timeofCourse = fourthGradeSchedule[i][j].getTimeofCourse();
						hours = fourthGradeSchedule[i][j].getHours();
						
						Query query = session.getNamedQuery("AddSchedule");
						query.setParameter("pCourseType", courseType);
						query.setParameter("pTimeofCourse", timeofCourse);
						query.setParameter("pHours", hours);
						query.setParameter("pSyllabusId", syllabus);
						query.executeUpdate();
					}
				}
			}
			
			tx.commit();
		}catch(Exception e){
			System.err.print(e.getMessage());
		}
		finally{
			session.close();
		}
	}

public void updateScheduleMatrix(){
	
	Session session=null;
	try{
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		
		for(int i = 0; i < 5;i++){
			for(int j = 0;j < 8 ;j++){
				//Kontrol diğer if lerde de uyugulanmalaı.
				if(!firstGradeSchedule[i][j].getLecturerName().equals("Lecturer")){
					
					syllabus.setSyllabusId(firstGradeSchedule[i][j].getSyllabusId());
					syllabus.setSemester(firstGradeSchedule[i][j].getSemester());
					syllabus.setYear(firstGradeSchedule[i][j].getYear());
					courseType = firstGradeSchedule[i][j].getCourseType();
					timeofCourse = firstGradeSchedule[i][j].getTimeofCourse();
					hours = firstGradeSchedule[i][j].getHours();
					scheduleId = firstGradeSchedule[i][j].getScheduleId();
					
					Query query = session.getNamedQuery("updateScheduleMatrix");
					query.setParameter("pScheduleId", scheduleId);
					query.setParameter("pCourseType", courseType);
					query.setParameter("pTimeofCourse", timeofCourse);
					query.setParameter("pHours", hours);
					query.setParameter("pSyllabusId", syllabus);
					query.executeUpdate();
					
			    }
				
				if(!secondGradeSchedule[i][j].getLecturerName().equals("Lecturer")){
					
					syllabus = new Syllabus();
					courseType="";
				    timeofCourse = -1;
				    hours = -1;
					
					syllabus.setSyllabusId(secondGradeSchedule[i][j].getSyllabusId());
					syllabus.setSemester(firstGradeSchedule[i][j].getSemester());
					syllabus.setYear(firstGradeSchedule[i][j].getYear());
					courseType = secondGradeSchedule[i][j].getCourseType();
					timeofCourse = secondGradeSchedule[i][j].getTimeofCourse();
					hours = secondGradeSchedule[i][j].getHours();
					scheduleId = firstGradeSchedule[i][j].getScheduleId();
					
					Query query = session.getNamedQuery("updateScheduleMatrix");
					query.setParameter("pScheduleId", scheduleId);
					query.setParameter("pCourseType", courseType);
					query.setParameter("pTimeofCourse", timeofCourse);
					query.setParameter("pHours", hours);
					query.setParameter("pSyllabusId", syllabus);
					query.executeUpdate();
				}
				
				if(!thirdGradeSchedule[i][j].getLecturerName().equals("Lecturer")){
					
					syllabus = new Syllabus();
					courseType="";
				    timeofCourse = -1;
				    hours = -1;
					
					syllabus.setSyllabusId(thirdGradeSchedule[i][j].getSyllabusId());
					syllabus.setSemester(firstGradeSchedule[i][j].getSemester());
					syllabus.setYear(firstGradeSchedule[i][j].getYear());
					courseType = thirdGradeSchedule[i][j].getCourseType();
					timeofCourse = thirdGradeSchedule[i][j].getTimeofCourse();
					hours = thirdGradeSchedule[i][j].getHours();
					scheduleId = firstGradeSchedule[i][j].getScheduleId();
					
					Query query = session.getNamedQuery("updateScheduleMatrix");
					query.setParameter("pScheduleId", scheduleId);
					query.setParameter("pCourseType", courseType);
					query.setParameter("pTimeofCourse", timeofCourse);
					query.setParameter("pHours", hours);
					query.setParameter("pSyllabusId", syllabus);
					query.executeUpdate();
				}
				
				if(!fourthGradeSchedule[i][j].getLecturerName().equals("Lecturer")){
					
					syllabus = new Syllabus();
					courseType="";
				    timeofCourse = -1;
				    hours = -1;
					
					syllabus.setSyllabusId(fourthGradeSchedule[i][j].getSyllabusId());
					syllabus.setSemester(firstGradeSchedule[i][j].getSemester());
					syllabus.setYear(firstGradeSchedule[i][j].getYear());
					courseType = fourthGradeSchedule[i][j].getCourseType();
					timeofCourse = fourthGradeSchedule[i][j].getTimeofCourse();
					hours = fourthGradeSchedule[i][j].getHours();
					scheduleId = firstGradeSchedule[i][j].getScheduleId();
					
					Query query = session.getNamedQuery("updateScheduleMatrix");
					query.setParameter("pScheduleId", scheduleId);
					query.setParameter("pCourseType", courseType);
					query.setParameter("pTimeofCourse", timeofCourse);
					query.setParameter("pHours", hours);
					query.setParameter("pSyllabusId", syllabus);
					query.executeUpdate();
				}
			}
		}
		
		tx.commit();
	}catch(Exception e){
		System.err.print(e.getMessage());
	}
	finally{
		session.close();
	}
}

	@SuppressWarnings("unchecked")
	public List<Schedule> getScheduleBySemesterAndGradeAndYear(){
		List<Schedule> allSchedules = null;
		
	     Session session = null;
	     
	     try {
	             SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	             session = sessionFactory.openSession();
	             
	             Query query = session.getNamedQuery("getScheduleBySemesterAndGradeAndYear");
	             query.setParameter("pGrade", syllabus.getCourse().getGrade());
	             query.setParameter("pSemester", syllabus.getSemester());
	             query.setParameter("pYear", syllabus.getYear());
	             allSchedules =(List<Schedule>) query.list();
	             
	     } catch (Exception e) {
	             // TODO: handle exception
	             e.getMessage();
	     } 
	     return allSchedules;
	}
	
	public String getCourseTheoricOrPraticName() {
		return courseTheoricOrPraticName;
	}

	public void setCourseTheoricOrPraticName(String courseTheoricOrPraticName) {
		this.courseTheoricOrPraticName = courseTheoricOrPraticName;
	}

	public Integer getScheduleId() {
		return this.scheduleId;
	}

	public void setScheduleId(Integer scheduleId) {
		this.scheduleId = scheduleId;
	}

	public Syllabus getSyllabus() {
		return this.syllabus;
	}

	public void setSyllabus(Syllabus syllabus) {
		this.syllabus = syllabus;
	}

	public String getCourseType() {
		return this.courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	public int getTimeofCourse() {
		return this.timeofCourse;
	}

	public void setTimeofCourse(int timeofCourse) {
		this.timeofCourse = timeofCourse;
	}

	public int getHours() {
		return this.hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public void setFirstGradeSchedule(BasicScheduleUtilBean[][] firstGradeSchedule) {
		this.firstGradeSchedule = firstGradeSchedule;
	}

	public void setSecondGradeSchedule(BasicScheduleUtilBean[][] secondGradeSchedule) {
		this.secondGradeSchedule = secondGradeSchedule;
	}

	public void setThirdGradeSchedule(BasicScheduleUtilBean[][] thirdGradeSchedule) {
		this.thirdGradeSchedule = thirdGradeSchedule;
	}

	public void setFourthGradeSchedule(BasicScheduleUtilBean[][] fourthGradeSchedule) {
		this.fourthGradeSchedule = fourthGradeSchedule;
	}

	public void setSyllabusArchive(SyllabusArchive syllabusArchive) {
		this.syllabusArchive = syllabusArchive;
	}

	public SyllabusArchive getSyllabusArchive() {
		return syllabusArchive;
	}

	public ArrayList<Schedule> getScheduleList() {
		return scheduleList;
	}

	public void setScheduleList(ArrayList<Schedule> scheduleList) {
		this.scheduleList = scheduleList;
	}

	
	
}
