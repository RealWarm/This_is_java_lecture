package sec05.exam02_consumer;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.ObjIntConsumer;


public class ConsumerExample {
	
	
	public static void main(String[] args) {		
		//---------------------------//
		// 1. Consumer<T> ���
		//---------------------------//
		
		// ���ٽ��� ����, �Լ��� �������̽� �����ϴ�
		// �͸�����ü ����
		Consumer<String> consumer = 
			t -> System.out.println(t + "8");
			
		consumer.accept("java"); // �߻�޼ҵ� ȣ��
		
		//---------------------------//
		// 2. BiConsumer<T,U> ���
		//---------------------------//
		
		BiConsumer<String, String> bigConsumer = 
			(t, u) -> System.out.println(t + u);
			
		bigConsumer.accept("Java", "8");
		
		//---------------------------//
		// 3. DoubleConsumer ���
		//---------------------------//
		
		DoubleConsumer doubleConsumer = 
			d -> System.out.println("Java" + d);
			
		doubleConsumer.accept(8.0);
		
		//---------------------------//
		// 4. ObjIntConsumer<T> ���
		//---------------------------//
		
		ObjIntConsumer<String> objIntConsumer = 
			(t, i) -> System.out.println(t + i);
			
		objIntConsumer.accept("Java", 8);
		
		
		//---------------------------//
		// 5. ObjIntConsumer<T> �� 
		//	   �͸�����ü�����ڵ��
		//    ���� 4�� ������ �ٽ� �����Ͻʽÿ�.
		//---------------------------//
		
		ObjIntConsumer<String> objIntConsumer2 =
			new ObjIntConsumer<String>() {
			
			private String name = "Yoseph";
			

			@Override
			public void accept(String t, int value) {
				System.out.println(t + value);
				
				method1();
				method2();
				
				System.out.println(name);
			} // accept
			
			private void method1() {
				;;
			} // method1
			
			private void method2() {
				;;
			} // method2
			
		}; // �͸�����ü�� �����ϴ� ù��° ������� ��ü����

		objIntConsumer2.accept("Java", 8);
		
		System.exit(0);
	} // main
	
} // end class
