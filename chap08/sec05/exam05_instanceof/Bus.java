package sec05.exam05_instanceof;


public class Bus 
	implements Vehicle {
	
	
	// �������̽��� ����� �߻�޼ҵ�(�԰�)�� ����(������)
	@Override
	public void run() {
		System.out.println("������ �޸��ϴ�.");
	} // run
	
	// ��ü �ν��Ͻ� �޼ҵ�
	public void checkFare() {
		System.out.println("��������� üũ�մϴ�.");
	} // checkFare
	
} // end class
