package sec08.exam01_method_declaration;


public class Calculator {
	
	
	//�޼ҵ�
	void powerOn() { // ���ϰ��� ����(void)
		System.out.println("������ �մϴ�.");
	} // powerOn
	
	//----------------------------------//
	
	int plus(int x, int y) {
		int result = x + y;
		
		return result;		// ���ϰ��� ��ȯ
	} // plus
	
	double plus(double x, double y) {
		double result = x + y;
		
		return result;		// ���ϰ��� ��ȯ
	} // plus
	
	float plus(float x, float y) {
		float result = x + y;
		
		return result;		// ���ϰ��� ��ȯ
	} // plus
	
	//----------------------------------//
	
	double divide(int x, int y) {
		double result = (double)x / y;
		
		return result;		// ���ϰ��� ��ȯ
	} // divide
	
	//----------------------------------//
	
	void powerOff() {	// ���ϰ��� ����(void)
		System.out.println("������ ���ϴ�");
		
		return;
	} // powerOff
	
} // end class
