package sec03.exam01_hashset;

import java.util.*;


public class HashSetExample2 {
	
	
	public static void main(String[] args) {
		Set<Member> set = new HashSet<>();
		
		set.add(new Member("ȫ�浿", 30));
		set.add(new Member("ȫ�浿", 30));

		System.out.println("- set: "+ set);
		System.out.println("�� ��ü�� : " + set.size());
	} // main
	
} // end class

