package sec03.exam02_arguments;


public class MyMethodReferencesExample {
	
	
	public static void main(String[] args) {
		MyFunctionalInterface fi;
		
		//-----------------------------//
		fi = (int x) -> {
			;;
		};
		
		fi= (x) -> {
			int result = x * 5;
			
			System.out.println(result);
		}; // 람다식을 통한, 익명구현객체생성
		
		fi.method(2); // 추상메소드 호출
		
		//-----------------------------//
		
		fi = (x) -> { 
			System.out.println( x * 5 ); 
		}; // 람다식을 통한, 익명구현객체생성
		
		fi.method(2); // 추상메소드 호출
		
		//-----------------------------//
		
		// 람다식을 통한, 익명구현객체생성
		fi = x -> System.out.println( x * 5 );
		
		fi.method(2); // 추상메소드 호출
		
		//-----------------------------//
	} // main
}











