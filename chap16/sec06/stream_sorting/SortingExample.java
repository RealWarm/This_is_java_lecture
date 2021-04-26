package sec06.stream_sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;


public class SortingExample {
	
	
	public static void main(String[] args) {
		//-----------------------------------//
		// 1. int[] 배열로부터 스트림 얻어내기
		//-----------------------------------//
		//숫자 요소일 경우
		IntStream intStream = 
			Arrays.stream(
				new int[] {5, 3, 2, 1, 4}
			);

		//-----------------------------------//
		// 2. 스트림 파이프라인 구성
		//-----------------------------------//
		// 스트림의 요소를 정렬시키고자 함.
//		intStream.
//			sorted().	// 2-1. 중간처리: 객체 정렬(오름차순)
//			forEach(	// 2-2. 최종처리: 정렬된 숫자출력
//				// 람다식의 매개변수가 단순전달되지
//				// 않고 있으므로, 메소드 참조 변환 불가
//				n -> System.out.print(n + " ")
//			); // 스트림 파이프라인 구성
//		
//		System.out.println();

		//-----------------------------------//
		// 3. Student 객체를 요소로 가지는 리스트로부터
		//    스트림 얻어내기
		//-----------------------------------//
		List<Student> studentList = 
			Arrays.asList(
				new Student("홍길동", 30), // 학생#1
				new Student("신용권", 10), // 학생#2
				new Student("유미선", 20)  // 학생#3
			); // 리스트 생성

		//-----------------------------------//
		// 4. 스트림 파이프라인 #2 구성
		//-----------------------------------//
		// 스트림의 요소가 객체일 경우, 정렬시키고자 함.
/*		studentList.
			stream().	// 4-1. 순차처리 스트림 얻어내기
			sorted().	// 4-2. 중간처리: 객체정렬 수행
			forEach(	// 4-3. 최종처리: 정렬된 학생성적출력
				// 람다식의 매개변수가 호출메소드에 
				// 단순전달되지 않고 있으므로,
				// 메소드 참조로 변환 불가
				s -> System.out.print(
						s.getScore() + ","
					 )
			); // 스트림 파이프라인 구성
		
		System.out.println();
		System.exit(0);*/
		
		//-----------------------------------//
		// 5. 스트림 파이프라인 #3 구성
		//-----------------------------------//
		studentList.
			stream().	// 5-1. 순차처리스트림 얻기
			// 5-2. 중간처리: 정렬순서를 반대로 해서 정렬
			sorted( Comparator.reverseOrder() ).
			forEach(	// 5-3. 최종처리: 정렬된 요소출력
				// 람다식의 매개변수가 호출메소드에 
				// 단순전달되지 않고 있으므로,
				// 메소드 참조로 변환 불가
				s -> System.out.print(
						s.getScore() + ","
					)
			); // 스트림 파이프라인 구성
		
	} // main
	
} // end class
