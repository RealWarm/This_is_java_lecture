package sec02.exam01_createthread;

import java.awt.Toolkit;


//-----------------------------------
// 4. WorkerThread ������� �׹�°.
//    Thread Ŭ������ �θ�� ����ϴ� �ڽ� Ŭ���� �����ϰ�,
//    �ڽ� Ŭ�������� run() �޼ҵ� overriding �ϴ� ���
//-----------------------------------
public class BeepThread 
	extends Thread {
	
	
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
	
} // end class

