package sec07.exam02_data_read_write;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerExample {
	
	
	public static void main(String[] args) {
		
		ServerSocket serverSocket = null;
		
		try {
			//---------------------------------//
			serverSocket = new ServerSocket();	
			
//			serverSocket = new ServerSocket(5001);		
			serverSocket.bind(
				new InetSocketAddress("localhost", 5001)
			); // 서버 포트 바인딩 수행
			//---------------------------------//

			//---------------------------------//
			// 무한루프안에서 지속적인 연결요청 수락 및
			// Socket 객체 생성 수행
			//---------------------------------//
			while(true) {
				//---------------------------------//
				System.out.println( "[연결 기다림]");
				
				Socket socket = 
					serverSocket.accept(); // Blocking I/O
				//---------------------------------//

				//---------------------------------//
				// 연결된 클라이언트의 IP주소와 Port정보 추출
				// 1) InetAddress -> IP주소만 저장
				// 2) InetSocketAddress -> IP주소+Port 저장
				InetSocketAddress isa = 
					(InetSocketAddress) 
						socket.getRemoteSocketAddress();
				//---------------------------------//
				
				System.out.println(
					"[연결 수락함] " + isa.getHostName());

				
				//---------------------------------//
				// 여기서부터, PDU(Packet Data Unit) 설계에
				// 따라서 연결된 클라이언트와 데이터 송/수신
				// 수행
				//---------------------------------//				
				byte[] bytes = null;
				String message = null;

				//---------------------------------//
				// 1. Socket에서 입력스트림 얻기
				//---------------------------------//
				InputStream is = 
						socket.getInputStream();

				//---------------------------------//
				// 2. 바이트 기반의 입력스트림으로부터,
				//    클라이언트가 송신한 메시지 수신
				//---------------------------------//
				bytes = new byte[100];  // 끌채 생성
				
				int readByteCount = 
						is.read(bytes); // 데이터 수신

				//---------------------------------//
				// 3. 수신한 바이트 기반의 데이터를, 
				//    문자열로 변환 및 수신 메시지 출력
				//
				// 	  byte[] ---> String 으로 변환
				//---------------------------------//
				message = 
					new String(
							bytes, 
							0, 
							readByteCount, 
							"UTF-8");
				
				System.out.println(
					"[데이터 받기 성공]: " + message);
				//---------------------------------//
				
				//---------------------------------//
				// 4. 클라이언트로 응답 메시지 보내기
				//    이를 위해, 우선 Socket 객체로부터
				//    바이트 기반의 출력스트림 얻기
				//---------------------------------//
				OutputStream os = 
						socket.getOutputStream();
				
				// 클라이언트로 송신할 메시지 준비
				message = "Hello Client";

				//---------------------------------//
				// 5. 송신할 메시지를 바이트 배열로 변환
				//    왜? 바이트 기반의 출력스트림이기 때문에.
				// 
				//    String --> byte[] 로 변환
				//---------------------------------//
				bytes = message.getBytes("UTF-8");
				
				//---------------------------------//
				// 6. 출력스트림으로 바이트배열 송신
				//---------------------------------//
				os.write(bytes);	// 바이트배열 송신
				
				os.flush();			// 출력버퍼 강제flush
				
				System.out.println( "[데이터 보내기 성공]");

				//---------------------------------//
				// 7. 클라이언트와의 대화(메시지 송수신)가
				//    모두 종료되었으니, 사용한 자원객체 반납
				//---------------------------------//
				is.close();
				os.close();
				
				// * 주의 * 
				// 자원객체 반납시, 입/출력 스트림 객체를 먼저
				// 닫은 후에, 맨 마지막으로 Socket 객체를 닫음
				socket.close();
			} // while
			
		} catch(Exception e) {
			;;
		} finally {
			//---------------------------------//
			// 8. 서버로서의 역할도 끝나면, ServerSocket
			//    객체도 자원반납시킴(학실히~~~)
			//---------------------------------//
			if(!serverSocket.isClosed()) { // 닫혀있나요?
				try {
					serverSocket.close();  // 닫습니다.
				} catch (IOException e1) { ;; }
			} // if
		} // try-catch-finally
		
	} // main
	
} // end class
