package sec03_try_catch_finally;

import java.io.IOException;

public class TryCatchFinallyExample {
	
	
	public static void main(String[] args) {

//		try {
//			
//			Class clazz = 
//				Class.forName("java.lang.String2");
//			
//		} catch(ClassNotFoundException e) {
//			
//			System.out.println(
//					"클래스가 존재하지 않습니다.");
//			
//		} // try-catch
		
		try {
			staticMethod3();
			
//			return;
			System.exit(1);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Goodbye!!!");
		} //try-catch-finally
		
	} // main
	
	public static void staticMethod1() 
		throws IOException, NumberFormatException {	// Checked 예외를 던짐
		;;
	} // staticMethod1
	
	public static void staticMethod2() 
		throws RuntimeException { // 예외없음
		
		throw new RuntimeException("TEST");
		
	} // staticMethod2
	
	public static void staticMethod3() 
		throws RuntimeException {	// 실행예외 던짐
		;;
	} // staticMethod3
	
	
	
	
	
} // end class









