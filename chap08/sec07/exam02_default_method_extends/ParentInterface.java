package sec07.exam02_default_method_extends;


public interface ParentInterface {
	// 1. 상수 (불변의 진리값, public static final)
	
	// 2. 추상 메소드 (public abstract)
    public abstract void method1();
    
    // 3. Default 메소드 (public)
    public default void method2() {
    	System.out.println(
    			"- ParentInterface::method2 invoked.");
    } // default method2
    
    // 4. static 메소드(public)
    // public static void staticMethod() { .. }
    
} // end interface

