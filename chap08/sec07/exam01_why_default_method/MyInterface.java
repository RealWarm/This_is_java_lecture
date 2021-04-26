package sec07.exam01_why_default_method;


public interface MyInterface {
	// 1. 상수(public static final)
	
	// 2. 추상메소드 (public abstract)
	public void method1();
	
	// 3. default 메소드 (public default)
	public default void method2() {
		System.out.println(
				"- MyInterface::method2 invoked.");
	} // method2
	
	// 4. static 메소드 (public static)
	
} // end interface
