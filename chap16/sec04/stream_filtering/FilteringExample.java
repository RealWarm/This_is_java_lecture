package sec04.stream_filtering;

import java.util.Arrays;
import java.util.List;


public class FilteringExample {
	
	
	public static void main(String[] args) {
		//----------------------------------------------//
		// 1. 이름을 요소로 가지는 리스트 객체 생성
		//----------------------------------------------//
		List<String> names = 
			Arrays.asList(
				"홍길동", 
				"신용권", 
				"감자바", 
				"신용권", 
				"신민철"
			);

		//----------------------------------------------//
		// 2. 이름 리스트로부터 스트림 얻어내기를 시작으로,
		//    스트림 파이프라인(즉, 중간처리 + 최종처리 등의 
		//    결합 by using Method Chaining)
		//----------------------------------------------//
		names.				// 스트림 파이프라인 구성
			stream()		// 2-1. 스트림 얻기
			.distinct()		// 2-2. 중간처리: 고유한 이름만필터
			.forEach(		// 2-3. 최종처리: 이름을 콘솔출력
//				n -> System.out.println(n)
				System.out::println	// 메소드 참조
			);
		
		System.out.println();

		//----------------------------------------------//
		// 3. 이름 리스트로부터 스트림 얻어내기를 시작으로,
		//    스트림 파이프라인(즉, 중간처리 + 최종처리 등의 
		//    결합 by using Method Chaining)
		//----------------------------------------------//
		names.			// 스트림 파이프라인 구성
			stream().	// 3-1. 이름 리스트에서 스트림 얻어내기
			filter(		// 3-2. 중간처리: 필터링(조건) 수행
						//      '신'으로 시작하는 이름만 추출
				n -> n.startsWith("신")
			).
			forEach(	// 3-3. 최종처리: 필터링된 이름콘솔출력
//				n -> System.out.println(n)
				System.out::println	// 메소드참조
			);
		
		System.out.println();


		//----------------------------------------------//
		// 4. 이름 리스트로부터 스트림 얻어내기를 시작으로,
		//    스트림 파이프라인(즉, 중간처리 + 최종처리 등의 
		//    결합 by using Method Chaining)
		//----------------------------------------------//
		names.			// 스트림 파이프라인 구성
			stream().	// 3-1. 이름 리스트에서 스트림 얻어내기
			distinct().	// 3-2. 중간처리: 고유한 이름만 추출
			filter(		//      '신'으로 시작하는 이름만 추출
					n -> n.startsWith("신")
					
					// 아래의 메소드 참조가 불가능한 이유는,
					// 람다식의 매개변수가 가지고 있는 메소드를
					// 단순호출하되, 이 메소드가 매개변수가 없는
					// 메소드 일 때만, 메소드 참조 변환이 가능함!
//					String::startsWith
			).
			forEach(	// 3-3. 최종처리: 필터링된 이름콘솔출력
	//				n -> System.out.println(n)
					System.out::println	// 메소드 참조
			);	
	
	} // main
	
} // end class
