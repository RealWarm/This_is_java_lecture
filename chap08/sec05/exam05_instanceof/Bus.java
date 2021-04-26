package sec05.exam05_instanceof;


public class Bus 
	implements Vehicle {
	
	
	// 인터페이스에 선언된 추상메소드(규격)을 구현(재정의)
	@Override
	public void run() {
		System.out.println("버스가 달립니다.");
	} // run
	
	// 자체 인스턴스 메소드
	public void checkFare() {
		System.out.println("승차요금을 체크합니다.");
	} // checkFare
	
} // end class
