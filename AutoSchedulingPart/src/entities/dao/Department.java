package entities.dao;

// Generated Apr 11, 2011 8:27:09 PM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * Department generated by hbm2java
 */
public class Department implements java.io.Serializable {

	private Integer departmentId;
	private String deptCode;
	private String deptDescription;
	private Set lecturers = new HashSet(0);
	private Set courses = new HashSet(0);

	public Department() {
	}

	public Department(String deptCode) {
		this.deptCode = deptCode;
	}

	public Department(String deptCode, String deptDescription, Set lecturers,
			Set courses) {
		this.deptCode = deptCode;
		this.deptDescription = deptDescription;
		this.lecturers = lecturers;
		this.courses = courses;
	}

	public Integer getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getDeptCode() {
		return this.deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getDeptDescription() {
		return this.deptDescription;
	}

	public void setDeptDescription(String deptDescription) {
		this.deptDescription = deptDescription;
	}

	public Set getLecturers() {
		return this.lecturers;
	}

	public void setLecturers(Set lecturers) {
		this.lecturers = lecturers;
	}

	public Set getCourses() {
		return this.courses;
	}

	public void setCourses(Set courses) {
		this.courses = courses;
	}

}
