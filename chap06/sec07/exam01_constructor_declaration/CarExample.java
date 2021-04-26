package sec07.exam01_constructor_declaration;

import java.util.Vector;

public class CarExample {
	
	public static void main(String[] args) 
		throws InterruptedException {
		
		// 기본 생성자는 더이상 업기 때문에, 
		// 이를 호출시, 컴파일오류 발생
		//Car myCar = new Car();  (x)
		
		Vector v = new Vector();
		
		for(;;) {
			// 명시적으로 선언한 생성자를 사용하여 객체 생성
			Car myCar = new Car("검정", 3000);
			System.out.println("- myCar: "+myCar);
			
			v.add(myCar);
			
			Thread.sleep(50);
		} //for
		
	} //main
	
} // end class
