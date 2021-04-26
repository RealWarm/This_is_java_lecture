package sec02.exam01_inputstream_read;

import java.io.FileInputStream;
import java.io.InputStream;


public class ReadExample1 {

	
	public static void main(String[] args) 
		throws Exception {
		
		// 지정된 파일로부터, 파일의 데이터를 읽어서,
		// console로 출력하는 예제 
		// (입력예제: Reader or InputStream) 
		
		// 파일을 입력소스로 하는,바이트 기반의 입력스트림 생성
		InputStream is = 
			new FileInputStream("C:/Temp/test.txt");
		
		int readByte; // 읽어낸 1바이트를 저장할 지역변수
		
		while(true) {
			// 입력스트림에서, 1바이트 씩 읽어냄!!!!
			readByte = is.read();	
			
			// 파일의 읽다가, 파일의 끝(EOF, End Of File)을 
			// 만나면, read() 메소드는 -1를 반환함
			if(readByte == -1) { 
				break; // loop를 빠져나감!!!
			} // if
			
			// 읽어낸 '바이트'를 '문자'로 강제형변환하여 출력 
			System.out.print( (char) readByte );
		} // while
		
		is.close(); // 입력스트림 닫기(자원반납)
	} // main
	
} // end class
