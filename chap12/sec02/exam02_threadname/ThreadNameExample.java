package sec02.exam02_threadname;


public class ThreadNameExample {
	
	
	public static void main(String[] args) {
		Thread mainThread = 
			Thread.currentThread();
		
		System.out.println(
			"���α׷� ���� ������ �̸�: " + 
			mainThread.getName());
		
		//--------------------------------------//
		
		ThreadA threadA = new ThreadA();
		threadA.start();
		
		System.out.println(
				"�۾� ������ �̸�: " + 
				threadA.getName());

		//--------------------------------------//
		
		ThreadB threadB = new ThreadB();
		threadB.start();
		
		System.out.println(
			"�۾� ������ �̸�: " + 
			threadB.getName()
		);
		
	} // main
	
} // end class
