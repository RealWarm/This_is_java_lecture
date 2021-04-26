package sec05.exam05_instanceof;


public class Taxi 
	implements Vehicle {
	
	
	// 인터페이스에 선언된 추상메소드를 구현(재정의)
	@Override
	public void run() {
		System.out.println("택시가 달립니다.");
	} // run
	
} // end class
