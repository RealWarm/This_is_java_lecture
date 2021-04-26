package sec05.stream_mapping;

import java.util.Arrays;
import java.util.List;

public class FlatMapExample {
	
	
	public static void main(String[] args) {
		//----------------------------------------------//
		// 1. 문자열을 요소로 가지는 리스트 객체 생성
		//----------------------------------------------//
		List<String> inputList1 = 
			Arrays.asList(
				"java8 lambda", 
				"stream mapping"
			);

		//----------------------------------------------//
		// 2. 생성된 리스트로부터 순차처리스트림 얻어내기
		//    바로 이어서, 스트림 파이프라인을 구성
		//----------------------------------------------//
		// 각 문자열을 공백문자로 쪼개서, 구성 단어들을 요소로 가지는
		// 새로운 스트림 객체를 생성하고, 그 다음, 콘솔로, mapping
		// 된 새로운 요소들을 모두 콘솔로 출력하는 파이프라인 구성
		inputList1.
			stream().	// 2-1. 순차처리 스트림 얻어내기
			flatMap(    // 2-2. 중간처리: flat map 적용
				data -> Arrays.stream( data.split(" ") )
			).			// 2-3. 최종처리: 모든 요소를 콘솔출력
			forEach( word -> System.out.println(word) );
		
		System.out.println();
//		System.exit(0);


		//----------------------------------------------//
		// 3. 문자열을 요소로 가지는 리스트#2 객체 생성
		//----------------------------------------------//		
		List<String> inputList2 = 
			Arrays.asList(
				"10, 20, 30", 
				"40, 50, 60"
			);

		//----------------------------------------------//
		// 4. 생성된 리스트#2 로부터 순차처리스트림 얻어내기
		//    바로 이어서, 스트림 파이프라인을 구성
		//----------------------------------------------//
		// 각 문자열을 ',' 문자로 쪼개서, 구성 단어들을 
		// 요소로 가지는 새로운 스트림 객체를 생성(flatMap)하고, 
		// 그 다음, 콘솔로, mapping 된 새로운 요소들을 
		// 모두 콘솔로 출력하는 파이프라인 구성
		inputList2.
			stream().
			flatMapToInt(
				data -> {
					// ',' 문자를 구분자로 해서 문자열 쪼개기
					String[] strArr = data.split(",");
					
					// 쪼개진 문자열을 요소로 가지는 배열의 크기
					// 만큼, 새로운 타입(int)의 배열을 생성
					int[] intArr = new int[strArr.length];
					
					// 새로이 생성한 int 배열의 각 원소에,
					// flat map 된 요소를 int로 바꾸어 저장
					for(int i=0; i<strArr.length; i++) {
						intArr[i] = //새로운 배열의 원소로 저장
							// 숫자형태의 문자열을, 정수(int)
							// 로 변환시킴
							Integer.
								parseInt(strArr[i].trim());
					} // for
					
					// Function 함수적 인터페이스 정의에 따라,
					// 최종 int[] 배열 --> 스트림 객체로 변환
					// 하여 반환
					return Arrays.stream(intArr);
				} // 람다식
			).
			// 최종처리: int로 변환된 각 요소의 값을 콘솔로 출력
			forEach(
//				number -> System.out.println(number)
				System.out::println	// 메소드 참조로 생략가능
			);
		
	} // main
	
} // end class