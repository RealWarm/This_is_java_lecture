package sec07.exam03_constructor_overloading;


public class CarExample {
	
	
	public static void main(String[] args) {
		Car car1 = new Car(); // ���ο� Car��ü����
		
		//----------------------------------------//
		System.out.println(
				"car1.company : " + car1.company);
									// ��ü�� �ʵ� ���
		System.out.println(); // 1���� ������� ���

		//----------------------------------------//
		Car car2 = new Car("�ڰ���"); // ���ο� Car��ü����
		
		System.out.println(
				"car2.company : " + car2.company);
									// ��ü�� �ʵ� ���
		System.out.println("car2.model : " + car2.model);
									// ��ü�� �ʵ� ���
		System.out.println(); // 1���� ������� ���

		//----------------------------------------//
		// ���ο� Car��ü����
		Car car3 = new Car("�ڰ���", "����");
		
		System.out.println(
				"car3.company : " + car3.company);
									// ��ü�� �ʵ� ���
		System.out.println("car3.model : " + car3.model);
									// ��ü�� �ʵ� ���
		System.out.println("car3.color : " + car3.color);
									// ��ü�� �ʵ� ���
		System.out.println(); // 1���� ������� ���

		//----------------------------------------//
		// ���ο� Car��ü����
		Car car4 = new Car("�ý�", "����", 200);
		
		System.out.println(
				"car4.company : " + car4.company);
									// ��ü�� �ʵ� ���
		System.out.println("car4.model : " + car4.model);
									// ��ü�� �ʵ� ���
		System.out.println("car4.color : " + car4.color);
									// ��ü�� �ʵ� ���
		System.out.println(
				"car4.maxSpeed : " + car4.maxSpeed);
									// ��ü�� �ʵ� ���
	} // main
	
} // end class

