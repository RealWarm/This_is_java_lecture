package sec01.exam01_variable;

public class VariableScopeExample {
	long price;		// ��������
	
	public static void main(String[] args) {
		int var1;    // �������� ����
//		System.out.println("1. var1: "+ var1);
		
		if(true) {
			int var2;  // ��������
			
			var1 = 10;
			var2 = 20;
			
			System.out.println("1. var1: "+ var1);
			System.out.println("2. var2: "+ var2);
		} // if
		
		var1 = 10;		// ��������
//		var2 = 20;	/* �������� */
		
		for(int i=0; i<1; i++) {
			int var3;
			
			var1 = 10;
			var3 = 30;
		} // for
		
		var1 = 10;		// ������ ���� �Ҵ�
		//var3 = 30;	// ������ ���� �Ҵ�
	} // main - Entry Point
	
} // end class
