package sec03.exam03_accuracy;


public class FromIntToDouble { // 실행클래스
	
	
	// 메소드 시그니처
	public static void main(
			String[] args /* 매개변수 */) { // 메소드블록
		// 지역변수
		int num1 = 123456780;
		int num2 = 123456780;
		
		double num3 = num2;
		num2 = (int) num3;
		
		int result = num1 - num2;
		
		System.out.println("------ " + result);
	} // main
	
} // end class

