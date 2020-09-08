package com.student;

import java.util.List;

import org.apache.log4j.Logger;

import com.student.model.Student;
import com.student.service.RegisterService;
import com.student.util.DegreeType;

public class StudentApp {

	private static Logger LOGGER =  Logger.getLogger(StudentApp.class);
	
	public static void main(String[] args) {
		
		LOGGER.info("Starting student app");
		
		RegisterService registerService = new RegisterService();
		List<Student> students = registerService.registerStudents();
		
		List<Student> mscStudents = registerService.getStudents(students, DegreeType.MSC);
		
		LOGGER.info("Number of MSc student - " + mscStudents.size());
		
		List<Student> phdStudents = registerService.getStudents(students, DegreeType.PHD);
		LOGGER.info("Number of Phd student - " + phdStudents.size());
		
		phdStudents = registerService.getPHDStudentsFromDifferentSubject(phdStudents);
		LOGGER.info("Number of Phd student - " + phdStudents.size());
		

	}
	
	
}
