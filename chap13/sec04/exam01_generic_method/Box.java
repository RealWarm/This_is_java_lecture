package sec04.exam01_generic_method;


// Ÿ���Ķ���� T�� ������ ���׸� Ÿ�� ����
public class Box<T> { // ���׸� Ŭ����
	private T t;	// �ʵ�
	
	
	public T get() { 
		return t; 
	} // getter
	
	public void set(T t) { 
		this.t = t; 
	} // setter	
} // end class
