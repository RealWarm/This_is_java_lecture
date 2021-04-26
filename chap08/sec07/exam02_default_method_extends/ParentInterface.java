package sec07.exam02_default_method_extends;


public interface ParentInterface {
	// 1. ��� (�Һ��� ������, public static final)
	
	// 2. �߻� �޼ҵ� (public abstract)
    public abstract void method1();
    
    // 3. Default �޼ҵ� (public)
    public default void method2() {
    	System.out.println(
    			"- ParentInterface::method2 invoked.");
    } // default method2
    
    // 4. static �޼ҵ�(public)
    // public static void staticMethod() { .. }
    
} // end interface

