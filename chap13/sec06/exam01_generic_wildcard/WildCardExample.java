package sec06.exam01_generic_wildcard;

import java.util.Arrays;


public class WildCardExample {
	
	// **일반인** 대상 과정으로 수강생들을 등록해주는 메소드
	public static void registerCourse(
				Course<?> course
			) {
		
		System.out.println(
			course.getName() + 
			" 수강생: " + 
			Arrays.toString( course.getStudents() )
		);
		
 	} // registerCourse
	
	
	// **학생** 만을 대상으로 하는 과정으로,
	// 수강생들을 등록해주는 메소드
	public static void registerCourseStudent(
			Course<? extends Student> course
		) {
		
		System.out.println(
			course.getName() + 
			" 수강생: " + 
			Arrays.toString( course.getStudents() ) 
		);
		
 	} // registerCourseStudent
	
	
	// **직장인** 만을 대상으로 하는 과정으로,
	// 수강생들을 등록해주는 메소드
	public static void registerCourseWorker(
			Course<? super Worker> course
		) {
		
		System.out.println(
			course.getName() + 
			" 수강생: " + 
			Arrays.toString( course.getStudents() )
		);
	} // registerCourseWorker
	
	
	public static void main(String[] args) {
		//--------- **일반인** 대상 과정 생성 ---------//
		Course<Person> personCourse = 
			new Course<Person>("일반인과정", 5);
		
		personCourse.add(new Person("일반인"));
		personCourse.add(new Worker("직장인"));
		personCourse.add(new Student("학생"));
		personCourse.add(new HighStudent("고등학생"));

		//--------- **직장인** 대상 과정 생성 ---------//
		Course<Worker> workerCourse = 
			new Course<Worker>("직장인과정", 5);
		
		workerCourse.add(new Worker("직장인"));

		//--------- **학생** 대상 과정 생성 ----------//
		Course<Student> studentCourse = 
			new Course<Student>("학생과정", 5);
		
		studentCourse.add(new Student("학생"));
		studentCourse.add(new HighStudent("고등학생"));

		//--------- **고등학생** 대상 과정 생성 -------//			
		Course<HighStudent> highStudentCourse = 
			new Course<HighStudent>("고등학생과정", 5);
		
		highStudentCourse.add(
				new HighStudent("고등학생")
			);	
		
		//---------------------------------//		
		//--- 1. **일반인** 대상 과정 등록 수행
		registerCourse(personCourse);
		
		//--- 2. **직장인** 대상 과정 등록 수행
		registerCourse(workerCourse);
		
		//--- 3. **학생** 대상 과정 등록 수행
		registerCourse(studentCourse);
		
		//--- 4. **고등학생** 대상 과정 등록 수행
		registerCourse(highStudentCourse);
		
		System.out.println("-------------");
		
		//---------------------------------//
		//--- 5. **학생** 대상 과정에, 일반인 등록 시도
//		registerCourseStudent(personCourse); 		// X			
		
		//--- 6. **학생** 대상 과정에, 직장인 등록 시도		
//		registerCourseStudent(workerCourse); 		// X			
		
		//--- 7. **학생** 대상 과정에, 학생 등록 시도		
		registerCourseStudent(studentCourse);			
		
		//--- 8. **학생** 대상 과정에, 고딩 등록 시도		
		registerCourseStudent(highStudentCourse);	
		
		System.out.println("-------------");
		
		//---------------------------------//
		//--- 9. **일반인** 대상 과정에, 일반인 등록 시도
		registerCourseWorker(personCourse);
		
		//--- 10. **직장인** 대상 과정에, 직장인 등록 시도
		registerCourseWorker(workerCourse);
		
		//--- 11. **학생** 대상 과정에, 학생 등록 시도
//		registerCourseWorker(studentCourse);
		
		//--- 12. **고딩** 대상 과정에, 고딩 등록 시도		(x)
//		registerCourseWorker(highStudentCourse); 		(x)
	} // main
	
} // end class
