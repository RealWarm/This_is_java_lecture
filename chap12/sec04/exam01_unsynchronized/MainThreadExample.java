package sec04.exam01_unsynchronized;


public class MainThreadExample {
	
	
	public static void main(String[] args) {
		// 1. ������ü ����
		Calculator calculator = new Calculator();
		
		// 2. User1 ������ ��ü ���� �� ����(����)
		User1 user1 = new User1();
		user1.setCalculator(calculator); // ������ü��������
		user1.start();
		
		//---- �������� ���������� ���� ���� ����!!!

		// 3. User2 ������ ��ü ���� �� ����(����)
		User2 user2 = new User2();
		user2.setCalculator(calculator); // ������ü��������
		user2.start();
	} // main
	
} // end class
