package sec05.exam05_instanceof;


public class Driver {
	
	
	// 매개변수의 다형성 -
	// 메소드의 매개변수가, 인터페이스 타입의 변수임!!!!
	// 따라서, 이 인터페이스를 구현하는 객체는 어떤 것이라도
	// 전달 가능!
	public void drive(Vehicle vehicle) {
		if(vehicle instanceof Bus) {	// 타입확인!!!
			Bus bus = (Bus) vehicle;	// 강제형변환!!!
			
			bus.checkFare();
		} // if
		
		vehicle.run();	// 인터페이스에 선언된 메소드 호출!
	} // drive
	
} // end class
