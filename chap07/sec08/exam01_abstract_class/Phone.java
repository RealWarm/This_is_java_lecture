package sec08.exam01_abstract_class;



public abstract class Phone {
	//1. �ʵ�
	public String owner;
	
	
	//2. ������
	public Phone(String owner) {
		this.owner = owner;
	} // constructor
	
	//3. �޼ҵ�
	public void turnOn() {
		System.out.println("�� ������ �մϴ�.");
	} // turnOn
	
	public void turnOff() {
		System.out.println("�� ������ ���ϴ�.");
	} // turnOff
	
} // end class
