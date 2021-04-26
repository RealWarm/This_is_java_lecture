package sec04.exam01_arithmetic;

public class AccuracyExample1 {
	
	public static void main(String[] args) {
		int apple = 1;
		int number = 7;
		
		double pieceUnit = 0.1;		
		double result = apple - number*pieceUnit;
		
		System.out.println("사과 한개에서 ");
		System.out.println("0.7 조각을 빼면, ");
		System.out.println(result + " 조각이 남는다.");
		
		System.out.println(1 - 7 * 0.1);
	} // main
	
} // end class

