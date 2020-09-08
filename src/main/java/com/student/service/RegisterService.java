package com.student.service;

import static com.student.util.Constants.INPUT_FILE;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;
import org.springframework.core.io.ClassPathResource;

import com.student.factory.StudentFactory;
import com.student.model.MSCStudent;
import com.student.model.PHDStudent;
import com.student.model.Program;
import com.student.model.Student;
import com.student.model.University;
import com.student.util.DegreeType;

public class RegisterService {

	private static Logger LOGGER =  Logger.getLogger(RegisterService.class);
	private static final String CONFIG_FILE = "student.properties";
	
	private String inputFileName;
	
	public RegisterService() {
		LOGGER.info("Register service initiated");
		loadConfigFile();
	}
	
	public List<Student> registerStudents() {
		
		try {
			LOGGER.info("Start registering student");
		    File file = new ClassPathResource(inputFileName).getFile();//new File(inputFileName);
		    
			
		    JAXBContext jaxbContext = JAXBContext.newInstance(University.class);
		    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
		    University university = (University) jaxbUnmarshaller.unmarshal(file);
		    LOGGER.info("Student registered - " + university.getStudents().size());
		    return university.getStudents();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		catch (JAXBException e) {
			LOGGER.error("Error in creating input XML file - " + e.getMessage());
			e.printStackTrace();
		}
		
		return Collections.emptyList();
	}
	
	public List<Student> getStudents(List<Student> students, DegreeType dType) {
		
		//TODO the solution is commented. Please remove the solution before test
		
		List<Student> studentList = new ArrayList<Student>();
		students.stream().forEach(s -> {
			Student student = StudentFactory.getStudent(s);
			if(dType == DegreeType.MSC && student instanceof MSCStudent) {
				studentList.add((MSCStudent) student);
			}
			else if(dType == DegreeType.PHD && student instanceof PHDStudent) {
				studentList.add((PHDStudent) student);
			}
		});
		
		return studentList;
		
		//return null;
	}
	
	public List<Student> getPHDStudentsFromDifferentSubject(List<Student> students) {
		
		//TODO the solution is commented. Please remove the solution before test
		
		List<Student> studentList = new ArrayList<Student>();
		
		students.stream().forEach(stud -> {
			Program prevProg = stud.getPrevProgram(); 
			Program currProg = stud.getCurProgram();
			
			if(!prevProg.getSubject().equalsIgnoreCase(currProg.getSubject())) {
				studentList.add(stud);
			}
		});
		
		return studentList;
		
		//return null;
	}
	
	private void loadConfigFile() {
		
		try (InputStream input = this.getClass().getClassLoader().getResourceAsStream(CONFIG_FILE)) {

            Properties prop = new Properties();
            prop.load(input);
            
            inputFileName = prop.getProperty(INPUT_FILE);
        } 
		catch (IOException ex) {
            ex.printStackTrace();
        }
	}
}
