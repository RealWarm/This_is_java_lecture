package sec02.exam02_threadname;

public class ThreadA extends Thread {
	
	
	public ThreadA() {
		// *** �� �����忡 �̸��� ����������!!!!
		setName("ThreadA");  // �θ�Ŭ�������� ��ӹ��� �޼ҵ�
	} // constructor
	
	@Override
	public void run() { // �������� �����ڵ�
		
		for(int i=0; i<2; i++) {		
			System.out.println(getName() + "�� ����� ����");
		} // for
		
	} // run
	
} // end class

