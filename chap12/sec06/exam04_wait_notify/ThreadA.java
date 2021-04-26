package sec06.exam04_wait_notify;


public class ThreadA 
	extends Thread {
	
	// ������ ������ü�� ���� ����
	private WorkObject workObject;


	// ������ �Ű������� ������ü ���� ����
	public ThreadA(WorkObject workObject) {
		this.workObject = workObject;
	} // constructor
	
	
	@Override
	public void run() {
		
		for(int i=0; i<10; i++) {
			workObject.methodA(); // ������A �� ������ ȣ��
		} // for
		
	} // run
	
} // end class

