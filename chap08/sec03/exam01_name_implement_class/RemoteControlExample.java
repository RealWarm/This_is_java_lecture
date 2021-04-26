package sec03.exam01_name_implement_class;


public class RemoteControlExample {

	
	public static void main(String[] args) {
		RemoteControl rc;		// 참조타입의 지역변수
		
		// 다형성-1:
		// 부모타입의 변수에는, 자식객체가 대입가능한 성질
		// 다형성-2:
		// 다형성-1이 만족된 상태에서, 부모타입의 변수로,
		// 부모타입에 선언된 메소드 호출시에, 부모타입의
		// 메소드가 호출되는것이 아니라, 자식객체의 오버라이딩
		// 된 메소드가 호출된다!!!(부모메소드는 가려진다)
		rc = new Television();	// 다형성-1 how ?
		System.out.println("1. rc: "+ rc);
		
		// 다형성-2
		rc.turnOn();
		rc.setMute(true);
		rc.turnOff();
		
		rc = new Audio();		// 다형성-1 how ?
		System.out.println("2. rc: "+ rc);
		
	} // main
	
} // end class
