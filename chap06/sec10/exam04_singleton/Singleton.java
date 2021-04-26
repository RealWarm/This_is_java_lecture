package sec10.exam04_singleton;


// Singleton Pattern
public class Singleton {
	private static Singleton singleton;
	
	
	static {
		singleton = new Singleton();
	} // static initializer
	
	// 외부에서 생성자호출못하게 막음 --> 객체생성금지
	private Singleton() {	
		;;
	} // constructor
	
	// 외부에서, 싱글톤 객체의 주소가 필요할 때마다 호출
	// 하기 위한 메소드 --> 반환값: 싱글톤 객체의 주소
	public static Singleton getInstance() {
		return singleton;
	} // getInstance
		
} // end class

