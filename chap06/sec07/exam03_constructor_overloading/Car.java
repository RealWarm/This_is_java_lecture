package sec07.exam03_constructor_overloading;

// ������ �����ε�(overloading) : ������ �̸��� ������
// �� �� �̻��� �����ڸ� �����ϴ� ��.
// �̶� �� �������� �Ű������� Ÿ��/����/������ ��� ������
// ������ ���� �߻�!!!!
public class Car {	// public : ����
	//�ʵ�
	String company = "�����ڵ���";	// �ʱ�ȭ�� �ʵ�
	String model;					// ���ʱ�ȭ�� �ʵ�	
	String color;					// ���ʱ�ȭ�� �ʵ�
	int maxSpeed;					// ���ʱ�ȭ�� �ʵ�
	
	
	// �⺻�����ڴ�, �Ű������� ����, ��� ���ο��� �ƹ��͵�
	// �������� ����
	Car() {
		;;
	} // default constructor
	
	//-----------------------------//
	
	Car(String model) {			// ������ �Ű����� 1��
		this.model = model;		// �ʵ� �ʱ�ȭ ����
	} // constructor2
	
	//-----------------------------//
	
	Car(String model, String color) {
		// ������ �Ű����� 2��
		this.model = model;		// �ʵ� �ʱ�ȭ ����
		this.color = color;		// �ʵ� �ʱ�ȭ ����
	} // constructor3
	
	//-----------------------------//
	
	Car(String model, String color, int maxSpeed) {
		// ������ �Ű����� 3��
		this.model = model;			// �ʵ� �ʱ�ȭ ����
		this.color = color;			// �ʵ� �ʱ�ȭ ����
		this.maxSpeed = maxSpeed;	// �ʵ� �ʱ�ȭ ����
	} // constructor4
	
} // end class


