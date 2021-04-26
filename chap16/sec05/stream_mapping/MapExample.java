package sec05.stream_mapping;

import java.util.Arrays;
import java.util.List;


public class MapExample {
	
	public static void main(String[] args) {
		//----------------------------------------------//
		// 1. Student ��ü�� ��ҷ� ������ ����Ʈ ��ü ����
		//----------------------------------------------//
		List<Student> studentList =
			// ����Ʈ�� ��ҷ�, Student Ÿ���� ��ü�� ����
			Arrays.asList(
				new Student("ȫ�浿", 10),	// Student #1
				new Student("�ſ��", 20),	// Student #2
				new Student("���̼�", 30)	// Student #3
			); // ����Ʈ ��ü ����

		//----------------------------------------------//
		// 2. ������ ������ ����Ʈ�κ���, Stream(���ιݺ���)
		//    �� ����, ��Ʈ�� ���������� ����
		//----------------------------------------------//
		studentList.
			stream().	// 2-1. ��Ʈ�� ����
			// 2-2. �߰�ó��: mapping
			mapToInt(
//					Student :: getScore
					Student::getScore
			). 
			forEach(	// 2-3. ����ó��: ��ȯ�� ����� �ܼ����
//				score -> System.out.println(score)
				System.out::println // �޼ҵ� ������ ��ü
			);
	} // main
	
} // end class
