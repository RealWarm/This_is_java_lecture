package sec01.stream_introduction;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


public class LambdaExpressionsExample {
	
	
	public static void main(String[] args) {		
		//----------------------------------------------//
		// 1. 학생(Student)을 요소로 가지는 리스트 객체 생성
		//----------------------------------------------//
		List<Student> list = Arrays.asList(
				new Student("홍길동", 90),	// 요소1
				new Student("신용권", 92)	// 요소2
		); // 리스트 객체 생성

		//----------------------------------------------//
		// 2. 내부반복자(Stream)를 이용하여, 모든 학생의 이름과
		//    성적을 콘솔로 출력하는 예제
		//----------------------------------------------//
		Stream<Student> stream = 
				list.stream();		// Stream객체 얻기
		
		// 최종처리 메소드인 forEach()를 이용하여
		// 모든 요소를 Traverse(순회)하면서, 개발자가 떤져준!!
		// 람다식을 적용합니다.
		stream.forEach(
			
			s -> {
					String name = s.getName();	// 학생이름
					int score = s.getScore();	// 학생성적
					
					System.out.println(name + "-" + score);
			} // Lambda Expression : 처리할 Task
			
		); // forEach
		
	} // main
	
} // end class
