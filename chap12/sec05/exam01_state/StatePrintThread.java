package sec05.exam01_state;

public class StatePrintThread 
	extends Thread {
	
	// 상태전이(transition)를 모니터링할, 
	// 대상 스레드 객체 저장
	private Thread targetThread;	

	
	// Target 스레드 객체를 주입받음
	public StatePrintThread(Thread targetThread) {
		this.targetThread = targetThread;
	} // constructor

	@Override
	public void run() {
		
		while(true) { // 무한루프
			//---------------------------------
			// Target 스레드의 현재 싯점의 상태를 얻어냄
			Thread.State state = targetThread.getState();			
			System.out.println("타겟 스레드 상태: " + state);

			//---------------------------------
			// 만일, Target 스레드의 상태가 NEW 이면
			// (즉, 스레드 객체만 생성되고, 아직 start되기전)
			if(state == Thread.State.NEW) {
				targetThread.start(); // 스레드 구동(시작)
			} // if
			
			//---------------------------------
			// 만일, Target 스레드의 상태가 종료상태 이면
			// 무한루프를 빠져나옴
			if(state == Thread.State.TERMINATED) {
				break;
			} // if

			//---------------------------------
			try { Thread.sleep(50); } 
			catch(Exception e) {;;}
		} // while
		
	} // run
	
} // end class

