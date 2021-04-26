package sec08.exam01_abstract_class;


public class SmartPhone extends Phone {
	// 1. 필드
	
	
	// 2. 생성자
	public SmartPhone(String owner) {
		super(owner); // 부모 클래스의 생성자 호출..왜?
		// 자식객체보다 항상 부모객체가 우선 생성되어야 함!
		// 부모없는 자식이란 존재할 수 없음을 잊지말것!!!
	} // constructor
		
	// 3. 메소드
	public void internetSearch() {
		System.out.println("인터넷 검색을 합니다.");
	} // internetSearch
	
} // end class


