package sec07.exam01_why_default_method;


public class DefaultMethodExample {
	
	
	public static void main(String[] args) {
		// 1. 첫번째 구현클래스는, 인터페이스의 default
		//    메소드를 있는 그대로 사용
		MyInterface mi1 = new MyClassA();
		mi1.method1();
		mi1.method2();	//-> default method(호출변수주의!!)
		
		//------------------------------------//
		
		// 2.두번째 구현클래스는, 인터페이스의 default
		//   메소드를 재정의(Overriding)하여 사용
		MyInterface mi2 = new MyClassB();
		mi2.method1();
		mi2.method2();	//-> default method(호출변수주의!!)
		
	} // main
	
} // end class
