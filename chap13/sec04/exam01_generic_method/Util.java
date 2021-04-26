package sec04.exam01_generic_method;


// 이렇게, 다른 유용한 기능을 제공하는 용도로 만드는 클래스를
// 우리는, 유틸리티 클래스 라고 부르고, 보통, 공통기능을 수행
// 하는 메소드(보통, 정적메소드로 선언)를 가지고 있습니다.
public class Util {	// 유틸리티 클래스 선언
	
	
	// 이게 바로, 타입파라미터를 가지는 제레릭 메소드 선언
	public static <T> Box<T> boxing(T t) {
		Box<T> box = new Box<T>(); // *** 주의 ****//
		
		box.set(t);
		
		return box;
	} // boxing
	
} // end class
