package sec04.exam01_arithmetic;

public class AccuracyExample1 {
	
	public static void main(String[] args) {
		int apple = 1;
		int number = 7;
		
		double pieceUnit = 0.1;		
		double result = apple - number*pieceUnit;
		
		System.out.println("��� �Ѱ����� ");
		System.out.println("0.7 ������ ����, ");
		System.out.println(result + " ������ ���´�.");
		
		System.out.println(1 - 7 * 0.1);
	} // main
	
} // end class

