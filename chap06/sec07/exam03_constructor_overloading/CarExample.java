package sec07.exam03_constructor_overloading;


public class CarExample {
	
	
	public static void main(String[] args) {
		Car car1 = new Car(); // 새로운 Car객체생성
		
		//----------------------------------------//
		System.out.println(
				"car1.company : " + car1.company);
									// 객체의 필드 사용
		System.out.println(); // 1개의 공백라인 출력

		//----------------------------------------//
		Car car2 = new Car("자가용"); // 새로운 Car객체생성
		
		System.out.println(
				"car2.company : " + car2.company);
									// 객체의 필드 사용
		System.out.println("car2.model : " + car2.model);
									// 객체의 필드 사용
		System.out.println(); // 1개의 공백라인 출력

		//----------------------------------------//
		// 새로운 Car객체생성
		Car car3 = new Car("자가용", "빨강");
		
		System.out.println(
				"car3.company : " + car3.company);
									// 객체의 필드 사용
		System.out.println("car3.model : " + car3.model);
									// 객체의 필드 사용
		System.out.println("car3.color : " + car3.color);
									// 객체의 필드 사용
		System.out.println(); // 1개의 공백라인 출력

		//----------------------------------------//
		// 새로운 Car객체생성
		Car car4 = new Car("택시", "검정", 200);
		
		System.out.println(
				"car4.company : " + car4.company);
									// 객체의 필드 사용
		System.out.println("car4.model : " + car4.model);
									// 객체의 필드 사용
		System.out.println("car4.color : " + car4.color);
									// 객체의 필드 사용
		System.out.println(
				"car4.maxSpeed : " + car4.maxSpeed);
									// 객체의 필드 사용
	} // main
	
} // end class

