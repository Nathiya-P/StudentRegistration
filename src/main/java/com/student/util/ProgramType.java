package com.student.util;

import java.util.Arrays;
import java.util.Optional;

public enum ProgramType {

	GRADUATE("Graduate"),
	UNDERGRADUATE("Undergraduate");
	
	private String type;
	
	public String getType() {
		return type;
	}
	
	ProgramType(String type) {
		this.type = type;
	}
	
	public static ProgramType getProgramType(String type) {
		
		Optional<ProgramType> pt = Arrays.asList(values()).stream()
										.filter(ty -> ty.getType().equalsIgnoreCase(type))
										.findAny();
		
		if(pt != null) {
			return pt.get();
		}
		
		return null;
	}
}
