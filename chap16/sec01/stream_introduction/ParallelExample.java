package sec01.stream_introduction;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


public class ParallelExample {
	
	
	public static void main(String[] args) {
		//----------------------------------------------//
		// 1. �л�(Student)�� ��ҷ� ������ ����Ʈ ��ü ����
		//----------------------------------------------//
		List<String> list = 
			Arrays.asList(
				"ȫ�浿", 
				"�ſ��", 
				"���ڹ�", 
				"���ٽ�", 
				"�ں���"
			); // �̸� ����Ʈ  ����

		//----------------------------------------------//
		// 2. ����ó�� �������, ��� �̸��� ���ؼ� ����ó������
		//----------------------------------------------//
		// 2-1. ����Ʈ�κ���, ����ó�� ��Ʈ�� ����
		Stream<String> stream = list.stream();
		// 2-2. �� ����ó����Ʈ���� ����ó���޼ҵ� ����
		//      ParallelExample Ŭ������ print() �޼ҵ� ����
		//      �� Task(��, ���ٽ����� ����)�� ����
		stream.forEach(ParallelExample :: print);
		
		System.out.println();

		//----------------------------------------------//
		// 3. ����ó�� �������, ��� �̸��� ���ؼ� ����ó������
		//----------------------------------------------//
		// 3-1. ����Ʈ���� ����ó����Ʈ�� ����
		Stream<String> parallelStream = 
					list.parallelStream();
		
		// 3-2. ����ó����Ʈ���� ����ó���޼ҵ��� forEach()
		//      �޼ҵ带 ����, ��ü��Ҹ� ���ķ� ��ȸ(traverse)
		//      �ϸ鼭, ���ٽ�(�޼ҵ�����)���� ������ task 
		//      ���� �� ����!!!
		parallelStream.forEach(ParallelExample :: print);
	} // main
	
	// �ٸ� �޼ҵ�(�� �޼ҵ带 ������ ȣ����): ****�����޼ҵ� ***
	public static void print(String name) {
		System.out.println(
			name+ " : " + 
			Thread.currentThread().getName()
		); // ������ �ڵ带 �����Ű�� �������� �̸��� ��� ���
	} // print
	
} // end class




