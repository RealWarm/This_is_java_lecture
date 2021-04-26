package sec02.exam02_generic_type;


public class BoxExample {
	
	
	public static void main(String[] args) {
		//-----------------------------------//
		// 제네릭 클래스인 box 타입의 객체생성
		Box<String> box1 = new Box<>();
		//-----------------------------------//
		
		// 생성된 box객체의 메소드 호출
		box1.set("hello");	// setter 호출
		String str = box1.get(); // getter 호출
		
		
		//-----------------------------------//
		// 제네릭 클래스인 box 타입의 객체생성
		Box<Integer> box2 = new Box<>();
		//-----------------------------------//

		// 생성된 box객체의 메소드 호출
		box2.set(6); // setter 호출
		int value = box2.get(); //getter 호출
		
		/*
		// Auto-Boxing / Unboxing
//		Integer intObj = new Integer(1);
		Integer intObj = 1;  // auto-boxing
		int i = intObj;	// auto-boxing
		i = intObj.intValue(); // by compiler
		
//		Boolean booleanObj = 
//				new Boolean(true);
		Boolean booleanObj = false; //auto-boxing
		boolean b = booleanObj; //auto-unboxing
		
		b = booleanObj.booleanValue(); // by compiler
		
//		Double doubleObj = new Double(1.0);
		Double doubleObj = 1.0; // auto-boxing
		double d = doubleObj;   // auto-unboxing
		d = doubleObj.doubleValue(); // by compiler
		*/
	
	} // main
	
} // end class




