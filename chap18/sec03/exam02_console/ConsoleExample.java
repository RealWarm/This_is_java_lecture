package sec03.exam02_console;

import java.io.Console;

public class ConsoleExample {
	
	
	public static void main(String[] args) {
		// 1. Console ��ü ȹ��
		Console console = System.console();
		
		
		// 2. �ü�� �ַܼκ���, ���̵� �Է¹���
		System.out.print("���̵�: ");
		
		String id = console.readLine();
		
		
		// 3. �ü�� �ַܼκ���, ��ȣ �Է¹���
		System.out.print("�н�����: ");
		
		char[] charPass = console.readPassword();
		String strPassword = new String(charPass);
		
		// 4. �ü�� �ַܼκ��� �Է¹���, ���̵�� ��ȣ��
		//    ���
		System.out.println("---------------------");
		System.out.println(id);
		System.out.println(strPassword);
	} // main
	
} // end class
