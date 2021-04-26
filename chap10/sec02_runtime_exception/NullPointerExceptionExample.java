package sec02_runtime_exception;


public class NullPointerExceptionExample {
	
	
	public static void main(String[] args) {
//		String data = null;
//		
//		System.out.println(data.toString());
		
		method1();
	} // main
	
	public static void method1() {
		System.out.println("- method1 invoked.");
		
		method2();
	} //method1
	
	public static void method2() {
		System.out.println("- method2 invoked.");
		
		method3();
	} //method2
	
	public static void method3() {
		System.out.println("- method3 invoked.");
		
		method4();
	} //method3
	
	public static void method4() {
		System.out.println("- method4 invoked.");
		
		method5();
	} //method4
	
	public static void method5() {
		System.out.println("- method5 invoked.");
		
		String data = null;
		
		System.out.println(data.toString());
	} //method5
	
} // end class

