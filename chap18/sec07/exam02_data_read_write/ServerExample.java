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
			); // ���� ��Ʈ ���ε� ����
			//---------------------------------//

			//---------------------------------//
			// ���ѷ����ȿ��� �������� �����û ���� ��
			// Socket ��ü ���� ����
			//---------------------------------//
			while(true) {
				//---------------------------------//
				System.out.println( "[���� ��ٸ�]");
				
				Socket socket = 
					serverSocket.accept(); // Blocking I/O
				//---------------------------------//

				//---------------------------------//
				// ����� Ŭ���̾�Ʈ�� IP�ּҿ� Port���� ����
				// 1) InetAddress -> IP�ּҸ� ����
				// 2) InetSocketAddress -> IP�ּ�+Port ����
				InetSocketAddress isa = 
					(InetSocketAddress) 
						socket.getRemoteSocketAddress();
				//---------------------------------//
				
				System.out.println(
					"[���� ������] " + isa.getHostName());

				
				//---------------------------------//
				// ���⼭����, PDU(Packet Data Unit) ���迡
				// ���� ����� Ŭ���̾�Ʈ�� ������ ��/����
				// ����
				//---------------------------------//				
				byte[] bytes = null;
				String message = null;

				//---------------------------------//
				// 1. Socket���� �Է½�Ʈ�� ���
				//---------------------------------//
				InputStream is = 
						socket.getInputStream();

				//---------------------------------//
				// 2. ����Ʈ ����� �Է½�Ʈ�����κ���,
				//    Ŭ���̾�Ʈ�� �۽��� �޽��� ����
				//---------------------------------//
				bytes = new byte[100];  // ��ä ����
				
				int readByteCount = 
						is.read(bytes); // ������ ����

				//---------------------------------//
				// 3. ������ ����Ʈ ����� �����͸�, 
				//    ���ڿ��� ��ȯ �� ���� �޽��� ���
				//
				// 	  byte[] ---> String ���� ��ȯ
				//---------------------------------//
				message = 
					new String(
							bytes, 
							0, 
							readByteCount, 
							"UTF-8");
				
				System.out.println(
					"[������ �ޱ� ����]: " + message);
				//---------------------------------//
				
				//---------------------------------//
				// 4. Ŭ���̾�Ʈ�� ���� �޽��� ������
				//    �̸� ����, �켱 Socket ��ü�κ���
				//    ����Ʈ ����� ��½�Ʈ�� ���
				//---------------------------------//
				OutputStream os = 
						socket.getOutputStream();
				
				// Ŭ���̾�Ʈ�� �۽��� �޽��� �غ�
				message = "Hello Client";

				//---------------------------------//
				// 5. �۽��� �޽����� ����Ʈ �迭�� ��ȯ
				//    ��? ����Ʈ ����� ��½�Ʈ���̱� ������.
				// 
				//    String --> byte[] �� ��ȯ
				//---------------------------------//
				bytes = message.getBytes("UTF-8");
				
				//---------------------------------//
				// 6. ��½�Ʈ������ ����Ʈ�迭 �۽�
				//---------------------------------//
				os.write(bytes);	// ����Ʈ�迭 �۽�
				
				os.flush();			// ��¹��� ����flush
				
				System.out.println( "[������ ������ ����]");

				//---------------------------------//
				// 7. Ŭ���̾�Ʈ���� ��ȭ(�޽��� �ۼ���)��
				//    ��� ����Ǿ�����, ����� �ڿ���ü �ݳ�
				//---------------------------------//
				is.close();
				os.close();
				
				// * ���� * 
				// �ڿ���ü �ݳ���, ��/��� ��Ʈ�� ��ü�� ����
				// ���� �Ŀ�, �� ���������� Socket ��ü�� ����
				socket.close();
			} // while
			
		} catch(Exception e) {
			;;
		} finally {
			//---------------------------------//
			// 8. �����μ��� ���ҵ� ������, ServerSocket
			//    ��ü�� �ڿ��ݳ���Ŵ(�н���~~~)
			//---------------------------------//
			if(!serverSocket.isClosed()) { // �����ֳ���?
				try {
					serverSocket.close();  // �ݽ��ϴ�.
				} catch (IOException e1) { ;; }
			} // if
		} // try-catch-finally
		
	} // main
	
} // end class
