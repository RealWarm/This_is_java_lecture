package sec07.exam02_data_read_write;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;


public class ClientExample {
	
	
	public static void main(String[] args) {
		Socket socket = null;
		
		try {
			//-------------------------------------//
			socket = new Socket();
			System.out.println( "[연결 요청]");
			
			socket.connect(
				new InetSocketAddress("localhost", 5001)
			);
			
			System.out.println( "[연결 성공]");
			//-------------------------------------//
			
			
			//---------------------------------//
			// 여기서부터, PDU(Packet Data Unit) 설계에
			// 따라서 연결된 서버와 데이터 송/수신 수행
			//---------------------------------//			
			byte[] bytes = null;
			String message = null;

			//---------------------------------//
			// 1. Socket 객체로부터, 바이트기반의
			//    출력스트림 객체 얻기
			//---------------------------------//
			OutputStream os = 
				socket.getOutputStream();

			//---------------------------------//
			// 2. 서버로 전송할 메시지 준비
			//---------------------------------//
			message = "Hello Server";

			//---------------------------------//
			// 3. 서버로 전송하기 위해, Socket 객체로부터
			// 얻어낸 출력스트림은 바이트 기반이기 때문에
			// 전송할 메시지를 바이트 배열로 변환
			//---------------------------------//
			bytes = message.getBytes("UTF-8");

			//---------------------------------//
			// 4. 서버로 준비된 바이트 배열(송신 메시지)을
			//    바이트 기반의 출력스트림으로 전송
			//---------------------------------//
			os.write(bytes);	// 출력버퍼에 쓰기
			
			os.flush();			// 출력버퍼 강제Flush
			
			System.out.println( "[데이터 보내기 성공]");

			//---------------------------------//
			// 5. 서버로 메시지 전송 후에, 서버로부터
			//    메시지를 받기로 설계(PDU)했기 때문에,
			//    Socket 객체로부터 바이트 기반의 입력스트림
			//    객체를 얻어냄
			//---------------------------------//
			InputStream is = 
				socket.getInputStream();

			//---------------------------------//
			// 6. 바이트 기반의 입력스트림으로부터,
			//    서버가 보내오기로 한 메시지 수신
			//---------------------------------//
			bytes = new byte[100];	// 끌채 준비
			int readByteCount = 
				is.read(bytes);		// 끌채로 읽어내기

			//---------------------------------//
			// 6. 서버가 보낸 데이터는 문자열 메시지
			//    이므로, 입력스트림에서 읽어낸 바이트 배열
			//    (끌채안에 저장된 데이터)을 문자열(String)로
			//    변환
			//
			//    * byte[] ---> String 으로 변환
			//---------------------------------//
			message = 
				new String(
					bytes, 
					0, 
					readByteCount, 
					"UTF-8"
				);
			
			// 변환된 수신 메시지 출력
			System.out.println(
				"[데이터 받기 성공]: " + message);

			//---------------------------------//
			// 7. 서버와의 모든 메시지 송수신이 종료
			//    되었으므로(PDU에 따라), 자원객체 반납 수행
			//---------------------------------//
			os.close();		// 출력스트림 객체 닫기
			is.close();		// 입력스트림 객체 닫기
			
		} catch(Exception e) {
			;;
		} finally {	
			//---------------------------------//
			// 8. 맨 마지막으로, 학실히~~~, 
			//    Socket 객체 닫기
			//---------------------------------//
			if(!socket.isClosed()) {  // 닫혀있나요?
				try {
					socket.close();	  // 닫습니다!!!
				} catch (IOException e1) {;;}
			} // if
		} // try-catch-finally
		
	} // main
	
} // end class