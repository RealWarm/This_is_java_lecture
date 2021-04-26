package sec03.exam01_multi_type_parameter;


// 두 개의 타입파라미터(T, M)을 가지는 제네릭 타입
public class Product<T, M> { // Generic Class
	private T kind;		// 제품의 종류
	private M model;	// 제품의 모델명
	
	
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






