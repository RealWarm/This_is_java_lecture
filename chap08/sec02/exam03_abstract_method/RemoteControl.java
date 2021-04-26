package sec02.exam03_abstract_method;


public interface RemoteControl {
	// 1. 상수(불변의 진리값)
	public static final int MAX_VOLUME = 10;
	public static final int MIN_VOLUME = 0;
	
	
	// 2. 추상 메소드 
	//    --> 규격(모델링 대상이 되는 객체가 반드시 지켜야할
	//             최소한 규격을 선언하는 것!!!)
	public abstract void turnOn();
	public abstract void turnOff();
	public abstract void setVolume(int volume);

} // end interface









