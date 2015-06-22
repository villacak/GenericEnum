package com.kv.genericenum.enums;


public enum FirstEnum {
	
	ONE("one"),
	TWO("two"),
	THREE("THREE");
	
	private String test;
	
	private FirstEnum(String test) {
		this.test = test;
	}
	
	public String getTest() {
		return test;
	}
	
//	public MyEnum getEnumFromStringValue(String value) {
//		
//	}

}
