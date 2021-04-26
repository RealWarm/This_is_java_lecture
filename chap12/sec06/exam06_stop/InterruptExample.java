package sec06.exam06_stop;


public class InterruptExample {
	
	
	public static void main(String[] args)  {
		Thread thread = new PrintThread2(); // NEW
		thread.start();  // 스레드 생성 및 구동(시작)
		// NEW > RUNNABLE
		
		// 1초 동안 대기 - TIMED_WAITING
		try { Thread.sleep(1000); } 
		catch (InterruptedException e) {;;}
		
		// Interrupt Signal 전송 to 해당 스레드.
		thread.interrupt();  /* ***** */
	} // main
	
} // end class
