package sec06.exam01_generic_wildcard;


// 타입파라미터 T를 가지는 제네릭 타입 선언
public class Course<T> { // 제네릭 클래스
	private String name;
	private T[] students; // T 타입의 배열로 학생들 관리
	
	
	public Course(String name, int capacity) {
		this.name = name;
		
		// 타입파라미터 T 타입의 배열은 기존 문법으로
		// 직접 생성불가. (아래 순서로 배열 생성해야 함!!!)
		//   1) 우선 Object 타입의 배열을 만들고
		//   2) T타입의 배열로 강제 형변환하여 생성
		students = (T[]) (new Object[capacity]);
	} // 생성자

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
