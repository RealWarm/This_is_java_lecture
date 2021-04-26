package sec06.exam06_stop;


// �����ϰ� �����ų ��� ������ ����
public class PrintThread2 
	extends Thread {
	
	
	@Override
	public void run() {	 // �������� �����ڵ�
		
		//---------------------------------//
		// 1st. method to terminate safely.
		//---------------------------------//
		try {
			
			while(true) {
				System.out.println("���� ��");
				
				// �Ϻη�, 0.001�ʸ� �ڰ� ����
				// (TIMED_WAITING)
				Thread.sleep(1);
			} // while
			
		} catch(InterruptedException e) {;;}
		
		
		//---------------------------------//		
		// 2nd. method to terminate safely.
		//---------------------------------//		
		while(!Thread.interrupted()) { // ���ѷ���
			System.out.println("���� ��");
			
			// ������ �̹� Interrupt Signal �� ���ŵǾ�����
			// üũ�Ͽ�, ���ŵ� Signal�� ������ ���ѷ�����
			// �������� ----> **�ٽ�**
			if(Thread.interrupted()) {
				break;
			} // if
		} // while

		//---------------------------------//		
		// 3rd. method to terminate safely.
		//---------------------------------//
		this.isInterrupted();

		//---------------------------------//
		// �ڿ�����
		//---------------------------------//	
		System.out.println("�ڿ� ����");
		System.out.println("���� ����");
	} // run
	
} // end class

