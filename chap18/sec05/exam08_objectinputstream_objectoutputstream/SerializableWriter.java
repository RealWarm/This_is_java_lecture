package sec05.exam08_objectinputstream_objectoutputstream;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;


public class SerializableWriter {
	
	
	public static void main(String[] args) 
		throws Exception {
		
		// 1. 바이트 기반의 파일 출력 스트림 생성
		FileOutputStream fos = 
			new FileOutputStream("C:/Temp/Object.dat");
		
		// 2. 파일 출력스트림에 객체 출력을 위해
		//    객체출력 보조스트림 추가
		ObjectOutputStream oos = 
			new ObjectOutputStream(fos);		
		
		// 3. OOP로 설계한 일반 클래스로부터 객체 생성 및
		//    필드값 초기화
		ClassA classA = new ClassA();
		classA.field1 = 1;
		classA.field2.field1 = 2;	// ClassB 타입필드
		classA.field3 = 3;			// static 필드 ***
		classA.field4 = 4;			// transient 필드 ***
		
		// 4. 파일에 ClassA 타입의 객체 출력
		//    ObjectOutputStream의 writeObject(Object)
		//    메소드 호출을 통해, 객체의 직렬화를 이용하여
		//    파일에 자바 객체 저장
		oos.writeObject(classA);
		
		oos.flush(); // 출력버퍼에 잔류하는 데이터 강제flush
		
		// 5. 사용이 끝난 모든 스트림 닫기(순서중요)
		//    보조스트림 닫기 > 원래 스트림 닫기
		oos.close(); 
		fos.close();	
	} // main
	
} // end class
