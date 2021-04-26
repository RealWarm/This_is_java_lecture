package sec05.exam03_supplier;

import java.util.function.IntSupplier;


public class SupplierExample {
	
	
	public static void main(String[] args) {
		//-----------------------------------
		// IntSupplier �Լ��� �������̽� ���
		//-----------------------------------
		IntSupplier intSupplier = () -> {
			int num = (int) (Math.random() * 6) + 1;
			
			return num;
		}; // ���ٽ����� �͸�����ü�� ����
		
		//�߻�޼ҵ�ȣ��
		int num = intSupplier.getAsInt(); 
		
		System.out.println("���� ��: " + num);
		
		
		//-----------------------------------
		// IntSupplier �Լ��� �������̽� ��ü����
		//-----------------------------------
		
		// What to do?
		
		// 4��
		
		IntSupplier intSupplier2
				= new IntSupplier() {
			private String name="name";
			private int age=44;
			

			@Override
			public int getAsInt() {
				
//				int num2
//					= (int) (Math.random() * 6) + 1;
//				
//				return num2;
				
				method1();
				method2();
				
				return 1;
			} // getAsInt
			
			private void method1() {
				;;
			}
			
			private void method2() {
				;;
			}
			
		}; // �͸�����ü�� �����ϴ� �ڵ����
		int num2 = intSupplier2.getAsInt();
		System.out.println("���� ��: " + num2);
		
		
	} // main
	
} // end class
