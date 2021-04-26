package sec06.exam04_wait_notify;


public class ThreadA 
	extends Thread {
	
	// 접근할 공유객체의 참조 저장
	private WorkObject workObject;


	// 생성자 매개변수로 공유객체 참조 저장
	public ThreadA(WorkObject workObject) {
		this.workObject = workObject;
	} // constructor
	
	
	@Override
	public void run() {
		
		for(int i=0; i<10; i++) {
			workObject.methodA(); // 스레드A 가 할일을 호출
		} // for
		
	} // run
	
} // end class

