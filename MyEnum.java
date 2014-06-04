
public enum MyEnum {
	
	ONE("one"),
	TWO("two"),
	THREE("THREE");
	
	private String test;
	
	private MyEnum(String test) {
		this.test = test;
	}
	
	public String getTest() {
		return test;
	}
	
//	public MyEnum getEnumFromStringValue(String value) {
//		
//	}

}
