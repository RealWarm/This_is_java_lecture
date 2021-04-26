package sec05.exam02_final_method;

public class Car {
	public int speed;
	
	
	public void speedUp() {
		speed += 1;
	} // speedUp
	
	//final ¸Þ¼Òµå
	public final void stop() {
		System.out.println("Â÷¸¦ ¸ØÃã");
		speed = 0;
	} // stop
	
} // end class

