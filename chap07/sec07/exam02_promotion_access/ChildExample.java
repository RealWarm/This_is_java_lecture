package sec07.exam02_promotion_access;

public class ChildExample {
	
	
	public static void main(String[] args) {
		  Child child = new Child();

		  Parent parent = child;	// ������-1 !!!
		  //--------------------------//

		  parent.method1();			// �ƹ��͵� �ƴ�
		  //--------------------------//

		  parent.method2();			// ������-2 !!!
		  //--------------------------//

		  //parent.method3();  		// ȣ�� �Ұ��� (X)
	} // main
	
} // end class
