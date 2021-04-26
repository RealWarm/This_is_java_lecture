package sec02.exam03_reader_read;

import java.io.FileReader;
import java.io.Reader;


public class ReadExample1 {

	
	public static void main(String[] args) 
		throws Exception {
		//--------------------------------------//
		Reader reader = 
			new FileReader("C:/Temp/test.txt");
		
		//--------------------------------------//
		
		int readData;	// 입력스트림에서 읽은 1개의 문자를
						// 저장할 지역변수
		
		while( true ) {
			readData = reader.read(); // 1개의 문자를 읽음
			
			if(readData == -1) { // 입력스트림의 끝(EOF)에
				                // 도달하면, loop를 빠져나감
				break;     
			} // if
			
			// 읽어낸 1개의 문자를 출력
			// 그런데, 왜 char 타입으로 강제형변환이 필요할까?
			System.out.print( (char) readData );
		} // while
		
		//--------------------------------------//
		
		reader.close();	// 입력스트림 닫기(자원반납)
	
	} // main

} // end class
