package sec06.exam03_join;


public class JoinExample {
	
	
	public static void main(String[] args) {
		// Worker Thread ���� �� ����(����)
		SumThread sumThread = new SumThread();
		sumThread.start();
		
		//---------------------------//
		// Thread Ŭ������ join() �޼ҵ��� ������
		// �ٸ� �������� ���Ḧ ��ٸ��� ����!!!!
		// ��, 1~100������ ������ ���� ���ϴ� �����尡 ����
		// �ɶ����� ��ٸ�(���� ��ٸ��°�? main ������)
		try { sumThread.join(); } 
		catch (InterruptedException e) {;;}
		
		// ������� ������ ������, ���������� ���� ���
		System.out.println(
			"1~100 ��: " + sumThread.getSum() // getter
		);
	} // main
	
} // end class

