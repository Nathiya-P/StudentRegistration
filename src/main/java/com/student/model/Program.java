package com.student.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="PREVIOUS")
@XmlAccessorType(XmlAccessType.FIELD)
public class Program {

	@XmlElement(name = "PROGRAM")
	protected String program;
	
	@XmlElement(name = "SUBJECT")
	protected String subject;
	
	@XmlElement(name = "GRADE")
	protected String grade;

	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
}
