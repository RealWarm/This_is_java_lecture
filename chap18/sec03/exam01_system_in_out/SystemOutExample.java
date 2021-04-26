package sec03.exam01_system_in_out;

import java.io.OutputStream;

public class SystemOutExample {
	
	
	public static void main(String[] args) 
		throws Exception {
		
		// 1. 운영체제가 자동으로 할당해준, 
		// 표준출력(바이트기반의 출력스트림) 획득.
		OutputStream os = System.out;
		
		// 2. From 48 to 57 까지 범위의 정수값을
		//    표준출력(바이트기반의 출력스트림)에 출력.
		for(byte b=48; b<58; b++) {
			os.write(b); // 정수를 출력시킨 결과는 ??
		} // for		
		
		// 3. 정수 10을 출력시킨 결과는 ???
		os.write(10);	// 10 = Line Feed	 
		
		// 4. From 97 to 122 까지 범위의 정수값을
		//    표준출력(바이트기반의 출력스트림)에 출력.
		for(byte b=97; b<123; b++) {
			os.write(b); // 정수를 출력시킨 결과는 ??
		} // for		
		
		// 5. 정수 10을 출력시킨 결과는 ???
		os.write(10);	// 10 = Line Feed	

		// 6. 한글 가~하 까지로 구성된 문자열을
		//    바이트 배열(byte[])로 변환.
		//    즉, String ----> byte[] 로 변환.
		//    왜 변환하나요?.. 출력스트림이 바이트기반 스트림
		//    이기 때문이죠!!
		String hangul = "가나다라마바사아자차카타파하";
		
		byte[] hangulBytes = hangul.getBytes();
		
		// 7. 변환된 바이트 배열(byte[])을 표준출력
		//    (바이트기반의 출력스트림)에 출력
		os.write(hangulBytes);
		
		// 8. 출력스트림에 존재하는, 출력버퍼(8192바이트, 8KB)
		//    에 잔류하는 데이터를 강제로 flush 시킴.
		//    입/출력 스트림을 닫기(close)전에 반드시 한번은
		//    호출필요!!!!(주의)
		os.flush();
		
		// 9. 표준 출력스트림 닫기!!! ---> 이러시면 안됩니다!
		//    왜 표준출력스트림을 닫으면 안될까요???
//		os.close();
	} // main
	
} // end class

