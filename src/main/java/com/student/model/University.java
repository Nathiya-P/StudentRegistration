package com.student.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="UNIVERSITY")
@XmlAccessorType(XmlAccessType.FIELD)
public class University {

	@XmlElement(name = "NAME")
	private String name;
	
	@XmlElement(name = "ACADEMIC-YEAR")
	private String academicYear;
	
	@XmlElement(name = "STUDENT")
	private List<Student> students;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAcademicYear() {
		return academicYear;
	}

	public void setAcademicYear(String academicYear) {
		this.academicYear = academicYear;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
}
