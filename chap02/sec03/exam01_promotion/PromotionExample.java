package sec03.exam01_promotion;


public class PromotionExample {
	
	public static void main(String[] args) {	
		byte byteValue = 10;
		
		// �ڵ�����ȯ�߻� (byte -> int, 1byte -> 4byte)
		int intValue = byteValue; 
		
		System.out.println(intValue);
		
		//-----------------------------//
		
		char charValue = '��';
		
		// �ڵ�����ȯ�߻� (char -> int, 2byte -> 4byte)
		intValue = charValue;
		
		System.out.println("���� �����ڵ�=" + intValue);
		
		//-----------------------------//
		
		intValue = 500;
		// �ڵ�����ȯ�߻� (int -> long, 4byte -> 8byte)
		long longValue = intValue;
		
		System.out.println(longValue);	
		
		//-----------------------------//	
		
		intValue = 200;
		// �ڵ�����ȯ�߻� (int -> double, ���� -> �Ǽ�)
		double doubleValue = intValue;
		
		System.out.println(doubleValue);		
	} // main
	
} // end class
