package sec07.exam01_why_default_method;


public class DefaultMethodExample {
	
	
	public static void main(String[] args) {
		// 1. ù��° ����Ŭ������, �������̽��� default
		//    �޼ҵ带 �ִ� �״�� ���
		MyInterface mi1 = new MyClassA();
		mi1.method1();
		mi1.method2();	//-> default method(ȣ�⺯������!!)
		
		//------------------------------------//
		
		// 2.�ι�° ����Ŭ������, �������̽��� default
		//   �޼ҵ带 ������(Overriding)�Ͽ� ���
		MyInterface mi2 = new MyClassB();
		mi2.method1();
		mi2.method2();	//-> default method(ȣ�⺯������!!)
		
	} // main
	
} // end class
