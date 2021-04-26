package sec02.exam01_createthread;

import java.awt.Toolkit;

public class BeepPrintExample2 {
	
	
	public static void main(String[] args) {
		
		//-----------------------------------
		// 1. WorkerThread ������� ù��°.
		//-----------------------------------
		// Runnable functional interface �� ���� �����ϴ�
		// Task�� �����, �̸� Thread ��ü ������, ��������
		// �Ű����� ������ ����!!!
//		Runnable beepTask = new BeepTask();
//		
//		Thread thread = new Thread(beepTask);
//		System.out.println("- thread: "+ thread);

		//-----------------------------------
		// 2. WorkerThread ������� �ι�°. (���߿�)
		//-----------------------------------
/*		Thread thread = new Thread( new Runnable() {
			
			@Override
			public void run() {
				Toolkit toolkit = 
					Toolkit.getDefaultToolkit();
				
				for(int i=0; i<5; i++) {		
					toolkit.beep();
					
					try { Thread.sleep(500); } 
					catch(Exception e) {;;}
				} // for
			} // run
			
		} �͸�����ü����  ); // Thread �������� ��.
*/
		//-----------------------------------
		// 3. WorkerThread ������� ����°. (���߿�)
		//-----------------------------------
		Thread thread = new Thread(() -> {
			
			Toolkit toolkit = 
					Toolkit.getDefaultToolkit();	
			
			for(int i=0; i<5; i++) {		
				toolkit.beep();
				
				try { Thread.sleep(500); } 
				catch(Exception e) {;;}
			} // for
			
		}); // �������� �Ű����� ������, Runnable �������̽���
		    // Target Type���� �ϴ�, ���ٽ��� �����Ͽ� ����
		
		//--------------------------------------------//
		// ù��° WorkerThread ����(����)
		thread.start();
		
		
		//-----------------------------------
		// �ι�° Task �� '��' ���� ��� Task��, 
		// main �����尡 ����
		for(int i=0; i<50; i++) {
			System.out.println("��");
			
			try { Thread.sleep(500L); } 
			catch(Exception e) {;;}
		} // for
		
	} // main
	
} // end class


