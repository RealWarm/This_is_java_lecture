package sec02.exam01_createthread;

import java.awt.Toolkit;


//-----------------------------------
// 4. WorkerThread 생성방법 네번째.
//    Thread 클래스를 부모로 상속하는 자식 클래스 생성하고,
//    자식 클래스에서 run() 메소드 overriding 하는 방법
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

