package sec05.exam03_supplier;

import java.util.function.IntSupplier;


public class SupplierExample {
	
	
	public static void main(String[] args) {
		//-----------------------------------
		// IntSupplier 함수적 인터페이스 사용
		//-----------------------------------
		IntSupplier intSupplier = () -> {
			int num = (int) (Math.random() * 6) + 1;
			
			return num;
		}; // 람다식으로 익명구현객체를 생성
		
		//추상메소드호출
		int num = intSupplier.getAsInt(); 
		
		System.out.println("눈의 수: " + num);
		
		
		//-----------------------------------
		// IntSupplier 함수적 인터페이스 대체구현
		//-----------------------------------
		
		// What to do?
		
		// 4조
		
		IntSupplier intSupplier2
				= new IntSupplier() {
			private String name="name";
			private int age=44;
			

			@Override
			public int getAsInt() {
				
//				int num2
//					= (int) (Math.random() * 6) + 1;
//				
//				return num2;
				
				method1();
				method2();
				
				return 1;
			} // getAsInt
			
			private void method1() {
				;;
			}
			
			private void method2() {
				;;
			}
			
		}; // 익명구현객체를 생성하는 코딩기법
		int num2 = intSupplier2.getAsInt();
		System.out.println("눈의 수: " + num2);
		
		
	} // main
	
} // end class
