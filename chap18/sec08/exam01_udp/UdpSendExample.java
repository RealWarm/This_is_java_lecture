package sec08.exam01_udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;


public class UdpSendExample {
	
	//---------------------------------------//
	// �����ڿ��� ���� �޽��� �� ���� �����ڿ���
	// ������ �߽��� ���α׷� (UDP���)
	//---------------------------------------//
	public static void main(String[] args) 
		throws Exception {

		//---------------------------------------//
		// 1. DatagramSocket ��ü ����
		//    �� socket ��ü�� �־��, UDP ��Ʈ��ũ��
		//    ��������(������)�� ������/���� �� ����
		//---------------------------------------//
		DatagramSocket datagramSocket = 
			new DatagramSocket();
		
		System.out.println("[�߽� ����]");

		//---------------------------------------//
		// 2. �� 3ȸ���� �ݺ��ؼ�,
		//    ��������(�޽���)�� �����Ͽ�, �����ڿ���
		//    ����
		//---------------------------------------//
		for(int i=1; i<3; i++) {
			// 2-1. �����ڿ��� ���� �޽��� �غ�
			String data = "�޽���" + i;
			
			// 2-2. ����Ʈ ������� ������ �ϱ� ������
			//      �غ��� �޽����� ����Ʈ�迭�� ��ȯ
			//
			//      ��,   String ---> byte[] �� ��ȯ
			byte[] byteArr = data.getBytes("UTF-8");
			
			// 2-3. ������ ������ ����Ʈ �迭(�޽���)�� 
			//      ���� ��������(DatagramPacket) ����
			//      *** ���� ** 
			//      ���⼭ ���� DatagramPacket�� �޽���
			//      �߽ſ����� ���� ����(���ſ��� �ƴ�!!!)
			DatagramPacket packet = 
				new DatagramPacket(
						byteArr, 		// ���� ������
						byteArr.length, // ������ ũ��
						new InetSocketAddress(
							"localhost", 5001
						) // �޴»�� �ּ� ����
			); // �޴»�� �ּ� �����Ͽ� ������������
			   // �̶� ������ ��� �ּҴ� �ڵ����� ����
			
			// 2-4. UDP����� DatagramSocket�� send()
			//      �޼ҵ带 ȣ���Ͽ�, �غ��� ��������(packet)
			//      ����
			datagramSocket.send(packet);
			
			System.out.println(
				"[���� ����Ʈ ��]: " + 
				byteArr.length + 
				" bytes");
		} // for

		
		//---------------------------------------//
		// 3. �� 3ȸ �޽����� �۽��ϰ� ����, socket ��ü
		//    �ݱ�(�ڿ��ݳ�)
		//
		//    ���� �޽����� � ��η�, ���� ����������
		//    �Ű澲�� ����.. �ϴ� ��� �޽����� ������
		//    ����, �ٷ� socket �ݾƼ� �ڿ��ݳ� ����
		//---------------------------------------//
		System.out.println("[�߽� ����]");
		
		datagramSocket.close();  // �ڿ��ݳ�
	} // main
	
} // end class
