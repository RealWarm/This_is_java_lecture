package sec02.exam01_arraylist;

import java.util.Arrays;
import java.util.List;


public class ArraysAsListExample {
	
	
	public static void main(String[] args) {
		List<String> list1 = 
				Arrays.asList(
					"홍길동", 
					"신용권", 
					"감자바"); 
		
		
		
		// enhanced for 문을 사용하려면, 객체가
		// Iterable 인터페이스를 구현하고 있어야 함
		for(String name: list1) {
			System.out.println(name);
		} // enhanced for
		
		//-------------------------------//
		List<Integer> list2 = 
				Arrays.asList(1,2,3);
		
		for(int value : list2) {
			System.out.println(value);
		} // enhanced for
	} // main
	
} // end class
