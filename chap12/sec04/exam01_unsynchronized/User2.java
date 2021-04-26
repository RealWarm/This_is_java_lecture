package sec04.exam01_unsynchronized;

public class User2 extends Thread {	
	private Calculator calculator; // ������ü�� ���������ʵ�	
	
	
	public void setCalculator(Calculator calculator) {
		this.setName("User2");	// ������ �̸� ����
		
		// ������ü�� ������ �ʵ忡 ����
		this.calculator = calculator; 
	} // setter
	
	@Override
	public void run() {
		System.out.println("- User2::run() invoked.");
		
		calculator.setMemory(50); // �������� �ʵ忡 ����
	} // run
	
} // end class
