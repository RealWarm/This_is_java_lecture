package sec03.exam03_multi_implement_class;


public class SmartTelevision 
	implements RemoteControl, Searchable {
	
	private int volume;
	
	
	//--------------- RemoteControl -------------//
	@Override
	public void turnOn() {
		System.out.println("TV�� �մϴ�.");
	} // turnOn
	
	@Override
	public void turnOff() {
		System.out.println("TV�� ���ϴ�.");
	} // turnOff
	
	@Override
	public void setVolume(int volume) {
		if(volume > RemoteControl.MAX_VOLUME) {
			this.volume = RemoteControl.MAX_VOLUME;
		} else if(volume < RemoteControl.MIN_VOLUME) {
			this.volume = RemoteControl.MIN_VOLUME;
		} else {
			this.volume = volume;
		} //if-else if-ese
		
		System.out.println("���� TV ����: " + volume);
	} // setVolume

	//--------------- Searchable -------------//
	@Override
	public void search(String url) {
		System.out.println(url + "�� �˻��մϴ�.");
	} // search
	
} // end class






