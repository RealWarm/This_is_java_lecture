package sec07.exam01_daemon;


public class AutoSaveThread 
	extends Thread {
	
	
	public void save() {
		System.out.println("�۾� ������ ������.");
	} // save
	
	@Override
	public void run() {
		
		while(true) { // ���ѷ���
			// Interrupt Signal�� ������ 
			// InterruptedException ���ܹ߻��� �̿���
			// ������ ������ ����
			try { Thread.sleep(1000); } 
			catch (InterruptedException e) {
				break;
			} // try-catch
			
			save(); // �ڵ����� ���� (�� 1�ʸ���)
		} // while
		
	} // run
	
} // end class
