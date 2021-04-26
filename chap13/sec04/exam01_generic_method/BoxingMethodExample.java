package sec04.exam01_generic_method;


public class BoxingMethodExample {
	
	
	public static void main(String[] args) {
		//---------------------------------//
		// 제네릭 메소드 호출시에, 타입 파라미터에
		// 구체타입 지정!!!
		//---------------------------------//
		// 제네릭 메소드 호출방법 - 1
		//   - 명시적으로 구체타입 지정하여 호출
		//---------------------------------//
		Box<Integer> box1 = 
				Util.<Integer>boxing(100);
		
//		Box box1 = Util.boxing(100);
		
		int intValue = box1.get();

		//---------------------------------//
		// 제네릭 메소드 호출방법 - 2
		//   - 묵시적으로 구체타입을 생략하여 호출
		//---------------------------------//		
		Box<String> box2 = Util.boxing("홍길동");
		
		String strValue = box2.get();
	} // main
	
	
	
	
	
	
	
	
} // end class
