package sec02.exam02_outputstream_write;

import java.io.FileOutputStream;
import java.io.OutputStream;


public class WriteExample1 {

	
	public static void main(String[] args) 
		throws Exception {
		
		// 1. '바이트' 기반의 '파일' 출력스트림 생성
		OutputStream os = 
			new FileOutputStream("C:/Temp/test1.txt");
		
		//----------------------------------------//
		
		// 2. 출력스트림에 출력시킬 데이터 생성
		//    문자열 -> 바이트 배열로 변환 ********
//		byte[] data = "김동희".getBytes();
		byte[] data = "김동희".getBytes("UTF-8");
		
		//----------------------------------------//
		
		// 3. 출력버퍼에 write 수행
		for(int i=0; i<data.length; i++) {
			// 출력버퍼에 '바이트 배열' 출력
			// (바이트기반 출력스트림 이기 때문)
			
			os.write(data[i]); // 여러바이트들을 한번에 출력	
			
			// 출력버퍼(최대8kb)가 다 차면, 자동으로 flush됨
			// 이를 'autoFlush'라고 함. 하지만, 마지막 출력
			// 이후, 이 출력버퍼가 다 차지 않으면, autoFlush
			// 가 발생하지 않기 때문에, 출력스트림을 닫기 전에
			// 반드시 한번 명시적으로 flush() 메소드를 호출
			// 해야 함!!! (주의)
			
		} // for
		
		//----------------------------------------//
		
		os.flush();	// 출력버퍼에 잔류한 바이트들을 flush
		os.close(); // 출력 스트림을 닫음(자원반납)
	} // main

} // end class
