package sec07.exam01_daemon;


public class DaemonExample {
	
	
	public static void main(String[] args) {
		AutoSaveThread autoSaveThread = 
			new AutoSaveThread();
		
		// Daemon ������� ���� 
		// (�ݵ��, ������ �������� �ؾ���)
		autoSaveThread.setDaemon(true);
		
		// ������ ����(����)
		autoSaveThread.start();	// ��1�ʸ��� �ڵ����� ����
		
		try { Thread.sleep(3000); } 
		catch (InterruptedException e) {;;}
		
		System.out.println("���� ������ ����");
	} // main
	
} // end class
