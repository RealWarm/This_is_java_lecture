package sec08.exam01_method_declaration;


public class Calculator {
	
	
	//메소드
	void powerOn() { // 리턴값이 없음(void)
		System.out.println("전원을 켭니다.");
	} // powerOn
	
	//----------------------------------//
	
	int plus(int x, int y) {
		int result = x + y;
		
		return result;		// 리턴값을 반환
	} // plus
	
	double plus(double x, double y) {
		double result = x + y;
		
		return result;		// 리턴값을 반환
	} // plus
	
	float plus(float x, float y) {
		float result = x + y;
		
		return result;		// 리턴값을 반환
	} // plus
	
	//----------------------------------//
	
	double divide(int x, int y) {
		double result = (double)x / y;
		
		return result;		// 리턴값을 반환
	} // divide
	
	//----------------------------------//
	
	void powerOff() {	// 리턴값이 없음(void)
		System.out.println("전원을 끕니다");
		
		return;
	} // powerOff
	
} // end class
