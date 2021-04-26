package sec03.exam01_system_in_out;

import java.io.InputStream;

public class SystemInExample2 {
	
	
	public static void main(String[] args) 
		throws Exception {
		
		// 1. 표준입력(바이트기반 스트림) 얻기
		InputStream is = System.in;
		
		// 2. 콘솔에서 사용자가 키보드로 입력한 메시지를 저장할
		// 변수정의(바이트 배열. 왜? 바이트기반 입력스트림이기에)
		byte[] datas = new byte[100]; // 최대100바이트까지
		
		// 3. 표준출력으로 메시지 표시
		System.err.print("1. 이름을 입력하세요: ");
		
		// 4. 표준입력(바이트기반 입력스트림)으로부터,
		//    사용자가 입력한 메시지를 읽어옴(끌채로...)
		int nameBytes = is.read(datas);
		// (주의) nameBytes : 실제 읽어온 바이트의 개수
		
		// 5. 표준입력(바이트기반 입력스트림)에서 끌채로
		//    읽어온 바이트 배열(최대100바이트)을 문자열로변환
		//    즉, byte[] ----> String
		//    (주의***) 이때, 바이트 배열의 맨 마지막 2바이트
		//              는 문자열로 변환시키지 않고 제외시킴.
		//              왜????
		String name = new String(datas, 0, nameBytes-2);

		// 5. 표준출력으로 메시지 표시
		System.err.print("2. 하고 싶은말을 입력하세요: ");

		// 6. 표준입력(바이트기반 입력스트림)으로부터,
		//    사용자가 입력한 메시지를 읽어옴(끌채로...)
		int commentBytes = is.read(datas);
		// (주의) commentBytes : 실제 읽어온 바이트의 개수
		
		// 7. 표준입력(바이트기반 입력스트림)에서 끌채로
		//    읽어온 바이트 배열(최대100바이트)을 문자열로변환
		//    즉, byte[] ----> String
		//    (주의***) 이때, 바이트 배열의 맨 마지막 2바이트
		//              는 문자열로 변환시키지 않고 제외시킴.
		//              왜????
		String comment = 
				new String(datas, 0, commentBytes-2);
		
		// 8. 표준출력(바이트기반 출력스트림)으로
		//    사용자가 입력한 이름과 하고싶은 말을 문자열로 
		//    출력함
		System.err.println("입력한 이름: " + name);	
		System.err.println("입력한 하고 싶은말: " + comment);
		
	} // main
	
} // end class

