package sec07.exam01_why_default_method;


public interface MyInterface {
	// 1. ���(public static final)
	
	// 2. �߻�޼ҵ� (public abstract)
	public void method1();
	
	// 3. default �޼ҵ� (public default)
	public default void method2() {
		System.out.println(
				"- MyInterface::method2 invoked.");
	} // method2
	
	// 4. static �޼ҵ� (public static)
	
} // end interface
