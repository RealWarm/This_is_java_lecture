package sec05.exam05_instanceof;


public class Driver {
	
	
	// �Ű������� ������ -
	// �޼ҵ��� �Ű�������, �������̽� Ÿ���� ������!!!!
	// ����, �� �������̽��� �����ϴ� ��ü�� � ���̶�
	// ���� ����!
	public void drive(Vehicle vehicle) {
		if(vehicle instanceof Bus) {	// Ÿ��Ȯ��!!!
			Bus bus = (Bus) vehicle;	// ��������ȯ!!!
			
			bus.checkFare();
		} // if
		
		vehicle.run();	// �������̽��� ����� �޼ҵ� ȣ��!
	} // drive
	
} // end class
