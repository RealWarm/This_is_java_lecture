package sec03.exam01_name_implement_class;


public class RemoteControlExample {

	
	public static void main(String[] args) {
		RemoteControl rc;		// ����Ÿ���� ��������
		
		// ������-1:
		// �θ�Ÿ���� ��������, �ڽİ�ü�� ���԰����� ����
		// ������-2:
		// ������-1�� ������ ���¿���, �θ�Ÿ���� ������,
		// �θ�Ÿ�Կ� ����� �޼ҵ� ȣ��ÿ�, �θ�Ÿ����
		// �޼ҵ尡 ȣ��Ǵ°��� �ƴ϶�, �ڽİ�ü�� �������̵�
		// �� �޼ҵ尡 ȣ��ȴ�!!!(�θ�޼ҵ�� ��������)
		rc = new Television();	// ������-1 how ?
		System.out.println("1. rc: "+ rc);
		
		// ������-2
		rc.turnOn();
		rc.setMute(true);
		rc.turnOff();
		
		rc = new Audio();		// ������-1 how ?
		System.out.println("2. rc: "+ rc);
		
	} // main
	
} // end class
