package sec04.exam01_field;


public class UsingThisExample {
	
	
	public static void main(String... args) {
		// ���� �ٱ��� Ŭ������ UsingThis �� ��ü�� ����
		UsingThis usingThis = new UsingThis();
		
		// UsingThis �ȿ� ����� ��ø Ŭ������ Inner��
		// ��ü�� ����
		UsingThis.Inner inner = usingThis.new Inner();
		
		inner.method();
	} // main
	
} // end class

