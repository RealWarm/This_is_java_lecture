package sec04.exam01_generic_method;


public class BoxingMethodExample {
	
	
	public static void main(String[] args) {
		//---------------------------------//
		// ���׸� �޼ҵ� ȣ��ÿ�, Ÿ�� �Ķ���Ϳ�
		// ��üŸ�� ����!!!
		//---------------------------------//
		// ���׸� �޼ҵ� ȣ���� - 1
		//   - ��������� ��üŸ�� �����Ͽ� ȣ��
		//---------------------------------//
		Box<Integer> box1 = 
				Util.<Integer>boxing(100);
		
//		Box box1 = Util.boxing(100);
		
		int intValue = box1.get();

		//---------------------------------//
		// ���׸� �޼ҵ� ȣ���� - 2
		//   - ���������� ��üŸ���� �����Ͽ� ȣ��
		//---------------------------------//		
		Box<String> box2 = Util.boxing("ȫ�浿");
		
		String strValue = box2.get();
	} // main
	
	
	
	
	
	
	
	
} // end class
