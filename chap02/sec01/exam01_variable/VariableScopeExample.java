package sec01.exam01_variable;

public class VariableScopeExample {
	long price;		// 전역변수
	
	public static void main(String[] args) {
		int var1;    // 지역변수 선언
//		System.out.println("1. var1: "+ var1);
		
		if(true) {
			int var2;  // 지역변수
			
			var1 = 10;
			var2 = 20;
			
			System.out.println("1. var1: "+ var1);
			System.out.println("2. var2: "+ var2);
		} // if
		
		var1 = 10;		// 지역변수
//		var2 = 20;	/* 지역변수 */
		
		for(int i=0; i<1; i++) {
			int var3;
			
			var1 = 10;
			var3 = 30;
		} // for
		
		var1 = 10;		// 변수에 값을 할당
		//var3 = 30;	// 변수에 값을 할당
	} // main - Entry Point
	
} // end class
