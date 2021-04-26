package sec03.exam01_promotion;


public class PromotionExample {
	
	public static void main(String[] args) {	
		byte byteValue = 10;
		
		// 자동형변환발생 (byte -> int, 1byte -> 4byte)
		int intValue = byteValue; 
		
		System.out.println(intValue);
		
		//-----------------------------//
		
		char charValue = '가';
		
		// 자동형변환발생 (char -> int, 2byte -> 4byte)
		intValue = charValue;
		
		System.out.println("가의 유니코드=" + intValue);
		
		//-----------------------------//
		
		intValue = 500;
		// 자동형변환발생 (int -> long, 4byte -> 8byte)
		long longValue = intValue;
		
		System.out.println(longValue);	
		
		//-----------------------------//	
		
		intValue = 200;
		// 자동형변환발생 (int -> double, 정수 -> 실수)
		double doubleValue = intValue;
		
		System.out.println(doubleValue);		
	} // main
	
} // end class
