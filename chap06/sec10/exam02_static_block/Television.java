package sec10.exam02_static_block;


public class Television {
	static {
		company = "LG";
		
//		System.out.println("- this: "+ this);
	} // static initializer	3
	
	
	
	static String company = "Samsung";
	static String model = "LCD";
	static String info;
	
	
	//----------------------------------------//
	// �����ʵ带 �ʱ�ȭ �ϴ�, ���� �ʱ�ȭ ��� ����
	//----------------------------------------//
	static {
		info = company + "-" + model;
	} // static initializer	
	
	
	
	static {
		model = "OLED";
	} // static initializer	2
	
	
	static void staticMethod() {
//		System.out.println(
//				"- this: "+ this);
	} //
	
	
	
	
	
	
	
	
	
	
	
	
	
	
} // end class
