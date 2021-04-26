package sec06.exam04_wait_notify;

// 두 쓰레드가 사용할 공유객체
public class WorkObject {
	
	
	// 스레드A가 수행해야할 로직을 가지는 메소드
	public synchronized void methodA() {
		System.out.println("ThreadA의 methodA() 작업 실행");
		
		// Waiting Pool안에 있는 WAITING상태의
		// 스레드 ***하나만*** 깨어나게 함
		notify();	
		
		try {
			// 자신은 RUNNING -> WATIING 상태로 빠짐
			wait();	
		} catch (InterruptedException e) {;;}
	} // methodA
	
	// 스레드B가 수행해야할 로직을 가지는 메소드
	public synchronized void methodB() {
		System.out.println("ThreadB의 methodB() 작업 실행");

		// Waiting Pool안에 있는 WAITING상태의
		// 스레드 ***하나만*** 깨어나게 함
		notify();
		
		try {
			// 자신은 RUNNING -> WATIING 상태로 빠짐
			wait();
		} catch (InterruptedException e) {;;}
	} // methodB
	
	// main가 수행해야할 로직을 가지는 메소드
	public synchronized void methodMain() {
		notify();
	} // methodMain
	
} // end class
