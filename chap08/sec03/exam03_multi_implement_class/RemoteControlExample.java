package sec03.exam03_multi_implement_class;


public class RemoteControlExample {
	
	
	public static void main(String[] args) {
		// ������ü ����
		SmartTelevision tv = new SmartTelevision();
		
		// RemoteControl �������̽� Ÿ�Կ� ����(������-1)
		RemoteControl rc = tv;
		
		// Searchable �������̽� Ÿ�Կ� ����(������-1)
		Searchable searchable = tv;
	} // main
	
} // end class
