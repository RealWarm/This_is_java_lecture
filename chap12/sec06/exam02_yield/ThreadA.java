package sec06.exam02_yield;


public class ThreadA 
	extends Thread {
	// ���ѷ����� �����Ű�� ������ �ϴ� �÷��� (****�߿�***)
	public boolean stop = false;
	
	// ���� �ڵ带 �����ų��, 
	// �ƴϸ� �纸������ �����ϴ� �÷���
	public boolean work = true;
	
	
	@Override
	public void run() { // Worker Thread �����ڵ�
		
		while(!stop) { // ���ѷ��� (*�����÷��׻��*)
			
			if(work) { // ���� �ڵ带 ���� (*�۾��÷��׻��*)
				System.out.println("ThreadA �۾� ����");
			} else {
				Thread.yield();	// time slice �纸 (**)
			} // if-else
		} // while
		
		System.out.println("ThreadA ����");
	} // run
	
} // end class

