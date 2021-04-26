package sec06.exam02_yield;


public class YieldExample {
	
	
	public static void main(String[] args) {
		// NEW
		ThreadA threadA = new ThreadA(); // 1st.���������
		ThreadB threadB = new ThreadB(); // 2nd.���������
		
		// RUNNABLE
		threadA.start(); // 1st. ������ ����(����)		
		threadB.start(); // 2nd. ������ ����(����)
		
		//---------------------------//
		try { Thread.sleep(1000L); } // TIMED_WAITING 
		catch (InterruptedException e) {;;}
		
		threadA.work = false;	// ** �۾��÷��� ���� **
		
		//---------------------------//
		try { Thread.sleep(1000L); } // TIMED_WAITING 
		catch (InterruptedException e) {;;}
		
		threadA.work = true;	// ** �۾��÷��� ���� **

		//---------------------------//
		try { Thread.sleep(3000L); } 
		catch (InterruptedException e) {;;}
		
		threadA.stop = true;	// ** ���� �÷��� ���� **
		threadB.stop = true;	// ** ���� �÷��� ���� **
	} // main
	
} // end class
