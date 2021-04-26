package sec06.exam04_wait_notify;


public class WaitNotifyExample {
	
	
	public static void main(String[] args) throws InterruptedException {
		
		// 1. 두 스레드가 공유할 공유객체 생성
		WorkObject sharedObject = new WorkObject();
		
		// 2. 두 스레드 생성(이때 공유객체 참조전달) -> NEW
		ThreadA threadA = new ThreadA(sharedObject);
		ThreadB threadB = new ThreadB(sharedObject);
		
		// 3. 두 스레드 시작(구동) -> NEW > RUNNABLE
		threadA.start();
		threadB.start();
		
		// 4. Waiting Pool에 남아있는 한 개의 스레드에 통지
		Thread.sleep(1000L*3);

		sharedObject.notify();
//		sharedObject.methodMain();
	} // main
	
} // end class
