package sec08.exam01_abstract_class;


public class PhoneExample {
	
	
	public static void main(String[] args) {
		//�߻�Ŭ�����κ��� ���� new �����ڷ� ��ü ���� �õ�!!!
//		Phone phone = new Phone(); // X
		
		// ������-1
		Phone smartPhone = new SmartPhone("ȫ�浿");
		System.out.println("1. smartPhone: " + smartPhone);
		
		// �߻�Ŭ�����κ��� ��ӹ��� �޼ҵ�(��, ������ �ǹ�!)
		smartPhone.turnOn();	
		
		SmartPhone sp = (SmartPhone) smartPhone;
		sp.internetSearch(); // �ڽİ�ü�� �������
		
		// �߻�Ŭ�����κ��� ��ӹ��� �޼ҵ�(��, ������ �ǹ�!)
		smartPhone.turnOff();
	} // main
	
} // end class
