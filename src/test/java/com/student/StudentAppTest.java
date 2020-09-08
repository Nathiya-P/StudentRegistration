package com.student;

import static com.student.util.Constants.MSC_STUD_COUNT;
import static com.student.util.Constants.PHD_STUD_COUNT_DIFF_SUB;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.student.model.Student;
import com.student.service.RegisterService;
import com.student.util.DegreeType;

@RunWith(MockitoJUnitRunner.class)
public class StudentAppTest {

	private static Logger LOGGER =  Logger.getLogger(StudentAppTest.class);
	private RegisterService registerService;
	private List<Student> students;
	
	@Before
    public void init() {
		registerService = new RegisterService();
		students = registerService.registerStudents();
    }
	
	@Test
    public void mscStudentTest() {
		
		LOGGER.info("mscStudentTest starts");
		List<Student> studs = registerService.getStudents(students, DegreeType.MSC);
		
		Assert.assertTrue(studs.size() == MSC_STUD_COUNT);
		
		LOGGER.info("mscStudentTest ends");
	}
	
	@Test
    public void phdStudentFromDifferentSubjectTest() {
		
		LOGGER.info("phdStudentTest starts");
		
		List<Student> studs = registerService.getStudents(students, DegreeType.PHD);
		List<Student> students = registerService.getPHDStudentsFromDifferentSubject(studs);
		
		
		Assert.assertTrue(students.size() == PHD_STUD_COUNT_DIFF_SUB);
		
		LOGGER.info("phdStudentTest ends");
	}
}
