package sec07.exam02_default_method_extends;


public interface ChildInterface2 
	extends ParentInterface {
	
	
	@Override
	public default void method2() { 
		System.out.println(
				"- ChildInterface2::method2 invoked.");
	} //method2
	
	public abstract void method3();
	
} // end interface

