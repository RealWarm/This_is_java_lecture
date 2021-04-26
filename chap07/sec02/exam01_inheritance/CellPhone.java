package sec02.exam01_inheritance;


public class CellPhone {
	//필드
	String model;
	String color;
	
	
	
	//생성자
	public CellPhone(String model, String color) {
		System.out.println(
			"- CellPhone::CellPhone invoked."
		);
		
		this.model = model;
		this.color = color;
	} //default constructor
	
	
	//메소드
	void powerOn() { 
		System.out.println("전원을 켭니다."); 
	} // powerOn
	
	void powerOff() { 
		System.out.println("전원을 끕니다."); 
	} // powerOff
	
	void bell() { 
		System.out.println("벨이 울립니다."); 
	} // bell
	
	void sendVoice(String message) { 
		System.out.println("자기: " + message); 
	} // sendVoice
	
	void receiveVoice(String message) { 
		System.out.println("상대방: " + message); 
	} // receiveVoice	
	
	void hangUp() { 
		System.out.println("전화를 끊습니다."); 
	} // hangUp
	
} // end class

