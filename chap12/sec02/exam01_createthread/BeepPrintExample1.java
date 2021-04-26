package sec02.exam01_createthread;

import java.awt.Toolkit;


public class BeepPrintExample1 {
	
	
	public static void main(String[] args) {
		//-------------------------------------
		// 1. Java AWT Toolkit 객체를 얻음. 
		// 왜? 비프음을 울리는 기능이 있기 때문에..
		Toolkit toolkit = Toolkit.getDefaultToolkit();

		//-------------------------------------
		// 2. 총 5번 반복해서, 위에서 얻어낸 Tookit 객체의
		//    메소드(beep)를 호출하여, 실제 비프음을 발생시킴
		for(int i=0; i<5; i++) {		
			toolkit.beep();
			
			// 매번 비프음을 울리기전에, 0.5초 대기
			try { Thread.sleep(1000L * 10); } 
			catch(Exception e) { ;; }
		} // for

		//-------------------------------------
		// 3. 총 5번 반복해서, console에 '띵' 문자를 출력
		for(int i=0; i<5; i++) {
			System.out.println("띵");

			// 매번 비프음을 울리기전에, 0.5초 대기
			try { Thread.sleep(500); } 
			catch(Exception e) { ;; }
		} // for
		
	} // main

} // end class
