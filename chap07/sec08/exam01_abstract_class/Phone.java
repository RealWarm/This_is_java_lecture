package sec08.exam01_abstract_class;



public abstract class Phone {
	//1. 필드
	public String owner;
	
	
	//2. 생성자
	public Phone(String owner) {
		this.owner = owner;
	} // constructor
	
	//3. 메소드
	public void turnOn() {
		System.out.println("폰 전원을 켭니다.");
	} // turnOn
	
	public void turnOff() {
		System.out.println("폰 전원을 끕니다.");
	} // turnOff
	
} // end class
