package sec03.exam01_no_arguments_no_return;


public class MyFunctionalInterfaceExample {
	
	
	public static void main(String[] args) {
		MyFunctionalInterface fi;
		
		//------------------------------//
		// ���ٽ��� �̿���, �͸�����ü ����
		//------------------------------//
		fi= () -> { // �Ű������� ����, ���ϰ��� ���� 
			String str = "method call1";
			System.out.println(str);
//			System.out.println("** this: "+ this);  // X
		}; // ���ٽ��� �̿���, �͸�����ü ����(������-1)
		
		System.out.println("1. fi: "+ fi);
		
		fi.method(); // �������̽��� �߻�޼ҵ�ȣ��(������-2)
		
		
		//------------------------------//
		// ���ٽ��� �̿���, �͸�����ü ����
		//------------------------------//
		fi = () -> { // �Ű������� ����, ���ϰ��� ����
			System.out.println("method call2"); 
		}; // ���ٽ��� �̿���, �͸�����ü ����(������-1)
		
		System.out.println("2. fi: "+ fi);
		
		fi.method(); // �������̽��� �߻�޼ҵ�ȣ��(������-2)
		
		
		//------------------------------//		
		// ���ٽ��� �̿���, �͸�����ü ���� (������-1)
		//------------------------------//	
		// �Ű������� ����, ���ϰ��� ����
		fi = () -> System.out.println("method call3");
		
		System.out.println("3. fi: "+ fi);
		
		fi.method(); // �������̽��� �߻�޼ҵ�ȣ��(������-2)
	} // main
	
} // end class











