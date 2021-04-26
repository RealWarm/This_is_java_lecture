package sec05.exam01_state;


public class ThreadStateExample {
	
	
	public static void main(String[] args) {
		// 상태출력스레드 생성 및 구동
		StatePrintThread statePrintThread = 
			new StatePrintThread(
					// Target 스레드 객체생성하여 전달
					new TargetThread()
				);
		
		statePrintThread.start(); // 스레드 구동(시작)
	} // main
	
} // end class
