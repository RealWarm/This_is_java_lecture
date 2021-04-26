package sec01.stream_introduction;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;


// 외부반복자인 Iterator 객체의 활용과
// 내부반복자인 Stream 객체의 활용 비교
public class IteratorVsStreamExample {
	
	
	public static void main(String[] args) {
		List<String> list = 
			Arrays.asList("홍길동", "신용권", "감자바");
				
		//-----------------------------------------//
		// 1. 외부반복자를 활용한 리스트 요소의 사용
		//-----------------------------------------//		
		Iterator<String> iterator = list.iterator();
		
		while(iterator.hasNext()) {	// 그 다음 요소가 있나요?
			String name = iterator.next(); // 그럼 주세요!
			
			System.out.println(name); // 요소값 출력
		} // while
		
		System.out.println();

		//-----------------------------------------//
		// 2. 내부반복자를 활용한 리스트 요소의 사용
		//-----------------------------------------//
		Stream<String> stream = 
				list.stream(); // 스트림 얻기
		
		// 람다식으로 각 요소에 처리해야 할 처리코드(즉, Task)를
		// 던짐!! (여기서 Task는 각 요소값을 콘솔에 출력
		// Stream.forEach() 메소드 ---> 최종처리 메소드임!!!
		stream.forEach( 
//			name -> System.out.println(name) 
			System.out::println	// 메소드 참조!!!!
		);
	} // main
	
} // end class
