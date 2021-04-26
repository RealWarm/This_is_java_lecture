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
	public int compareTo(Student s /*�񱳰�ü�� Ÿ��*/) {
		log.info("---------------------------------");
		log.info("Student::compareTo(s) invoked.");
		log.info("\t+ ���ذ�ü: "+ this);
		log.info("\t+ �񱳰�ü: "+ s);
		
		// �� �л���ü�� �� - �񱳱���: ����
		return Integer.compare(score, s.score);
	} // compareTo
	
} // end class

