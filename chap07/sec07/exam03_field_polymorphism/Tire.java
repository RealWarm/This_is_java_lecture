package sec07.exam03_field_polymorphism;


public class Tire {
	//�����ʵ�
	public int maxRotation;     	//�ִ� ȸ����(�ִ����)
	public String location;       	//Ÿ�̾��� ��ġ
	
	public int accumulatedRotation;	//���� ȸ����

	
	//������
	public Tire(String location, int maxRotation) {
		this.location = location;
		this.maxRotation = maxRotation;
	} // constructor

	//�޼ҵ�
	public boolean roll() {
		++accumulatedRotation;
		
		if(accumulatedRotation < maxRotation) {
			System.out.println(
				location + 
				" Tire ����: " + 
				(maxRotation-accumulatedRotation) + 
				"ȸ"
			);
			
			return true;
		} else {
			System.out.println(
				"*** " + location + " Tire ��ũ ***"
			);
			
			return false;
		} // if-else
	} // roll
	
} // end class

