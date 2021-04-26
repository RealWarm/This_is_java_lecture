package sec01.stream_introduction;

import java.util.Arrays;
import java.util.List;

public class MapAndReduceExample {

	
	public static void main(String[] args) {	
		//----------------------------------------------//
		// 1. �л�(Student)�� ��ҷ� ������ ����Ʈ ��ü ����
		//----------------------------------------------//
		List<Student> studentList = Arrays.asList(
				new Student("ȫ�浿", 10),
				new Student("�ſ��", 20),
				new Student("���̼�", 30)
		); // �л� ����Ʈ ����
		
		//----------------------------------------------//
		// 2. �л� ����Ʈ�κ��� Stream ��ü ���
		//    ���Ҿ, �޼ҵ� ü��(Method Chain) ����� �̿�
		//    �Ͽ�, �߰�ó������ ~ ����ó������ �Ѳ����� ������
		//    �� �ڵ� ����
		//----------------------------------------------//
		double avg = 
				studentList.
					// 2-1. ����Ʈ�κ��� ��Ʈ�� ����
					stream().
					// 2-2. �߰�ó��(�л� ��ü --> ������ ����)
					mapToInt( Student::getScore ).
//					mapToInt(Student :: getScore).
					// 2-3. ���� ó��(������� - ��� ����)
					average().
					// 2-4. ���� ó�� ����� Double �⺻Ÿ��
					//      ������ ����
					getAsDouble();
		
		// ����ó������� �л��� ��������� �ֿܼ� ���
		System.out.println("��� ����: " + avg);
	} // main
	
} // end class
