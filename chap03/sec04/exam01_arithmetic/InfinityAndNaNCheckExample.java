package sec04.exam01_arithmetic;


public class InfinityAndNaNCheckExample {

	
	public static void main(String[] args) {
		
//		System.out.println(-5 / 0.0);
		int x = 5;
		
		double y = 0.0;
		double z = x / y;
		//double z = x % y;

		System.out.println("- z: " + z);
		System.out.println(Double.isInfinite(z));
		System.out.println(Double.isNaN(z));	
//		
//		//잘못된 코드
//		System.out.println(z + 2);	
//		
//		//알맞은 코드
//		if(Double.isInfinite(z) || Double.isNaN(z)) { 
//			System.out.println("값 산출 불가"); 
//		} else { 
//			System.out.println(z + 2); 
//		} // if-else
		
		//---------------------------------------------------
		
		/*int x = 5;
		int y = 0;
		
		try {
			//int z = x / y;
			int z = x % y;
			
			System.out.println("z: " + z);
		} catch(ArithmeticException e) {
			System.out.println("0으로 나누면 안됨");
		}*/
	} // main
	
} // end class

