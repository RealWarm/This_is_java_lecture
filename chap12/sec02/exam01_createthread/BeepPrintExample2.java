package sec02.exam01_createthread;

import java.awt.Toolkit;

public class BeepPrintExample2 {
	
	
	public static void main(String[] args) {
		
		//-----------------------------------
		// 1. WorkerThread 생성방법 첫번째.
		//-----------------------------------
		// Runnable functional interface 를 직접 구현하는
		// Task를 만들고, 이를 Thread 객체 생성시, 생성자의
		// 매개변수 값으로 전달!!!
//		Runnable beepTask = new BeepTask();
//		
//		Thread thread = new Thread(beepTask);
//		System.out.println("- thread: "+ thread);

		//-----------------------------------
		// 2. WorkerThread 생성방법 두번째. (나중에)
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
			
		} 익명구현객체생성  ); // Thread 생성자의 끝.
*/
		//-----------------------------------
		// 3. WorkerThread 생성방법 세번째. (나중에)
		//-----------------------------------
		Thread thread = new Thread(() -> {
			
			Toolkit toolkit = 
					Toolkit.getDefaultToolkit();	
			
			for(int i=0; i<5; i++) {		
				toolkit.beep();
				
				try { Thread.sleep(500); } 
				catch(Exception e) {;;}
			} // for
			
		}); // 생성자의 매개변수 값으로, Runnable 인터페이스를
		    // Target Type으로 하는, 람다식을 생성하여 전달
		
		//--------------------------------------------//
		// 첫번째 WorkerThread 시작(구동)
		thread.start();
		
		
		//-----------------------------------
		// 두번째 Task 인 '띵' 문자 출력 Task는, 
		// main 스레드가 수행
		for(int i=0; i<50; i++) {
			System.out.println("띵");
			
			try { Thread.sleep(500L); } 
			catch(Exception e) {;;}
		} // for
		
	} // main
	
} // end class


