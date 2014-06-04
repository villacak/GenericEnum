public class MyMainClass {

	public static void main(String[] args) throws Exception {

		// Now it's just get the key from the value
		GenericEnum gEnum = new GenericEnum(MyEnum.class, "two");
		MyEnum tt = (MyEnum) gEnum.getKeyByValue();
		System.out.println("Enum Name is :" + tt.toString());

		gEnum = new GenericEnum(SecondEnumTest.class, "fName");
		SecondEnumTest sc = (SecondEnumTest) gEnum.getKeyByValue();
		System.out.println("Enum Name is :" + sc.toString());

	}
}
