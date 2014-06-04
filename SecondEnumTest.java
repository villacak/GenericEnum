
public enum SecondEnumTest {
	FIRST_NAME("fName"),
	LAST_NAME("lName");
	
	private String partName;
	
	private SecondEnumTest(String partName) {
		this.partName = partName;
	}
	
	public String getCode() {
		return partName;
	}

}
