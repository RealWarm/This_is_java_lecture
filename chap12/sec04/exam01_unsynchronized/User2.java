package sec04.exam01_unsynchronized;

public class User2 extends Thread {	
	private Calculator calculator; // 공유객체의 참조보관필드	
	
	
	public void setCalculator(Calculator calculator) {
		this.setName("User2");	// 스레드 이름 지정
		
		// 공유객체의 참조를 필드에 저장
		this.calculator = calculator; 
	} // setter
	
	@Override
	public void run() {
		System.out.println("- User2::run() invoked.");
		
		calculator.setMemory(50); // 연산결과를 필드에 저장
	} // run
	
} // end class
