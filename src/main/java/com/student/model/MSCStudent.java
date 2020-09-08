package com.student.model;

import java.util.function.Consumer;

public class MSCStudent extends Student {

	public static MSCStudent build(Consumer<MSCStudent> stud) {
		MSCStudent mStud = new MSCStudent();
		stud.accept(mStud);
		return mStud;
	}
}
