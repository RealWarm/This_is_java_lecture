package sec06.exam01_generic_wildcard;

import java.util.Arrays;


public class WildCardExample {
	
	// **�Ϲ���** ��� �������� ���������� ������ִ� �޼ҵ�
	public static void registerCourse(
				Course<?> course
			) {
		
		System.out.println(
			course.getName() + 
			" ������: " + 
			Arrays.toString( course.getStudents() )
		);
		
 	} // registerCourse
	
	
	// **�л�** ���� ������� �ϴ� ��������,
	// ���������� ������ִ� �޼ҵ�
	public static void registerCourseStudent(
			Course<? extends Student> course
		) {
		
		System.out.println(
			course.getName() + 
			" ������: " + 
			Arrays.toString( course.getStudents() ) 
		);
		
 	} // registerCourseStudent
	
	
	// **������** ���� ������� �ϴ� ��������,
	// ���������� ������ִ� �޼ҵ�
	public static void registerCourseWorker(
			Course<? super Worker> course
		) {
		
		System.out.println(
			course.getName() + 
			" ������: " + 
			Arrays.toString( course.getStudents() )
		);
	} // registerCourseWorker
	
	
	public static void main(String[] args) {
		//--------- **�Ϲ���** ��� ���� ���� ---------//
		Course<Person> personCourse = 
			new Course<Person>("�Ϲ��ΰ���", 5);
		
		personCourse.add(new Person("�Ϲ���"));
		personCourse.add(new Worker("������"));
		personCourse.add(new Student("�л�"));
		personCourse.add(new HighStudent("����л�"));

		//--------- **������** ��� ���� ���� ---------//
		Course<Worker> workerCourse = 
			new Course<Worker>("�����ΰ���", 5);
		
		workerCourse.add(new Worker("������"));

		//--------- **�л�** ��� ���� ���� ----------//
		Course<Student> studentCourse = 
			new Course<Student>("�л�����", 5);
		
		studentCourse.add(new Student("�л�"));
		studentCourse.add(new HighStudent("����л�"));

		//--------- **����л�** ��� ���� ���� -------//			
		Course<HighStudent> highStudentCourse = 
			new Course<HighStudent>("����л�����", 5);
		
		highStudentCourse.add(
				new HighStudent("����л�")
			);	
		
		//---------------------------------//		
		//--- 1. **�Ϲ���** ��� ���� ��� ����
		registerCourse(personCourse);
		
		//--- 2. **������** ��� ���� ��� ����
		registerCourse(workerCourse);
		
		//--- 3. **�л�** ��� ���� ��� ����
		registerCourse(studentCourse);
		
		//--- 4. **����л�** ��� ���� ��� ����
		registerCourse(highStudentCourse);
		
		System.out.println("-------------");
		
		//---------------------------------//
		//--- 5. **�л�** ��� ������, �Ϲ��� ��� �õ�
//		registerCourseStudent(personCourse); 		// X			
		
		//--- 6. **�л�** ��� ������, ������ ��� �õ�		
//		registerCourseStudent(workerCourse); 		// X			
		
		//--- 7. **�л�** ��� ������, �л� ��� �õ�		
		registerCourseStudent(studentCourse);			
		
		//--- 8. **�л�** ��� ������, ��� ��� �õ�		
		registerCourseStudent(highStudentCourse);	
		
		System.out.println("-------------");
		
		//---------------------------------//
		//--- 9. **�Ϲ���** ��� ������, �Ϲ��� ��� �õ�
		registerCourseWorker(personCourse);
		
		//--- 10. **������** ��� ������, ������ ��� �õ�
		registerCourseWorker(workerCourse);
		
		//--- 11. **�л�** ��� ������, �л� ��� �õ�
//		registerCourseWorker(studentCourse);
		
		//--- 12. **���** ��� ������, ��� ��� �õ�		(x)
//		registerCourseWorker(highStudentCourse); 		(x)
	} // main
	
} // end class
