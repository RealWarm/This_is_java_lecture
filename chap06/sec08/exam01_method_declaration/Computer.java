package sec08.exam01_method_declaration;


public class Computer {
	
	
	int sum1(int[] values) {	// �迭Ÿ���� �Ű�����
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
	
	int sum2(int... values) {	// �������� �޼ҵ� ����
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
