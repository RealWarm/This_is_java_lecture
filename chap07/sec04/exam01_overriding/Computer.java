package sec04.exam01_overriding;


public class Computer extends Calculator {
	
	
	@Override 
	double areaCircle(double r) {
		System.out.println(
				"Computer ��ü�� areaCircle() ����");
		
		super.areaCircle(r);
		
		return Math.PI * r * r;
	} // areaCircle
	
} // end class


