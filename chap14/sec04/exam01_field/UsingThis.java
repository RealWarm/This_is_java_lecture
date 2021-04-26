package sec04.exam01_field;


class A { ;; }
class B { ;; }


public class UsingThis {	
	public int outterField = 10;
	
	
	public void instanceMethod() {
		int age = 44;		// 지역변수 (local varible)
			
		class LocalClass {  // 로컬클래스(local class)
			;;
		} // end class: LocalClass
		
	} // instanceMethod

	//-----------------------------------//
	// 중첩 클래스 선언(Nested Class)
	//-----------------------------------//
	class Inner {
		int innerField = 20;

		
		void method() {
			
			//-- 람다식 시작 -----------------------//
			MyFunctionalInterface fi = () -> {	
				
				//----------------------//
				
				System.out.println(
					"****** this: " + this);
				
				//----------------------//
				
				System.out.println(
					"****** UsingThis.this: " + 
					UsingThis.this);
				
				//----------------------//
				
				System.out.println(
					"outterField: " + 
					outterField);
				
				/**** 주의 ****/
				System.out.println(
					"outterField: " + 
					UsingThis.this.outterField + 
					"\n");
				
				//----------------------//
				
				System.out.println(
					"innerField: " + 
					innerField);
				
				System.out.println(
					"innerField: " + 
					this.innerField + 
					"\n");
			}; // 람다식에 의한, 익명구현객체 생성
			//-- 람다식 끝 -----------------------//
			
			fi.method(); // 추상메소드 호출
			
		} // method
		
	} // end class: Inner
	
} // end class: UsingThis

