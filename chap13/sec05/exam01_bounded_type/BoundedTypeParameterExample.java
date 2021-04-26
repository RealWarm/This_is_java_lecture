package sec05.exam01_bounded_type;


public class BoundedTypeParameterExample {
	
	
	public static void main(String[] args) {
		//------------------------------------//
		// 제한된 범위의 타입(<T extends Number>)에 
		// 속하지 않음.
		// 제네릭 메소드 호출방법 두가지 중, 2번째 사용
		// 즉, 구체타입 지정 생략
		//------------------------------------//
		// String str = Util.compare("a", "b"); (x)
		
		//------------------------------------//
		// 제네릭 메소드 호출방법 두가지 중, 2번째 사용
		// 즉, 구체타입 지정 생략
		
		int result1 = Util.compare(10, 20);
		System.out.println("1. "+result1);
		
		//------------------------------------//
		// 제네릭 메소드 호출방법 두가지 중, 2번째 사용
		// 즉, 구체타입 지정 생략
		
		int result2 = Util.compare(4.5, 3);
		System.out.println("2. "+result2);
		
		//------------------------------------//
		// 제네릭 메소드 호출방법 두가지 중, 2번째 사용
		// 즉, 구체타입 지정 생략
		
		int result3 = Util.compare(6, 6);
		System.out.println("3. "+result3);
	} // main
	
} // end class
