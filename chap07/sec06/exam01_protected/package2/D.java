package sec06.exam01_protected.package2;

import sec06.exam01_protected.package1.A;


public class D extends A {
	
	
	public D() {
		//�ݵ�� ù���ο� ���;� �� 
		//��������-�̶����� �ڹ������Ϸ��� �ڵ带 ���� �־���
		super();		// �θ������ȣ��
		
		this.field = "value";
		this.method();
	} // constructor
	
} // end class
