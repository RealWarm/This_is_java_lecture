package sec07.exam01_why_default_method;


public class MyClassB 
	implements MyInterface {
	
	

	// �������̽��� ����� �߻�޼ҵ�(��, �԰�-��������)��
	// �����ϰ� ����
	@Override
	public void method1() {
		System.out.println(
				"- MyClassB::method1() invoked.");
	} // method1
	
	//***** �������̽��� ���ǵ� default �޼ҵ带 ������
	//      (Overriding) ��
	@Override
	public void method2() {
		System.out.println(
				"- MyClassB::method2() invoked.");
	} // method2
	
} // end class
