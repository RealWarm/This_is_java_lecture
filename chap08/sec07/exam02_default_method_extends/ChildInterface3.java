package sec07.exam02_default_method_extends;


public interface ChildInterface3 
	extends ParentInterface {
	
	
	// 부모 인터페이스에서 상속받은, 디폴트 메소드를
	// 다시, 추상메소드로 전환: 디폴트 메소드 --> 추상 메소드
	@Override 
	public void method2(); 
	
	public void method3();
	
} // end class
