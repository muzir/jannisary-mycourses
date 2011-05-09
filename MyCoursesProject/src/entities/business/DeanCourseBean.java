package entities.business;
import java.awt.Color;
import java.util.*;
import java.lang.Integer;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import entities.dao.Course;
import entities.dao.Syllabus;
import entities.utility.ScheduleAtomic;
import entities.utility.SortedList;

public class DeanCourseBean 
{
	
//************************** SUBFIELDS *************************************************	
// For general usage, these object are created. By passing them methods, related data
// is taken from these classes.
	Course courseObj = new Course();
	Syllabus syllabusObj = new Syllabus();
	ScheduleAtomic scheduleAtomicObj = new ScheduleAtomic();
// When year and semester values are selected, they will be attached to these subfields. 	
	private String selectedYear = ""; 												//1
	private String selectedSemester = "";											//2
// These subfields holds the actions state when selecting year and semester.
	private boolean yearFlag = false;
	private boolean semesterFlag = false;
// Year and semester data are hold in these subfields.
	private ArrayList<SelectItem> yearList = new ArrayList<SelectItem>(); 			//3
	private ArrayList<SelectItem> semesterList = new ArrayList<SelectItem>();		//4
// 'Dean Course' type courses in selected year and semester are stored in this subfield.	
	private ArrayList<SelectItem> deanCourseList = new ArrayList<SelectItem>(); 	//5
// After selection of dean course, lecturers of this course are stored in this subfield.
	private ArrayList<SelectItem> deanLecturerList = new ArrayList<SelectItem>();  	//6
//***************************************************************************************
// This eight subfields holds the data about courses in four grade.
	private ArrayList<SelectItem> freshmanCourses = new ArrayList<SelectItem>();
	private ArrayList<SelectItem> sophomoreCourses = new ArrayList<SelectItem>();
	private ArrayList<SelectItem> juniorCourses = new ArrayList<SelectItem>();
	private ArrayList<SelectItem> seniorCourses = new ArrayList<SelectItem>();
//**************************************************************************************	
// These subfields holds data about the scheduling operations
	private ArrayList<ScheduleAtomic> freshmanSchedules = new ArrayList<ScheduleAtomic>();
	private ArrayList<ScheduleAtomic> sophomoreSchedules = new ArrayList<ScheduleAtomic>();
	private ArrayList<ScheduleAtomic> juniorSchedules = new ArrayList<ScheduleAtomic>();
	private ArrayList<ScheduleAtomic> seniorSchedules = new ArrayList<ScheduleAtomic>();
	private ArrayList<ScheduleAtomic> deanSchedules = new ArrayList<ScheduleAtomic>();
//**************************************************************************************	
	private String selectedDeanCourse = "";
	private String creditValueTheo = "";
	private String creditValuePrac = "";
//******************************************************************************
	private ArrayList<SelectItem> freshmanOperations = new ArrayList<SelectItem>();
	private ArrayList<SelectItem> sophomoreOperations = new ArrayList<SelectItem>();
	private ArrayList<SelectItem> juniorOperations = new ArrayList<SelectItem>();
	private ArrayList<SelectItem> seniorOperations = new ArrayList<SelectItem>();
	
	private ArrayList<SelectItem> freshmanDays = new ArrayList<SelectItem>();
	private ArrayList<SelectItem> sophomoreDays = new ArrayList<SelectItem>();
	private ArrayList<SelectItem> juniorDays = new ArrayList<SelectItem>();
	private ArrayList<SelectItem> seniorDays = new ArrayList<SelectItem>();
	
	private ArrayList<SelectItem> freshmanHours = new ArrayList<SelectItem>();
	private ArrayList<SelectItem> sophomoreHours = new ArrayList<SelectItem>();
	private ArrayList<SelectItem> juniorHours = new ArrayList<SelectItem>();
	private ArrayList<SelectItem> seniorHours = new ArrayList<SelectItem>();
	
	private ArrayList<SelectItem> freshmanCredits = new ArrayList<SelectItem>();
	private ArrayList<SelectItem> sophomoreCredits = new ArrayList<SelectItem>();
	private ArrayList<SelectItem> juniorCredits = new ArrayList<SelectItem>();
	private ArrayList<SelectItem> seniorCredits = new ArrayList<SelectItem>();
//******************************************************************************
	private ArrayList<ScheduleAtomic> freshmanUnmarkedList = new ArrayList<ScheduleAtomic>();
	private ArrayList<ScheduleAtomic> freshmanMarkedList = new ArrayList<ScheduleAtomic>();
	
	private ArrayList<ScheduleAtomic> sophomoreUnmarkedList = new ArrayList<ScheduleAtomic>();
	private ArrayList<ScheduleAtomic> sophomoreMarkedList = new ArrayList<ScheduleAtomic>();
	
	private ArrayList<ScheduleAtomic> juniorUnmarkedList = new ArrayList<ScheduleAtomic>();
	private ArrayList<ScheduleAtomic> juniorMarkedList = new ArrayList<ScheduleAtomic>();
	
	private ArrayList<ScheduleAtomic> seniorUnmarkedList = new ArrayList<ScheduleAtomic>();
	private ArrayList<ScheduleAtomic> seniorMarkedList = new ArrayList<ScheduleAtomic>();
	
	private Hashtable<String, Integer> dayMapToIndexHash;	
//******************* MATRICES *************************************************
	public String[][] initCourseTable = new String[8][6];
	public String[][] initFreshmanCourseTable = new String[8][6];
	public String[][] initSophomoreCourseTable = new String[8][6];
	public String[][] initJuniorCourseTable = new String[8][6];
	public String[][] initSeniorCourseTable = new String[8][6];
//******************************************************************************
	private String selectedDeanLecturer;
	String selectedDeanDay = "";
	String selectedOperation = "";
	String selectedStartHour = "";
	String selectedEndHour = "";
	String selectedRoom = "";
	boolean buttonStatus = false;
	
	Color testColor = Color.green;
//**************** Freshman Subfields ***********************************************
	private String selectedFreshmanCourse = "";
	private String selectedFreshmanSplitCourse = "";
	private String selectedFreshmanSplitLecturer = "";
	private String selectedFreshmanLecturer;
	private String selectedFreshmanDay = "";
	private String selectedFreshmanOperation = "";
	private String selectedFreshmanStartHour = "";
	private String selectedFreshmanCredit = "";
	private String freshmanCreditValeuTeo = "";
	private String freshmanCreditValuePrac = "";
	
	private Syllabus selectedFreshmanSyllabus = null;
	private ScheduleAtomic selectedScheduleAtomicFreshman = null;
	private int atomicIndexFreshman = -1;
	private int topCreditFreshman = -1;
	private String optFlagFreshman = "";
//**************** Sophomore Subfields **********************************************
	private String selectedSophomoreCourse = "";
	private String selectedSophomoreSplitCourse = "";
	private String selectedSophomoreSplitLecturer = "";
	private String selectedSophomoreLecturer;
	private String selectedSophomoreDay = "";
	private String selectedSophomoreOperation = "";
	private String selectedSophomoreStartHour = "";
	private String selectedSophomoreCredit = "";
	private String sophomoreCreditValeuTeo = "";
	private String sophomoreCreditValuePrac = "";
	
	private Syllabus selectedSophomoreSyllabus = null;
	private ScheduleAtomic selectedScheduleAtomicSophomore = null;
	private int atomicIndexSophomore = -1;
	private int topCreditSophomore = -1;
	private String optFlagSophomore = "";
//**************** Junior Subfields *************************************************
	private String selectedJuniorCourse = "";
	private String selectedJuniorSplitCourse = "";
	private String selectedJuniorSplitLecturer = "";
	private String selectedJuniorLecturer;
	private String selectedJuniorDay = "";
	private String selectedJuniorOperation = "";
	private String selectedJuniorStartHour = "";
	private String selectedJuniorCredit = "";
	private String juniorCreditValueTeo = "";
	private String juniorCreditValuePrac = "";
	
	private Syllabus selectedJuniorSyllabus = null;
	private ScheduleAtomic selectedScheduleAtomicJunior = null;
	private int atomicIndexJunior = -1;
	private int topCreditJunior = -1;
	private String optFlagJunior = "";
//**************** Senior Subfields **************************************************
	private String selectedSeniorCourse = "";
	private String selectedSeniorSplitCourse = "";
	private String selectedSeniorSplitLecturer = "";
	private String selectedSeniorLecturer;
	private String selectedSeniorDay = "";
	private String selectedSeniorOperation = "";
	private String selectedSeniorStartHour = "";
	private String selectedSeniorCredit = "";
	private String seniorCreditValueTeo = "";
	private String seniorCreditValuePrac = "";
	
	private Syllabus selectedSeniorSyllabus = null;
	private ScheduleAtomic selectedScheduleAtomicSenior = null;
	private int atomicIndexSenior = -1;
	private int topCreditSenior = -1;
	private String optFlagSenior = "";
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//******************** CONSTRUCTOR ***************************************************	
	public DeanCourseBean()
	{	
		dayMapToIndexHash = new Hashtable<String, Integer>();
		dayMapToIndexHash.put("Monday", 1);
		dayMapToIndexHash.put("Tuesday", 2);
		dayMapToIndexHash.put("Wednesday", 3);
		dayMapToIndexHash.put("Thursday", 4);
		dayMapToIndexHash.put("Friday", 5);
		
		initCourseTable[0][0] = "1";
		initCourseTable[1][0] = "2";
		initCourseTable[2][0] = "3";
		initCourseTable[3][0] = "4";
		initCourseTable[4][0] = "5";
		initCourseTable[5][0] = "6";
		initCourseTable[6][0] = "7";
		initCourseTable[7][0] = "8";	
		
		initFreshmanCourseTable[0][0] = "1";
		initFreshmanCourseTable[1][0] = "2";
		initFreshmanCourseTable[2][0] = "3";
		initFreshmanCourseTable[3][0] = "4";
		initFreshmanCourseTable[4][0] = "5";
		initFreshmanCourseTable[5][0] = "6";
		initFreshmanCourseTable[6][0] = "7";
		initFreshmanCourseTable[7][0] = "8";
		
		initSophomoreCourseTable[0][0] = "1";
		initSophomoreCourseTable[1][0] = "2";
		initSophomoreCourseTable[2][0] = "3";
		initSophomoreCourseTable[3][0] = "4";
		initSophomoreCourseTable[4][0] = "5";
		initSophomoreCourseTable[5][0] = "6";
		initSophomoreCourseTable[6][0] = "7";
		initSophomoreCourseTable[7][0] = "8";
		
		initJuniorCourseTable[0][0] = "1";
		initJuniorCourseTable[1][0] = "2";
		initJuniorCourseTable[2][0] = "3";
		initJuniorCourseTable[3][0] = "4";
		initJuniorCourseTable[4][0] = "5";
		initJuniorCourseTable[5][0] = "6";
		initJuniorCourseTable[6][0] = "7";
		initJuniorCourseTable[7][0] = "8";
		
		initSeniorCourseTable[0][0] = "1";
		initSeniorCourseTable[1][0] = "2";
		initSeniorCourseTable[2][0] = "3";
		initSeniorCourseTable[3][0] = "4";
		initSeniorCourseTable[4][0] = "5";
		initSeniorCourseTable[5][0] = "6";
		initSeniorCourseTable[6][0] = "7";
		initSeniorCourseTable[7][0] = "8";		
	}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//******************** TABLE CLEANING ************************************************
	public String clearDeanCourseTable()
	{
		try
		{
			initCourseTable = new String[8][6];
			initCourseTable[0][0] = "1";
			initCourseTable[1][0] = "2";
			initCourseTable[2][0] = "3";
			initCourseTable[3][0] = "4";
			initCourseTable[4][0] = "5";
			initCourseTable[5][0] = "6";
			initCourseTable[6][0] = "7";
			initCourseTable[7][0] = "8";
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return null;
	}	
	
	public String clearFreshmanCourseTable()
	{
		try
		{
			initFreshmanCourseTable = new String[8][6];
			initFreshmanCourseTable[0][0] = "1";
			initFreshmanCourseTable[1][0] = "2";
			initFreshmanCourseTable[2][0] = "3";
			initFreshmanCourseTable[3][0] = "4";
			initFreshmanCourseTable[4][0] = "5";
			initFreshmanCourseTable[5][0] = "6";
			initFreshmanCourseTable[6][0] = "7";
			initFreshmanCourseTable[7][0] = "8";
		}
		catch(Exception ex)
		{
			ex.getMessage();
		}
		return null;
	}
	
	public String clearSophomoreCourseTable()
	{
		try
		{
			initSophomoreCourseTable = new String[8][6];
			initSophomoreCourseTable[0][0] = "1";
			initSophomoreCourseTable[1][0] = "2";
			initSophomoreCourseTable[2][0] = "3";
			initSophomoreCourseTable[3][0] = "4";
			initSophomoreCourseTable[4][0] = "5";
			initSophomoreCourseTable[5][0] = "6";
			initSophomoreCourseTable[6][0] = "7";
			initSophomoreCourseTable[7][0] = "8";
		}
		catch(Exception ex)
		{
			ex.getMessage();
		}
		return null;
	}
	
	public String clearJuniorCourseTable()
	{
		try
		{
			initJuniorCourseTable = new String[8][6];
			initJuniorCourseTable[0][0] = "1";
			initJuniorCourseTable[1][0] = "2";
			initJuniorCourseTable[2][0] = "3";
			initJuniorCourseTable[3][0] = "4";
			initJuniorCourseTable[4][0] = "5";
			initJuniorCourseTable[5][0] = "6";
			initJuniorCourseTable[6][0] = "7";
			initJuniorCourseTable[7][0] = "8";
		}
		catch(Exception ex)
		{
			ex.getMessage();
		}
		return null;
	}
	
	public String clearSeniorCourseTable()
	{
		try
		{
			initSeniorCourseTable = new String[8][6];
			initSeniorCourseTable[0][0] = "1";
			initSeniorCourseTable[1][0] = "2";
			initSeniorCourseTable[2][0] = "3";
			initSeniorCourseTable[3][0] = "4";
			initSeniorCourseTable[4][0] = "5";
			initSeniorCourseTable[5][0] = "6";
			initSeniorCourseTable[6][0] = "7";
			initSeniorCourseTable[7][0] = "8";
		}
		catch(Exception ex)
		{
			ex.getMessage();
		}
		return null;
	}
// ******************** INITIALIZING DEAN COURSES TAB ***********************************
	public String initDeanCourseTable()
	{
		try
		{						
			if(selectedOperation.equals("Theory Operation"))
			{
				System.out.println("Function 2*****");
				if(!selectedDeanDay.equals("Choose Days"))
				{	
					if(!selectedStartHour.equals("Choose Start Hour") && !selectedEndHour.equals("Choose End Hour"))
					{		
						int dayIndexOnCourseTable = dayMapToIndexHash.get(selectedDeanDay);
						int startHourOfDeanCourse = Integer.parseInt(selectedStartHour);
						int endHourOfDeanCourse = Integer.parseInt(selectedEndHour);	
						//int totalCourseHour = endHourOfDeanCourse - startHourOfDeanCourse;					
						int startHourT = startHourOfDeanCourse - 1;
						int endHourT = endHourOfDeanCourse - 1;
						//for(int acc = 0; acc < totalCourseHour + 1; acc++)
						//{	
							if(initCourseTable[startHourT][dayIndexOnCourseTable] == null)
							{
								if(initCourseTable[endHourT][dayIndexOnCourseTable] == null)
								{
									initCourseTable[startHourT][dayIndexOnCourseTable] = selectedDeanCourse + "(T)";
									initCourseTable[endHourT][dayIndexOnCourseTable] = selectedDeanCourse + "(T)";
									//System.out.println("Test Result ::: "+initCourseTable[startHourOfDeanCourse][dayIndexOnCourseTable]);							
								}
							}
							else
							{
								System.out.println("Indices are not available");
							}
						//}
						System.out.println(initCourseTable);
					}
				}
			}		
			else if(selectedOperation.equals("Practice Operation"))
			{
				if(!selectedDeanDay.equals("Choose Days"))
				{
					if(!selectedStartHour.equals("Choose Start Hour") && !selectedEndHour.equals("Choose End Hour"))
					{
						int dayIndexOnCourseTable = dayMapToIndexHash.get(selectedDeanDay);
						int startHourOfDeanCourse = Integer.parseInt(selectedStartHour);
						int endHourOfDeanCourse = Integer.parseInt(selectedEndHour);
						//int totalCourseHour = endHourOfDeanCourse - startHourOfDeanCourse;
						int startHourT = startHourOfDeanCourse - 1;
						int endHourT = endHourOfDeanCourse - 1;
						//for(int acc = 0; acc < totalCourseHour + 1; acc++)
						//{	
							if(initCourseTable[startHourT][dayIndexOnCourseTable] == null)
							{
								if(initCourseTable[endHourT][dayIndexOnCourseTable] == null)
								{
									initCourseTable[startHourT][dayIndexOnCourseTable] = selectedDeanCourse + "(P)";
									initCourseTable[endHourT][dayIndexOnCourseTable] = selectedDeanCourse + "(P)";
									//System.out.println("Test Result ::: "+initCourseTable[startHourOfDeanCourse][dayIndexOnCourseTable]);							
								}
							}
							else
							{
								System.out.println("Indices are not available");
							}
						//}
					}
				}
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return null;
	}
//********************* INITIALIZING FOUR GRADEs TABS ***********************************	
	public String initFreshmanCourseTableEvent()
	{	
		try
		{
			if(selectedFreshmanOperation.equals("Theory Operation"))
			{
				if(!selectedFreshmanDay.equals("Choose Days"))
				{
					if(!selectedFreshmanStartHour.equals("Choose Start Hour")
							&& !selectedFreshmanCredit.equals("Choose Credit"))
					{
						int dayIndexOnCourseTable = dayMapToIndexHash.get(selectedFreshmanDay);
						int startHourOfFreshmanCourse = Integer.parseInt(selectedFreshmanStartHour);
						int endHourOfFreshmanCourse = Integer.parseInt(selectedFreshmanCredit);
						
						int startHourT = startHourOfFreshmanCourse - 1;
						int endHourT = endHourOfFreshmanCourse - 1;
						
						if(initFreshmanCourseTable[startHourT][dayIndexOnCourseTable] == null)
						{
							if(initFreshmanCourseTable[endHourT][dayIndexOnCourseTable] == null)
							{
								initFreshmanCourseTable[startHourT][dayIndexOnCourseTable] = selectedFreshmanCourse + "(T)";
								initFreshmanCourseTable[endHourT][dayIndexOnCourseTable] = selectedFreshmanCourse + "(T)";							
							}
						}
						else
						{
							System.out.println("Indices are not available");
						}	
					}
				}
			}
			else if(selectedFreshmanOperation.equals("Practice Operation"))
			{
				if(!selectedFreshmanDay.equals("Choose Days"))
				{
					if(!selectedFreshmanStartHour.equals("Choose Start Hour")
							&& !selectedFreshmanCredit.equals("Choose Credit"))
					{
						int dayIndexOnCourseTable = dayMapToIndexHash.get(selectedFreshmanDay);
						int startHourOfFreshmanCourse = Integer.parseInt(selectedFreshmanStartHour);
						int endHourOfFreshmanCourse = Integer.parseInt(selectedFreshmanCredit);
						
						int startHourT = startHourOfFreshmanCourse - 1;
						int endHourT = endHourOfFreshmanCourse - 1;
						
						if(initFreshmanCourseTable[startHourT][dayIndexOnCourseTable] == null)
						{
							if(initFreshmanCourseTable[endHourT][dayIndexOnCourseTable] == null)
							{
								initFreshmanCourseTable[startHourT][dayIndexOnCourseTable] = selectedFreshmanCourse + "(P)";
								initFreshmanCourseTable[endHourT][dayIndexOnCourseTable] = selectedFreshmanCourse + "(P)";							
							}
						}
						else
						{
							System.out.println("Indices are not available");
						}						
					}
				}
			}
		}
		catch(Exception ex)
		{
			ex.getMessage();
		}
		return null;
	}
	
	public String initSophomoreCourseTableEvent()
	{
		try
		{
			if(selectedSophomoreOperation.equals("Theory Operation"))
			{
				if(!selectedSophomoreDay.equals("Choose Days"))
				{
					if(!selectedSophomoreStartHour.equals("Choose Start Hour")
							&& !selectedSophomoreCredit.equals("Choose Credit"))
					{
						int dayIndexOnCourseTable = dayMapToIndexHash.get(selectedSophomoreDay);
						int startHourOfSophomoreCourse = Integer.parseInt(selectedSophomoreStartHour);
						int endHourOfSophomoreCourse = Integer.parseInt(selectedSophomoreCredit);
						
						int startHourT = startHourOfSophomoreCourse - 1;
						int endHourT = endHourOfSophomoreCourse - 1;
						
						if(initSophomoreCourseTable[startHourT][dayIndexOnCourseTable] == null)
						{
							if(initSophomoreCourseTable[endHourT][dayIndexOnCourseTable] == null)
							{
								initSophomoreCourseTable[startHourT][dayIndexOnCourseTable] = selectedSophomoreCourse + "(T)";
								initSophomoreCourseTable[endHourT][dayIndexOnCourseTable] = selectedSophomoreCourse + "(T)";							
							}
						}
						else
						{
							System.out.println("Indices are not available");
						}
					}
				}
			}
			else if(selectedSophomoreOperation.equals("Practice Operation"))
			{
				if(!selectedSophomoreDay.equals("Choose Days"))
				{
					if(!selectedSophomoreStartHour.equals("Choose Start Hour")
							&& !selectedSophomoreCredit.equals("Choose Credit"))
					{
						int dayIndexOnCourseTable = dayMapToIndexHash.get(selectedSophomoreDay);
						int startHourOfSophomoreCourse = Integer.parseInt(selectedSophomoreStartHour);
						int endHourOfSophomoreCourse = Integer.parseInt(selectedSophomoreCredit);
						
						int startHourT = startHourOfSophomoreCourse - 1;
						int endHourT = endHourOfSophomoreCourse - 1;
						
						if(initSophomoreCourseTable[startHourT][dayIndexOnCourseTable] == null)
						{
							if(initSophomoreCourseTable[endHourT][dayIndexOnCourseTable] == null)
							{
								initSophomoreCourseTable[startHourT][dayIndexOnCourseTable] = selectedSophomoreCourse + "(P)";
								initSophomoreCourseTable[endHourT][dayIndexOnCourseTable] = selectedSophomoreCourse + "(P)";							
							}
						}
						else
						{
							System.out.println("Indices are not available");
						}						
					}
				}
			}
		}
		catch(Exception ex)
		{
			ex.getMessage();
		}
		return null;
	}
	
	public String initJuniorCourseTableEvent()
	{
		try
		{
				if(selectedJuniorOperation.equals("Theory Operation"))
				{
					if(!selectedJuniorDay.equals("Choose Days"))
					{
						if(!selectedJuniorStartHour.equals("Choose Start Hour")
								&& !selectedJuniorCredit.equals("Choose End Hour"))
						{
							int dayIndexOnCourseTable = dayMapToIndexHash.get(selectedJuniorDay);
							int startHourOfJuniorCourse = Integer.parseInt(selectedJuniorStartHour);
							int endHourOfJuniorCourse = Integer.parseInt(selectedJuniorCredit);
							
							int startHourT = startHourOfJuniorCourse - 1;
							int endHourT = endHourOfJuniorCourse - 1;
							
							if(initJuniorCourseTable[startHourT][dayIndexOnCourseTable] == null)
							{
								if(initJuniorCourseTable[endHourT][dayIndexOnCourseTable] == null)
								{
									initJuniorCourseTable[startHourT][dayIndexOnCourseTable] = selectedJuniorCourse + "(T)";
									initJuniorCourseTable[endHourT][dayIndexOnCourseTable] = selectedJuniorCourse + "(T)";							
								}
							}
							else
							{
								System.out.println("Indices are not available");
							}
						}
					}
				}
				else if(selectedJuniorOperation.equals("Practice Operation"))
				{
					if(!selectedJuniorDay.equals("Choose Days"))
					{
						if(!selectedJuniorStartHour.equals("Choose Start Hour")
								&& !selectedJuniorCredit.equals("Choose Credit"))
						{
							int dayIndexOnCourseTable = dayMapToIndexHash.get(selectedJuniorDay);
							int startHourOfJuniorCourse = Integer.parseInt(selectedJuniorStartHour);
							int endHourOfJuniorCourse = Integer.parseInt(selectedJuniorCredit);							
							int startHourT = startHourOfJuniorCourse - 1;
							int endHourT = endHourOfJuniorCourse - 1;
							
							if(initJuniorCourseTable[startHourT][dayIndexOnCourseTable] == null)
							{
								if(initJuniorCourseTable[endHourT][dayIndexOnCourseTable] == null)
								{
									initJuniorCourseTable[startHourT][dayIndexOnCourseTable] = selectedJuniorCourse + "(P)";
									initJuniorCourseTable[endHourT][dayIndexOnCourseTable] = selectedJuniorCourse + "(P)";							
								}
							}
							else
							{
								System.out.println("Indices are not available");
							}						
						}
					}
				}
		}
		catch(Exception ex)
		{
			ex.getMessage();
		}
		return null;
	}
	
	public String initSeniorCourseTableEvent()
	{
		try
		{
			if(selectedSeniorOperation.equals("Theory Operation"))
			{
				if(!selectedSeniorDay.equals("Choose Days"))
				{
					if(!selectedSeniorStartHour.equals("Choose Start Hour")
							&& !selectedSeniorCredit.equals("Choose Credit"))
					{
						int dayIndexOnCourseTable = dayMapToIndexHash.get(selectedSeniorDay);
						int startHourOfSeniorCourse = Integer.parseInt(selectedSeniorStartHour);
						int endHourOfSeniorCourse = Integer.parseInt(selectedSeniorCredit);
						
						int startHourT = startHourOfSeniorCourse - 1;
						int endHourT = endHourOfSeniorCourse - 1;
						
						if(initSeniorCourseTable[startHourT][dayIndexOnCourseTable] == null)
						{
							if(initSeniorCourseTable[endHourT][dayIndexOnCourseTable] == null)
							{
								initSeniorCourseTable[startHourT][dayIndexOnCourseTable] = selectedSeniorCourse + "(T)";
								initSeniorCourseTable[endHourT][dayIndexOnCourseTable] = selectedSeniorCourse + "(T)";							
							}
						}
						else
						{
							System.out.println("Indices are not available");
						}
					}
				}
			}
			else if(selectedSeniorOperation.equals("Practice Operation"))
			{
				if(!selectedSeniorDay.equals("Choose Days"))
				{
					if(!selectedSeniorStartHour.equals("Choose Start Hour")
							&& !selectedSeniorCredit.equals("Choose Credit"))
					{
						int dayIndexOnCourseTable = dayMapToIndexHash.get(selectedSeniorDay);
						int startHourOfSeniorCourse = Integer.parseInt(selectedSeniorStartHour);
						int endHourOfSeniorCourse = Integer.parseInt(selectedSeniorCredit);
						
						int startHourT = startHourOfSeniorCourse - 1;
						int endHourT = endHourOfSeniorCourse - 1;
						
						if(initSeniorCourseTable[startHourT][dayIndexOnCourseTable] == null)
						{
							if(initSeniorCourseTable[endHourT][dayIndexOnCourseTable] == null)
							{
								initSeniorCourseTable[startHourT][dayIndexOnCourseTable] = selectedSeniorCourse + "(P)";
								initSeniorCourseTable[endHourT][dayIndexOnCourseTable] = selectedSeniorCourse + "(P)";							
							}
						}
						else
						{
							System.out.println("Indices are not available");
						}						
					}
				}
			}
		}
		catch(Exception ex)
		{
			ex.getMessage();
		}
		return null;
	}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
//********************** EVENTS **********************************************************
// Onur (Finished 03.05)
// This is the event which holds the operations when a year is selected. According to year
// selected, semester data will be loaded to the related subfield.
	public void yearValueChange(ValueChangeEvent event) {
		System.out.println("Year Code : " + event.getComponent().getId());
		String oldValue = (String)event.getOldValue();
		String newValue = (String)event.getNewValue();
		System.out.println("Old Value : "+oldValue);
		System.out.println("New Value : "+newValue);
		this.selectedYear = newValue;
		if((!this.selectedYear.equals("Choose Year")) && (this.selectedYear != null)) {
			if(this.semesterFlag == true) {
				this.clearAllComponents();
				this.loadAllLists(selectedYear, selectedSemester);
			}
			else {
				this.semesterList = new ArrayList<SelectItem>();
				this.loadSemester();
			}		
		}
		else {
			this.clearAllComponents();
		}
	}
// Onur (Finished 03.05)
// This is the event which holds the operations when a semester is selected. Via of 
// selected semester value, all the subfield which must be initialized after this event
	public void semesterValueChange(ValueChangeEvent event) {
		System.out.println("Course Code : " + event.getComponent().getId());
		String oldValue = (String)event.getOldValue();
		String newValue = (String)event.getNewValue();
		System.out.println("Old Value : "+oldValue);
		System.out.println("New Value : "+newValue);
		this.selectedSemester = newValue;
		if((!this.selectedSemester.equals("Choose Semester")) && (this.selectedSemester != null)) {
			this.clearAllComponents();
			this.loadAllLists(this.selectedYear, this.selectedSemester);
			this.semesterFlag = true;
		}
		else { 
			this.semesterFlag = false;
			this.clearAllComponents();
		}
	}
	
//This is the event which holds the operations when a course selected in dean tab	
	public void handleValueChange(ValueChangeEvent event) {
		System.out.println("Course Code : " + event.getComponent().getId());
		String oldValue = (String)event.getOldValue();
		String newValue = (String)event.getNewValue();
		System.out.println("Old Value : "+oldValue);
		System.out.println("New Value : "+newValue);
		this.selectedDeanCourse = newValue;
		this.clearDeanSubFields();
		this.loadDeanSubFields();
	}
// ****************** 4(Freshman, Sophomore, Junior, Senior) GRADE EVENTS ***************
//******************* FRESHMAN EVENTS ***************************************************
	public void freshmanSplitChange(ValueChangeEvent event) {
		System.out.println("Freshman Course has been changed!!!");
		String oldValue = (String)event.getOldValue();
		String newValue = (String)event.getNewValue();
		System.out.println("Old Value : "+oldValue);
		System.out.println("New Value : "+newValue);
		this.selectedFreshmanCourse = newValue;	
		this.clearSubFields("Freshman");
		this.clearTimeValues("Freshman");
		if(!this.selectedFreshmanCourse.equals("Course Selection") && this.selectedFreshmanCourse != null) {
			this.loadSubFields("Freshman");
		}
	}
	
	public void freshmanOperationChange(ValueChangeEvent event) {
		System.out.println("Freshman Operation has been changed!!!");
		String oldValue = (String)event.getOldValue();
		String newValue = (String)event.getNewValue();
		System.out.println("Old Value : "+oldValue);
		System.out.println("New Value : "+newValue);
		this.selectedFreshmanOperation = newValue;
		this.atomicIndexFreshman = -1;
		this.topCreditFreshman = -1;
		this.clearTimeValues("Freshman");
		if((!this.selectedFreshmanOperation.equals("Choose Course Type")) && (this.selectedFreshmanOperation != null)) {
			if(this.selectedFreshmanOperation.equals("Theoretical") && (this.optFlagFreshman != "T")) {
				if(this.optFlagFreshman == "P") { 
					this.selectedFreshmanCredit = null;
				}
				this.optFlagFreshman = "T";
				this.topCreditFreshman = Integer.parseInt(this.freshmanCreditValeuTeo);
				this.loadCredits("Freshman", this.topCreditFreshman);
				this.atomicIndexFreshman = this.findRelatedAtomic("Freshman", "Unmarked", "SEEK", this.selectedFreshmanSyllabus, "Theo", this.topCreditFreshman);
				return;
			} 
			if(this.selectedFreshmanOperation.equals("Practice") && (this.optFlagFreshman != "P")) {
				if(this.optFlagFreshman == "T") {
					this.selectedFreshmanCredit = null;
				}
				this.optFlagFreshman = "P";
				this.topCreditFreshman = Integer.parseInt(this.freshmanCreditValuePrac);
				this.loadCredits("Freshman", this.topCreditFreshman);
				this.atomicIndexFreshman = this.findRelatedAtomic("Freshman", "Unmarked", "SEEK", this.selectedFreshmanSyllabus, "Prac", this.topCreditFreshman);
				return;
			}
		}
		else { 
			this.clearTimeValues("Freshman"); 
			this.optFlagFreshman = "";
		}
	}
	
	public void freshmanCreditChange(ValueChangeEvent event) {
		System.out.println("Freshman Credit has been changed!!!");
		String oldValue = (String)event.getOldValue();
		String newValue = (String)event.getNewValue();
		System.out.println("Old Value : "+oldValue);
		System.out.println("New Value : "+newValue);
		this.selectedFreshmanCredit = newValue;
		this.freshmanDays.clear();
		this.freshmanHours.clear();
		if(!this.selectedFreshmanCredit.equals("Choose Credit") && this.selectedFreshmanCredit != "") {
			this.loadDays("Freshman");
			if (this.atomicIndexFreshman != -1) {
				if(this.topCreditFreshman != Integer.parseInt(this.selectedFreshmanCredit)) {
					this.selectedScheduleAtomicFreshman = this.freshmanUnmarkedList.get(this.atomicIndexFreshman).splitCredit(Integer.parseInt(this.selectedFreshmanCredit));	
				}
				else {
					this.selectedScheduleAtomicFreshman = this.freshmanUnmarkedList.get(this.atomicIndexFreshman);
				}
			}
			System.out.println("Credit "+ Integer.toString(this.selectedScheduleAtomicFreshman.getCredit()));
			System.out.println("Credit "+ Integer.toString(this.selectedScheduleAtomicFreshman.getSyllabus().getSyllabusId()));
		}
	}
	
	public void freshmanDayChange(ValueChangeEvent event) {
		System.out.println("Freshman Day has been changed!!!");
		String oldValue = (String)event.getOldValue();
		String newValue = (String)event.getNewValue();
		System.out.println("Old Value : "+oldValue);
		System.out.println("New Value : "+newValue);
		this.selectedFreshmanDay = newValue;
		this.freshmanHours.clear();
		if(!this.selectedFreshmanDay.equals("Choose Day") && this.selectedFreshmanDay != "") {
			this.freshmanHours = this.selectedScheduleAtomicFreshman.getKnowledgeByDay(this.selectedFreshmanDay);
			this.deneme();
		}
	}
//******************* SOPHOMORE EVENTS **************************************************
	public void sophomoreSplitChange(ValueChangeEvent event) {
		System.out.println("Sophomore course has been changed!!!");
		String oldValue = (String)event.getOldValue();
		String newValue = (String)event.getNewValue();
		System.out.println("Old Value : "+oldValue);
		System.out.println("New Value : "+newValue);
		this.selectedSophomoreCourse = newValue;
		this.clearSubFields("Sophomore");
		this.clearTimeValues("Sophomore");
		if(!this.selectedSophomoreCourse.equals("Course Selection") && this.selectedSophomoreCourse != null) {
			this.loadSubFields("Sophomore");
		}
	}
	
	public void sophomoreOperationChange(ValueChangeEvent event) {
		System.out.println("Sophomore Operation has been changed!!!");
		String oldValue = (String)event.getOldValue();
		String newValue = (String)event.getNewValue();
		System.out.println("Old Value : "+oldValue);
		System.out.println("New Value : "+newValue);
		this.selectedSophomoreOperation = newValue;
		this.atomicIndexSophomore = -1;
		this.topCreditSophomore = -1;
		this.clearTimeValues("Sophomore");
		if((!this.selectedSophomoreOperation.equals("Choose Course Type")) && (this.selectedSophomoreOperation != null)) {
			if(this.selectedSophomoreOperation.equals("Theoretical")) {
				if(this.optFlagSophomore == "P") { 
					this.clearTimeValues("Sophomore");
					this.selectedSophomoreCredit = null;
				}
				this.optFlagSophomore = "T";
				this.topCreditSophomore = Integer.parseInt(this.sophomoreCreditValeuTeo);
				this.loadCredits("Sophomore", this.topCreditSophomore);
				this.atomicIndexSophomore = this.findRelatedAtomic("Sophomore", "Unmarked", "SEEK", this.selectedSophomoreSyllabus, "Theo", this.topCreditSophomore);
				return;
			} 
			if(this.selectedSophomoreOperation.equals("Practice")) {
				if(this.optFlagSophomore == "T") {
					this.clearTimeValues("Sophomore");
					this.selectedSophomoreCredit = null;
				}
				this.optFlagSophomore = "P";
				this.topCreditSophomore = Integer.parseInt(this.sophomoreCreditValuePrac);
				this.loadCredits("Sophomore", this.topCreditSophomore);
				this.atomicIndexSophomore = this.findRelatedAtomic("Sophomore", "Unmarked", "SEEK", this.selectedSophomoreSyllabus, "Prac", this.topCreditSophomore);
				return;
			}
		}
		else { 
			this.clearTimeValues("Sophomore"); 
			this.optFlagSophomore = "";
		}
	}
	
	public void sophomoreCreditChange(ValueChangeEvent event) {
		System.out.println("Sophomore Credit has been changed!!!");
		String oldValue = (String)event.getOldValue();
		String newValue = (String)event.getNewValue();
		System.out.println("Old Value : "+oldValue);
		System.out.println("New Value : "+newValue);
		this.selectedSophomoreCredit = newValue;
		this.sophomoreDays.clear();
		this.sophomoreHours.clear();
		if(!this.selectedSophomoreCredit.equals("Choose Credit") && this.selectedSophomoreCredit != "") {
			this.loadDays("Sophomore");
			if (this.atomicIndexSophomore != -1) {
				if(this.topCreditSophomore != Integer.parseInt(this.selectedSophomoreCredit)) {
					this.selectedScheduleAtomicSophomore = this.sophomoreUnmarkedList.get(this.atomicIndexSophomore).splitCredit(Integer.parseInt(this.selectedSophomoreCredit));
				}
				else {
					this.selectedScheduleAtomicSophomore = this.sophomoreUnmarkedList.get(this.atomicIndexSophomore);	
				}
			}
			System.out.println("Credit "+ Integer.toString(this.selectedScheduleAtomicSophomore.getCredit()));
			System.out.println("Credit "+ Integer.toString(this.selectedScheduleAtomicSophomore.getSyllabus().getSyllabusId()));
		}
	}
	
	public void sophomoreDayChange(ValueChangeEvent event) {
		System.out.println("Sophomore Day has been changed!!!");
		String oldValue = (String)event.getOldValue();
		String newValue = (String)event.getNewValue();
		System.out.println("Old Value : "+oldValue);
		System.out.println("New Value : "+newValue);
		this.selectedSophomoreDay = newValue;
		this.sophomoreHours.clear();
		if(!this.selectedSophomoreDay.equals("Choose Day") && this.selectedSophomoreDay != "") {
			this.sophomoreHours = this.selectedScheduleAtomicSophomore.getKnowledgeByDay(this.selectedSophomoreDay);
		}
	}
	
//******************* JUNIOR EVENTS *****************************************************
	public void juniorSplitChange(ValueChangeEvent event) {
		System.out.println("Junior course has been changed!!!");
		String oldValue = (String)event.getOldValue();
		String newValue = (String)event.getNewValue();
		System.out.println("Old Value : "+oldValue);
		System.out.println("New Value : "+newValue);
		this.selectedJuniorCourse = newValue;
		this.clearSubFields("Junior");
		this.clearTimeValues("Junior");
		if(!this.selectedJuniorCourse.equals("Course Selection") && this.selectedJuniorCourse != null) {
			this.loadSubFields("Junior");
		}	
	}
	
	public void juniorOperationChange(ValueChangeEvent event) {
		System.out.println("Junior Operation has been changed!!!");
		String oldValue = (String)event.getOldValue();
		String newValue = (String)event.getNewValue();
		System.out.println("Old Value : "+oldValue);
		System.out.println("New Value : "+newValue);
		this.selectedJuniorOperation = newValue;
		this.atomicIndexJunior = -1;
		this.topCreditJunior = -1;
		this.clearTimeValues("Junior");
		if((!this.selectedJuniorOperation.equals("Choose Course Type")) && (this.selectedJuniorOperation != null)) {
			if(this.selectedJuniorOperation.equals("Theoretical")) {
				if(this.optFlagJunior == "P") { 
					this.clearTimeValues("Junior");
					this.selectedJuniorCredit = null;
				}
				this.optFlagJunior = "T";
				this.topCreditJunior = Integer.parseInt(this.juniorCreditValueTeo);
				this.loadCredits("Junior", this.topCreditJunior);
				this.atomicIndexJunior = this.findRelatedAtomic("Junior", "Unmarked", "SEEK", this.selectedJuniorSyllabus, "Theo", this.topCreditJunior);
				return;
			} 
			if(this.selectedJuniorOperation.equals("Practice")) {
				if(this.optFlagJunior == "T") {
					this.clearTimeValues("Junior");
					this.selectedJuniorCredit = null;
				}
				this.optFlagJunior = "P";
				this.topCreditJunior = Integer.parseInt(this.juniorCreditValuePrac);
				this.loadCredits("Junior", this.topCreditJunior);
				this.atomicIndexJunior = this.findRelatedAtomic("Junior", "Unmarked", "SEEK", this.selectedJuniorSyllabus, "Prac", this.topCreditJunior);
				return;
			}
		}
		else { 
			this.clearTimeValues("Junior"); 
			this.optFlagJunior = "";
		}
	}
	
	public void juniorCreditChange(ValueChangeEvent event) {
		System.out.println("Junior Credit has been changed!!!");
		String oldValue = (String)event.getOldValue();
		String newValue = (String)event.getNewValue();
		System.out.println("Old Value : "+oldValue);
		System.out.println("New Value : "+newValue);
		this.selectedJuniorCredit = newValue;
		this.juniorDays.clear();
		this.juniorHours.clear();
		if(!this.selectedJuniorCredit.equals("Choose Credit") && this.selectedJuniorCredit != "") {
			this.loadDays("Junior");
			if (this.atomicIndexJunior != -1) {
				if(this.topCreditJunior != Integer.parseInt(this.selectedJuniorCredit)) {
					this.selectedScheduleAtomicJunior = this.juniorUnmarkedList.get(this.atomicIndexJunior).splitCredit(Integer.parseInt(this.selectedJuniorCredit));
				}
				else {
					this.selectedScheduleAtomicJunior = this.juniorUnmarkedList.get(this.atomicIndexJunior);	
				}
			}
			System.out.println("Credit "+ Integer.toString(this.selectedScheduleAtomicJunior.getCredit()));
			System.out.println("Credit "+ Integer.toString(this.selectedScheduleAtomicJunior.getSyllabus().getSyllabusId()));
		}
	}
	
	public void juniorDayChange(ValueChangeEvent event) {
		System.out.println("Junior Day has been changed!!!");
		String oldValue = (String)event.getOldValue();
		String newValue = (String)event.getNewValue();
		System.out.println("Old Value : "+oldValue);
		System.out.println("New Value : "+newValue);
		this.selectedJuniorDay = newValue;
		this.juniorHours.clear();
		if(!this.selectedJuniorDay.equals("Choose Day") && this.selectedJuniorDay != "") {
			this.juniorHours = this.selectedScheduleAtomicJunior.getKnowledgeByDay(this.selectedJuniorDay);
		}
	}
	
//******************* SENIOR EVENTS *****************************************************
	public void seniorSplitChange(ValueChangeEvent event) {
		System.out.println("Senior course has been changed!!!");
		String oldValue = (String)event.getOldValue();
		String newValue = (String)event.getNewValue();
		System.out.println("Old Value : "+oldValue);
		System.out.println("New Value : "+newValue);
		this.selectedSeniorCourse = newValue;
		this.clearSubFields("Senior");
		this.clearTimeValues("Senior");
		if(!this.selectedSeniorCourse.equals("Course Selection") && this.selectedSeniorCourse != null) {
			this.loadSubFields("Senior");
		}	
	}
	
	public void seniorOperationChange(ValueChangeEvent event) {
		System.out.println("Senior Operation has been changed!!!");
		String oldValue = (String)event.getOldValue();
		String newValue = (String)event.getNewValue();
		System.out.println("Old Value : "+oldValue);
		System.out.println("New Value : "+newValue);
		this.selectedSeniorOperation = newValue;
		this.atomicIndexSenior = -1;
		this.topCreditSenior = -1;
		this.clearTimeValues("Senior");
		if((!this.selectedSeniorOperation.equals("Choose Course Type")) && (this.selectedSeniorOperation != null)) {
			if(this.selectedSeniorOperation.equals("Theoretical")) {
				if(this.optFlagSenior == "P") { 
					this.clearTimeValues("Senior");
					this.selectedSeniorCredit = null;
				}
				this.optFlagSenior = "T";
				this.topCreditSenior = Integer.parseInt(this.seniorCreditValueTeo);
				this.loadCredits("Senior", this.topCreditSenior);
				this.atomicIndexSenior = this.findRelatedAtomic("Senior", "Unmarked", "SEEK", this.selectedSeniorSyllabus, "Theo", this.topCreditSenior);
				return;
			} 
			if(this.selectedSeniorOperation.equals("Practice")) {
				if(this.optFlagSenior == "T") {
					this.clearTimeValues("Senior");
					this.selectedSeniorCredit = null;
				}
				this.optFlagSenior = "P";
				this.topCreditSenior = Integer.parseInt(this.seniorCreditValuePrac);
				this.loadCredits("Senior", this.topCreditSenior);
				this.atomicIndexSenior = this.findRelatedAtomic("Senior", "Unmarked", "SEEK", this.selectedSeniorSyllabus, "Prac", this.topCreditSenior);
				return;
			}
		}
		else { 
			this.clearTimeValues("Senior"); 
			this.optFlagSenior = "";
		}
	}
	
	public void seniorCreditChange(ValueChangeEvent event) {
		System.out.println("senior Credit has been changed!!!");
		String oldValue = (String)event.getOldValue();
		String newValue = (String)event.getNewValue();
		System.out.println("Old Value : "+oldValue);
		System.out.println("New Value : "+newValue);
		this.selectedSeniorCredit = newValue;
		this.seniorDays.clear();
		this.seniorHours.clear();
		if(!this.selectedSeniorCredit.equals("Choose Credit") && this.selectedSeniorCredit != "") {
			this.loadDays("Senior");
			if (this.atomicIndexSenior != -1) {
				if(this.topCreditSenior != Integer.parseInt(this.selectedSeniorCredit)) {
					this.selectedScheduleAtomicSenior = this.seniorUnmarkedList.get(this.atomicIndexSenior).splitCredit(Integer.parseInt(this.selectedSeniorCredit));
				}
				else {
					this.selectedScheduleAtomicSenior = this.seniorUnmarkedList.get(this.atomicIndexSenior);	
				}
			}
			System.out.println("Credit "+ Integer.toString(this.selectedScheduleAtomicSenior.getCredit()));
			System.out.println("Credit "+ Integer.toString(this.selectedScheduleAtomicSenior.getSyllabus().getSyllabusId()));
		}
	}
	
	public void seniorDayChange(ValueChangeEvent event) {
		System.out.println("senior Day has been changed!!!");
		String oldValue = (String)event.getOldValue();
		String newValue = (String)event.getNewValue();
		System.out.println("Old Value : "+oldValue);
		System.out.println("New Value : "+newValue);
		this.selectedSeniorDay = newValue;
		this.seniorHours.clear();
		if(!this.selectedSeniorDay.equals("Choose Day") && this.selectedSeniorDay != "") {
			this.seniorHours = this.selectedScheduleAtomicSenior.getKnowledgeByDay(this.selectedSeniorDay);
		}
	}
	
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//******************* LOAD & CLEAR METHODS **********************************************	
// Onur (Finished 01.05)
// This method clears the all components when year value is changed. It's a kind of
// refresh operation for system components
	private void clearAllComponents() {
		this.freshmanCourses.clear();
		this.sophomoreCourses.clear();
		this.juniorCourses.clear();
		this.seniorCourses.clear();
		this.deanCourseList.clear();
		this.clearSubFields("Freshman");
		this.clearTimeValues("Freshman");
	}
//***************************************************************************************
// Onur (Finished 01.05)
// This method provides the all data needed for all components which are filled after 
// selecting the year and semester values. Try catch block, catches error which can be
// thrown during the convert of string to an integer.
	private void loadAllLists(String year, String semester) {
		try
		{
			int yearOfSyllabus = Integer.parseInt(year);
			this.loadDeanCourses(yearOfSyllabus, semester);
			this.loadCoursesByGrade(yearOfSyllabus, semester);
		}
		catch(Exception ex)
		{
			ex.getMessage();
		}
	}
//***************************************************************************************
// Onur (Finished 03.05)
// This method returns the all dean courses in related year and semester. The subfield of
// bean class which holds the data about dean courses filled with the related data here.
	private void loadDeanCourses(int year, String semester) {
		ArrayList<Syllabus> sList = syllabusObj.getDeanCourses(year, semester);
		if((sList != null) && (sList.size() != 0)) {
			this.deanSchedules = this.generateAtomic(sList);
			this.deanCourseList.add(new SelectItem("Choose Course"));
			for(int i = 0; i < sList.size(); i++) {
				String name = sList.get(i).getCourse().getCourseName();
				this.deanCourseList.add(new SelectItem(name));
			}
			return;
		}
		this.deanCourseList = new ArrayList<SelectItem>();
	}
//***************************************************************************************
// Onur (Finished 04.05)
// This method filled the related subfields of class with the expected data which are
// determined by the year and semester values. Each subfield of four grade filled in here.
	private void loadCoursesByGrade(int year, String semester) {
		//First Year(Freshman) Courses are loaded
		ArrayList<Syllabus> itemList = syllabusObj.getSyllabusByGrade(year, semester, 1);
		if(itemList.size() != 0) {
			this.freshmanUnmarkedList = this.generateAtomic(itemList);
			this.freshmanCourses.add(new SelectItem("Course Selection"));
			for(int i = 0; i < itemList.size(); i++) {
				this.freshmanCourses.add(new SelectItem(itemList.get(i).getCourse().getCourseCode()));
			}
		}
		//Second Year(Sophomore) Courses are loaded
		itemList = syllabusObj.getSyllabusByGrade(year, semester, 2);
		if(itemList.size() != 0) {
			this.sophomoreUnmarkedList = this.generateAtomic(itemList);
			this.sophomoreCourses.add(new SelectItem("Course Selection"));
			for(int i = 0; i < itemList.size(); i++) {
				this.sophomoreCourses.add(new SelectItem(itemList.get(i).getCourse().getCourseCode()));
			}
		}
		//Third Year(Junior) Courses are loaded
		itemList = syllabusObj.getSyllabusByGrade(year, semester, 3);
		if(itemList.size() != 0) {
			this.juniorUnmarkedList = this.generateAtomic(itemList);
			this.juniorCourses.add(new SelectItem("Course Selection"));
			for(int i = 0; i < itemList.size(); i++) {
				this.juniorCourses.add(new SelectItem(itemList.get(i).getCourse().getCourseCode()));
			}
		}
		//Fourth Year(Senior) Courses are loaded
		itemList = syllabusObj.getSyllabusByGrade(year, semester, 4);
		if(itemList.size() != 0) {
			this.seniorUnmarkedList = this.generateAtomic(itemList);
			this.seniorCourses.add(new SelectItem("Course Selection"));
			for(int i = 0; i < itemList.size(); i++) {
				this.seniorCourses.add(new SelectItem(itemList.get(i).getCourse().getCourseCode()));
			}
		}
	}
//***************************************************************************************
// Onur (Finished 03.05)
// This method loads the 'semesterList' subfield which holds the data of semester combobox
// with the related data below.
	private void loadSemester() {	
		this.semesterList.add(new SelectItem("Choose Semester"));
		this.semesterList.add(new SelectItem("Fall"));
		this.semesterList.add(new SelectItem("Spring"));
		this.semesterList.add(new SelectItem("Summer"));
	}
//***************************************************************************************
	private void loadDays(String grade) {
		if(grade.equals("Freshman")) {
			freshmanDays.add(new SelectItem("Choose Day"));
			freshmanDays.add(new SelectItem("Monday"));
			freshmanDays.add(new SelectItem("Tuesday"));
			freshmanDays.add(new SelectItem("Wednesday"));
			freshmanDays.add(new SelectItem("Thursday"));
			freshmanDays.add(new SelectItem("Friday"));
			return;
		}
		if(grade.equals("Sophomore")) {
			sophomoreDays.add(new SelectItem("Choose Day"));
			sophomoreDays.add(new SelectItem("Monday"));
			sophomoreDays.add(new SelectItem("Tuesday"));
			sophomoreDays.add(new SelectItem("Wednesday"));
			sophomoreDays.add(new SelectItem("Thursday"));
			sophomoreDays.add(new SelectItem("Friday"));
			return;
		}
		if(grade.equals("Junior")) {
			juniorDays.add(new SelectItem("Choose Day"));
			juniorDays.add(new SelectItem("Monday"));
			juniorDays.add(new SelectItem("Tuesday"));
			juniorDays.add(new SelectItem("Wednesday"));
			juniorDays.add(new SelectItem("Thursday"));
			juniorDays.add(new SelectItem("Friday"));
			return;
		}
		if(grade.equals("Senior")) {
			seniorDays.add(new SelectItem("Choose Day"));
			seniorDays.add(new SelectItem("Monday"));
			seniorDays.add(new SelectItem("Tuesday"));
			seniorDays.add(new SelectItem("Wednesday"));
			seniorDays.add(new SelectItem("Thursday"));
			seniorDays.add(new SelectItem("Friday"));
			return;
		}
	}
//***************************************************************************************
	private void loadCredits(String grade, int pCredit) {
		if(grade.equals("Freshman")) {
			int credit = pCredit;
			if(credit > 4) { credit = 4; }
			this.freshmanCredits = new ArrayList<SelectItem>();
			this.freshmanCredits.add(new SelectItem("Choose Credit"));
			for(int i = 0; i < credit; i++) {
				this.freshmanCredits.add(new SelectItem(Integer.toString(i + 1)));
			}
			return;
		}
		if(grade.equals("Sophomore")) {
			int credit = pCredit;
			if(credit > 4) { credit = 4; }
			this.sophomoreCredits = new ArrayList<SelectItem>();
			this.sophomoreCredits.add(new SelectItem("Choose Credit"));
			for(int i = 0; i < credit; i++) {
				this.sophomoreCredits.add(new SelectItem(Integer.toString(i + 1)));
			}
			return;
		}
		if(grade.equals("Junior")) {
			int credit = pCredit;
			if(credit > 4) { credit = 4; }
			this.juniorCredits = new ArrayList<SelectItem>();
			this.juniorCredits.add(new SelectItem("Choose Credit"));
			for(int i = 0; i < credit; i++) {
				this.juniorCredits.add(new SelectItem(Integer.toString(i + 1)));
			}
			return;
		}
		if(grade.equals("Senior")) {
			int credit = pCredit;
			if(credit > 4) { credit = 4; }
			this.seniorCredits = new ArrayList<SelectItem>();
			this.seniorCredits.add(new SelectItem("Choose Credit"));
			for(int i = 0; i < credit; i++) {
				this.seniorCredits.add(new SelectItem(Integer.toString(i + 1)));
			}
			return;
		}
	}
//***************************************************************************************
// Onur (Finished 31.04)
// When selection of dean course changed, then all information contained in sub-components
// must be cleared and updated again. This method clears the all fields related with.
	private void clearDeanSubFields() {
		this.deanLecturerList.clear();		
		this.creditValueTheo = "";
		this.creditValuePrac = "";
	}
// Onur (Finished 03.05)
// According to 'selected dean course' this method loads the related components with 
// related data 
	
	private void loadDeanSubFields()
	{
		ArrayList<Syllabus> itemList = syllabusObj.getSyllabusByCourseName(this.selectedDeanCourse);
		this.creditValueTheo = Integer.toString(itemList.get(0).getCourse().getTeoricLectureHours());
		this.creditValuePrac = Integer.toString(itemList.get(0).getCourse().getPracticeLectureHourse());
		for(int i = 0; i < itemList.size(); i++) {
			this.deanLecturerList.add(new SelectItem(itemList.get(i).getLecturer().getLecturerName()));
		}
	}
	
//****************** FIELD CLEAR & LOAD METHODS OF GRADES ******************************
	private void loadSubFields(String grade) {
		int year = Integer.parseInt(this.selectedYear);
		if(grade.equals("Freshman")) {
			ArrayList<Syllabus> itemList = syllabusObj.getSyllabusByCourseCode(year, this.selectedSemester, this.selectedFreshmanCourse);
			this.selectedFreshmanSyllabus = itemList.get(0);
			
			this.selectedFreshmanSplitCourse = this.selectedFreshmanSyllabus.getCourse().getCourseName();
			this.selectedFreshmanSplitLecturer = this.selectedFreshmanSyllabus.getLecturer().getLecturerName();
			this.freshmanCreditValeuTeo = Integer.toString(this.selectedFreshmanSyllabus.getCourse().getTeoricLectureHours());
			this.freshmanCreditValuePrac = Integer.toString(this.selectedFreshmanSyllabus.getCourse().getPracticeLectureHourse());
			
			this.freshmanOperations.add(new SelectItem("Choose Course Type"));
			this.freshmanOperations.add(new SelectItem("Theoretical"));
			this.freshmanOperations.add(new SelectItem("Practice"));
			return;
		}
		if(grade.equals("Sophomore")) {
			ArrayList<Syllabus> itemList = syllabusObj.getSyllabusByCourseCode(year, this.selectedSemester, this.selectedSophomoreCourse);
			this.selectedSophomoreSyllabus = itemList.get(0);
			
			this.selectedSophomoreSplitCourse = this.selectedSophomoreSyllabus.getCourse().getCourseName();
			this.selectedSophomoreSplitLecturer = this.selectedSophomoreSyllabus.getLecturer().getLecturerName();
			this.sophomoreCreditValeuTeo = Integer.toString(this.selectedSophomoreSyllabus.getCourse().getTeoricLectureHours());
			this.sophomoreCreditValuePrac = Integer.toString(this.selectedSophomoreSyllabus.getCourse().getPracticeLectureHourse());
			
			this.sophomoreOperations.add(new SelectItem("Choose Course Type"));
			this.sophomoreOperations.add(new SelectItem("Theoretical"));
			this.sophomoreOperations.add(new SelectItem("Practice"));
			return;
		}
		if(grade.equals("Junior")) { 
			ArrayList<Syllabus> itemList = syllabusObj.getSyllabusByCourseCode(year, this.selectedSemester, this.selectedJuniorCourse);
			this.selectedJuniorSyllabus = itemList.get(0);
		
			this.selectedJuniorSplitCourse = this.selectedJuniorSyllabus.getCourse().getCourseName();
			this.selectedJuniorSplitLecturer = this.selectedJuniorSyllabus.getLecturer().getLecturerName();
			this.juniorCreditValueTeo = Integer.toString(this.selectedJuniorSyllabus.getCourse().getTeoricLectureHours());
			this.juniorCreditValuePrac = Integer.toString(this.selectedJuniorSyllabus.getCourse().getPracticeLectureHourse());
		
			this.juniorOperations.add(new SelectItem("Choose Course Type"));
			this.juniorOperations.add(new SelectItem("Theoretical"));
			this.juniorOperations.add(new SelectItem("Practice"));
			return;
		}
		if(grade.equals("Senior")) { 
			ArrayList<Syllabus> itemList = syllabusObj.getSyllabusByCourseCode(year, this.selectedSemester, this.selectedSeniorCourse);
			this.selectedSeniorSyllabus = itemList.get(0);
		
			this.selectedSeniorSplitCourse = this.selectedSeniorSyllabus.getCourse().getCourseName();
			this.selectedSeniorSplitLecturer = this.selectedSeniorSyllabus.getLecturer().getLecturerName();
			this.seniorCreditValueTeo = Integer.toString(this.selectedSeniorSyllabus.getCourse().getTeoricLectureHours());
			this.seniorCreditValuePrac = Integer.toString(this.selectedSeniorSyllabus.getCourse().getPracticeLectureHourse());
		
			this.seniorOperations.add(new SelectItem("Choose Course Type"));
			this.seniorOperations.add(new SelectItem("Theoretical"));
			this.seniorOperations.add(new SelectItem("Practice"));
			return;
		}
	}
	
	private void clearSubFields(String grade) {
		if(grade.equals("Freshman")) {
			this.selectedFreshmanSplitCourse = "";
			this.selectedFreshmanSplitLecturer = "";
			this.freshmanCreditValeuTeo = "";
			this.freshmanCreditValuePrac = "";
			this.freshmanOperations.clear();
			return;
		}
		if(grade.equals("Sophomore")) { 
			this.selectedSophomoreSplitCourse = "";
			this.selectedSophomoreSplitLecturer = "";
			this.sophomoreCreditValeuTeo = "";
			this.sophomoreCreditValuePrac = "";
			this.sophomoreOperations.clear();
			return;
		}
		if(grade.equals("Junior")) { 
			this.selectedJuniorSplitCourse = "";
			this.selectedJuniorSplitLecturer = "";
			this.juniorCreditValueTeo = "";
			this.juniorCreditValuePrac = "";
			this.juniorOperations.clear();
			return;
		}
		if(grade.equals("Senior")) { 
			this.selectedSeniorSplitCourse = "";
			this.selectedSeniorSplitLecturer = "";
			this.seniorCreditValueTeo = "";
			this.seniorCreditValuePrac = "";
			this.seniorOperations.clear();
			return;
		}
	}
	
	
	private void clearTimeValues(String grade) {
		if(grade.equals("Freshman")) {
			this.freshmanCredits.clear();
			this.freshmanDays.clear();
			this.freshmanHours.clear(); 
			return;
		}
		if(grade.equals("Sophomore")) {
			this.sophomoreCredits.clear();
			this.sophomoreDays.clear();
			this.sophomoreHours.clear();
			return;
		}
		if(grade.equals("Junior")) { 
			this.juniorCredits.clear();
			this.juniorDays.clear();
			this.juniorHours.clear();
			return;
		}
		if(grade.equals("Senior")) { 
			this.seniorCredits.clear();
			this.seniorDays.clear();
			this.seniorHours.clear();
			return;
		}
	}
		
//***************************************************************************************	
//*********************** UTILITY METHODS ***********************************************
// Onur (Finished 29.04)
// This function has ability to detect duplication of an item in a list. We can not use
// DISTINCT operation in our stored procedures. That's why we have to eliminate duplicated
// data. This method called in 'getYearList()'.
	private boolean checkList(ArrayList<String> itemList, String item) {
		boolean breaker = false;
		int i = 0;
		while((breaker != true) && (i < itemList.size())) {
			if(itemList.get(i).equals(item)) {
				breaker = true;
			}
			i++;
		}
		return breaker;
	}
//***************************************************************************************
// Onur (Finished 03.05)
// This function generates Schedule Automatic objects from Syllabus objects. In another
// way we can say a syllabus list is converted to a scheduleAtomic list. 
	private ArrayList<ScheduleAtomic> generateAtomic(ArrayList<Syllabus> sList) {
		ArrayList<ScheduleAtomic> retList = new ArrayList<ScheduleAtomic>();
		for(int i = 0; i < sList.size(); i++) {
			Syllabus sItem = new Syllabus(sList.get(i));
			boolean att = sItem.getCourse().isAttendance();
			int courseId = sItem.getCourse().getCourseId();
			String preCondition = sItem.getCourse().getPrecondition();
			int lecturerId = sItem.getLecturer().getLecturerId();
			int classroomId = sItem.getClassroom().getClassroomId();
			int tHour = sItem.getCourse().getTeoricLectureHours();
			if(tHour != 0) {
				retList.add(new ScheduleAtomic(sItem, "Theo", "", 0, tHour, att, courseId, lecturerId, classroomId, preCondition));
			}
			int pHour = sItem.getCourse().getPracticeLectureHourse();
			if(pHour != 0) {
				retList.add(new ScheduleAtomic(sItem, "Prac", "", 0, pHour, att, courseId, lecturerId, classroomId, preCondition));
			}
		}
		return retList;
	}
	
	private int findRelatedAtomic(String grade, String sign, String opType, Syllabus syllabus, String courseType, int credit) {
		ScheduleAtomic sAtom = new ScheduleAtomic(syllabus, courseType, "", 0, credit, false, 0, 0, 0, "");
		if(grade.equals("Freshman")) {
			if(sign.equals("Unmarked")) {
				for(int i = 0; i < this.freshmanUnmarkedList.size(); i++) {
					if(sAtom.equals(this.freshmanUnmarkedList.get(i))) {
						return i;
					}
				}
				return -1;
			}
			if(sign.equals("Marked")) {
				for(int i = 0; i < this.freshmanMarkedList.size(); i++) {
					
				}
			}
		}
		return -1;
	}
	
//***************************************************************************************
//************************* GETTER-SETTER METHODS ***************************************	
//***1***********************************************************************************
// Onur (Finished 29.04)
// This getter method returns the list of years(YEARLIST) which are contained in syllabus 
// table. Via of 'checkList' utility method, duplication of year data is averted.
	public ArrayList<SelectItem> getYearList() {
		if(this.yearFlag == false)	{
			SelectItem stm = new SelectItem("Choose Year");
			this.yearList.add(stm);
			ArrayList<Syllabus> itemList = syllabusObj.getSyllabusAll();
			ArrayList<String> tempList = new ArrayList<String>();
			for(int i = 0; i < itemList.size(); i++) {
				String item = Integer.toString(itemList.get(i).getYear());
				if(this.checkList(tempList, item) == false) {
					tempList.add(item);
				}
			}
			for(int j = 0; j < tempList.size(); j++) {
				this.yearList.add(new SelectItem(tempList.get(j).toString()));
			}
			this.yearFlag = true; 
		}
		return this.yearList;
	}
// Set method of 'YEARLIST' subfield	
	public void setYearList(ArrayList<SelectItem> yearList) {
		this.yearList = yearList;
	}
//***2************************************************************************************
	public ArrayList<SelectItem> getSemesterList() {
		return semesterList;
	}

	public void setSemesterList(ArrayList<SelectItem> semesterList) {
		this.semesterList = semesterList;
	}
//***3************************************************************************************	
	public String getSelectedYear() {
		return selectedYear;
	}

	public void setSelectedYear(String selectedYear) {
		this.selectedYear = selectedYear;
	}
//***4************************************************************************************
	public String getSelectedSemester() {
		return selectedSemester;
	}

	public void setSelectedSemester(String selectedSemester) {
		this.selectedSemester = selectedSemester;
	}
//***************************************************************************************
//***5********************* DEAN GET SET *************************************************
	public ArrayList<SelectItem> getDeanCourseList() {
		return this.deanCourseList;
	}

	public void setDeanCourseList(ArrayList<SelectItem> deanCourseList) {
		this.deanCourseList = deanCourseList;
	}
//***6******************************************************************************
	public ArrayList<SelectItem> getDeanLecturerList() {
		return deanLecturerList;
	}

	public void setDeanLecturerList(ArrayList<SelectItem> deanLecturerList) {
		this.deanLecturerList = deanLecturerList;
	}
//************************************************************************************	
	public String getCreditValueTheo() {
		return creditValueTheo;
	}

	public void setCreditValueTheo(String creditValueTheo) {
		this.creditValueTheo = creditValueTheo;
	}
//************************************************************************************
	public String getCreditValuePrac() {
		return creditValuePrac;
	}

	public void setCreditValuePrac(String creditValuePrac) {
		this.creditValuePrac = creditValuePrac;
	}
//************************************************************************************
	public String getSelectedDeanCourse() {
		return selectedDeanCourse;
	}

	public void setSelectedDeanCourse(String selectedDeanCourse) {
		this.selectedDeanCourse = selectedDeanCourse;
	}

	public String getSelectedDeanLecturer() {
		return selectedDeanLecturer;
	}
	
	public void setSelectedDeanLecturer(String selectedDeanLecturer) {
		this.selectedDeanLecturer = selectedDeanLecturer;
	}

	public String[][] getInitCourseTable() {
		return initCourseTable;
	}

	public void setInitCourseTable(String[][] initCourseTable) {
		this.initCourseTable = initCourseTable;
	}

	public boolean isButtonStatus() {
		return buttonStatus;
	}

	public void setButtonStatus(boolean buttonStatus) {
		this.buttonStatus = buttonStatus;
	}

	public String getSelectedRoom() {
		return selectedRoom;
	}

	public void setSelectedRoom(String selectedRoom) {
		this.selectedRoom = selectedRoom;
	}

	public String getSelectedOperation() {
		return selectedOperation;
	}

	public void setSelectedOperation(String selectedOperation) {
		this.selectedOperation = selectedOperation;
	}

	public String getSelectedStartHour() {
		return selectedStartHour;
	}

	public void setSelectedStartHour(String selectedStartHour) {
		this.selectedStartHour = selectedStartHour;
	}

	public String getSelectedEndHour() {
		return selectedEndHour;
	}

	public void setSelectedEndHour(String selectedEndHour) {
		this.selectedEndHour = selectedEndHour;
	}

	public String getSelectedDeanDay() {
		return selectedDeanDay;
	}

	public void setSelectedDeanDay(String selectedDeanDay) {
		this.selectedDeanDay = selectedDeanDay;
	}

	public Color getTestColor() {
		return testColor;
	}

	public void setTestColor(Color testColor) {
		this.testColor = testColor;
	}
//**************************** FRESHMAN GET-SET *************************************
	public ArrayList<SelectItem> getFreshmanCourses() {
		return freshmanCourses;
	}

	public void setFreshmanCourses(ArrayList<SelectItem> freshmanCourses) {
		this.freshmanCourses = freshmanCourses;
	}
	
	public String getSelectedFreshmanCourse() {
		return selectedFreshmanCourse;
	}
	public void setSelectedFreshmanCourse(String selectedFreshmanCourse) {
		this.selectedFreshmanCourse = selectedFreshmanCourse;
	}

	public String getSelectedFreshmanLecturer() {
		return selectedFreshmanLecturer;
	}

	public void setSelectedFreshmanLecturer(String selectedFreshmanLecturer) {
		this.selectedFreshmanLecturer = selectedFreshmanLecturer;
	}

	public String getSelectedFreshmanDay() {
		return selectedFreshmanDay;
	}

	public void setSelectedFreshmanDay(String selectedFreshmanDay) {
		this.selectedFreshmanDay = selectedFreshmanDay;
	}

	public String getSelectedFreshmanOperation() {
		return selectedFreshmanOperation;
	}

	public void setSelectedFreshmanOperation(String selectedFreshmanOperation) {
		this.selectedFreshmanOperation = selectedFreshmanOperation;
	}

	public String getSelectedFreshmanStartHour() {
		return selectedFreshmanStartHour;
	}

	public void setSelectedFreshmanStartHour(String selectedFreshmanStartHour) {
		this.selectedFreshmanStartHour = selectedFreshmanStartHour;
	}

	public String getSelectedFreshmanCredit() {
		return selectedFreshmanCredit;
	}

	public void setSelectedFreshmanCredit(String selectedFreshmanCredit) {
		this.selectedFreshmanCredit = selectedFreshmanCredit;
	}

	public String getFreshmanCreditValeuTeo() {
		return freshmanCreditValeuTeo;
	}

	public void setFreshmanCreditValeuTeo(String freshmanCreditValeuTeo) {
		this.freshmanCreditValeuTeo = freshmanCreditValeuTeo;
	}

	public String getFreshmanCreditValuePrac() {
		return freshmanCreditValuePrac;
	}

	public void setFreshmanCreditValuePrac(String freshmanCreditValuePrac) {
		this.freshmanCreditValuePrac = freshmanCreditValuePrac;
	}

	public String getSelectedFreshmanSplitCourse() {
		return selectedFreshmanSplitCourse;
	}

	public void setSelectedFreshmanSplitCourse(String selectedFreshmanSplitCourse) {
		this.selectedFreshmanSplitCourse = selectedFreshmanSplitCourse;
	}

	public String getSelectedFreshmanSplitLecturer() 
	{
		return selectedFreshmanSplitLecturer;
	}

	public void setSelectedFreshmanSplitLecturer(
			String selectedFreshmanSplitLecturer) {
		this.selectedFreshmanSplitLecturer = selectedFreshmanSplitLecturer;
	}
	
	public String[][] getInitFreshmanCourseTable() {
		return initFreshmanCourseTable;
	}
	
	public void setInitFreshmanCourseTable(String[][] initFreshmanCourseTable) {
		this.initFreshmanCourseTable = initFreshmanCourseTable;
	}	
//********************** SOPHOMORE GET_SET METHODSSS ***********************************	
	public ArrayList<SelectItem> getSophomoreCourses() {
		return sophomoreCourses;
	}

	public void setSophomoreCourses(ArrayList<SelectItem> sophomoreCourses) {
		this.sophomoreCourses = sophomoreCourses;
	}
	
	public String[][] getInitSophomoreCourseTable() {
		return initSophomoreCourseTable;
	}
	
	public void setInitSophomoreCourseTable(String[][] initSophomoreCourseTable) {
		this.initSophomoreCourseTable = initSophomoreCourseTable;
	}
	
	public String getSelectedSophomoreCourse() {
		return selectedSophomoreCourse;
	}
	
	public void setSelectedSophomoreCourse(String selectedSophomoreCourse) {
		this.selectedSophomoreCourse = selectedSophomoreCourse;
	}
	
	public String getSelectedSophomoreSplitCourse() {
		return selectedSophomoreSplitCourse;
	}
	
	public void setSelectedSophomoreSplitCourse(String selectedSophomoreSplitCourse) {
		this.selectedSophomoreSplitCourse = selectedSophomoreSplitCourse;
	}
	
	public String getSelectedSophomoreSplitLecturer() {
		return selectedSophomoreSplitLecturer;
	}
	
	public void setSelectedSophomoreSplitLecturer(
			String selectedSophomoreSplitLecturer) {
		this.selectedSophomoreSplitLecturer = selectedSophomoreSplitLecturer;
	}
	
	public String getSelectedSophomoreLecturer() {
		return selectedSophomoreLecturer;
	}
	
	public void setSelectedSophomoreLecturer(String selectedSophomoreLecturer) {
		this.selectedSophomoreLecturer = selectedSophomoreLecturer;
	}
	
	public String getSelectedSophomoreDay() {
		return selectedSophomoreDay;
	}
	
	public void setSelectedSophomoreDay(String selectedSophomoreDay) {
		this.selectedSophomoreDay = selectedSophomoreDay;
	}
	
	public String getSelectedSophomoreOperation() {
		return selectedSophomoreOperation;
	}
	
	public void setSelectedSophomoreOperation(String selectedSophomoreOperation) {
		this.selectedSophomoreOperation = selectedSophomoreOperation;
	}
	
	public String getSelectedSophomoreStartHour() {
		return selectedSophomoreStartHour;
	}
	
	public void setSelectedSophomoreStartHour(String selectedSophomoreStartHour) {
		this.selectedSophomoreStartHour = selectedSophomoreStartHour;
	}
	
	public String getSelectedSophomoreCredit() {
		return selectedSophomoreCredit;
	}
	
	public void setSelectedSophomoreCredit(String selectedSophomoreCredit) {
		this.selectedSophomoreCredit = selectedSophomoreCredit;
	}
	
	public String getSophomoreCreditValeuTeo() {
		return sophomoreCreditValeuTeo;
	}
	
	public void setSophomoreCreditValeuTeo(String sophomoreCreditValeuTeo) {
		this.sophomoreCreditValeuTeo = sophomoreCreditValeuTeo;
	}
	
	public String getSophomoreCreditValuePrac() {
		return sophomoreCreditValuePrac;
	}
	
	public void setSophomoreCreditValuePrac(String sophomoreCreditValuePrac) {
		this.sophomoreCreditValuePrac = sophomoreCreditValuePrac;
	}
//******************** JUNIOR GET SET METHODS ******************************************
	public ArrayList<SelectItem> getJuniorCourses() {
		return juniorCourses;
	}

	public void setJuniorCourses(ArrayList<SelectItem> juniorCourses) {
		this.juniorCourses = juniorCourses;
	}
	
	public String[][] getInitJuniorCourseTable() {
		return initJuniorCourseTable;
	}
	
	public void setInitJuniorCourseTable(String[][] initJuniorCourseTable) {
		this.initJuniorCourseTable = initJuniorCourseTable;
	}
	
	public String getSelectedJuniorCourse() {
		return selectedJuniorCourse;
	}
	
	public void setSelectedJuniorCourse(String selectedJuniorCourse) {
		this.selectedJuniorCourse = selectedJuniorCourse;
	}
	
	public String getSelectedJuniorSplitCourse() {
		return selectedJuniorSplitCourse;
	}
	
	public void setSelectedJuniorSplitCourse(String selectedJuniorSplitCourse) {
		this.selectedJuniorSplitCourse = selectedJuniorSplitCourse;
	}
	
	public String getSelectedJuniorSplitLecturer() {
		return selectedJuniorSplitLecturer;
	}
	
	public void setSelectedJuniorSplitLecturer(String selectedJuniorSplitLecturer) {
		this.selectedJuniorSplitLecturer = selectedJuniorSplitLecturer;
	}
	
	public String getSelectedJuniorLecturer() {
		return selectedJuniorLecturer;
	}
	
	public void setSelectedJuniorLecturer(String selectedJuniorLecturer) {
		this.selectedJuniorLecturer = selectedJuniorLecturer;
	}
	
	public String getSelectedJuniorDay() {
		return selectedJuniorDay;
	}
	
	public void setSelectedJuniorDay(String selectedJuniorDay) {
		this.selectedJuniorDay = selectedJuniorDay;
	}
	
	public String getSelectedJuniorOperation() {
		return selectedJuniorOperation;
	}
	
	public void setSelectedJuniorOperation(String selectedJuniorOperation) {
		this.selectedJuniorOperation = selectedJuniorOperation;
	}
	
	public String getSelectedJuniorStartHour() {
		return selectedJuniorStartHour;
	}
	
	public void setSelectedJuniorStartHour(String selectedJuniorStartHour) {
		this.selectedJuniorStartHour = selectedJuniorStartHour;
	}
	
	public String getSelectedJuniorCredit() {
		return selectedJuniorCredit;
	}
	
	public void setSelectedJuniorCredit(String selectedJuniorCredit) {
		this.selectedJuniorCredit = selectedJuniorCredit;
	}
	
	public String getJuniorCreditValueTeo() {
		return juniorCreditValueTeo;
	}
	
	public void setJuniorCreditValueTeo(String juniorCreditValueTeo) {
		this.juniorCreditValueTeo = juniorCreditValueTeo;
	}
	
	public String getJuniorCreditValuePrac() {
		return juniorCreditValuePrac;
	}
	
	public void setJuniorCreditValuePrac(String juniorCreditValuePrac) {
		this.juniorCreditValuePrac = juniorCreditValuePrac;
	}
	
//******************* SENIOR GET-SET METHODS *****************************************
	public ArrayList<SelectItem> getSeniorCourses() {
		return seniorCourses;
	}

	public void setSeniorCourses(ArrayList<SelectItem> seniorCourses) {
		this.seniorCourses = seniorCourses;
	}
	
	public String[][] getInitSeniorCourseTable() {
		return initSeniorCourseTable;
	}
	
	public void setInitSeniorCourseTable(String[][] initSeniorCourseTable) {
		this.initSeniorCourseTable = initSeniorCourseTable;
	}
	
	public String getSelectedSeniorCourse() {
		return selectedSeniorCourse;
	}
	
	public void setSelectedSeniorCourse(String selectedSeniorCourse) {
		this.selectedSeniorCourse = selectedSeniorCourse;
	}
	
	public String getSelectedSeniorSplitCourse() {
		return selectedSeniorSplitCourse;
	}
	
	public void setSelectedSeniorSplitCourse(String selectedSeniorSplitCourse) {
		this.selectedSeniorSplitCourse = selectedSeniorSplitCourse;
	}
	
	public String getSelectedSeniorSplitLecturer() {
		return selectedSeniorSplitLecturer;
	}
	
	public void setSelectedSeniorSplitLecturer(String selectedSeniorSplitLecturer) {
		this.selectedSeniorSplitLecturer = selectedSeniorSplitLecturer;
	}
	
	public String getSelectedSeniorLecturer() {
		return selectedSeniorLecturer;
	}
	
	public void setSelectedSeniorLecturer(String selectedSeniorLecturer) {
		this.selectedSeniorLecturer = selectedSeniorLecturer;
	}
	
	public String getSelectedSeniorDay() {
		return selectedSeniorDay;
	}
	
	public void setSelectedSeniorDay(String selectedSeniorDay) {
		this.selectedSeniorDay = selectedSeniorDay;
	}
	
	public String getSelectedSeniorOperation() {
		return selectedSeniorOperation;
	}
	
	public void setSelectedSeniorOperation(String selectedSeniorOperation) {
		this.selectedSeniorOperation = selectedSeniorOperation;
	}
	
	public String getSelectedSeniorStartHour() {
		return selectedSeniorStartHour;
	}
	
	public void setSelectedSeniorStartHour(String selectedSeniorStartHour) {
		this.selectedSeniorStartHour = selectedSeniorStartHour;
	}
	
	public String getSelectedSeniorCredit() {
		return selectedSeniorCredit;
	}
	
	public void setSelectedSeniorCredit(String selectedSeniorCredit) {
		this.selectedSeniorCredit = selectedSeniorCredit;
	}
	
	public String getSeniorCreditValueTeo() {
		return seniorCreditValueTeo;
	}
	
	public void setSeniorCreditValueTeo(String seniorCreditValueTeo) {
		this.seniorCreditValueTeo = seniorCreditValueTeo;
	}
	
	public String getSeniorCreditValuePrac() {
		return seniorCreditValuePrac;
	}
	
	public void setSeniorCreditValuePrac(String seniorCreditValuePrac) {
		this.seniorCreditValuePrac = seniorCreditValuePrac;
	}
//**************************************************************************************	 
//*********** GETTER-SETTER METHODS OF SUBFIELDS RELATED WITH SCHEDULE *****************	
	public ArrayList<ScheduleAtomic> getFreshmanSchedules() {
		return freshmanSchedules;
	}
	
	public void setFreshmanSchedules(ArrayList<ScheduleAtomic> freshmanSchedules) {
		this.freshmanSchedules = freshmanSchedules;
	}
	
	public ArrayList<ScheduleAtomic> getSophomoreSchedules() {
		return sophomoreSchedules;
	}
	
	public void setSophomoreSchedules(ArrayList<ScheduleAtomic> sophomoreSchedules) {
		this.sophomoreSchedules = sophomoreSchedules;
	}
	
	public ArrayList<ScheduleAtomic> getJuniorSchedules() {
		return juniorSchedules;
	}
	
	public void setJuniorSchedules(ArrayList<ScheduleAtomic> juniorSchedules) {
		this.juniorSchedules = juniorSchedules;
	}
	
	public ArrayList<ScheduleAtomic> getSeniorSchedules() {
		return seniorSchedules;
	}
	
	public void setSeniorSchedules(ArrayList<ScheduleAtomic> seniorSchedules) {
		this.seniorSchedules = seniorSchedules;
	}
	
	public ArrayList<ScheduleAtomic> getDeanSchedules() {
		return deanSchedules;
	}
	
	public void setDeanSchedules(ArrayList<ScheduleAtomic> deanSchedules) {
		this.deanSchedules = deanSchedules;
	}
//************************************************************************************	
	public ArrayList<SelectItem> getFreshmanOperations() {
		return freshmanOperations;
	}
	public void setFreshmanOperations(ArrayList<SelectItem> freshmanOperations) {
		this.freshmanOperations = freshmanOperations;
	}
	public ArrayList<SelectItem> getSophomoreOperations() {
		return sophomoreOperations;
	}
	public void setSophomoreOperations(ArrayList<SelectItem> sophomoreOperations) {
		this.sophomoreOperations = sophomoreOperations;
	}
	public ArrayList<SelectItem> getJuniorOperations() {
		return juniorOperations;
	}
	public void setJuniorOperations(ArrayList<SelectItem> juniorOperations) {
		this.juniorOperations = juniorOperations;
	}
	public ArrayList<SelectItem> getSeniorOperations() {
		return seniorOperations;
	}
	public void setSeniorOperations(ArrayList<SelectItem> seniorOperations) {
		this.seniorOperations = seniorOperations;
	}
//************************************************************************************	
	public ArrayList<SelectItem> getFreshmanDays() {
		return freshmanDays;
	}
	public void setFreshmanDays(ArrayList<SelectItem> freshmanDays) {
		this.freshmanDays = freshmanDays;
	}
	public ArrayList<SelectItem> getSophomoreDays() {
		return sophomoreDays;
	}
	public void setSophomoreDays(ArrayList<SelectItem> sophomoreDays) {
		this.sophomoreDays = sophomoreDays;
	}
	public ArrayList<SelectItem> getJuniorDays() {
		return juniorDays;
	}
	public void setJuniorDays(ArrayList<SelectItem> juniorDays) {
		this.juniorDays = juniorDays;
	}
	public ArrayList<SelectItem> getSeniorDays() {
		return seniorDays;
	}
	public void setSeniorDays(ArrayList<SelectItem> seniorDays) {
		this.seniorDays = seniorDays;
	}
//***************************************************************************************
	public ArrayList<SelectItem> getFreshmanHours() {
		return freshmanHours;
	}
	public void setFreshmanHours(ArrayList<SelectItem> freshmanHours) {
		this.freshmanHours = freshmanHours;
	}
	public ArrayList<SelectItem> getSophomoreHours() {
		return sophomoreHours;
	}
	public void setSophomoreHours(ArrayList<SelectItem> sophomoreHours) {
		this.sophomoreHours = sophomoreHours;
	}
	public ArrayList<SelectItem> getJuniorHours() {
		return juniorHours;
	}
	public void setJuniorHours(ArrayList<SelectItem> juniorHours) {
		this.juniorHours = juniorHours;
	}
	public ArrayList<SelectItem> getSeniorHours() {
		return seniorHours;
	}
	public void setSeniorHours(ArrayList<SelectItem> seniorHours) {
		this.seniorHours = seniorHours;
	}
//*************************************************************************************
	public ArrayList<SelectItem> getFreshmanCredits() {
		return freshmanCredits;
	}
	public void setFreshmanCredits(ArrayList<SelectItem> freshmanCredits) {
		this.freshmanCredits = freshmanCredits;
	}
	public ArrayList<SelectItem> getSophomoreCredits() {
		return sophomoreCredits;
	}
	public void setSophomoreCredits(ArrayList<SelectItem> sophomoreCredits) {
		this.sophomoreCredits = sophomoreCredits;
	}
	public ArrayList<SelectItem> getJuniorCredits() {
		return juniorCredits;
	}
	public void setJuniorCredits(ArrayList<SelectItem> juniorCredits) {
		this.juniorCredits = juniorCredits;
	}
	public ArrayList<SelectItem> getSeniorCredits() {
		return seniorCredits;
	}
	public void setSeniorCredits(ArrayList<SelectItem> seniorCredits) {
		this.seniorCredits = seniorCredits;
	}
//**************************************************************************************
	private void deneme() {
		SortedList item = new SortedList(this.freshmanUnmarkedList);
		System.out.println("4 Credit Atomics");
		ArrayList<ScheduleAtomic> lst = item.getFourthCreditList();
		for(int i = 0; i < lst.size(); i++) {
			System.out.print(lst.get(i).toString());
		}
		System.out.println("3 Credit Atomics");
		lst = item.getThirdCreditList();
		for(int i = 0; i < lst.size(); i++) {
			System.out.print(lst.get(i).toString());
		}
		System.out.println("2 Credit Atomics");
		lst = item.getSecondCreditList();
		for(int i = 0; i < lst.size(); i++) {
			System.out.print(lst.get(i).toString());
		}
		System.out.println("1 Credit Atomics");
		lst = item.getFirstCreditList();
		for(int i = 0; i < lst.size(); i++) {
			System.out.print(lst.get(i).toString());
		}
		System.out.println("Not Attendence Atomics");
		lst = item.getFalseAttendanceList();
		for(int i = 0; i < lst.size(); i++) {
			System.out.print(lst.get(i).toString());
		}
	}
	
}
