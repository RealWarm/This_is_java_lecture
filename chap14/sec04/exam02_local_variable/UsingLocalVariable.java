package sec04.exam02_local_variable;



public class UsingLocalVariable {
	MyFunctionalInterface fi2;
	
	
	
	void method(final int arg) {  //arg�� final Ư���� ����
		final int localVar = 40; 	//localVar�� final Ư���� ����
		int localVar2 = 100;
		
//		arg = 31;  		//final Ư�� ������ ���� �Ұ�
		//localVar = 41; 	//final Ư�� ������ ���� �Ұ�
        
		//----- ���ٽ� ------------------------//
		MyFunctionalInterface fi= () -> {
			//���ú��� ���
			System.out.println("arg: " + arg); 
			System.out.println(
				"localVar: " + localVar + "\n");
		}; // Ÿ��Ÿ���� �͸�����ü�� ����
		
		fi2 = fi;
		
		fi.method();
		
		localVar2 = 1000;
	} // method
	
} // end class

