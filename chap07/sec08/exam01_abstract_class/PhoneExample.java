package sec08.exam01_abstract_class;


public class PhoneExample {
	
	
	public static void main(String[] args) {
		//추상클래스로부터 직접 new 연산자로 객체 생성 시도!!!
//		Phone phone = new Phone(); // X
		
		// 다형성-1
		Phone smartPhone = new SmartPhone("홍길동");
		System.out.println("1. smartPhone: " + smartPhone);
		
		// 추상클래스로부터 상속받은 메소드(즉, 공통기능 의미!)
		smartPhone.turnOn();	
		
		SmartPhone sp = (SmartPhone) smartPhone;
		sp.internetSearch(); // 자식객체의 고유기능
		
		// 추상클래스로부터 상속받은 메소드(즉, 공통기능 의미!)
		smartPhone.turnOff();
	} // main
	
} // end class
