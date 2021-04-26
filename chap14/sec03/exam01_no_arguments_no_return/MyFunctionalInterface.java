package sec03.exam01_no_arguments_no_return;


@FunctionalInterface
public interface MyFunctionalInterface {
	public static final double PI = 3.14159;
	
	
    public abstract void method();	// 추상메소드 선언
    
    // default method
    public default void defaultMethod() {
    	;;
    }
    
    // static method
    public static void staticMethod() {
    	;;
    }
//    public abstract void method2();
    
} // end interface


//class MyFunctionalImpl {
//
//	public static void main() {
//		MyFunctionalInterface obj =
//				new MyFunctionalInterface() {
//
//			@Override
//			public void method() {
//				;;
//			} // run
//			
//		}; // 익명구현객체를 생성하는 1첫번째 코딩기법
//	} // main
//	
//} // end class

