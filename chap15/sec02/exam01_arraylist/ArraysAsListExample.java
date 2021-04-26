package sec02.exam01_arraylist;

import java.util.Arrays;
import java.util.List;


public class ArraysAsListExample {
	
	
	public static void main(String[] args) {
		List<String> list1 = 
				Arrays.asList(
					"ȫ�浿", 
					"�ſ��", 
					"���ڹ�"); 
		
		
		
		// enhanced for ���� ����Ϸ���, ��ü��
		// Iterable �������̽��� �����ϰ� �־�� ��
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
