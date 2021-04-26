package sec02.exam02_generic_type;


public class Box<T> {	// Generic Type
	private T t;	// Type parameter: <T>
	
	
	public T get() { // getter
		return t; 
	} // get
	
	public void set(T t) {	// setter 
		this.t = t; 
	} // set
	
} // end class




