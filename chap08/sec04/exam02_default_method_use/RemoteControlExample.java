package sec04.exam02_default_method_use;


public class RemoteControlExample {
	
	
	public static void main(String[] args) {
		RemoteControl rc = null;
		
		//-----------½ÇÇè-----------//
		
//		rc.setMute(true); 		// X
		RemoteControl.changeBattery();   // OK
		
		//----------------------------//
		
		rc = new Television();
		rc.turnOn();
		rc.setMute(true);
		
		rc = new Audio();
		rc.turnOn();
		rc.setMute(true);
	} // main
	
} //end class
