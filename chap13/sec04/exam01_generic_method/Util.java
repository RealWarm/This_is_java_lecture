package sec04.exam01_generic_method;


// �̷���, �ٸ� ������ ����� �����ϴ� �뵵�� ����� Ŭ������
// �츮��, ��ƿ��Ƽ Ŭ���� ��� �θ���, ����, �������� ����
// �ϴ� �޼ҵ�(����, �����޼ҵ�� ����)�� ������ �ֽ��ϴ�.
public class Util {	// ��ƿ��Ƽ Ŭ���� ����
	
	
	// �̰� �ٷ�, Ÿ���Ķ���͸� ������ ������ �޼ҵ� ����
	public static <T> Box<T> boxing(T t) {
		Box<T> box = new Box<T>(); // *** ���� ****//
		
		box.set(t);
		
		return box;
	} // boxing
	
} // end class
