package sec03.exam01_priority;


public class PriorityExample {
	
	// **** 중요 ****
	// 스레드의 우선순위 범위 : 1 ~ 10 까지 할당가능(기본은 5)
	public static void main(String[] args) {
		
		for(int i=1; i<=10; i++) {
			// 각 10개의 스레드 생성
			Thread thread = new CalcThread("thread" + i);
			
			// 1 ~ 9 까지의 스레드는 최고로 낮은 우선순위부여
			if(i != 10) {
				thread.setPriority(Thread.MIN_PRIORITY);
			} else {				
				// 10번째 스레드에만 최고의 높은 우선순위부여
				thread.setPriority(Thread.MAX_PRIORITY);
			} // if-else
			
			thread.start(); // 스레드 구동(시작)
		} // for
		
	} // main
	
} // end class

