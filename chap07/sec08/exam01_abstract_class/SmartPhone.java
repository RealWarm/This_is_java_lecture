package sec08.exam01_abstract_class;


public class SmartPhone extends Phone {
	// 1. �ʵ�
	
	
	// 2. ������
	public SmartPhone(String owner) {
		super(owner); // �θ� Ŭ������ ������ ȣ��..��?
		// �ڽİ�ü���� �׻� �θ�ü�� �켱 �����Ǿ�� ��!
		// �θ���� �ڽ��̶� ������ �� ������ ��������!!!
	} // constructor
		
	// 3. �޼ҵ�
	public void internetSearch() {
		System.out.println("���ͳ� �˻��� �մϴ�.");
	} // internetSearch
	
} // end class


