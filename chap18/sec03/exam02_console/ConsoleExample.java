package sec03.exam02_console;

import java.io.Console;

public class ConsoleExample {
	
	
	public static void main(String[] args) {
		// 1. Console 객체 획득
		Console console = System.console();
		
		
		// 2. 운영체제 콘솔로부터, 아이디 입력받음
		System.out.print("아이디: ");
		
		String id = console.readLine();
		
		
		// 3. 운영체제 콘솔로부터, 암호 입력받음
		System.out.print("패스워드: ");
		
		char[] charPass = console.readPassword();
		String strPassword = new String(charPass);
		
		// 4. 운영체제 콘솔로부터 입력받은, 아이디와 암호를
		//    출력
		System.out.println("---------------------");
		System.out.println(id);
		System.out.println(strPassword);
	} // main
	
} // end class
