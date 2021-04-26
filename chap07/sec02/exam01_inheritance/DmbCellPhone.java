package sec02.exam01_inheritance;


public class DmbCellPhone extends CellPhone {
	//필드
	int channel;
	
	
	//생성자
	DmbCellPhone(
		String model, 
		String color, 
		int channel) {

		// 부모클래스의 생성자를 명시적으로 호출
		// 반드시 자식 클래스의 생성자 안에서.. 호출..
		super(model, color);		
		
		this.model = model;
		this.color = color;
		this.channel = channel;
		
		System.out.println(
				"- DmbCellPhone::DmbCellPhone invoked."
			);
		
	} // constructor

	//메소드
	void turnOnDmb() {
		System.out.println(
			"채널 " + 
			channel + 
			"번 DMB 방송 수신을 시작합니다."
		);
	} // turnOnDmb
	
	void changeChannelDmb(int channel) {
		this.channel = channel;
		
		System.out.println(
			"채널 " + 
			channel + 
			"번으로 바꿉니다."
		);
	} // changeChannelDmb
	
	void turnOffDmb() {
		System.out.println("DMB 방송 수신을 멈춥니다.");
	} // turnOffDmb
	
} // end class

