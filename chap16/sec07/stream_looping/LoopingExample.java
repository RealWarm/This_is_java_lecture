package sec07.stream_looping;

import java.util.Arrays;


public class LoopingExample {
	
	
	public static void main(String[] args) {
		//-----------------------------------//
		// 1. int[] 배열 생성
		//-----------------------------------//
		int[] intArr = { 1, 2, 3, 4, 5 };

		//-----------------------------------//
		// 2. int[] 배열로부터 스트림을 얻어내어
		//    스트림 파이프라인 생성
		//-----------------------------------//
		System.out.println("[peek()를 마지막에 호출한 경우]");
		
		
		//      **** 동작하지 않음 **** 
		Arrays.
			stream(intArr).	// 2-1. 순차처리스트림 얻기
			filter(a -> a%2==0). // 2-2. 중간처리: 필터링
			peek(	// 2-3. 중간처리: 루핑 수행
//				n -> System.out.println(n)
				System.out::println	// 메소드 참조로대체
			); // 스트림 파이프라인 구성


		//-----------------------------------//
		// 3. int[] 배열로부터 스트림을 얻어내어
		//    스트림 파이프라인#2 생성
		//-----------------------------------//
		System.out.println(
			"[최종 처리 메소드를 마지막에 호출한 경우]");
		
		// 생성한 스트림 파이프라인을 통해, 전체 요소의 값
		// 중에, **짝수** 만을 얻어내어(필터링), 짝수들의
		// 총합(sum)을 구함
		int total = 
			Arrays.
				stream(intArr). // 3-1. 순차처리스트림얻기
				filter(a -> a%2==0). // 3-2. 중간처리: 필터링
				peek( // 3-3. 중간처리: 루핑
//					n -> System.out.println(n)
					System.out::println // 메소드참조대체
				). 
				// 3-4. 최종처리: 집계(총합구하기)
				sum(); // 스트림파이프라인 구성
		
		System.out.println("총합: " + total);

		//-----------------------------------//
		// 4. int[] 배열로부터 스트림을 얻어내어
		//    스트림 파이프라인#3 생성
		//-----------------------------------//
		System.out.println(
			"[forEach()를 마지막에 호출한 경우]");
		
		Arrays.
			stream(intArr).	// 4-1. 순차처리스트림얻기
			filter(a -> a%2==0). // 4-2. 중간처리:필터링
			forEach( // 4-3. 최종처리: 루핑
//				n -> System.out.println(n)
				System.out::println // 메소드참조대체
			); // 스트림 파이프라인 구성
		
	} // main
	
} // end class
