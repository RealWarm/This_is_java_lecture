package sec03.exam03_multi_implement_class;


public class RemoteControlExample {
	
	
	public static void main(String[] args) {
		// 구현객체 생성
		SmartTelevision tv = new SmartTelevision();
		
		// RemoteControl 인터페이스 타입에 대입(다형성-1)
		RemoteControl rc = tv;
		
		// Searchable 인터페이스 타입에 대입(다형성-1)
		Searchable searchable = tv;
	} // main
	
} // end class
