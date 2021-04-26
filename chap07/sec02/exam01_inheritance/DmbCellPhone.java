package sec02.exam01_inheritance;


public class DmbCellPhone extends CellPhone {
	//�ʵ�
	int channel;
	
	
	//������
	DmbCellPhone(
		String model, 
		String color, 
		int channel) {

		// �θ�Ŭ������ �����ڸ� ��������� ȣ��
		// �ݵ�� �ڽ� Ŭ������ ������ �ȿ���.. ȣ��..
		super(model, color);		
		
		this.model = model;
		this.color = color;
		this.channel = channel;
		
		System.out.println(
				"- DmbCellPhone::DmbCellPhone invoked."
			);
		
	} // constructor

	//�޼ҵ�
	void turnOnDmb() {
		System.out.println(
			"ä�� " + 
			channel + 
			"�� DMB ��� ������ �����մϴ�."
		);
	} // turnOnDmb
	
	void changeChannelDmb(int channel) {
		this.channel = channel;
		
		System.out.println(
			"ä�� " + 
			channel + 
			"������ �ٲߴϴ�."
		);
	} // changeChannelDmb
	
	void turnOffDmb() {
		System.out.println("DMB ��� ������ ����ϴ�.");
	} // turnOffDmb
	
} // end class

