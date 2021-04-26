package sec02.exam04_writer_write;

import java.io.FileWriter;
import java.io.Writer;


public class WriteExample1 {

	public static void main(String[] args) 
		throws Exception {
		
		//------------------------------------//
		// 문자기반의 '파일' 출력스트림 객체 생성
		// Lvalue Type : 추상클래스
		// Rvalue Type : Lvalue의 구현(자식)클래스
		Writer writer = 
			new FileWriter("C:/Temp/test.txt");
		
		//------------------------------------//
		// 출력시킬 문자열을, char[]로 변환
		// 즉, 문자열 ----> char[]
		char[] data = "홍길동".toCharArray();
		
		// 문자열의 길이만큼, 루프를 돌면서
		// 1개의 문자씩 출력스트림에 전송
		// 실제 출력은, 출력스트림이 가지는 
		// '출력버퍼(최대8192문자)' 에 출력하는 것임!!!
		for(int i=0; i<data.length; i++) {
			// 매개변수의 타입은 int임 
			// 그런데, 문자(char type)을 전달해도 OK!????
			writer.write(data[i]); // 1개 문자 전송
		} // for
		
		//------------------------------------//
		
		writer.flush(); // 출력버퍼에 잔류하는 문자들을 flush
		writer.close(); // 출력스트림 닫기(자원반납)
	} // main

} // end class
