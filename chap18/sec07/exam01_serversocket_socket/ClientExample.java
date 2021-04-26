package sec07.exam01_serversocket_socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientExample {
	
	
	public static void main(String[] args) {
		// 데이터 통신용, Socket 객체 생성
		Socket socket = null;
		
		try {
			// 1. 데이터 통신용 소켓 객체 생성
			socket = new Socket();
			System.out.println(
				"1. Before connecting: "+socket);
			
			// 2. 서버로 클라이언트 연결요청 생성 및 전송
			System.out.println( "[연결 요청]");
			
			// 실제 서버로 연결요청을 보내는 메소드는 아래의
			// connect() 메소드임!!!!2
			socket.connect( 
				// SocketAddress : IP주소와 포트번호 정보소유
				// InetSocketAddress extends SocketAddress
				new InetSocketAddress(
					"localhost", 	// 서버 IP주소
					5001			// 서버 바인딩 포트번호
				) // InetSocketAddress
			); // connect
			
			// 3. 서버에서 연결수락 및 소켓객체 출력
			System.out.println( "[연결 성공]");
			System.out.println(
					"2. After connecting: "+socket);
		} catch(Exception e) { // 예외발생시 처리
			;;
		} finally {
			// 자원반납(확실히 하자!!!)
			if(!socket.isClosed()) {
				try { socket.close(); } 
				catch (IOException e1) {;;} // try-catch
			} // if	
		} // try-catch-finally
		
	} // main
	
} // end class