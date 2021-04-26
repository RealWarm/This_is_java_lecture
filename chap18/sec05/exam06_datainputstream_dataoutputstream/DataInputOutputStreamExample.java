package sec05.exam06_datainputstream_dataoutputstream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DataInputOutputStreamExample {
	
	
	public static void main(String[] args) 
		throws Exception {
		
		// 기본타입의 변수에 저장된 데이터를 가지고
		// 입/출력을 수행하고자 할 때에는,
		// DataInputStream/DataOutputStream을 사용
		
		// 원래의 바이트기반의 파일출력스트림 생성
		FileOutputStream fos = 
			new FileOutputStream("C:/Temp/primitive.dat");
		
		// 기본타입 기반의 보조 출력스트림 추가
		DataOutputStream dos = 
				new DataOutputStream(fos);
		
		//----------------------------------
		// 기본타입의 값으로 출력수행
		//----------------------------------
		dos.writeUTF("홍길동");		// 1. 문자열 출력
		dos.writeDouble(95.5);		// 2. double 값 출력
		dos.writeInt(1);			// 3. int 값 출력
		
		dos.writeUTF("감자바");		// 4. 문자열 출력
		dos.writeDouble(90.3);		// 5. double 값 출력
		dos.writeInt(2);			// 6. int 값 출력
		
		// 사용한 스트림 닫기 (닫는 순서 중요)
		// 보조스트림 닫기 > 원래의 스트림 닫기 순서로...
		dos.flush(); 
		dos.close(); 
		fos.close();
		
		//-------------------------------------//
		// 쓴 파일을 역으로 읽어냄
		//-------------------------------------//
		
		FileInputStream fis = 
			new FileInputStream("C:/Temp/primitive.dat");
		
		// 기본타입으로 입력수행위한 보조스트림 추가
		DataInputStream dis = new DataInputStream(fis);
		
		// 2회에 걸쳐서...
		for(int i=0; i<2; i++) {
			String name = dis.readUTF();	// 1. 문자열
			double score = dis.readDouble();// 2. double	
			int order = dis.readInt();		// 3. int
			
			System.out.println(
				name + " : " + 
				score + " : " + 
				order);
		} // for
		
		// 사용이 끝난 스트림 닫기(닫는순서 중요)
		dis.close(); 
		fis.close();
	} // main
	
} // end class

