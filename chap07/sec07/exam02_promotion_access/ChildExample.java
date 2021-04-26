package sec07.exam02_promotion_access;

public class ChildExample {
	
	
	public static void main(String[] args) {
		  Child child = new Child();

		  Parent parent = child;	// 다형성-1 !!!
		  //--------------------------//

		  parent.method1();			// 아무것도 아님
		  //--------------------------//

		  parent.method2();			// 다형성-2 !!!
		  //--------------------------//

		  //parent.method3();  		// 호출 불가능 (X)
	} // main
	
} // end class
