package sec10.exam04_singleton;


// Singleton Pattern
public class Singleton {
	private static Singleton singleton;
	
	
	static {
		singleton = new Singleton();
	} // static initializer
	
	// �ܺο��� ������ȣ����ϰ� ���� --> ��ü��������
	private Singleton() {	
		;;
	} // constructor
	
	// �ܺο���, �̱��� ��ü�� �ּҰ� �ʿ��� ������ ȣ��
	// �ϱ� ���� �޼ҵ� --> ��ȯ��: �̱��� ��ü�� �ּ�
	public static Singleton getInstance() {
		return singleton;
	} // getInstance
		
} // end class

