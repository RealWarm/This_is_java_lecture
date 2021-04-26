package sec02.exam04_default_method;


public interface RemoteControl {
	// 1. ��� (public static final)
	public static final int MAX_VOLUME = 10;
	public static final int MIN_VOLUME = 0;
	
	
	// 2. �߻� �޼ҵ� (public abstract)
	public abstract void turnOn();
	public abstract void turnOff();
	public abstract void setVolume(int volume);
	
	// 3. ����Ʈ �޼ҵ� (public default)
	// default Ű���� �����Ұ�
	public default void setMute(boolean mute) {
		if(mute) {
			System.out.println("���� ó���մϴ�.");
		} else {
			System.out.println("���� �����մϴ�.");
		} // if-else
	} // setMute
	
} // end interface






