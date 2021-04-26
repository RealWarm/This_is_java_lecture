package sec01.stream_introduction;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


public class ParallelExample {
	
	
	public static void main(String[] args) {
		//----------------------------------------------//
		// 1. 학생(Student)을 요소로 가지는 리스트 객체 생성
		//----------------------------------------------//
		List<String> list = 
			Arrays.asList(
				"홍길동", 
				"신용권", 
				"감자바", 
				"람다식", 
				"박병렬"
			); // 이름 리스트  생성

		//----------------------------------------------//
		// 2. 순차처리 방식으로, 모든 이름에 대해서 가공처리수행
		//----------------------------------------------//
		// 2-1. 리스트로부터, 순차처리 스트림 얻어내기
		Stream<String> stream = list.stream();
		// 2-2. 얻어낸 순차처리스트림의 최종처리메소드 수행
		//      ParallelExample 클래스의 print() 메소드 수행
		//      을 Task(즉, 람다식으로 생성)로 전달
		stream.forEach(ParallelExample :: print);
		
		System.out.println();

		//----------------------------------------------//
		// 3. 병렬처리 방식으로, 모든 이름에 대해서 가공처리수행
		//----------------------------------------------//
		// 3-1. 리스트에서 병렬처리스트림 얻어내기
		Stream<String> parallelStream = 
					list.parallelStream();
		
		// 3-2. 병렬처리스트림의 최종처리메소드인 forEach()
		//      메소드를 통해, 전체요소를 병렬로 순회(traverse)
		//      하면서, 람다식(메소드참조)으로 수행할 task 
		//      생성 및 던짐!!!
		parallelStream.forEach(ParallelExample :: print);
	} // main
	
	// 다른 메소드(이 메소드를 위에서 호출함): ****정적메소드 ***
	public static void print(String name) {
		System.out.println(
			name+ " : " + 
			Thread.currentThread().getName()
		); // 현재의 코드를 수행시키는 스레드의 이름을 얻어 출력
	} // print
	
} // end class




