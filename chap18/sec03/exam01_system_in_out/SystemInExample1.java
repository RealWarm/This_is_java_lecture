package sec03.exam01_system_in_out;

import java.io.InputStream;


public class SystemInExample1 {
	
	public static void main(String[] args) 
		throws Exception {
		
		//-----------------------------------------//
		
		System.out.println("=== 메뉴 ===");
		System.out.println("1. 예금 조회");
		System.out.println("2. 예금 출금");
		System.out.println("3. 예금 입금");
		System.out.println("4. 종료 하기");
		System.out.println();
		
		System.out.print("* 메뉴를 선택하세요: ");
		
		//-----------------------------------------//
		
		// 운영체제가 자동으로 할당해준, 표준입력스트림을 얻음
		// 이때 표준입력스트림의 타입은 바이트기반 입력스트림!
		InputStream is = System.in;
		
		// 표준입력(System.in, 즉, 콘솔과 연결된)으로부터, 
		// 1개의 바이트 읽어옴. 
		// 읽어온 1개의 바이트를 문자타입으로 강제형변환
		// 왜? 사용자가 선택한 메뉴가 무엇인지 알기 위해, 
		// 문자로 강제 형변환함 (그래도, 데이터 유실은 없음)
		char inputChar = (char) is.read();	
		
		//-----------------------------------------//
		
		// 사용자가 선택한 메뉴가 무엇인지에 따라, 다른
		// 응답을 콘솔에 표준출력(System.out)을 통해 출력함!!!
		switch(inputChar) {
			case '1':		// 선택한 메뉴가 1이면,
				System.
					out.	// 표준출력
					println("예금 조회를 선택하셨습니다.");
				
				break;
			case '2':		// 선택한 메뉴가 2이면,
				System.
					out.	// 표준출력
					println("예금 출금를 선택하셨습니다.");
				
				break;
			case '3':		// 선택한 메뉴가 3이면,
				System.
					out.	// 표준출력
					println("예금 입금를 선택하셨습니다.");
				
				break;
			case '4':		// 선택한 메뉴가 4이면,
				System.
					err.	// 표준에러
					println("종료 하기를 선택하셨습니다.");
				
				break;
		} // switch		 	
	} // main
	
} // end class
