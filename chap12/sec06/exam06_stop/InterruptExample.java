package sec06.exam06_stop;


public class InterruptExample {
	
	
	public static void main(String[] args)  {
		Thread thread = new PrintThread2(); // NEW
		thread.start();  // ������ ���� �� ����(����)
		// NEW > RUNNABLE
		
		// 1�� ���� ��� - TIMED_WAITING
		try { Thread.sleep(1000); } 
		catch (InterruptedException e) {;;}
		
		// Interrupt Signal ���� to �ش� ������.
		thread.interrupt();  /* ***** */
	} // main
	
} // end class
