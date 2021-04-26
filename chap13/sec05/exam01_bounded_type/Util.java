package sec05.exam01_bounded_type;


// �������� �����޼ҵ�� �����Ͽ� ������ �ִ� �Ϲ����� Ŭ����
// �� ��ƿ��Ƽ Ŭ������� �ϸ�, �ٸ� Ŭ�������� �������� ����ϴ�
// Ŭ������ �ǹ�
public class Util {	// ��ƿ��Ƽ Ŭ����(Utility Class)
	
	
	// Generic Method
	public 
		static 
		<T extends Number> /* Bounded type parameter */
		int 			   /* return type */
		compare(T t1, T t2) {
		
		double v1 = t1.doubleValue(); 
		//System.out.println(t1.getClass().getName());
		
		double v2 = t2.doubleValue();
		//System.out.println(t2.getClass().getName());
		
		return Double.compare(v1, v2);		
	} // compare
	
} // end class
