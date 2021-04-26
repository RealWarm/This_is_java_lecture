package sec05.stream_mapping;

import java.util.Arrays;
import java.util.List;


public class MapExample {
	
	public static void main(String[] args) {
		//----------------------------------------------//
		// 1. Student 객체를 요소로 가지는 리스트 객체 생성
		//----------------------------------------------//
		List<Student> studentList =
			// 리스트의 요소로, Student 타입의 객체를 가짐
			Arrays.asList(
				new Student("홍길동", 10),	// Student #1
				new Student("신용권", 20),	// Student #2
				new Student("유미선", 30)	// Student #3
			); // 리스트 객체 생성

		//----------------------------------------------//
		// 2. 위에서 생성한 리스트로부터, Stream(내부반복자)
		//    을 얻어내어, 스트림 파이프라인 구성
		//----------------------------------------------//
		studentList.
			stream().	// 2-1. 스트림 얻어내기
			// 2-2. 중간처리: mapping
			mapToInt(
//					Student :: getScore
					Student::getScore
			). 
			forEach(	// 2-3. 최종처리: 변환된 요소의 콘솔출력
//				score -> System.out.println(score)
				System.out::println // 메소드 참조로 대체
			);
	} // main
	
} // end class
