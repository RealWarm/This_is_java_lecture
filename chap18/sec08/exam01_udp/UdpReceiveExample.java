package sec08.exam01_udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;


public class UdpReceiveExample {
	
	
	public static void main(String[] args) 
		throws Exception {
		
		//-------------------------------------
		// 1. 데이터(패킷)를 보내기 위한 편지봉투 생성
		//    여기서, 편지봉투가 바로 DatagramSocket 객체임
		//-------------------------------------
		// 수신자 PC가 가지고 있는 모든 IP주소에 대하여,
		// 지정된 바인딩 포트로 수신대기 하는 것임
		// 그럼, 수신자 PC가 가지고 잇는 한 개 이상의 IP주소중에
		// 특정 IP주소로 들어오는 메시지만 수신하고 싶을 때에는?
		// API 문서에서 추가로 다른 생성자가 있는지 확인해봐야
		// 하겠죠??
		DatagramSocket datagramSocket = 
			new DatagramSocket(5001); // 5001포트 바인딩

		
		//-------------------------------------
		// 2. 현재의 수행스레드인 'main' 스레드 외에,
		//    다른 스레드 생성 및 수행
		//-------------------------------------
		Thread thread = new Thread() {
			
			@Override
			public void run() {
				
				System.out.println("[수신 시작]");
				
				try {
					//-------------------------------------
					// 무한루프를 돌면서, 지속적으로 
					// 데이터 패킷(메시지) 수신
					//-------------------------------------
					while(true) {
						
						//-------------------------------------
						// 3. DatagramPacket 생성
						//-------------------------------------
						DatagramPacket packet = 
						    new DatagramPacket(
					    		new byte[100], // 끌채 지정
					    		100	// 최대 읽을 수 있는 크기
					    	); 
						
						//-------------------------------------
						// 4. 데이터 패킷(Datagram) 수신
						//-------------------------------------
						datagramSocket.receive(packet); // blocking I/O

						//-------------------------------------
						// 5. 수신한 패킷(바이트열)을 문자열로 변환
						//     즉, byte[] --> String 변환
						//-------------------------------------
						String data = 
							new String(
								packet.getData(), // return byte[]
								0, 
								packet.getLength(), // return size
								"UTF-8"				// encoding charset
							); // 문자열 변환

						//-------------------------------------
						// 6. 받은 메시지 출력
						//-------------------------------------
						System.out.println(
							"[받은 내용: "  + 
							packet.getSocketAddress() + // 어디에서..
							"] " + 
							data);						// 받은메시지..
					} // while
					
				} catch (Exception e) {
					System.out.println("[수신 종료]");
				} // try-catch
				
			} // run			
		}; // **** 익명자식객체 생성 코딩 **** //
		
		//----------------------------------//
		// 7. 새로운 스레드 구동(시작)
		//----------------------------------//
		thread.start();

		//----------------------------------//
		// 8. main 스레드는 잠시동안(30초) 대기
		//----------------------------------//
		Thread.sleep(30 * 1000L);	

		//----------------------------------//
		// 9. 자원객체 반납(소켓 닫음)
		//----------------------------------//
		datagramSocket.close();
	} // main
	
} // end class
