package sec05.exam01_bounded_type;


public class BoundedTypeParameterExample {
	
	
	public static void main(String[] args) {
		//------------------------------------//
		// ���ѵ� ������ Ÿ��(<T extends Number>)�� 
		// ������ ����.
		// ���׸� �޼ҵ� ȣ���� �ΰ��� ��, 2��° ���
		// ��, ��üŸ�� ���� ����
		//------------------------------------//
		// String str = Util.compare("a", "b"); (x)
		
		//------------------------------------//
		// ���׸� �޼ҵ� ȣ���� �ΰ��� ��, 2��° ���
		// ��, ��üŸ�� ���� ����
		
		int result1 = Util.compare(10, 20);
		System.out.println("1. "+result1);
		
		//------------------------------------//
		// ���׸� �޼ҵ� ȣ���� �ΰ��� ��, 2��° ���
		// ��, ��üŸ�� ���� ����
		
		int result2 = Util.compare(4.5, 3);
		System.out.println("2. "+result2);
		
		//------------------------------------//
		// ���׸� �޼ҵ� ȣ���� �ΰ��� ��, 2��° ���
		// ��, ��üŸ�� ���� ����
		
		int result3 = Util.compare(6, 6);
		System.out.println("3. "+result3);
	} // main
	
} // end class
