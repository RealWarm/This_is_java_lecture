package sec06.exam04_wait_notify;


public class ThreadB 
	extends Thread {
	
	// ������ ������ü�� ���� ����
	private WorkObject workObject;

	
	// ������ �Ű������� ������ü ���� ����
	public ThreadB(WorkObject workObject) {
		this.workObject = workObject;
	} // constructor
	
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			workObject.methodB(); // ������B �� ������ ȣ��
		} // for
	} // run
	
} // end class
