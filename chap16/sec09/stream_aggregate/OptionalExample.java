package sec09.stream_aggregate;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;


public class OptionalExample {
	
	
	public static void main(String[] args) {
		//--------------------------------------//
		// 1. Integer 객체를 요소로 가지는 리스트 생성
		//--------------------------------------//
		List<Integer> list = new ArrayList<>();

		//--------------------------------------//
		// 2. Integer 객체를 요소로 가지는 리스트 생성
		//--------------------------------------//
		// 리스트에 요소가 하나도 없는 상태에서, 스트림
		// 파이프라인 구동되면, 어떻게 될까???? (*중요*)
		// 예외 발생(java.util.NoSuchElementException)
/*		double avg = 
			list.
				stream().
				mapToInt(Integer :: intValue).
				average().	
				getAsDouble();*/
		
//		System.exit(0);

		//--------------------------------------//
		// 3. 위 2의 문제를 해결하는 방법 #1
		//--------------------------------------//
		// 스트림파이프라인의 최종처리결과를 값-기반 객체
		// (즉, OptionalXXX 객체)로 받음.
		// 이 값-기반 객체의 메소드를 이용하여, 다양한 경우에
		// 대응
/*		OptionalDouble optional = 
			list.
				stream().
				mapToInt(
//						Integer :: intValue
						
						Integer::intValue
				).
				average();
		
		// 3-1. 최종처리결과가 있습니까??
		if(optional.isPresent()) {
			System.out.println(
				"방법1_평균: " + 
				optional.getAsDouble()
			);
		} else {
			System.out.println("방법1_평균: 0.0");
		} // if-else
		System.exit(0);*/
		
		//--------------------------------------//
		// 4. 위 2의 문제를 해결하는 방법 #2
		//--------------------------------------//
		// 스트림파이프라인의 최종처리결과를 값-기반 객체
		// (즉, OptionalXXX 객체)로 받음.
		// 이 값-기반 객체의 메소드를 이용하여, 다양한 경우에
		// 대응
/*		double avg2 = 
			list.
				stream().
				mapToInt(Integer :: intValue).
				average().
				orElse(100); // 최종처리값이 없으면, 
							 // 지정된 기본값 반환
		
		System.out.println("방법2_평균: " + avg2);
		System.exit(0);*/
		
		//--------------------------------------//
		// 5. 위 2의 문제를 해결하는 방법 #3
		//--------------------------------------//
		// 스트림파이프라인의 최종처리결과를 값-기반 객체
		// (즉, OptionalXXX 객체)로 받음.
		// 이 값-기반 객체의 메소드를 이용하여, 다양한 경우에
		// 대응
		list.add(1);
		
		list.
			stream().
			mapToInt(Integer :: intValue).
			average().
			ifPresent(
				a -> System.out.println(
						"방법3_평균: " + a
					)
			);
		
	} // main
	
} // end class
