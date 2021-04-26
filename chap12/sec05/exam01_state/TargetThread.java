package sec05.exam01_state;


public class TargetThread 
	extends Thread {
	
	
	@Override
	public void run() {
		for(long i=0; i<1000000000; i++) {	// 1st. loop
//			System.out.print('.');
		} // for
		
		//-----------------------------//
		
		try {
			//1.5초간 일시 정지
			Thread.sleep(1500);
		} catch(Exception e) {;;}
		
		//-----------------------------//		
		
		for(long i=0; i<1000000000; i++) {	// 2nd. loop
//			System.out.print('.');
		} // for
	} // run
	
} // end class
