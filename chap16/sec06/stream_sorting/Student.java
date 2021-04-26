package sec06.stream_sorting;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.log4j.Log4j;


@Log4j
@AllArgsConstructor
public class Student 
	implements Comparable<Student> {
	
	private @Getter String name;
	@Getter private int score;

	
	@Override
	public int compareTo(Student s /*비교객체의 타입*/) {
		log.info("---------------------------------");
		log.info("Student::compareTo(s) invoked.");
		log.info("\t+ 기준객체: "+ this);
		log.info("\t+ 비교객체: "+ s);
		
		// 두 학생객체의 비교 - 비교기준: 성적
		return Integer.compare(score, s.score);
	} // compareTo
	
} // end class

