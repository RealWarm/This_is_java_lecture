package sec06.exam01_sleep;

import java.awt.Toolkit;


public class SleepExample {
	
	public static void main(String[] args) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		
		for(int i=0; i<10; i++) {
			toolkit.beep();	// beep �� �߻�
			
			try {
				// 3�ʵ��� TIMED_WAITING ���·� ����
				// (�Ͻ�����)
				Thread.sleep(300000); 
			} catch(InterruptedException e) {;;}		
		} // for	
	} // main
	
} // end class
