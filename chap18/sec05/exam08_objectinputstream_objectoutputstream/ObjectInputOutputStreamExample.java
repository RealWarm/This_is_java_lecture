package sec05.exam08_objectinputstream_objectoutputstream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;



public class ObjectInputOutputStreamExample {
	
	
	public static void main(String[] args) 
		throws Exception {
		
		// 1. 바이트기반의 파일 출력스트림 생성
		FileOutputStream fos = 
			new FileOutputStream("C:/Temp/Object.dat");
		
		// 2. 원래의 파일출력스트림에 객체출력 보조스트림 추가
		ObjectOutputStream oos = 
			new ObjectOutputStream(fos);		
		
		// 3. 객체보조스트림이 제공하는 writeObject(Object)
		//    메소드를 호출하여, 파일에 자바 객체 저장
		oos.writeObject(new Integer(10)); // Integer객체
		oos.writeObject(new Double(3.14)); // Double객체
		oos.writeObject(new int[] { 1, 2, 3 }); // 배열객체
		oos.writeObject(new String("홍길동")); // 문자열객체
		
		oos.flush(); // 출력버퍼에 잔류하는 바이트 강제 Flush	
		
		// 4. 모든 스트림 객체 닫기(닫는 순서 중요)
		//    보조스트림 닫기 > 원래의 스트림 닫기
		oos.close(); 
		fos.close();
		
//		System.exit(0);
		
		
		
		
		//-----------------------------------------//
		// Part2: 객체의 역직렬화 과정을 통해, 파일에 저장된
		//        자바객체를 복원(읽기)
		//-----------------------------------------//
		
		// 1. 바이트 기반의 파일입력스트림 생성
		FileInputStream fis = 
				new FileInputStream("C:/Temp/Object.dat");
		
		// 2. 객체의 역직렬화 과정을 이용한 자바객체를 파일로부터
		//    복원하기 위하여 객체 입력보조스트림 생성
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		// 3. ObjectInputStream 은 readObject() 메소드를
		//    호출하여, 파일에 저장된 개별 자바 객체를 복원(읽음)
		Integer obj1 = (Integer) ois.readObject();
		Double obj2 = (Double) ois.readObject();
		int[] obj3 = (int[]) ois.readObject();
		String obj4 = (String) ois.readObject();

		// 4. 모든 스트림 객체 닫기(닫는 순서 중요)
		//    보조스트림 닫기 > 원래의 스트림 닫기
		ois.close(); 
		fis.close();
		
		// 5. 파일로부터 복원한 자바객체 출력
		System.out.println(obj1);
		System.out.println(obj2);
		System.out.println(
			obj3[0] + "," + obj3[1] + "," + obj3[2]);
		System.out.println(obj4);
	} // main
	
} // end class
