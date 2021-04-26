package sec06.exam04_wait_notify;

// �� �����尡 ����� ������ü
public class WorkObject {
	
	
	// ������A�� �����ؾ��� ������ ������ �޼ҵ�
	public synchronized void methodA() {
		System.out.println("ThreadA�� methodA() �۾� ����");
		
		// Waiting Pool�ȿ� �ִ� WAITING������
		// ������ ***�ϳ���*** ����� ��
		notify();	
		
		try {
			// �ڽ��� RUNNING -> WATIING ���·� ����
			wait();	
		} catch (InterruptedException e) {;;}
	} // methodA
	
	// ������B�� �����ؾ��� ������ ������ �޼ҵ�
	public synchronized void methodB() {
		System.out.println("ThreadB�� methodB() �۾� ����");

		// Waiting Pool�ȿ� �ִ� WAITING������
		// ������ ***�ϳ���*** ����� ��
		notify();
		
		try {
			// �ڽ��� RUNNING -> WATIING ���·� ����
			wait();
		} catch (InterruptedException e) {;;}
	} // methodB
	
	// main�� �����ؾ��� ������ ������ �޼ҵ�
	public synchronized void methodMain() {
		notify();
	} // methodMain
	
} // end class
