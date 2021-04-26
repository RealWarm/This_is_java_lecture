package sec06.exam02_yield;


public class YieldExample {
	
	
	public static void main(String[] args) {
		// NEW
		ThreadA threadA = new ThreadA(); // 1st.스레드생성
		ThreadB threadB = new ThreadB(); // 2nd.스레드생성
		
		// RUNNABLE
		threadA.start(); // 1st. 스레드 구동(시작)		
		threadB.start(); // 2nd. 스레드 구동(시작)
		
		//---------------------------//
		try { Thread.sleep(1000L); } // TIMED_WAITING 
		catch (InterruptedException e) {;;}
		
		threadA.work = false;	// ** 작업플래그 변경 **
		
		//---------------------------//
		try { Thread.sleep(1000L); } // TIMED_WAITING 
		catch (InterruptedException e) {;;}
		
		threadA.work = true;	// ** 작업플래그 변경 **

		//---------------------------//
		try { Thread.sleep(3000L); } 
		catch (InterruptedException e) {;;}
		
		threadA.stop = true;	// ** 종료 플래그 변경 **
		threadB.stop = true;	// ** 종료 플래그 변경 **
	} // main
	
} // end class
