package sec08.exam02_abstract_method;


public class Dog extends Animal {
	
	
	public Dog() {
		this.kind = "������";
	} // constructor

	/*
	 * �θ�κ��� ��������, �������� �԰ݿ� ���Ͽ�
	 * ������ (by overriding)
	 * �� �԰��� �������� ������, �ڽ�Ŭ��������
	 * ������ ������ �߻�
	 * 
	 */
	@Override
	public void sound() {
		System.out.println("�۸�");
	} // sound
	
} // end class





