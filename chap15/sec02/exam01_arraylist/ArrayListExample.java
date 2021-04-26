package sec02.exam01_arraylist;

import java.util.*;


public class ArrayListExample {
	
	
	// List 타입의 컬렉션:
	//    1) 순서를 유지
	//    2) 중복을 허용
	public static void main(String[] args) {
		// List 인터페이스를 구현하는 ArrayList 자료구조 생성
		// 요소의 타입은, 구체타입으로 String 지정
		List<String> list = new ArrayList<String>();
		
		//---------------------------------//
		// 자료구조에 요소(객체, 데이터) 추가
		//---------------------------------//
		list.add("Java");
		list.add("JDBC");
		list.add("Servlet/JSP");
		list.add(2, "Database");	// index 지정
		list.add("iBATIS");
		
		System.out.println("- list:\n"+list);
//		System.exit(0);
		
		//---------------------------------//
		// 자료구조의 다양한 사용법(List 인터페이스에 정의된
		// 규격(= 객체사용설명서)에 따라 사용)
		//---------------------------------//
		int size = list.size();
		
		System.out.println("총 객체수: " + size);		
		System.out.println();

		//---------------------------------//
		
		String skill = list.get(2);
		
		System.out.println("2: " + skill);
		System.out.println();

		//---------------------------------//

		for(int i=0; i<list.size(); i++) {
			String str = list.get(i);
			System.out.println(i + ":" + str);
		} // for
		
		for(String element : list) {
			System.out.println(element);
		} // enhanced for
		
		System.out.println();

		//---------------------------------//				
		list.remove(2);
		list.remove(2);
		list.remove("iBATIS");		
		
		for(int i=0; i<list.size(); i++) {
			String str = list.get(i);
			System.out.println(i + ":" + str);
		} // for
		
//		System.exit(0);

		//---------------------------------//
		// 사용한 자원반납 (가비지 컬렉션)
		//---------------------------------//
		if(list != null && list.size() > 0) {
			list.clear();
			
			list = null;	// 매우 중요!!!!
		} // if
		
	} // main
	
} // end class

