package sec03.exam01_name_implement_class;

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
	
	// 4. ���� �޼ҵ� (public static)
	public static void changeBattery() {
		System.out.println("�������� ��ȯ�մϴ�.");
	} // changeBattery
}
