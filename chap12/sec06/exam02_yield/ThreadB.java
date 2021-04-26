package sec06.exam02_yield;


public class ThreadB 
	extends Thread {
	// 무한루프를 종료시키는 역할을 하는 플래그 (****중요***)
	public boolean stop = false;
	
	// 나의 코드를 수행시킬지, 
	// 아니면 양보할지를 결정하는 플래그
	public boolean work = true;

	
	@Override
	public void run() { // Worker Thread 실행코드
		
		while(!stop) { // 무한루프 (*종료플래그사용*)
			
			if(work) { // 나의 코드를 수행 (*작업플래그사용*)
				System.out.println("ThreadB 작업 내용");
			} else {
				Thread.yield();// time slice 양보 (**)
			} // if-else
			
		} // while
		
		System.out.println("ThreadB 종료");
	} // run
	
} // end class

