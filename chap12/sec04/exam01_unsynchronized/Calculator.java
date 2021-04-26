package sec04.exam01_unsynchronized;


// 여러 쓰레드에 의해서 공유되는 전자계산기 객체임
public class Calculator {
	private int memory;			// 연산결과를 보관하는 필드

	
	public int getMemory() {
		return memory;
	} // getter

	
	public synchronized void setMemory(int memory) {
		System.out.println(
			"- Calculator::setMemory("+memory+") invoked.");
		
//		synchronized(this) {
			this.memory = memory; // 1. 연산결과를 필드에 보관
			
			// 2. 500초동안 대기상태(sleep)
			try { Thread.sleep(1000L * 500); } 
			catch(InterruptedException e) {;;}
			
			// 3. 필드에 보관한 연산결과 출력 + 현재 처리 스레드 이름
			System.out.println(
				/* 현재 처리 스레드의 이름출력 */
				Thread.currentThread().getName() + 
				": " +  
				this.memory		/* 연산결과 필드 출력 */
			);
			
			instanceMethod();
			Calculator.staticMethod();
//		} // 임계영역(Critical Section) #1
		
		
		
	} // setter
	
	
	public synchronized void instanceMethod() {
		System.out.println("- Calculator::instanceMethod() invoked.");
		
		;; // Critical Section #2
	} // instanceMethod
	
	
	public synchronized static void staticMethod() {
		System.out.println("- Calculator::staticMethod() invoked.");
		
		;; // Critical Section #3
	} // instanceMethod
	
} // end class

