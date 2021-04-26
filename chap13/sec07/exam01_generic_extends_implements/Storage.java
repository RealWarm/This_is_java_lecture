package sec07.exam01_generic_extends_implements;

// 타입파라미터를 가지는 제네릭 타입 선언
public interface Storage<T> { // 제네릭 인터페이스
	
	
	public abstract void add(T item, int index);	
	public abstract T get(int index);
	
} // end interface
