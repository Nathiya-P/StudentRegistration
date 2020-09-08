package com.student.model;

import java.util.function.Consumer;

public class PHDStudent extends Student {

	public static PHDStudent build(Consumer<PHDStudent> stud) {
		PHDStudent pStud = new PHDStudent();
		stud.accept(pStud);
		return pStud;
	}
}
