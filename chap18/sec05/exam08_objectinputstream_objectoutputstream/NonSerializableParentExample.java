package sec05.exam08_objectinputstream_objectoutputstream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class NonSerializableParentExample {

	
	public static void main(String[] args) 
		throws Exception {
		
		// 1. 객체의 직렬화를 통해, 파일에 자바 객체를 저장하기
		//    위해, 우선 바이트 기반의 파일출력스트림 생성
		FileOutputStream fos = 
				new FileOutputStream("C:/Temp/Object.dat");
		
		
		// 2. 파일출력스트림에 객체직렬화 보조스트림 추가
		ObjectOutputStream oos = 
				new ObjectOutputStream(fos);
		
		
		// 3. Serializable 인터페이스를 구현하지 않은
		//    Child 객체를 생성 및 필드값 초기화
		Child child = new Child();
		child.field1 = "홍길동";
		child.field2 = "홍삼원";
		
		
		// 4. 객체출력보조스트림의 writeObject(Object)
		//    메소드를 호출하여, 출력스트림으로 출력(파일)
		oos.writeObject(child);
		
		oos.flush(); // 출력버퍼에 잔류하는 데이터 강제flush
		
		// 5. 사용한 모든 스트림 객체 닫기(순서 중요)
		//    보조스트림 닫기 > 원래스트림 닫기		
		oos.close(); 
		fos.close();	
		
		//------------------------------------------//
		// 
		
		FileInputStream fis = 
			new FileInputStream("C:/Temp/Object.dat");
		
		
		ObjectInputStream ois = 
			new ObjectInputStream(fis);
		
		Child v = (Child) ois.readObject();
		
		
		System.out.println("field1: " + v.field1);
		System.out.println("field2: " + v.field2);
		
		
		ois.close(); 
		fis.close();
	} // main
	
} // end class
