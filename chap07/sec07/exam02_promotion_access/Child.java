package sec07.exam02_promotion_access;


public class Child extends Parent {
	
	
	@Override
	public void method2() {
		System.out.println("- Child::method2() invoked.");
	} // method2
	
	public void method3() {
		System.out.println("- Child::method3() invoked.");
	} // method3
	
} // end class
