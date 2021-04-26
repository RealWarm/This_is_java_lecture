package sec03.exam01_name_implement_class;

public interface RemoteControl {
	// 1. 상수 (public static final)
	public static final int MAX_VOLUME = 10;
	public static final int MIN_VOLUME = 0;
	
	
	// 2. 추상 메소드 (public abstract)
	public abstract void turnOn();
	public abstract void turnOff();
	public abstract void setVolume(int volume);
	
	// 3. 디폴트 메소드 (public default)
	// default 키워드 생략불가
	public default void setMute(boolean mute) {
		if(mute) {
			System.out.println("무음 처리합니다.");
		} else {
			System.out.println("무음 해제합니다.");
		} // if-else
	} // setMute
	
	// 4. 정적 메소드 (public static)
	public static void changeBattery() {
		System.out.println("건전지를 교환합니다.");
	} // changeBattery
}
