package sec08.exam02_abstract_method;


public abstract class Animal {
	public String kind;		// 동물의 종류
	
	
	// 모든 동물은 산소로 숨을 쉬어야 합니다.
	public void breathe() {
		System.out.println("숨을 쉽니다.");
	} // breathe

	// 추상 메소드!!!!
	// 이것이야 말로, 자식 클래스가 반드시 지켜야할
	// "규격"을 만들고, 강제하는 수단임!!!!! (********)
	// 이 클래스를 부모로 삼는, 모든 자식 클래스에서
	// 이 추상메소드를 반드시 구현해야함!!!
	// 구현하지 않으면 ---> 컴파일 오류발생!!!
	// 구현하는 방법 --> 자식 클래스에서 이 추상메소드를
	// 오버라이딩(Overriding) 해야 함!!!
	public abstract void sound();
	
} // end class





