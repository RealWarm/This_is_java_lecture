package sec01.stream_introduction;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;


// �ܺιݺ����� Iterator ��ü�� Ȱ���
// ���ιݺ����� Stream ��ü�� Ȱ�� ��
public class IteratorVsStreamExample {
	
	
	public static void main(String[] args) {
		List<String> list = 
			Arrays.asList("ȫ�浿", "�ſ��", "���ڹ�");
				
		//-----------------------------------------//
		// 1. �ܺιݺ��ڸ� Ȱ���� ����Ʈ ����� ���
		//-----------------------------------------//		
		Iterator<String> iterator = list.iterator();
		
		while(iterator.hasNext()) {	// �� ���� ��Ұ� �ֳ���?
			String name = iterator.next(); // �׷� �ּ���!
			
			System.out.println(name); // ��Ұ� ���
		} // while
		
		System.out.println();

		//-----------------------------------------//
		// 2. ���ιݺ��ڸ� Ȱ���� ����Ʈ ����� ���
		//-----------------------------------------//
		Stream<String> stream = 
				list.stream(); // ��Ʈ�� ���
		
		// ���ٽ����� �� ��ҿ� ó���ؾ� �� ó���ڵ�(��, Task)��
		// ����!! (���⼭ Task�� �� ��Ұ��� �ֿܼ� ���
		// Stream.forEach() �޼ҵ� ---> ����ó�� �޼ҵ���!!!
		stream.forEach( 
//			name -> System.out.println(name) 
			System.out::println	// �޼ҵ� ����!!!!
		);
	} // main
	
} // end class
