package sec05.exam05_bufferedoutputstream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class BufferedOutputStreamExample {
	
	// File Copy Program
	public static void main(String[] args) 
		throws Exception {
		
		// 1. 필요한 지역변수들 선언
		FileInputStream fis = null;
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		// 2. 필요한 지역변수들 선언
		int data = -1;	// 실제 읽어낸 바이트를 저장
		
		long start = 0;
		long end = 0;
		
		//--------------------------------------------
		// 3. File Copy Logic
		// 3-1. Copy할 Target File에 대한 바이트 기반의
		//      입력스트림을 생성
		fis = new FileInputStream(
		"C:/temp/FileZilla_3.43.0_win64_sponsored-setup.exe");
		
		// 3-2. 좀 더 낳은 copy 성능확보를 위해
		//      Buffered 보조입력스트림을 추가
		bis = new BufferedInputStream(fis);
		
		// 3-3. Target file로 Copy 수행위해,
		//      바이트 기반의 출력스트림 생성
		fos = new FileOutputStream("C:/Temp/A.exe");
		
		//----------------------------------------------//
		// 4. File Copy 및 성능측정 (1/1000초 단위-밀리초)
		//    성능향상 보조스트림을 사용하지 않았을 때!!!
		start = System.currentTimeMillis();
		
			while((data = bis.read()) != -1) {
				fos.write(data);
			} // while
			
			fos.flush();
			
		end = System.currentTimeMillis();

		// 5. 사용한 모든 스트림 닫기
		//    이때 순서가 중요함
		//    (보조스트림을 먼저 닫은 후, 원래 스트림 닫기 순서)
		fos.close(); 	
		bis.close();  
		fis.close();
		
		// 5-1. 성능측정결과 출력(1/1000초- 밀리초 단위)
		System.out.println(
			"사용하지 않았을 때: " + (end-start) + "ms");
		
		//------------------------------------------//
		// 성능향상 보조스트림을 사용하였을 때
		//------------------------------------------//
		
		// 1. 바이트 기반의 입/출력 스트림에, 성능향상 보조
		//    스트림을 추가
		fis = new FileInputStream(
			"C:/temp/FileZilla_3.43.0_win64_sponsored-setup.exe");
		
		// 1-1. 성능향상 보조입력스트림 추가
		bis = new BufferedInputStream(fis);
		
		// 1-2. 성능향상 보조출력스트림 추가
		fos = new FileOutputStream(
				"C:/Temp/A.exe");	
		
		bos = new BufferedOutputStream(fos); // 보조
		
		// 2. File copy 성능측정
		start = System.currentTimeMillis();
		
			// Source File의 끝(EOF)까지 읽고
			while((data = bis.read()) != -1) { // if EOF
				bos.write(data); // Target file로 쓰기
			} // while
			
			// 성능향상 보조스트림 내의 출력버퍼에 잔류하는
			// 데이터 강제 flush 시킴
			bos.flush();	// 출력보조스트림 flush
			
		end = System.currentTimeMillis();

		// 3. 사용한 모든 스트림 닫기
		//    이때 순서가 중요함
		//    (보조스트림을 먼저 닫은 후, 원래 스트림 닫기 순서)
		bos.close();	// 출력보조스트림 닫기 
		fos.close(); 	// 원래의 출력스트림 닫기
		
		bis.close(); 	// 입력보조스트림 닫기
		fis.close();	// 원래의 입력스트림 닫기
		
		// 4. 측정결과 출력(1/1000초 - 밀리초 단위)
		System.out.println(
			"사용했을 때: " + (end-start) + "ms");
	} // main
	
} // end class

