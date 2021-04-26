package sec05.exam02_consumer;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.ObjIntConsumer;


public class ConsumerExample {
	
	
	public static void main(String[] args) {		
		//---------------------------//
		// 1. Consumer<T> 사용
		//---------------------------//
		
		// 람다식을 통해, 함수적 인터페이스 구현하는
		// 익명구현객체 생성
		Consumer<String> consumer = 
			t -> System.out.println(t + "8");
			
		consumer.accept("java"); // 추상메소드 호출
		
		//---------------------------//
		// 2. BiConsumer<T,U> 사용
		//---------------------------//
		
		BiConsumer<String, String> bigConsumer = 
			(t, u) -> System.out.println(t + u);
			
		bigConsumer.accept("Java", "8");
		
		//---------------------------//
		// 3. DoubleConsumer 사용
		//---------------------------//
		
		DoubleConsumer doubleConsumer = 
			d -> System.out.println("Java" + d);
			
		doubleConsumer.accept(8.0);
		
		//---------------------------//
		// 4. ObjIntConsumer<T> 사용
		//---------------------------//
		
		ObjIntConsumer<String> objIntConsumer = 
			(t, i) -> System.out.println(t + i);
			
		objIntConsumer.accept("Java", 8);
		
		
		//---------------------------//
		// 5. ObjIntConsumer<T> 를 
		//	   익명구현객체생성코드로
		//    위의 4의 로직을 다시 구현하십시요.
		//---------------------------//
		
		ObjIntConsumer<String> objIntConsumer2 =
			new ObjIntConsumer<String>() {
			
			private String name = "Yoseph";
			

			@Override
			public void accept(String t, int value) {
				System.out.println(t + value);
				
				method1();
				method2();
				
				System.out.println(name);
			} // accept
			
			private void method1() {
				;;
			} // method1
			
			private void method2() {
				;;
			} // method2
			
		}; // 익명구현객체를 생성하는 첫번째 방법으로 대체구현

		objIntConsumer2.accept("Java", 8);
		
		System.exit(0);
	} // main
	
} // end class
