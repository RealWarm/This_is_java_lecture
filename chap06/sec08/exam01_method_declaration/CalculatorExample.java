package sec08.exam01_method_declaration;


public class CalculatorExample {
	
	
	public static void main(String[] args) {
		Calculator myCalc = new Calculator();
		
		//---------------------------------//
		// �޼ҵ� ȣ��
		myCalc.powerOn();
		
		//---------------------------------//
		// �޼ҵ� ȣ��
		Integer result1 = myCalc.plus(5, 6);
		Double result2 = myCalc.plus(5.0, 6.0);
		
		System.out.println("result1: " + result1);
		
		//---------------------------------//
		
		byte x = 10;
		byte y = 4;
		
		// �޼ҵ� ȣ��
		myCalc.divide(x, y); 
		
//		System.out.println("result2: " + result2);
		
		//---------------------------------//
		
		// �޼ҵ� ȣ��
		myCalc.powerOff(); 
	} // main
	
} // end class
