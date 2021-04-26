package sec02.exam01_inputstream_read;

import java.io.FileInputStream;
import java.io.InputStream;


public class ReadExample2 {

	
	public static void main(String[] args) 
		throws Exception {
		
		InputStream is = 
			new FileInputStream("C:/Temp/test.txt");
		
		int readByteNo;
		
		// 바이트 기반의 입력스트림으로부터, 지정된 크기만큼
		// 한번에 여러 바이트를 읽어오는 예제
		byte[] readBytes = new byte[3];   // 크기가 3인배열
		
		String data = "";
		
		while( true ) {
			readByteNo = is.read(readBytes);
			
			if(readByteNo == -1) { // if EOF(-1)
				break;
			} // if
			
			data += new String(readBytes, 0, readByteNo);
		} // while
		
		System.out.println(data);
		
		is.close(); // 자원반납
	} // main

}
