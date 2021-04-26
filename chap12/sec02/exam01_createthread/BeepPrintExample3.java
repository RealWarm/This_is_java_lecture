package sec02.exam01_createthread;

import java.awt.Toolkit;

public class BeepPrintExample3 {
	
	
	public static void main(String[] args) {
		
		//-----------------------------------
		// 4. WorkerThread 생성방법 네번째.
		//-----------------------------------
//		Thread thread = new BeepThread();

		//-----------------------------------
		// 5. WorkerThread 생성방법 디섯번째.
		Thread thread = new Thread() {
			
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
		}; // 익명자식객체 구현 방식
		
		// WorkerThread 구동(시작)
		thread.start();
		
		//---------------------------------//		
		for(int i=0; i<5; i++) {
			System.out.println("띵");
			
			try { Thread.sleep(500); } 
			catch(Exception e) {;;}
		} // for
		
	} // end class
}

