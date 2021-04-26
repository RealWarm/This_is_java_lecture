package sec02.exam02_generic_type;


public class BoxExample {
	
	
	public static void main(String[] args) {
		//-----------------------------------//
		// ���׸� Ŭ������ box Ÿ���� ��ü����
		Box<String> box1 = new Box<>();
		//-----------------------------------//
		
		// ������ box��ü�� �޼ҵ� ȣ��
		box1.set("hello");	// setter ȣ��
		String str = box1.get(); // getter ȣ��
		
		
		//-----------------------------------//
		// ���׸� Ŭ������ box Ÿ���� ��ü����
		Box<Integer> box2 = new Box<>();
		//-----------------------------------//

		// ������ box��ü�� �޼ҵ� ȣ��
		box2.set(6); // setter ȣ��
		int value = box2.get(); //getter ȣ��
		
		/*
		// Auto-Boxing / Unboxing
//		Integer intObj = new Integer(1);
		Integer intObj = 1;  // auto-boxing
		int i = intObj;	// auto-boxing
		i = intObj.intValue(); // by compiler
		
//		Boolean booleanObj = 
//				new Boolean(true);
		Boolean booleanObj = false; //auto-boxing
		boolean b = booleanObj; //auto-unboxing
		
		b = booleanObj.booleanValue(); // by compiler
		
//		Double doubleObj = new Double(1.0);
		Double doubleObj = 1.0; // auto-boxing
		double d = doubleObj;   // auto-unboxing
		d = doubleObj.doubleValue(); // by compiler
		*/
	
	} // main
	
} // end class




