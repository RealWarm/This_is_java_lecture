package sec05.stream_mapping;

import java.util.Arrays;
import java.util.stream.IntStream;


public class AsDoubleStreamAndBoxedExample {
	
	
	public static void main(String[] args) {
		//----------------------------------------------//
		// 1. 정수를 요소로 가지는 배열 객체 생성
		//----------------------------------------------//
		// 값이 목록으로, 배열리터럴 객체 생성
		int[] intArray = { 1, 2, 3, 4, 5};

		
		//----------------------------------------------//
		// 2. 스트림 파이프라인 구성 #1
		//----------------------------------------------//
		// 2-1. 배열객체로부터, 스트림 얻어내기
		IntStream intStream = Arrays.stream(intArray);
		
		// 2-2. 스트림 파이프라인 구성
		intStream.
			asDoubleStream(). // 중간처리:double타입으로 변환
			// 최종처리: 모든 요소 순회 및 람다식 적용(콘솔출력)
			forEach( d -> System.out.println(d) );
			
		System.out.println();

		//----------------------------------------------//
		// 3. 스트림 파이프라인 구성 #2
		//----------------------------------------------//
		// 3-1. 정수배열객체로부터 스트림 얻어내기
		intStream = Arrays.stream(intArray);
		
		// 3-2. 스트림 파이프라인 구성
		intStream
			.boxed()	// 중간처리: Auto-Boxing 수행
			// 최종처리: 모든 요소 순회 및 람다식 적용(콘솔출력)
			.forEach(
				// 아래의 람다식은, 메소드 참조로변환불가
				// 왜? 매개변수의 가공이 포함되어잇음
				obj -> System.out.println( obj.intValue() )
			);
	} // main
	
} // end class
