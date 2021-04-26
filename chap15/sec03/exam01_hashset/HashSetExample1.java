package sec03.exam01_hashset;

import java.util.*;


public class HashSetExample1 {
	
	
	// -- Set 컬렉션의 대전제:
	//    1) 순서를 보장하지 않음(구슬주머니)
	//    2) 중복을 허용하지 않음(수학의 집합특성)
	public static void main(String[] args) {
		// 요소(구슬)의 타입이 문자열인 Set 컬렉션
		// 자료구조 생성
		Set<String> set = new HashSet<>();
		
		//---------------------------------//
		
		// 요소 추가
		set.add("Java");			// 중복단어
		set.add("JDBC");
		set.add("Servlet/JSP");
		set.add("Java");			// 중복단어
		set.add("iBATIS");
		
		System.out.println("- set: "+ set);
//		System.exit(0);
		
		//---------------------------------//
		
		// 요소 개수
		int size = set.size();
		System.out.println("총 객체수: " + size);
		
		//---------------------------------//		
		// 반복자(Iterator)를 통한 , 모든 구슬 객체의
		// 순회(Traverse)
		Iterator<String> iterator = set.iterator();
		
		// hasNext(): 순회할 구슬이 아직도 남아있습니까?
		while(iterator.hasNext()) { 
			// next() : 남아있으면 주세요!!!(획득)
			String element = iterator.next();
			
			System.out.println("\t" + element);
		} // while
		
		//---------------------------------//
		// Set 컬렉션에서, 요소 삭제
		//---------------------------------//
		set.remove("JDBC");
		set.remove("iBATIS");
		
		System.out.println("총 객체수: " + set.size());
		
		for(String element : set) {
			System.out.println("\t" + element);
		} // enhanced for

		//---------------------------------//
		// Set 자료구조의 모든 요소 삭제
		//---------------------------------//
		set.clear();		
		
		if(set.isEmpty()) { 
			System.out.println("비어 있음"); 
		} // if
		
		set = null;		// 매우 중요 ******!!!!
		
	} // main
	
} // end class

