package sec06.exam06_stop;


// 안전하게 종료시킬 대상 스레드 선언
public class PrintThread2 
	extends Thread {
	
	
	@Override
	public void run() {	 // 스레드의 실행코드
		
		//---------------------------------//
		// 1st. method to terminate safely.
		//---------------------------------//
		try {
			
			while(true) {
				System.out.println("실행 중");
				
				// 일부러, 0.001초만 자게 만듦
				// (TIMED_WAITING)
				Thread.sleep(1);
			} // while
			
		} catch(InterruptedException e) {;;}
		
		
		//---------------------------------//		
		// 2nd. method to terminate safely.
		//---------------------------------//		
		while(!Thread.interrupted()) { // 무한루프
			System.out.println("실행 중");
			
			// 이전에 이미 Interrupt Signal 이 수신되었는지
			// 체크하여, 수신된 Signal이 있으면 무한루프를
			// 빠져나옴 ----> **핵심**
			if(Thread.interrupted()) {
				break;
			} // if
		} // while

		//---------------------------------//		
		// 3rd. method to terminate safely.
		//---------------------------------//
		this.isInterrupted();

		//---------------------------------//
		// 자원정리
		//---------------------------------//	
		System.out.println("자원 정리");
		System.out.println("실행 종료");
	} // run
	
} // end class

