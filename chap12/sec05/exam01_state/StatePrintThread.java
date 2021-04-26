package sec05.exam01_state;

public class StatePrintThread 
	extends Thread {
	
	// ��������(transition)�� ����͸���, 
	// ��� ������ ��ü ����
	private Thread targetThread;	

	
	// Target ������ ��ü�� ���Թ���
	public StatePrintThread(Thread targetThread) {
		this.targetThread = targetThread;
	} // constructor

	@Override
	public void run() {
		
		while(true) { // ���ѷ���
			//---------------------------------
			// Target �������� ���� ������ ���¸� ��
			Thread.State state = targetThread.getState();			
			System.out.println("Ÿ�� ������ ����: " + state);

			//---------------------------------
			// ����, Target �������� ���°� NEW �̸�
			// (��, ������ ��ü�� �����ǰ�, ���� start�Ǳ���)
			if(state == Thread.State.NEW) {
				targetThread.start(); // ������ ����(����)
			} // if
			
			//---------------------------------
			// ����, Target �������� ���°� ������� �̸�
			// ���ѷ����� ��������
			if(state == Thread.State.TERMINATED) {
				break;
			} // if

			//---------------------------------
			try { Thread.sleep(50); } 
			catch(Exception e) {;;}
		} // while
		
	} // run
	
} // end class

