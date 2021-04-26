package sec03.exam01_name_implement_class;


public class Television
	implements RemoteControl {
	//�ʵ�
	private int volume;

	
	//turnOn() �߻� �޼ҵ��� ��ü �޼ҵ�
	@Override
	public void turnOn() {
		System.out.println("TV�� �մϴ�.");
	} // turnOn
	
	//turnOff() �߻� �޼ҵ��� ��ü �޼ҵ�
	@Override
	public void turnOff() {
		System.out.println("TV�� ���ϴ�.");
	} // turnOff
	
	//setVolume() �߻� �޼ҵ��� ��ü �޼ҵ�
	@Override
	public void setVolume(int volume) {
		if(volume> RemoteControl.MAX_VOLUME) {
			this.volume = RemoteControl.MAX_VOLUME;
		} else if(volume < RemoteControl.MIN_VOLUME) {
			this.volume = RemoteControl.MIN_VOLUME;
		} else {
			this.volume = volume;
		}
		
		System.out.println("���� TV ����: " + volume);
	} // setVolume
	
} // end class
