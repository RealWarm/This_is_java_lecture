package sec01.stream_introduction;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


public class LambdaExpressionsExample {
	
	
	public static void main(String[] args) {		
		//----------------------------------------------//
		// 1. �л�(Student)�� ��ҷ� ������ ����Ʈ ��ü ����
		//----------------------------------------------//
		List<Student> list = Arrays.asList(
				new Student("ȫ�浿", 90),	// ���1
				new Student("�ſ��", 92)	// ���2
		); // ����Ʈ ��ü ����

		//----------------------------------------------//
		// 2. ���ιݺ���(Stream)�� �̿��Ͽ�, ��� �л��� �̸���
		//    ������ �ַܼ� ����ϴ� ����
		//----------------------------------------------//
		Stream<Student> stream = 
				list.stream();		// Stream��ü ���
		
		// ����ó�� �޼ҵ��� forEach()�� �̿��Ͽ�
		// ��� ��Ҹ� Traverse(��ȸ)�ϸ鼭, �����ڰ� ������!!
		// ���ٽ��� �����մϴ�.
		stream.forEach(
			
			s -> {
					String name = s.getName();	// �л��̸�
					int score = s.getScore();	// �л�����
					
					System.out.println(name + "-" + score);
			} // Lambda Expression : ó���� Task
			
		); // forEach
		
	} // main
	
} // end class
