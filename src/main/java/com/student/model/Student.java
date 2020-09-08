package com.student.model;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="STUDENT")
@XmlAccessorType(XmlAccessType.FIELD)
public class Student {

	@XmlElement(name = "FIRSTNAME")
	protected String fName;
	
	@XmlElement(name = "LASTNAME")
	protected String lName;
	
	@XmlElement(name = "REGISTRATION")
	protected String regNumber;
	
	@XmlElement(name = "REGISTERED")
	protected Program curProgram;
	
	@XmlElement(name = "PREVIOUS")
	protected Program prevProgram;

	public String getfName() {
		return fName;
	}

	public Student setfName(String fName) {
		this.fName = fName;
		return this;
	}

	public String getlName() {
		return lName;
	}

	public Student setlName(String lName) {
		this.lName = lName;
		return this;
	}

	public String getRegNumber() {
		return regNumber;
	}

	public Student setRegNumber(String regNumber) {
		this.regNumber = regNumber;
		return this;
	}

	public Program getCurProgram() {
		return curProgram;
	}

	public Student setCurProgram(Program curProgram) {
		this.curProgram = curProgram;
		return this;
	}

	public Program getPrevProgram() {
		return prevProgram;
	}

	public Student setPrevProgram(Program prevProgram) {
		this.prevProgram = prevProgram;
		return this;
	}
}
