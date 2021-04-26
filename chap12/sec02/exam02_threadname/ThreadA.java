package sec02.exam02_threadname;

public class ThreadA extends Thread {
	
	
	public ThreadA() {
		// *** 이 스레드에 이름을 지정해주자!!!!
		setName("ThreadA");  // 부모클래스에서 상속받은 메소드
	} // constructor
	
	@Override
	public void run() { // 스레드의 실행코드
		
		for(int i=0; i<2; i++) {		
			System.out.println(getName() + "가 출력한 내용");
		} // for
		
	} // run
	
} // end class

