package sec08.exam01_method_declaration;


public class CalculatorExample {
	
	
	public static void main(String[] args) {
		Calculator myCalc = new Calculator();
		
		//---------------------------------//
		// 메소드 호출
		myCalc.powerOn();
		
		//---------------------------------//
		// 메소드 호출
		Integer result1 = myCalc.plus(5, 6);
		Double result2 = myCalc.plus(5.0, 6.0);
		
		System.out.println("result1: " + result1);
		
		//---------------------------------//
		
		byte x = 10;
		byte y = 4;
		
		// 메소드 호출
		myCalc.divide(x, y); 
		
//		System.out.println("result2: " + result2);
		
		//---------------------------------//
		
		// 메소드 호출
		myCalc.powerOff(); 
	} // main
	
} // end class
