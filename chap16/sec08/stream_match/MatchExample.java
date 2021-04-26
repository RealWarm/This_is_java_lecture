package sec08.stream_match;

import java.util.Arrays;


public class MatchExample {
	
	
	public static void main(String[] args) {
		//-----------------------------------//
		// 1. int[] 배열 생성
		//-----------------------------------//
		int[] intArr = { 2, 4 ,6 };

		
		//-----------------------------------//
		// 2. int[] 배열로부터, 순차처리스트림을
		//    얻어내어, 스트림 파이프라인 구성
		//-----------------------------------//
		boolean result = 
			Arrays.
				stream(intArr).	// 2-1. 순차처리스트림얻기
				// 중간처리가 없음!!!!
				// 2-2. 최종처리: All 매칭(2의배수인가???)
				allMatch(a -> a%2==0);
		
		System.out.println("모두 2의 배수인가? " + result);

		
		//-----------------------------------//
		// 3. int[] 배열로부터, 순차처리스트림을
		//    얻어내어, 스트림 파이프라인 구성
		//-----------------------------------//
		result = 
			Arrays.
				stream(intArr).// 3-1. 순차처리스트림얻기
				// 중간처리가 없음!!!!
				// 3-2. 최종처리: Any 매칭(3의배수인가???)
				anyMatch(a -> a%3==0);
		
		System.out.println(
			"하나라도 3의 배수가 있는가? " + result);

		
		//-----------------------------------//
		// 4. int[] 배열로부터, 순차처리스트림을
		//    얻어내어, 스트림 파이프라인 구성
		//-----------------------------------//
		result = 
			Arrays.
				stream(intArr).// 3-1. 순차처리스트림얻기
				// 중간처리가 없음!!!!
				// 3-2. 최종처리: Any 매칭(3의배수인가???)
				noneMatch(a -> a%3==0);
		
		System.out.println(
				"3의 배수가 없는가?  " + result);
		
	} // main
	
} // end class
