package sec05.exam04_function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;


public class FunctionExample1 {
	
	private static List<Student> list = 
		Arrays.asList(
				
		new Student("홍길동", 90, 96),
		new Student("신용권", 95, 93)
		
	); // List 타입의 필드 선언(학생객체목록으로 저장)
		
	//-----------------------------------------//
	
	public static void printString(
		/* 매개변수의 타입이 Function<T,R> 
		 * 함수적 인터페이스 */
		Function<Student, String> function
	) {
		for(Student student : list) {
			System.out.print(
				/* 추상메소드 호출 */
				function.apply(student) + " "
			);
		} // enhanced for
		
		System.out.println();
	} // printString
	
	//-----------------------------------------//
		
	public static void printInt(
		/* 매개변수의 타입이 ToIntFunction<T> 
		 * 함수적 인터페이스 */
		ToIntFunction<Student> function
	) {
		for(Student student : list) {
			
			System.out.print(
				/* 추상메소드 호출 */
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

		// TIF2 : 람다? 방식
//		ToIntFunction<Student> TIF2 = 
//			t -> t.getEnglishScore();
				
//		System.out.println(TIF2.applyAsInt(st));
		
/*		System.out.println("[학생 이름]");
		
		 매개변수(함수적 인터페이스)에 맞게, 
		 * 익명구현객체를 람다식으로 생성하여 던짐!!! 
		printString( t -> t.getName() );
		
		//----
		Function<Student, String> function = 
				t -> t.getName();
		//----
		
		//++++++++++++++++++++++++++++++//
		
		System.out.println("[영어 점수]");
		
		 매개변수(함수적 인터페이스)에 맞게, 
		 * 익명구현객체를 람다식으로 생성하여 던짐!!! 
		printInt( t -> t.getEnglishScore() );
		
		//++++++++++++++++++++++++++++++//
		
		System.out.println("[수학 점수]");
		
		 매개변수(함수적 인터페이스)에 맞게, 
		 * 익명구현객체를 람다식으로 생성하여 던짐!!! 
		printInt( t -> t.getMathScore() );*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		
		Student st = new Student("이희수", 10, 20);
//		
//		// TIF1 : 익명 구현 객체 생성 방식
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




