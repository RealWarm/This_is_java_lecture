package sec03.exam02_noname_implement_class;

public class RemoteControlExample {
	
	
	public static void main(String[] args) {
		
		RemoteControl rc = new RemoteControl() {
			
			@Override
			public void turnOn() { 
				System.out.println("-turnOn() invoked.");
			} // turnOn	
			
			@Override
			public void turnOff() { 
				System.out.println("-turnOff() invoked.");				
			} // turnOff
			
			@Override
			public void setVolume(int volume) {
				System.out.println("-turnOff() invoked."); 				 
			} // setVolume
			
		}; // 익명구현객체 생성
		
		System.out.println("- rc: "+ rc);
		
		rc.turnOn();
		rc.setVolume(2);
		rc.turnOff();
		
		// default method 호출
		rc.setMute(false);	
		// static method 호출
		RemoteControl.changeBattery(); 
				
	} // main
	
} // end class
