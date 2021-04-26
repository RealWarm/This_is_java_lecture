package sec07.exam01_daemon;


public class DaemonExample {
	
	
	public static void main(String[] args) {
		AutoSaveThread autoSaveThread = 
			new AutoSaveThread();
		
		// Daemon 스레드로 설정 
		// (반드시, 스레드 구동전에 해야함)
		autoSaveThread.setDaemon(true);
		
		// 스레드 구동(시작)
		autoSaveThread.start();	// 매1초마다 자동저장 수행
		
		try { Thread.sleep(3000); } 
		catch (InterruptedException e) {;;}
		
		System.out.println("메인 스레드 종료");
	} // main
	
} // end class
