package sec07.exam07_instanceof;

public class InstanceofExample {
	
	
	public static void main(String[] args) {
		Parent parentA = new Child();
		
		method1(parentA);		// OK
		method2(parentA);		// OK
		
		//--------------------------------//
		
		Parent parentB = new Parent();
		
		method1(parentB);		// OK
		method2(parentB); 		//***** 예외 발생 *****
	} // main
	
	
	public static void method1(Parent parent) {
		if(parent instanceof Child) {
			Child child = (Child) parent;
			
			System.out.println(
					"method1 - Child로 변환 성공");
		} else {
			System.out.println(
					"method1 - Child로 변환되지 않음");
		} // if-else
	} // method1
	
	public static void method2(Parent parent) {
		Child child = (Child) parent;
		
		System.out.println("method2 - Child로 변환 성공");
	} // method2
	
} // end class
