package sec05.exam01_bounded_type;


// 공통기능을 정적메소드로 구현하여 가지고 있는 일반적인 클래스
// 를 유틸리티 클래스라고 하며, 다른 클래스들이 공통으로 사용하는
// 클래스를 의미
public class Util {	// 유틸리티 클래스(Utility Class)
	
	
	// Generic Method
	public 
		static 
		<T extends Number> /* Bounded type parameter */
		int 			   /* return type */
		compare(T t1, T t2) {
		
		double v1 = t1.doubleValue(); 
		//System.out.println(t1.getClass().getName());
		
		double v2 = t2.doubleValue();
		//System.out.println(t2.getClass().getName());
		
		return Double.compare(v1, v2);		
	} // compare
	
} // end class
