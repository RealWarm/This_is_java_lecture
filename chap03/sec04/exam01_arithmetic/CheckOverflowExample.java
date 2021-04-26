package sec04.exam01_arithmetic;

public class CheckOverflowExample {
	
	
	public static void main(String[] args) {
//		System.out.println(
//		"- 1. Integer.MAX_VALUE: "+
//				Integer.MAX_VALUE);		// 2147483647
//		
//		int op1 = 2000000000;
//		int op2 = 2000000000;		// 2147483647
//		int result = op1 + op2;		// 4000000000
//		
//		System.out.println("- result: "+ result);
		
		//--------------------------------------------//
		
		System.out.println(
		"- 2. Integer.MIN_VALUE: "+
				Integer.MIN_VALUE);		// -2147483648
		
		int op1 = -2000000000;
		int op2 = -2000000000;		// -2147483648
		int result = op1 + op2;		// -4000000000
		
		System.out.println("- result: "+ result);
		
		
		
		
		
		
//		
//		System.out.print(op1 + op2);
		
//		try {
//			System.out.println(
//				"- 1. Integer.MAX_VALUE: "+
//						Integer.MAX_VALUE);
//			System.out.println(
//				"- 2. Integer.MIN_VALUE: "+
//						Integer.MIN_VALUE);
//			
//			int result = safeAdd(2000000000, 2000000000);
//			
//			System.out.println(result);
//		} catch(ArithmeticException e) {
//			System.out.println(
//					"오버플로우가 발생하여 정확하게 계산할 수 없음");
//		} // try-catch
//	} // main
	
	
//	public static int safeAdd(int 피연산자1, int 피연산자2)  {
//		if( 피연산자2 > 0 ) {
//			System.out.println(
//					"- temp: "+ (Integer.MAX_VALUE - 피연산자2));
//			// temp: 147483647
//			
//			if(피연산자1 > (Integer.MAX_VALUE - 피연산자2)) {
//				throw new ArithmeticException("오버플로우 발생");
//			} // nested if
//			
//		} else {
//			
//			if(피연산자1 < (Integer.MIN_VALUE - 피연산자2)) {
//				throw new ArithmeticException("오버플로우 발생");
//			} // nested if
//			
//		} // outer if-else
//		
////		return left + right;
//	} // safeAdd
	
	} // main
	
} // end class
