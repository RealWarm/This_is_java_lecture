package sec06.exam01_interface_extends;

public class ImplementationC 
	implements InterfaceC {
	/* 
	 * 다중상속한 인터페이스를 구현하는 클래스는,
	 * 해당 인터페이스에 정의된 추상메소드 뿐만 아니라, 
	 * 상속받은 추상 메소드까지 모두 구현해야 함!!!
	 */
	
	public void methodA() {	// interfaceA 의 추상메소드
		System.out.println(
				"- ImplementationC::methodA() invoked.");
	} // methodA
	
	public void methodB() { // interfaceB 의 추상메소드
		System.out.println(
				"- ImplementationC::methodB() invoked.");
	} // methodB
	
	public void methodC() { // interfaceC 의 추상메소드
		System.out.println(
				"- ImplementationC::methodC() invoked.");
	} // methodC
	 
} // end class

