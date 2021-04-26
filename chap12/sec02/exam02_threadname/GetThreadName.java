package sec02.exam02_threadname;

public class GetThreadName {
	
	public static void main(String... args) {
		
		// 현재 이 실행문장을 수행시키고 있는 스레드 객체의
		// 참조값을 가진 객체를 반환.
		// return type: Thread
		Thread t = Thread.currentThread();
		
		System.out.println("- t: "+ t);
		System.out.println("- t's name: "+ t.getName());
		
	} // main

} // end class
