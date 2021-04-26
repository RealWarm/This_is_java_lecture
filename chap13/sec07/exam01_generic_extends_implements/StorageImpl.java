package sec07.exam01_generic_extends_implements;


// ���׸� �������̽��� �����ϴ� ����Ŭ������ ������
// ���׸� Ŭ�����̾�� �Ѵ�!!! ��� ������,
// ����Ŭ������ Ÿ�� �Ķ���͸� ������ �մϴ�.
public class StorageImpl<T> 
	implements Storage<T> { // ���׸� ���� Ŭ���� ����
	
	private T[] array;	// �ʵ�
	
	
	public StorageImpl(int capacity) {
		// Ÿ���Ķ���� T�� �迭��, ���� ��Ĵ�� �����Ұ�
		// ������, Object Ÿ���� �迭�� �켱 ������ �Ŀ�,
		// T[] �迭�� ��������ȯ �ؾ���!!(��Ģ)
		this.array = (T[]) (new Object[capacity]);
		
//		this.array = new T[]; // X
	} // ������
	
	@Override
	public void add(T item, int index) {
		array[index] = item;
	} // add

	@Override
	public T get(int index) {
		return array[index];
	} // get
	
} // end class
