package sec04.exam01_unsynchronized;


public class MainThreadExample {
	
	
	public static void main(String[] args) {
		// 1. 공유객체 생성
		Calculator calculator = new Calculator();
		
		// 2. User1 스레드 객체 생성 및 시작(구동)
		User1 user1 = new User1();
		user1.setCalculator(calculator); // 공유객체참조전달
		user1.start();
		
		//---- 스레드의 무작위성을 절대 잊지 말것!!!

		// 3. User2 스레드 객체 생성 및 시작(구동)
		User2 user2 = new User2();
		user2.setCalculator(calculator); // 공유객체참조전달
		user2.start();
	} // main
	
} // end class
