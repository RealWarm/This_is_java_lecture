package sec08.exam01_method_declaration;


public class ComputerExample {
	
	
	public static void main(String[] args) {
		Computer myCom = new Computer(); // 哪腔磐 按眉积己
		
		int[] values1 = {1, 2, 3}; // 硅凯府磐凡 按眉积己

		//------------------------------------------//
		int result1 = myCom.sum1(values1);
		System.out.println("result1: " + result1);
		//------------------------------------------//
		int result2 = myCom.sum1(new int[]{1, 2, 3, 4, 5});
		System.out.println("result2: " + result2);
		//------------------------------------------//
		int result3 = myCom.sum2(1, 2, 3);
		System.out.println("result3: " + result3);
		//------------------------------------------//
		int result4 = myCom.sum2(1, 2, 3, 4, 5);
		int result5 = myCom.sum2();
		int result6 = myCom.sum2(new int[]{1,2,3});
		
//		int[] values = new int[]{1,2,3};
		
		
		
		System.out.println("result4: " + result4);
		System.out.println("result5: " + result5);
		System.out.println("result6: " + result6);
	} // main
	
} // end class
