package sec05.exam04_bufferedreader;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;


public class BufferedReaderExample {

	
	public static void main(String[] args) 
		throws Exception {
		
		// 1. 바이트 기반의 표준입력스트림을 지역변수에 저장
		InputStream is = System.in;
		
		// 2. 바이트 기반의 입력스트림 --> 문자기반의 입력스트림
		//    으로 변환(즉, InputStream --> Reader로 변경)
		//    해주는 보조스트림인 InputStreamReader 사용
		Reader reader = new InputStreamReader(is);	
		
		// 3. 보조스트림 체인 구성
		//    변환된 문자기반 입력스트림에 다시,
		//    성능향상 보조스트림을 추가
		BufferedReader br = new BufferedReader(reader);
		
		// 4. 문자기반의 입력스트림을 통해, 사용자가 콘솔에
		//    입력하는 데이터를 읽음(행단위로 입력받음)
		System.out.print("입력: ");
		String lineString = br.readLine();
		
		// 5. 사용자가 입력한 데이터를 표준출력으로 출력
		System.out.println("출력: " + lineString);	
	} // main
	
} // end class