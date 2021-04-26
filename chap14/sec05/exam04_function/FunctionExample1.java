package sec05.exam04_function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;


public class FunctionExample1 {
	
	private static List<Student> list = 
		Arrays.asList(
				
		new Student("ȫ�浿", 90, 96),
		new Student("�ſ��", 95, 93)
		
	); // List Ÿ���� �ʵ� ����(�л���ü������� ����)
		
	//-----------------------------------------//
	
	public static void printString(
		/* �Ű������� Ÿ���� Function<T,R> 
		 * �Լ��� �������̽� */
		Function<Student, String> function
	) {
		for(Student student : list) {
			System.out.print(
				/* �߻�޼ҵ� ȣ�� */
				function.apply(student) + " "
			);
		} // enhanced for
		
		System.out.println();
	} // printString
	
	//-----------------------------------------//
		
	public static void printInt(
		/* �Ű������� Ÿ���� ToIntFunction<T> 
		 * �Լ��� �������̽� */
		ToIntFunction<Student> function
	) {
		for(Student student : list) {
			
			System.out.print(
				/* �߻�޼ҵ� ȣ�� */
				function.applyAsInt(student) + " "
			);
			
		} // enhanced for
		
		System.out.println();
	} // printInt
	
	//-----------------------------------------//
	
	public static void main(String[] args) {
		
		Function<Student, String> function =
			new Function<Student, String>() {

			@Override
			public String apply(Student student) {				
				return student.getName();
			} // apply
			
		};
		
		Function<Student, String> function2 = t -> t.getName();
		
		//-------------------------------//
		
		
//		ToIntFunction<Student> function3;
		
		
//		ToIntFunction<Student> TIF1 = new ToIntFunction<Student>() {
//			
//			@Override
//			public int applyAsInt(Student t) {
//				return t.getEnglishScore();
//			}
//		};
//		System.out.println(TIF1.applyAsInt(st));

		// TIF2 : ����? ���
//		ToIntFunction<Student> TIF2 = 
//			t -> t.getEnglishScore();
				
//		System.out.println(TIF2.applyAsInt(st));
		
/*		System.out.println("[�л� �̸�]");
		
		 �Ű�����(�Լ��� �������̽�)�� �°�, 
		 * �͸�����ü�� ���ٽ����� �����Ͽ� ����!!! 
		printString( t -> t.getName() );
		
		//----
		Function<Student, String> function = 
				t -> t.getName();
		//----
		
		//++++++++++++++++++++++++++++++//
		
		System.out.println("[���� ����]");
		
		 �Ű�����(�Լ��� �������̽�)�� �°�, 
		 * �͸�����ü�� ���ٽ����� �����Ͽ� ����!!! 
		printInt( t -> t.getEnglishScore() );
		
		//++++++++++++++++++++++++++++++//
		
		System.out.println("[���� ����]");
		
		 �Ű�����(�Լ��� �������̽�)�� �°�, 
		 * �͸�����ü�� ���ٽ����� �����Ͽ� ����!!! 
		printInt( t -> t.getMathScore() );*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		
		Student st = new Student("�����", 10, 20);
//		
//		// TIF1 : �͸� ���� ��ü ���� ���
//		ToIntFunction<Student> tif1 = ???? ;
		
		ToIntFunctionImpl<Student> ttt = 
				new ToIntFunctionImpl();
	} // main
	
} // end class



class ToIntFunctionImpl< T extends Student> 
	implements ToIntFunction<T> {

	@Override
	public int applyAsInt(T t) {
		return t.getMathScore();
	} // applyAsInt
	
} // end class




