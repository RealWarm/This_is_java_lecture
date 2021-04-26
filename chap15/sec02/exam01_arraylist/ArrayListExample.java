package sec02.exam01_arraylist;

import java.util.*;


public class ArrayListExample {
	
	
	// List Ÿ���� �÷���:
	//    1) ������ ����
	//    2) �ߺ��� ���
	public static void main(String[] args) {
		// List �������̽��� �����ϴ� ArrayList �ڷᱸ�� ����
		// ����� Ÿ����, ��üŸ������ String ����
		List<String> list = new ArrayList<String>();
		
		//---------------------------------//
		// �ڷᱸ���� ���(��ü, ������) �߰�
		//---------------------------------//
		list.add("Java");
		list.add("JDBC");
		list.add("Servlet/JSP");
		list.add(2, "Database");	// index ����
		list.add("iBATIS");
		
		System.out.println("- list:\n"+list);
//		System.exit(0);
		
		//---------------------------------//
		// �ڷᱸ���� �پ��� ����(List �������̽��� ���ǵ�
		// �԰�(= ��ü��뼳��)�� ���� ���)
		//---------------------------------//
		int size = list.size();
		
		System.out.println("�� ��ü��: " + size);		
		System.out.println();

		//---------------------------------//
		
		String skill = list.get(2);
		
		System.out.println("2: " + skill);
		System.out.println();

		//---------------------------------//

		for(int i=0; i<list.size(); i++) {
			String str = list.get(i);
			System.out.println(i + ":" + str);
		} // for
		
		for(String element : list) {
			System.out.println(element);
		} // enhanced for
		
		System.out.println();

		//---------------------------------//				
		list.remove(2);
		list.remove(2);
		list.remove("iBATIS");		
		
		for(int i=0; i<list.size(); i++) {
			String str = list.get(i);
			System.out.println(i + ":" + str);
		} // for
		
//		System.exit(0);

		//---------------------------------//
		// ����� �ڿ��ݳ� (������ �÷���)
		//---------------------------------//
		if(list != null && list.size() > 0) {
			list.clear();
			
			list = null;	// �ſ� �߿�!!!!
		} // if
		
	} // main
	
} // end class

