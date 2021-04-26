package sec06.exam01_generic_wildcard;


public class Person {
	private String name;
	
	
	public Person(String name) {
		this.name = name;
	} // 생성자

	public String getName() { 
		return name; 
	} // getter
	
	// 최상위 부모 클래스인 Object가 상속해준,
	// toString() 메소드를 재정의함!!!
	@Override
	public String toString() { 
		return name; 
	} // setter
	
} // end class
