package sec03.exam03_scanner;

import java.util.Scanner;


public class ScannerExample {
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("1. 문자열 입력> ");
		
		String inputString = scanner.nextLine();
		System.out.println(inputString);		
		System.out.println();
		
		//----------------------------------//
		
		System.out.print("2. 정수 입력> ");
		
		int inputInt = scanner.nextInt();
		System.out.println(inputInt);
		System.out.println();
		
		scanner.nextLine();
		
		//----------------------------------//
		
		System.out.print("3. 실수 입력> ");
		
		double inputDouble = scanner.nextDouble();
		System.out.println(inputDouble);
		
		//----------------------------------//
		scanner.close(); // 자원반납!!!
	} // main
	
} // end class
