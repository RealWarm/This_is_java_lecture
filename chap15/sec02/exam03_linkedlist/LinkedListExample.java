package sec02.exam03_linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class LinkedListExample {
	
	
	// List �÷��� ������:
	//	1) ���� ����
	//	2) �ߺ� ���� ���
	public static void main(String[] args) {
		
		// ArrayList:
		//	����� ����/����/���Կ��� ���ɻ� ����
		//  ������ �޸� ��������, �˻������� ����!!!
		List<String> list1 = new ArrayList<>();
		
		// LinkedList:
		//  ����� ����/����/���Կ��� ���ɻ� ����
		//  ����� ������ ������屸���� ���Ͽ�, �˻����ɿ���
		//  ������ ������!!!!
		List<String> list2 = new LinkedList<>();
		
		
		//--------------------------------------//
		// ArrayList�� LinkedList�� �������� �� ��
		//--------------------------------------//
		long startTime;
		long endTime;
		
		//--------------------------------------//
		// 1. ArrayList ��������
		//--------------------------------------//
		
		startTime = System.nanoTime();
		
			for(int i=0; i< 10000; i++) {
				// String.valueOf(value) - ���� ���(***)
				// ���� �޼ҵ��, �Ű����� ���ڿ��� ��ȯ����
				// �ִ� �޼ҵ��Դϴ�.
				
				list1.add(0, String.valueOf(i));
				
				// ArrayList�� �� ó���� ���ο� ���ڿ� ��Ҹ�
				// �߰��ϴ� �ڵ�
			} // for
		
		endTime = System.nanoTime();
		
		System.out.println(
			"ArrayList �ɸ��ð�: " + 
			(endTime-startTime) + " ns");
		
		//--------------------------------------//
		// 2. LinkedList ��������
		//--------------------------------------//
		
		startTime = System.nanoTime();
		
			for(int i=0; i < 10000; i++) {
				list2.add(0, String.valueOf(i));
				
				// LinkedList�� �� ó���� 
				// ���ο� ���ڿ� ��Ҹ� �߰��ϴ� �ڵ�
			} // for
			
		endTime = System.nanoTime();
		
		System.out.println(
			"LinkedList �ɸ��ð�: " + 
			(endTime-startTime) + " ns");
		
		
		String str1 = "Yoseph";
		String str2 = new String("Yoseph");
		
		
		Object o1 = new Object();
		Object o2 = new Object();
		
		if(o1 == o2) {
			
		} // if 1
		
		if(o1.equals(o2)) {
			
		} // if 2
		
	} // main
	
} // end class



