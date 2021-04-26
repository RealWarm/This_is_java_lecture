package sec06.exam04_wait_notify;


public class WaitNotifyExample {
	
	
	public static void main(String[] args) throws InterruptedException {
		
		// 1. �� �����尡 ������ ������ü ����
		WorkObject sharedObject = new WorkObject();
		
		// 2. �� ������ ����(�̶� ������ü ��������) -> NEW
		ThreadA threadA = new ThreadA(sharedObject);
		ThreadB threadB = new ThreadB(sharedObject);
		
		// 3. �� ������ ����(����) -> NEW > RUNNABLE
		threadA.start();
		threadB.start();
		
		// 4. Waiting Pool�� �����ִ� �� ���� �����忡 ����
		Thread.sleep(1000L*3);

		sharedObject.notify();
//		sharedObject.methodMain();
	} // main
	
} // end class
