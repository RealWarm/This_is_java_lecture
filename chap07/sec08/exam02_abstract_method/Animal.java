package sec08.exam02_abstract_method;


public abstract class Animal {
	public String kind;		// ������ ����
	
	
	// ��� ������ ��ҷ� ���� ����� �մϴ�.
	public void breathe() {
		System.out.println("���� ���ϴ�.");
	} // breathe

	// �߻� �޼ҵ�!!!!
	// �̰��̾� ����, �ڽ� Ŭ������ �ݵ�� ���Ѿ���
	// "�԰�"�� �����, �����ϴ� ������!!!!! (********)
	// �� Ŭ������ �θ�� ���, ��� �ڽ� Ŭ��������
	// �� �߻�޼ҵ带 �ݵ�� �����ؾ���!!!
	// �������� ������ ---> ������ �����߻�!!!
	// �����ϴ� ��� --> �ڽ� Ŭ�������� �� �߻�޼ҵ带
	// �������̵�(Overriding) �ؾ� ��!!!
	public abstract void sound();
	
} // end class





