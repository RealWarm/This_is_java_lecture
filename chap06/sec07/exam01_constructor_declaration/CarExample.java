package sec07.exam01_constructor_declaration;

import java.util.Vector;

public class CarExample {
	
	public static void main(String[] args) 
		throws InterruptedException {
		
		// �⺻ �����ڴ� ���̻� ���� ������, 
		// �̸� ȣ���, �����Ͽ��� �߻�
		//Car myCar = new Car();  (x)
		
		Vector v = new Vector();
		
		for(;;) {
			// ��������� ������ �����ڸ� ����Ͽ� ��ü ����
			Car myCar = new Car("����", 3000);
			System.out.println("- myCar: "+myCar);
			
			v.add(myCar);
			
			Thread.sleep(50);
		} //for
		
	} //main
	
} // end class
