package sec03.exam03_scanner;

import java.util.Scanner;


public class ScannerExample {
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("1. ���ڿ� �Է�> ");
		
		String inputString = scanner.nextLine();
		System.out.println(inputString);		
		System.out.println();
		
		//----------------------------------//
		
		System.out.print("2. ���� �Է�> ");
		
		int inputInt = scanner.nextInt();
		System.out.println(inputInt);
		System.out.println();
		
		scanner.nextLine();
		
		//----------------------------------//
		
		System.out.print("3. �Ǽ� �Է�> ");
		
		double inputDouble = scanner.nextDouble();
		System.out.println(inputDouble);
		
		//----------------------------------//
		scanner.close(); // �ڿ��ݳ�!!!
	} // main
	
} // end class
