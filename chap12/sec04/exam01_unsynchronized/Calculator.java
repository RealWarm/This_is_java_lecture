package sec04.exam01_unsynchronized;


// ���� �����忡 ���ؼ� �����Ǵ� ���ڰ��� ��ü��
public class Calculator {
	private int memory;			// �������� �����ϴ� �ʵ�

	
	public int getMemory() {
		return memory;
	} // getter

	
	public synchronized void setMemory(int memory) {
		System.out.println(
			"- Calculator::setMemory("+memory+") invoked.");
		
//		synchronized(this) {
			this.memory = memory; // 1. �������� �ʵ忡 ����
			
			// 2. 500�ʵ��� ������(sleep)
			try { Thread.sleep(1000L * 500); } 
			catch(InterruptedException e) {;;}
			
			// 3. �ʵ忡 ������ ������ ��� + ���� ó�� ������ �̸�
			System.out.println(
				/* ���� ó�� �������� �̸���� */
				Thread.currentThread().getName() + 
				": " +  
				this.memory		/* ������ �ʵ� ��� */
			);
			
			instanceMethod();
			Calculator.staticMethod();
//		} // �Ӱ迵��(Critical Section) #1
		
		
		
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

