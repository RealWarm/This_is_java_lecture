package sec05.exam01_state;


public class ThreadStateExample {
	
	
	public static void main(String[] args) {
		// ������½����� ���� �� ����
		StatePrintThread statePrintThread = 
			new StatePrintThread(
					// Target ������ ��ü�����Ͽ� ����
					new TargetThread()
				);
		
		statePrintThread.start(); // ������ ����(����)
	} // main
	
} // end class
