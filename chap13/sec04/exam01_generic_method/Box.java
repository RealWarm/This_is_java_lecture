package sec04.exam01_generic_method;


// 타입파라미터 T를 가지는 제네릭 타입 선언
public class Box<T> { // 제네릭 클래스
	private T t;	// 필드
	
	
	public T get() { 
		return t; 
	} // getter
	
	public void set(T t) { 
		this.t = t; 
	} // setter	
} // end class
