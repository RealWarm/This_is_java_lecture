package sec07.exam01_generic_extends_implements;

// Ÿ���Ķ���͸� ������, ���׸� Ÿ�� ����
public class Product<T, M> { // ���׸� Ŭ����
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

// �ϳ��� �ڹ� �ҽ����� �ȿ���, �Ѱ� �̻��� Ŭ���� ���𰡴�
// ��, Ŭ���� ���� public ���������ڴ�, �� �߿� �ϳ��� Ŭ����
// ���� ���� �� �ְ�, �ҽ� ���ϸ� public Ű���尡 ���� Ŭ����
// ��� �����ϰ� �ؾ� ��
// �߰������� ������ Ŭ����
class Tv {
	;;
} // end class






