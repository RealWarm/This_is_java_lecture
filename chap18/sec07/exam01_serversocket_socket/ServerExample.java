package sec07.exam01_serversocket_socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExample {
	
	
	public static void main(String[] args) {
		// 1. 클라이언트의 연결요청을 수락하고, 
		//    서버 끝단(end point)을 표현하는 Socket 객체 생성.
		ServerSocket serverSocket = null;
		
		try {
			// 연결요청 수락 및 새로운 Socket 객체 생성을 위한
			// ServerSocket 객체 생성
			serverSocket = new ServerSocket();
//			serverSocket = new ServerSocket(5001);
			
			// 특정 포트(이를, 바인딩 포트라 함)로 
			// 포트 바인딩 수행
			// 주의) Binding Port, Binding
			serverSocket.
				bind(
					// InetSocketAddress ????
					new InetSocketAddress(
							"localhost", 	// IP주소
							5001			// 포트번호
						) 
				); // Port Binding 수행
			
			System.out.println(
				"- serverSocket: "+serverSocket);
			
			// 무한루프를 수행하면서, 서버는 항시 새로운
			// 클라이언트의 연결요청을 기다림(대기상태,blocking)
			while(true) {
				System.out.println( "[연결 기다림]");
				//--------------------------------
				// ServerSocket의 accept() 메소드 호출하면,
				// 클라이언트로부터 새로운 연결요청이 들어오기
				// 전까지 블록킹 됨(blocking, 대기상태)
				
				Socket socket = serverSocket.accept();
				
				System.out.println(
					"- Connected socket: "+ socket);

				//--------------------------------
				// 위의 accept() 메소드가 blocking 상태에서
				// 빠져나오면(즉, 새로운 연결요청이 들어왔으면)
				// 데이터 통신을 위한, 서버측의 끝단을 표현하는
				// 새로운 Socket 객체 생성
				InetSocketAddress isa = 
					(InetSocketAddress) 
						socket.getRemoteSocketAddress();
				
				System.out.println(
						"- isa: "+ isa);
				
				//--------------------------------
				// 연결요청이 수락된 클라이언트의 IP주소 출력
				System.out.println(
					"[연결 수락함] " + 
					isa.getHostName());
			} // while
		} catch(Exception e) {
			;;  // 서버 수락과정에서 문제발생시, 아무것도 안함??
		} // try-catch

		//--------------------------------
		// ServerSocket, Socket 객체 모두
		// 자원객체로, 사용이 끝나면, 반드시 close() 수행하여
		// 자원반납 시켜야 함(**** 매우중요, 이를 안할 시,
		// 서버 장애 유발 ****)
		if(!serverSocket.isClosed()) { // 이미 닫혔나요?
			try {
				serverSocket.close();  // 닫아줌(자원반납)
			} catch (IOException e1) { 
				;; 
			} // try-catch
		} // if
		
	} // main
	
} // end class
