package sec03.exam02_arguments;


public class MyMethodReferencesExample {
	
	
	public static void main(String[] args) {
		MyFunctionalInterface fi;
		
		//-----------------------------//
		fi = (int x) -> {
			;;
		};
		
		fi= (x) -> {
			int result = x * 5;
			
			System.out.println(result);
		}; // ���ٽ��� ����, �͸�����ü����
		
		fi.method(2); // �߻�޼ҵ� ȣ��
		
		//-----------------------------//
		
		fi = (x) -> { 
			System.out.println( x * 5 ); 
		}; // ���ٽ��� ����, �͸�����ü����
		
		fi.method(2); // �߻�޼ҵ� ȣ��
		
		//-----------------------------//
		
		// ���ٽ��� ����, �͸�����ü����
		fi = x -> System.out.println( x * 5 );
		
		fi.method(2); // �߻�޼ҵ� ȣ��
		
		//-----------------------------//
	} // main
}











