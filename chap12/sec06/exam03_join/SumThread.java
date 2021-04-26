package sec06.exam03_join;


public class SumThread 
	extends Thread {
	
	private long sum;	// 연산결과를 저장하는 필드
	
	
	public long getSum() {
		return sum;
	} // getter

	public void setSum(long sum) {
		this.sum = sum;
	} // setter

	@Override
	public void run() {
		
		// 1 ~ 100 까지의 숫자의 누적합을 구하는 연산
		for(int i=1; i<=100; i++) {
			sum += i;
			
			try {
				Thread.sleep(1000L*5);
			} catch (InterruptedException e) {;;}
		} // for
		
	} // run
	
} // end class

