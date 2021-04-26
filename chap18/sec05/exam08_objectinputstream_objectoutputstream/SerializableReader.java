package sec05.exam08_objectinputstream_objectoutputstream;

import java.io.FileInputStream;
import java.io.ObjectInputStream;


public class SerializableReader {
	
	
	public static void main(String[] args) 
		throws Exception {
		
		// 1. 객체가 저장되어 있는 파일로부터, 자바객체를
		//    복원하여 사용하기 위해, 
		//    우선, 바이트기반의 입력스트림 생성
		FileInputStream fis = 
			new FileInputStream("C:/Temp/Object.dat");
		
		
		// 2. 객체입력 보조스트림 추가
		ObjectInputStream ois = 
			new ObjectInputStream(fis);
		
		
		// 3. ObjectInputStream 의 Object readObject()
		//    메소드를 호출하여, 객체의 역직렬화 및 자바객체복원
		//    return type이 Object 이므로 원래타입으로 강제
		//    형변환 필요.
		ClassA v = (ClassA) ois.readObject();
		
		
		// 4. 복원된 자바객체의 필드값을 출력해 봄으로써,
		//    처음부터 객체의 직렬화에서 제외된 필드가 어떻게
		//    복원되는지 확인필요!!!
		System.out.println("field1: " + v.field1);
		System.out.println(
				"field2.field1: " + v.field2.field1);
		
		System.out.println("field3: " + v.field3);
//		System.out.println("field3: " + ClassA.field3);
		
		System.out.println("field4: " + v.field4);
		
		
		// 5. 사용이 끝난 모든 스트림 닫기(순서중요)
		//    보조스트림 닫기 > 원래 스트림 닫기
		ois.close(); 
		fis.close();	
	} // main
	
} // end class
