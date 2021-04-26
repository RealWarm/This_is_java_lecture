package sec06.exam03_join;


public class JoinExample {
	
	
	public static void main(String[] args) {
		// Worker Thread 생성 및 구동(시작)
		SumThread sumThread = new SumThread();
		sumThread.start();
		
		//---------------------------//
		// Thread 클래스의 join() 메소드의 역할은
		// 다른 스레드의 종료를 기다리는 것임!!!!
		// 즉, 1~100까지의 숫잡의 합을 구하는 스레드가 종료
		// 될때까지 기다림(누가 기다리는가? main 스레드)
		try { sumThread.join(); } 
		catch (InterruptedException e) {;;}
		
		// 연산수행 스레드 종료후, 연산결과값을 얻어내어 출력
		System.out.println(
			"1~100 합: " + sumThread.getSum() // getter
		);
	} // main
	
} // end class

