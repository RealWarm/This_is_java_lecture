package sec03.exam01_hashset;

import java.util.*;


public class HashSetExample1 {
	
	
	// -- Set �÷����� ������:
	//    1) ������ �������� ����(�����ָӴ�)
	//    2) �ߺ��� ������� ����(������ ����Ư��)
	public static void main(String[] args) {
		// ���(����)�� Ÿ���� ���ڿ��� Set �÷���
		// �ڷᱸ�� ����
		Set<String> set = new HashSet<>();
		
		//---------------------------------//
		
		// ��� �߰�
		set.add("Java");			// �ߺ��ܾ�
		set.add("JDBC");
		set.add("Servlet/JSP");
		set.add("Java");			// �ߺ��ܾ�
		set.add("iBATIS");
		
		System.out.println("- set: "+ set);
//		System.exit(0);
		
		//---------------------------------//
		
		// ��� ����
		int size = set.size();
		System.out.println("�� ��ü��: " + size);
		
		//---------------------------------//		
		// �ݺ���(Iterator)�� ���� , ��� ���� ��ü��
		// ��ȸ(Traverse)
		Iterator<String> iterator = set.iterator();
		
		// hasNext(): ��ȸ�� ������ ������ �����ֽ��ϱ�?
		while(iterator.hasNext()) { 
			// next() : ���������� �ּ���!!!(ȹ��)
			String element = iterator.next();
			
			System.out.println("\t" + element);
		} // while
		
		//---------------------------------//
		// Set �÷��ǿ���, ��� ����
		//---------------------------------//
		set.remove("JDBC");
		set.remove("iBATIS");
		
		System.out.println("�� ��ü��: " + set.size());
		
		for(String element : set) {
			System.out.println("\t" + element);
		} // enhanced for

		//---------------------------------//
		// Set �ڷᱸ���� ��� ��� ����
		//---------------------------------//
		set.clear();		
		
		if(set.isEmpty()) { 
			System.out.println("��� ����"); 
		} // if
		
		set = null;		// �ſ� �߿� ******!!!!
		
	} // main
	
} // end class

