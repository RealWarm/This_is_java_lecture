package sec08.exam02_abstract_method;


public class  Cat extends Animal {
	
	
	public Cat() {
		this.kind = "포유류";
	} // constructor

	/*
	 * 부모로부터 물려받은, 강제적인 규격에 대하여
	 * 구현함 (by overriding)
	 * 이 규격을 구현하지 않으면, 자식클래스에서
	 * 컴파일 오류가 발생
	 * 
	 */
//	@Override
//	public void sound() {
//		System.out.println("야옹");
//	} // sound
	
} // end class
