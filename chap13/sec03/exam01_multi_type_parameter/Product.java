package sec03.exam01_multi_type_parameter;


// �� ���� Ÿ���Ķ����(T, M)�� ������ ���׸� Ÿ��
public class Product<T, M> { // Generic Class
	private T kind;		// ��ǰ�� ����
	private M model;	// ��ǰ�� �𵨸�
	
	
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






