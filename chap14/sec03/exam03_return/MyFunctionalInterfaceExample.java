package sec03.exam03_return;


public class MyFunctionalInterfaceExample {
	public static String name="Yoseph";
	
	
	public static void main(String[] args) {
		MyFunctionalInterface fi;
		int age = 44;
		
		//---------------------------//
		
		fi = (x, y) -> {
			MyFunctionalInterfaceExample.sum(x,y);
			
			System.out.println(
					MyFunctionalInterfaceExample.name);
			
			System.out.println(args);
			System.out.println(age);
			
			int result = x + y;
			
			return result;	// ���ϰ� ��ȯ
		}; // Ÿ��Ÿ���� �����ϴ� �͸�����ü����
		
		// �߻� �޼ҵ� ȣ��
		System.out.println( fi.method(2, 5) ); 
		
		//---------------------------//
		
		fi = (x, y) -> { 
			return x + y;	// ���ϰ� ��ȯ
		}; // Ÿ��Ÿ���� �����ϴ� �͸�����ü����

		// �߻� �޼ҵ� ȣ��
		System.out.println( fi.method(2, 5) );
		
		//---------------------------//
		
		// Ÿ��Ÿ���� �����ϴ� �͸�����ü����
		fi = (x, y) -> x + y;

		// �߻� �޼ҵ� ȣ��
		System.out.println( fi.method(2, 5) );
		
		//---------------------------//
		
		// Ÿ��Ÿ���� �����ϴ� �͸�����ü����
		fi = (x, y) -> sum(x, y);

		// �߻� �޼ҵ� ȣ��
		System.out.println( fi.method(2, 5) );
	} // main	
	 
	public static int sum(int x, int y) {
		return (x + y);
	} // sum
	
} // end class











