package sec04.exam01_arithmetic;

public class AccuracyExample2 {
	
	public static void main(String[] args) {
		int apple = 1;
		int number = 7;
		
		int totalPieces = apple * 10;		// 1 * 10
		int temp = totalPieces - number;	// 10 - 7 --> 3
		
		double result = temp/10.0;		// 3 / 10.0 
		
		System.out.println("��� �Ѱ����� ");
		System.out.println("0.7 ������ ����, ");
		System.out.println(result + " ������ ���´�.");
	} // main
	
} // end class
