package sec03.exam01_priority;


public class PriorityExample {
	
	// **** �߿� ****
	// �������� �켱���� ���� : 1 ~ 10 ���� �Ҵ簡��(�⺻�� 5)
	public static void main(String[] args) {
		
		for(int i=1; i<=10; i++) {
			// �� 10���� ������ ����
			Thread thread = new CalcThread("thread" + i);
			
			// 1 ~ 9 ������ ������� �ְ�� ���� �켱�����ο�
			if(i != 10) {
				thread.setPriority(Thread.MIN_PRIORITY);
			} else {				
				// 10��° �����忡�� �ְ��� ���� �켱�����ο�
				thread.setPriority(Thread.MAX_PRIORITY);
			} // if-else
			
			thread.start(); // ������ ����(����)
		} // for
		
	} // main
	
} // end class

