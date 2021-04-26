package sec07.exam01_daemon;


public class AutoSaveThread 
	extends Thread {
	
	
	public void save() {
		System.out.println("작업 내용을 저장함.");
	} // save
	
	@Override
	public void run() {
		
		while(true) { // 무한루프
			// Interrupt Signal의 흔적과 
			// InterruptedException 예외발생을 이용한
			// 안전한 스레드 종료
			try { Thread.sleep(1000); } 
			catch (InterruptedException e) {
				break;
			} // try-catch
			
			save(); // 자동저장 수행 (매 1초마다)
		} // while
		
	} // run
	
} // end class
