package sec07.exam01_why_default_method;


public class MyClassA 
	implements MyInterface {
	
	
	// 인터페이스에 선언된 추상메소드(즉, 규격-강제사항)를
	// 구현하고 있음
	@Override
	public void method1() {
		System.out.println(
				"- MyClassA::method1() invoked.");
	} // method1
	
} // end class
