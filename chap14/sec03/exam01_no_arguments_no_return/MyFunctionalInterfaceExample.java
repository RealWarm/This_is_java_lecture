package sec03.exam01_no_arguments_no_return;


public class MyFunctionalInterfaceExample {
	
	
	public static void main(String[] args) {
		MyFunctionalInterface fi;
		
		//------------------------------//
		// 람다식을 이용한, 익명구현객체 생성
		//------------------------------//
		fi= () -> { // 매개변수가 없고, 리턴값이 없음 
			String str = "method call1";
			System.out.println(str);
//			System.out.println("** this: "+ this);  // X
		}; // 람다식을 이용한, 익명구현객체 생성(다형성-1)
		
		System.out.println("1. fi: "+ fi);
		
		fi.method(); // 인터페이스의 추상메소드호출(다형성-2)
		
		
		//------------------------------//
		// 람다식을 이용한, 익명구현객체 생성
		//------------------------------//
		fi = () -> { // 매개변수가 없고, 리턴값이 없음
			System.out.println("method call2"); 
		}; // 람다식을 이용한, 익명구현객체 생성(다형성-1)
		
		System.out.println("2. fi: "+ fi);
		
		fi.method(); // 인터페이스의 추상메소드호출(다형성-2)
		
		
		//------------------------------//		
		// 람다식을 이용한, 익명구현객체 생성 (다형성-1)
		//------------------------------//	
		// 매개변수가 없고, 리턴값이 없음
		fi = () -> System.out.println("method call3");
		
		System.out.println("3. fi: "+ fi);
		
		fi.method(); // 인터페이스의 추상메소드호출(다형성-2)
	} // main
	
} // end class











