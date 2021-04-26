package sec06.exam01_protected.package1;


public class B {

	
	public void method() {
		A a = new A();			// 사용관계
		
		a.field = "value";		// A 객체의 필드사용
		a.method();				// A 객체의 메소드호출
	} // method
	
} //end class
