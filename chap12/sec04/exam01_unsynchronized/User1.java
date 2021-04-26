package sec04.exam01_unsynchronized;


public class User1 extends Thread {	
	private Calculator calculator;	// 공유객체의 저장필드
	
	
	// 공유객체를 전달받기 위한 용도의 setter 메소드
	public void setCalculator(Calculator calculator) {
		this.setName("User1");  // 스레드의 이름 지정
		
		// 공유객체를 필드에 저장
		this.calculator = calculator;  
	} // setter
	
	// User1 스레드의 실행코드블록
	@Override
	public void run() {
		System.out.println("- User1::run() invoked.");
		
		calculator.setMemory(100);
	} // run
	
} // end class

