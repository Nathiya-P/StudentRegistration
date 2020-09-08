package com.student.factory;

import org.apache.log4j.Logger;

import com.student.model.MSCStudent;
import com.student.model.PHDStudent;
import com.student.model.Program;
import com.student.model.Student;
import com.student.util.ProgramType;

/*
 * Student coming from undergraduate program of same subject can apply for PHD if he/she has grade more than A- (including) 
 * Student coming from graduate program of same subject can apply for PHD if he/she has grade more than B+ (including) 
 * Student coming from graduate program of different subject can apply for PHD if he/she has grade more than A (including)
 * Chemistry does not have MSc degree
 * 
 */
public class StudentFactory {

	private static Logger LOGGER =  Logger.getLogger(StudentFactory.class);
	
	public static Student getStudent(Student student) {
		
		//TODO the solution is commented. Please remove the solution before test
		
		Program prevProg = student.getPrevProgram();
		Program curProg = student.getCurProgram();
		
		ProgramType preProgType = ProgramType.getProgramType(prevProg.getProgram());
		ProgramType currProgType = ProgramType.getProgramType(curProg.getProgram());
		
		if(preProgType == currProgType) {
			if(prevProg.getSubject().equalsIgnoreCase(curProg.getSubject()) ) {
				if(hasGradeMoreThanB(prevProg.getGrade())) {
					return getPHDStudent(student); 
				}
			}
			else {
				if(hasGradeMoreThanAMinus(prevProg.getGrade())) {
					return getPHDStudent(student); 
				}
			}
		}
		else {
			
			if(prevProg.getSubject().equalsIgnoreCase(curProg.getSubject()) ) {
				if(hasGradeMoreThanBPlus(prevProg.getGrade())) {
					return getPHDStudent(student); 
				}
				else {
					if(!prevProg.getSubject().equalsIgnoreCase("Chemistry")) {
						return getMSCStudent(student); 
					}
				}
			}
		}
		return student;		
		//return null;
	}
	
	private static boolean hasGradeMoreThanAMinus(String grade) {
		
		if(grade.equalsIgnoreCase("A+") || grade.equalsIgnoreCase("A")) {
			return true;
		}
		
		return false;
	}

	private static boolean hasGradeMoreThanBPlus(String grade) {
		
		if(hasGradeMoreThanAMinus(grade) || grade.equalsIgnoreCase("A-")) {
			
			return true;
		}
		
		return false;
	}
	
	private static boolean hasGradeMoreThanB(String grade) {
		
		if(grade.equalsIgnoreCase("B+") || hasGradeMoreThanBPlus(grade)) {
			return true;
		}
		
		return false;
	}
 	
	private static Student getMSCStudent(Student student) {
		
		return MSCStudent.build(stud -> stud.setfName(student.getfName())
											.setlName(student.getlName())
											.setRegNumber(student.getRegNumber())
											.setCurProgram(student.getCurProgram())
											.setPrevProgram(student.getPrevProgram()));
	}
	
	private static Student getPHDStudent(Student student) {
		
		return PHDStudent.build(stud -> stud.setfName(student.getfName())
											.setlName(student.getlName())
											.setRegNumber(student.getRegNumber())
											.setCurProgram(student.getCurProgram())
											.setPrevProgram(student.getPrevProgram()));
	}
	
	private static void printStudent(Student student) {
		LOGGER.info("=================================");
		LOGGER.info("NAME - " + student.getfName() + " " + student.getlName());
		LOGGER.info("PREVIOUS PROG INFO. PROG - " + student.getPrevProgram().getProgram() + ", SUBJECT - " 
				+ student.getPrevProgram().getSubject() + ", GRADE - " + student.getPrevProgram().getGrade());
		LOGGER.info("CURRENT PROG INFO. PROG - " + student.getCurProgram().getProgram() + ", SUBJECT - " 
				+ student.getCurProgram().getSubject());
		LOGGER.info("=================================");
	}
}
