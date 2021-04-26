package sec02.exam03_linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class LinkedListExample {
	
	
	// List 컬렉션 대전제:
	//	1) 순서 유지
	//	2) 중복 저장 허용
	public static void main(String[] args) {
		
		// ArrayList:
		//	빈번한 수정/삭제/삽입에는 성능상 단점
		//  연접한 메모리 구조덕에, 검색성능은 좋다!!!
		List<String> list1 = new ArrayList<>();
		
		// LinkedList:
		//  빈번한 수정/삭제/삽입에는 성능상 장점
		//  흩어진 형태의 요소저장구조로 인하여, 검색성능에는
		//  단점을 가진다!!!!
		List<String> list2 = new LinkedList<>();
		
		
		//--------------------------------------//
		// ArrayList와 LinkedList의 성능측정 및 비교
		//--------------------------------------//
		long startTime;
		long endTime;
		
		//--------------------------------------//
		// 1. ArrayList 성능측정
		//--------------------------------------//
		
		startTime = System.nanoTime();
		
			for(int i=0; i< 10000; i++) {
				// String.valueOf(value) - 자주 사용(***)
				// 정적 메소드는, 매개값을 문자열로 변환시켜
				// 주는 메소드입니다.
				
				list1.add(0, String.valueOf(i));
				
				// ArrayList의 맨 처음에 새로운 문자열 요소를
				// 추가하는 코드
			} // for
		
		endTime = System.nanoTime();
		
		System.out.println(
			"ArrayList 걸린시간: " + 
			(endTime-startTime) + " ns");
		
		//--------------------------------------//
		// 2. LinkedList 성능측정
		//--------------------------------------//
		
		startTime = System.nanoTime();
		
			for(int i=0; i < 10000; i++) {
				list2.add(0, String.valueOf(i));
				
				// LinkedList의 맨 처음에 
				// 새로운 문자열 요소를 추가하는 코드
			} // for
			
		endTime = System.nanoTime();
		
		System.out.println(
			"LinkedList 걸린시간: " + 
			(endTime-startTime) + " ns");
		
		
		String str1 = "Yoseph";
		String str2 = new String("Yoseph");
		
		
		Object o1 = new Object();
		Object o2 = new Object();
		
		if(o1 == o2) {
			
		} // if 1
		
		if(o1.equals(o2)) {
			
		} // if 2
		
	} // main
	
} // end class



