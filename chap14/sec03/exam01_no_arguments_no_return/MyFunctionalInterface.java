package sec03.exam01_no_arguments_no_return;


@FunctionalInterface
public interface MyFunctionalInterface {
	public static final double PI = 3.14159;
	
	
    public abstract void method();	// �߻�޼ҵ� ����
    
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
//		}; // �͸�����ü�� �����ϴ� 1ù��° �ڵ����
//	} // main
//	
//} // end class

