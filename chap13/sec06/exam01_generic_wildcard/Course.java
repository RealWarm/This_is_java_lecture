package sec06.exam01_generic_wildcard;


// Ÿ���Ķ���� T�� ������ ���׸� Ÿ�� ����
public class Course<T> { // ���׸� Ŭ����
	private String name;
	private T[] students; // T Ÿ���� �迭�� �л��� ����
	
	
	public Course(String name, int capacity) {
		this.name = name;
		
		// Ÿ���Ķ���� T Ÿ���� �迭�� ���� ��������
		// ���� �����Ұ�. (�Ʒ� ������ �迭 �����ؾ� ��!!!)
		//   1) �켱 Object Ÿ���� �迭�� �����
		//   2) TŸ���� �迭�� ���� ����ȯ�Ͽ� ����
		students = (T[]) (new Object[capacity]);
	} // ������

	public String getName() { 
		return name; 
	} // getter
	
	public T[] getStudents() { 
		return students; 
	} // getter
	
	public void add(T t) {
		
		for(int i=0; i<students.length; i++) {
			
			if(students[i] == null) {
				students[i] = t;
				
				break;
			} // if
			
		} // for
		
	} // add
	
} // end class
