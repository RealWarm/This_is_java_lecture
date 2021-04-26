package sec08.exam01_method_declaration;


public class Computer {
	
	
	int sum1(int[] values) {	// 배열타입의 매개변수
		int sum = 0;
		
		for(int i=0; i<values.length; i++) {
			sum += values[i];
		} // for
		
		sum = 0;
		for(int value : values) {
			sum += value;
		} // enhanced for
		
		return sum;
	} // sum1
	
	int sum2(int... values) {	// 가변인자 메소드 선언
		int sum = 0;
		
		for(int i=0; i<values.length; i++) {
			sum += values[i];
		} // for
		
		sum = 0;
		for(int value : values) {
			sum += value;
		} // enhanced for				
		
		return sum;
	} // sum2
	
} // end class
