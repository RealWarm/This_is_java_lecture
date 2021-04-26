package sec05.exam01_inputstreamreader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;


public class InputStreamReaderExample {
	
	
	public static void main(String[] args) 
		throws Exception {
		
		// 1. 바이트 기반의 입력스트림을, 문자기반의 입력스트림으로 변환
		//    즉, 원래 입력스트림 + 보조스트림(문자변환) 생성
		InputStream is = System.in;
		Reader reader = new InputStreamReader(is);	
		
		// 2. 문자변환 보조스트림을 이용하여, 입력 수행
		int readCharNo;				 // 입력시, 실제 읽은 문자수 저장
		char[] cbuf = new char[100]; // 100문자크기의 끌채 생성
		
		// 3. 입력스트림의 끝(EOF,-1값)까지 반복적으로 read 수행
		while ((readCharNo=reader.read(cbuf)) != -1) {
			// 읽은 문자수만큼의 문자배열(끌채) --> 문자열로 변환!
			String data = new String(cbuf, 0, readCharNo);
			
			System.out.println(data);	// 변환된 문자열 출력
		} // while
		
		// 4. 입/출력 스트림은 다 사용하고 나면, 반드시 닫아준다!(자원반납)
//		reader.close();
	} // main
	
} // end class

