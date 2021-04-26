package sec02.exam01_inputstream_read;

import java.io.FileInputStream;
import java.io.InputStream;

public class ReadExample3 {

	
	public static void main(String[] args) 
		throws Exception {
		
		// 바이트 기반의 파일 입력스트림 생성
		// 모든 종류의 파일을 읽을 수 있음(텍스트파일도 포함)
		InputStream is = 
			new FileInputStream("C:/Temp/test.txt");
		
		int readByteNo;	// 실제 읽어온 바이트의 갯수저장
		
		// 한번에 입력스트림에서 바이트를 읽어올 수 있는,
		// 끌채의 크기를 8바이트 배열로 생성
		byte[] readBytes = new byte[8];
		
		// 세번째 read() 메소드에, 끌채(8바이트크기)를 전달
		// 하여, 최대 8바이트씩 입력스트림에서 읽기 가능
		// 하지만, read(byte[], int offset, int length)
		// 의 메소드를 이용하기 때문에, 끌채의 전체 크기를
		// 이용하지 않고, 고작 3바이트씩만 읽어오게 하였음
//		readByteNo = is.read(readBytes, 2, 3);
		
		readByteNo = is.read(readBytes, 0, readBytes.length);
		readByteNo = is.read(readBytes);
		
		
		// 실제 읽어온 바이트의 값을 콘솔로 출력
		for(int i=0; i<readBytes.length; i++) {
			System.out.println(readBytes[i]);
		} // for
		
		is.close();	// 자원반납
	} // main

} // end class
