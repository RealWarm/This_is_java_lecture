package sec06.exam01_sleep;

import java.awt.Toolkit;


public class SleepExample {
	
	public static void main(String[] args) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		
		for(int i=0; i<10; i++) {
			toolkit.beep();	// beep 음 발생
			
			try {
				// 3초동안 TIMED_WAITING 상태로 빠짐
				// (일시정지)
				Thread.sleep(300000); 
			} catch(InterruptedException e) {;;}		
		} // for	
	} // main
	
} // end class
