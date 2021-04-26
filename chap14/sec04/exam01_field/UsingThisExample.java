package sec04.exam01_field;


public class UsingThisExample {
	
	
	public static void main(String... args) {
		// 가장 바깥쪽 클래스인 UsingThis 의 객체를 생성
		UsingThis usingThis = new UsingThis();
		
		// UsingThis 안에 선언된 중첩 클래스인 Inner의
		// 객체를 생성
		UsingThis.Inner inner = usingThis.new Inner();
		
		inner.method();
	} // main
	
} // end class

