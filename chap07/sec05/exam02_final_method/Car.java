package sec05.exam02_final_method;

public class Car {
	public int speed;
	
	
	public void speedUp() {
		speed += 1;
	} // speedUp
	
	//final �޼ҵ�
	public final void stop() {
		System.out.println("���� ����");
		speed = 0;
	} // stop
	
} // end class

