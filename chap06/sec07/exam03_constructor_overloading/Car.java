package sec07.exam03_constructor_overloading;

// 생성자 오버로딩(overloading) : 동일한 이름을 가지는
// 한 개 이상의 생성자를 선언하는 것.
// 이때 각 생성자의 매개변수의 타입/개수/순서가 모두 같으면
// 컴파일 오류 발생!!!!
public class Car {	// public : 공용
	//필드
	String company = "현대자동차";	// 초기화된 필드
	String model;					// 미초기화된 필드	
	String color;					// 미초기화된 필드
	int maxSpeed;					// 미초기화된 필드
	
	
	// 기본생성자는, 매개변수도 없고, 블록 내부에서 아무것도
	// 수행하지 않음
	Car() {
		;;
	} // default constructor
	
	//-----------------------------//
	
	Car(String model) {			// 생성자 매개변수 1개
		this.model = model;		// 필드 초기화 수행
	} // constructor2
	
	//-----------------------------//
	
	Car(String model, String color) {
		// 생성자 매개변수 2개
		this.model = model;		// 필드 초기화 수행
		this.color = color;		// 필드 초기화 수행
	} // constructor3
	
	//-----------------------------//
	
	Car(String model, String color, int maxSpeed) {
		// 생성자 매개변수 3개
		this.model = model;			// 필드 초기화 수행
		this.color = color;			// 필드 초기화 수행
		this.maxSpeed = maxSpeed;	// 필드 초기화 수행
	} // constructor4
	
} // end class


