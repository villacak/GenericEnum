package com.kv.genericenum.enums;


public enum SecondEnum {
	FIRST_NAME("fName"),
	LAST_NAME("lName");
	
	private String partName;
	
	private SecondEnum(String partName) {
		this.partName = partName;
	}
	
	public String getCode() {
		return partName;
	}

}
