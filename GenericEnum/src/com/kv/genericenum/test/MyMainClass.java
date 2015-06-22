package com.kv.genericenum.test;

import com.kv.genericenum.GenericEnum;
import com.kv.genericenum.enums.FirstEnum;
import com.kv.genericenum.enums.SecondEnum;
import com.kv.genericenum.enums.ThirdEnum;

public class MyMainClass {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) throws Exception {

		// Now it's just get the key from the value
		GenericEnum gEnum = new GenericEnum(FirstEnum.class, "two");
		FirstEnum tt = (FirstEnum) gEnum.getKeyByValue();
		System.out.println("Enum Name is :" + tt.toString());

		gEnum = new GenericEnum(SecondEnum.class, "fName");
		SecondEnum sc = (SecondEnum) gEnum.getKeyByValue();
		System.out.println("Enum Name is :" + sc.toString());
		
		
		// If your Enum doesn't have a parameter then you can check is without worry about letter case.
		gEnum = new GenericEnum(ThirdEnum.class, "THIRD_ONE");
		ThirdEnum te = (ThirdEnum) gEnum.getKeyByValue();
		System.out.println("Enum Name is :" + te.toString());	
		
		gEnum = new GenericEnum(ThirdEnum.class, "third_one");
		te = (ThirdEnum) gEnum.getKeyByValue();
		System.out.println("Enum Name is :" + te.toString());	

	}
}
