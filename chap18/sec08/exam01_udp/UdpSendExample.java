package sec08.exam01_udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;


public class UdpSendExample {
	
	//---------------------------------------//
	// 수신자에게 보낼 메시지 를 만들어서 수신자에게
	// 보내는 발신자 프로그램 (UDP기반)
	//---------------------------------------//
	public static void main(String[] args) 
		throws Exception {

		//---------------------------------------//
		// 1. DatagramSocket 객체 생성
		//    이 socket 객체가 있어야, UDP 네트워크에
		//    편지봉투(데이터)를 보내고/받을 수 있음
		//---------------------------------------//
		DatagramSocket datagramSocket = 
			new DatagramSocket();
		
		System.out.println("[발신 시작]");

		//---------------------------------------//
		// 2. 총 3회동안 반복해서,
		//    편지봉투(메시지)를 생성하여, 수신자에게
		//    보냄
		//---------------------------------------//
		for(int i=1; i<3; i++) {
			// 2-1. 수신자에게 보낼 메시지 준비
			String data = "메시지" + i;
			
			// 2-2. 바이트 기반으로 보내야 하기 때문에
			//      준비한 메시지를 바이트배열로 변환
			//
			//      즉,   String ---> byte[] 로 변환
			byte[] byteArr = data.getBytes("UTF-8");
			
			// 2-3. 위에서 생성한 바이트 배열(메시지)을 
			//      담을 편지봉투(DatagramPacket) 생성
			//      *** 주의 ** 
			//      여기서 만든 DatagramPacket은 메시지
			//      발신용으로 만든 것임(수신용이 아님!!!)
			DatagramPacket packet = 
				new DatagramPacket(
						byteArr, 		// 보낼 데이터
						byteArr.length, // 데이터 크기
						new InetSocketAddress(
							"localhost", 5001
						) // 받는사람 주소 기재
			); // 받는사람 주소 기재하여 편지봉투생성
			   // 이때 보내는 사람 주소는 자동으로 생성
			
			// 2-4. UDP기반의 DatagramSocket의 send()
			//      메소드를 호출하여, 준비한 편지봉투(packet)
			//      전송
			datagramSocket.send(packet);
			
			System.out.println(
				"[보낸 바이트 수]: " + 
				byteArr.length + 
				" bytes");
		} // for

		
		//---------------------------------------//
		// 3. 총 3회 메시지를 송신하고 나서, socket 객체
		//    닫기(자원반납)
		//
		//    보낸 메시지가 어떤 경로로, 언제 도착할지는
		//    신경쓰지 않음.. 일단 모든 메시지를 보내고
		//    나면, 바로 socket 닫아서 자원반납 수행
		//---------------------------------------//
		System.out.println("[발신 종료]");
		
		datagramSocket.close();  // 자원반납
	} // main
	
} // end class
