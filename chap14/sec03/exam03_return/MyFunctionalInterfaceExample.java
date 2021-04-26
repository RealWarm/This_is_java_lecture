package sec03.exam03_return;


public class MyFunctionalInterfaceExample {
	public static String name="Yoseph";
	
	
	public static void main(String[] args) {
		MyFunctionalInterface fi;
		int age = 44;
		
		//---------------------------//
		
		fi = (x, y) -> {
			MyFunctionalInterfaceExample.sum(x,y);
			
			System.out.println(
					MyFunctionalInterfaceExample.name);
			
			System.out.println(args);
			System.out.println(age);
			
			int result = x + y;
			
			return result;	// 리턴값 반환
		}; // 타겟타입을 구현하는 익명구현객체생성
		
		// 추상 메소드 호출
		System.out.println( fi.method(2, 5) ); 
		
		//---------------------------//
		
		fi = (x, y) -> { 
			return x + y;	// 리턴값 반환
		}; // 타겟타입을 구현하는 익명구현객체생성

		// 추상 메소드 호출
		System.out.println( fi.method(2, 5) );
		
		//---------------------------//
		
		// 타겟타입을 구현하는 익명구현객체생성
		fi = (x, y) -> x + y;

		// 추상 메소드 호출
		System.out.println( fi.method(2, 5) );
		
		//---------------------------//
		
		// 타겟타입을 구현하는 익명구현객체생성
		fi = (x, y) -> sum(x, y);

		// 추상 메소드 호출
		System.out.println( fi.method(2, 5) );
	} // main	
	 
	public static int sum(int x, int y) {
		return (x + y);
	} // sum
	
} // end class











