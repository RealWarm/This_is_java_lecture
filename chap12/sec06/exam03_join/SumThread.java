package sec06.exam03_join;


public class SumThread 
	extends Thread {
	
	private long sum;	// �������� �����ϴ� �ʵ�
	
	
	public long getSum() {
		return sum;
	} // getter

	public void setSum(long sum) {
		this.sum = sum;
	} // setter

	@Override
	public void run() {
		
		// 1 ~ 100 ������ ������ �������� ���ϴ� ����
		for(int i=1; i<=100; i++) {
			sum += i;
			
			try {
				Thread.sleep(1000L*5);
			} catch (InterruptedException e) {;;}
		} // for
		
	} // run
	
} // end class

