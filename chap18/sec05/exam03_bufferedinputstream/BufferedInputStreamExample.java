package sec05.exam03_bufferedinputstream;

import java.io.BufferedInputStream;
import java.io.FileInputStream;


public class BufferedInputStreamExample {
	
	
	public static void main(String[] args) 
		throws Exception {
		
		long start = 0;
		long end = 0;
		
		// 1. Original InputStream 생성 (바이트 기반)
		FileInputStream fis1 = 
			new FileInputStream(
					"C:/temp/FileZilla_3.43.0_win64_sponsored-setup.exe");
		
		// 2. 성능측정 1
		start = System.currentTimeMillis();
		
			while(fis1.read() != -1);// 실행문장은 없음. 읽기만수행
		
		end = System.currentTimeMillis();

		// 3. 성능측정 1
		System.out.println(
			"1. 사용하지 않았을 때: " + (end-start) + "ms");
		
		fis1.close();	// 4. 자원반납
		
		//-------------------------------------//
		
		// 1. Original InputStream 생성 (바이트 기반)
		FileInputStream fis2 = 
			new FileInputStream(
				"C:/temp/FileZilla_3.43.0_win64_sponsored-setup.exe");
		
		// 2. 성능향상용 보조스트림 생성
		BufferedInputStream bis = 
			new BufferedInputStream(fis2);
		
		// 3. 성능측정 1
		start = System.currentTimeMillis();
		
			while(bis.read() != -1);// 실행문장은 없음. 읽기만수행

		// 4. 성능측정 2
		end = System.currentTimeMillis();
		
		System.out.println(
			"2. 사용했을 때: " + (end-start) + "ms");
		
		// 5. 스트림 닫기 -> 자원반납
		//    *** 주의사항 1 ***
		//    보조스트림을 사용하는 경우, 스트림을 닫는 순서는,
		//    보조스트림부터 닫고, 마지막으로 original 스트림을 닫음
		// 
		//    *** 주의사항 2 ***
		//    보조스트림으로 스트림 체인을 형성한 경우에도,
		//    가장 바깥쪽 보조 스트림부터 닫고, 마지막으로 원래의 스트림을 닫음
		//
		//    *** 주의사항 3 ***
		//    보조스트림을 설령 닫지 못했다 하더라도, 반드시 원래의 스트림을
		//    닫게 된다면, 이전의 모든 보조스트림도 함께 닫힘
		//
		//    *** 주의사항 4 ***
		//    특히, 출력 스트림에 대한 보조스트림을 포함하여,
		//    출력(보조)스트림을 닫기전에, 일전과 같이, 반드시 flush()를 
		//    수행하여, 버퍼에 잔류하는 데이터를 전송시키고 비울것!!!
		
		bis.close();
		fis2.close();
	} // main
	
} // end class

