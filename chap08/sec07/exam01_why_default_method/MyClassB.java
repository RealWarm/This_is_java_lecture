package sec07.exam01_why_default_method;


public class MyClassB 
	implements MyInterface {
	
	

	// 인터페이스에 선언된 추상메소드(즉, 규격-강제사항)를
	// 구현하고 있음
	@Override
	public void method1() {
		System.out.println(
				"- MyClassB::method1() invoked.");
	} // method1
	
	//***** 인터페이스에 정의된 default 메소드를 재정의
	//      (Overriding) 함
	@Override
	public void method2() {
		System.out.println(
				"- MyClassB::method2() invoked.");
	} // method2
	
} // end class
