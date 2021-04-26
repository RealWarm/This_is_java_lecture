package sec04.exam01_unsynchronized;


public class User1 extends Thread {	
	private Calculator calculator;	// ������ü�� �����ʵ�
	
	
	// ������ü�� ���޹ޱ� ���� �뵵�� setter �޼ҵ�
	public void setCalculator(Calculator calculator) {
		this.setName("User1");  // �������� �̸� ����
		
		// ������ü�� �ʵ忡 ����
		this.calculator = calculator;  
	} // setter
	
	// User1 �������� �����ڵ���
	@Override
	public void run() {
		System.out.println("- User1::run() invoked.");
		
		calculator.setMemory(100);
	} // run
	
} // end class

