package sec07.exam01_generic_extends_implements;

// Ÿ���Ķ���͸� ������ ���׸� Ÿ�� ����
public interface Storage<T> { // ���׸� �������̽�
	
	
	public abstract void add(T item, int index);	
	public abstract T get(int index);
	
} // end interface
