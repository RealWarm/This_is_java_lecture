package sec02.exam01_inheritance;


public class CellPhone {
	//�ʵ�
	String model;
	String color;
	
	
	
	//������
	public CellPhone(String model, String color) {
		System.out.println(
			"- CellPhone::CellPhone invoked."
		);
		
		this.model = model;
		this.color = color;
	} //default constructor
	
	
	//�޼ҵ�
	void powerOn() { 
		System.out.println("������ �մϴ�."); 
	} // powerOn
	
	void powerOff() { 
		System.out.println("������ ���ϴ�."); 
	} // powerOff
	
	void bell() { 
		System.out.println("���� �︳�ϴ�."); 
	} // bell
	
	void sendVoice(String message) { 
		System.out.println("�ڱ�: " + message); 
	} // sendVoice
	
	void receiveVoice(String message) { 
		System.out.println("����: " + message); 
	} // receiveVoice	
	
	void hangUp() { 
		System.out.println("��ȭ�� �����ϴ�."); 
	} // hangUp
	
} // end class

