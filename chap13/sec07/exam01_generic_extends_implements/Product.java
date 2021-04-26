package sec07.exam01_generic_extends_implements;

// 타입파라미터를 가지는, 제네릭 타입 선언
public class Product<T, M> { // 제네릭 클래스
	private T kind;
	private M model;
	
	
	public T getKind() { 
		return this.kind; 
	} // getter
	
	public M getModel() { 
		return this.model; 
	} // getter
	
	public void setKind(T kind) { 
		this.kind = kind; 
	} // setter
	
	public void setModel(M model) { 
		this.model = model; 
	} // setter
	
} // end class

// 하나의 자바 소스파일 안에는, 한개 이상의 클래스 선언가능
// 단, 클래스 앞의 public 접근제한자는, 그 중에 하나의 클래스
// 에만 붙일 수 있고, 소스 파일명도 public 키워드가 붙은 클래스
// 명과 동일하게 해야 함
// 추가적으로 선언한 클래스
class Tv {
	;;
} // end class






