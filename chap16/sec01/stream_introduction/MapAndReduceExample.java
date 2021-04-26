package sec01.stream_introduction;

import java.util.Arrays;
import java.util.List;

public class MapAndReduceExample {

	
	public static void main(String[] args) {	
		//----------------------------------------------//
		// 1. 학생(Student)을 요소로 가지는 리스트 객체 생성
		//----------------------------------------------//
		List<Student> studentList = Arrays.asList(
				new Student("홍길동", 10),
				new Student("신용권", 20),
				new Student("유미선", 30)
		); // 학생 리스트 생성
		
		//----------------------------------------------//
		// 2. 학생 리스트로부터 Stream 객체 얻기
		//    더불어서, 메소드 체인(Method Chain) 기법을 이용
		//    하여, 중간처리부터 ~ 최종처리까지 한꺼번에 수행하
		//    는 코드 생성
		//----------------------------------------------//
		double avg = 
				studentList.
					// 2-1. 리스트로부터 스트림 얻어내기
					stream().
					// 2-2. 중간처리(학생 객체 --> 점수로 매핑)
					mapToInt( Student::getScore ).
//					mapToInt(Student :: getScore).
					// 2-3. 최종 처리(집계산출 - 평균 점수)
					average().
					// 2-4. 최종 처리 결과를 Double 기본타입
					//      값으로 얻어내기
					getAsDouble();
		
		// 최종처리결과인 학생의 평균점수를 콘솔에 출력
		System.out.println("평균 점수: " + avg);
	} // main
	
} // end class
