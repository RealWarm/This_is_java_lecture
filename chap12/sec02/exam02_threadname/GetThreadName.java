package sec02.exam02_threadname;

public class GetThreadName {
	
	public static void main(String... args) {
		
		// ���� �� ���๮���� �����Ű�� �ִ� ������ ��ü��
		// �������� ���� ��ü�� ��ȯ.
		// return type: Thread
		Thread t = Thread.currentThread();
		
		System.out.println("- t: "+ t);
		System.out.println("- t's name: "+ t.getName());
		
	} // main

} // end class
