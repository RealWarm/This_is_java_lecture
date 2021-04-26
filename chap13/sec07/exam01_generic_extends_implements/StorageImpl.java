package sec07.exam01_generic_extends_implements;


// 제네릭 인터페이스를 구현하는 구현클래스는 무조건
// 제네릭 클래스이어야 한다!!! 라고 했으니,
// 구현클래스도 타입 파라미터를 가져야 합니다.
public class StorageImpl<T> 
	implements Storage<T> { // 제네릭 구현 클래스 선언
	
	private T[] array;	// 필드
	
	
	public StorageImpl(int capacity) {
		// 타입파라미터 T의 배열은, 기존 방식대로 생성불가
		// 때문에, Object 타입의 배열을 우선 생성한 후에,
		// T[] 배열로 강제형변환 해야함!!(규칙)
		this.array = (T[]) (new Object[capacity]);
		
//		this.array = new T[]; // X
	} // 생성자
	
	@Override
	public void add(T item, int index) {
		array[index] = item;
	} // add

	@Override
	public T get(int index) {
		return array[index];
	} // get
	
} // end class
