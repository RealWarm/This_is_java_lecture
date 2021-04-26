package sec07.exam01_serversocket_socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExample {
	
	
	public static void main(String[] args) {
		// 1. Ŭ���̾�Ʈ�� �����û�� �����ϰ�, 
		//    ���� ����(end point)�� ǥ���ϴ� Socket ��ü ����.
		ServerSocket serverSocket = null;
		
		try {
			// �����û ���� �� ���ο� Socket ��ü ������ ����
			// ServerSocket ��ü ����
			serverSocket = new ServerSocket();
//			serverSocket = new ServerSocket(5001);
			
			// Ư�� ��Ʈ(�̸�, ���ε� ��Ʈ�� ��)�� 
			// ��Ʈ ���ε� ����
			// ����) Binding Port, Binding
			serverSocket.
				bind(
					// InetSocketAddress ????
					new InetSocketAddress(
							"localhost", 	// IP�ּ�
							5001			// ��Ʈ��ȣ
						) 
				); // Port Binding ����
			
			System.out.println(
				"- serverSocket: "+serverSocket);
			
			// ���ѷ����� �����ϸ鼭, ������ �׽� ���ο�
			// Ŭ���̾�Ʈ�� �����û�� ��ٸ�(������,blocking)
			while(true) {
				System.out.println( "[���� ��ٸ�]");
				//--------------------------------
				// ServerSocket�� accept() �޼ҵ� ȣ���ϸ�,
				// Ŭ���̾�Ʈ�κ��� ���ο� �����û�� ������
				// ������ ���ŷ ��(blocking, ������)
				
				Socket socket = serverSocket.accept();
				
				System.out.println(
					"- Connected socket: "+ socket);

				//--------------------------------
				// ���� accept() �޼ҵ尡 blocking ���¿���
				// ����������(��, ���ο� �����û�� ��������)
				// ������ ����� ����, �������� ������ ǥ���ϴ�
				// ���ο� Socket ��ü ����
				InetSocketAddress isa = 
					(InetSocketAddress) 
						socket.getRemoteSocketAddress();
				
				System.out.println(
						"- isa: "+ isa);
				
				//--------------------------------
				// �����û�� ������ Ŭ���̾�Ʈ�� IP�ּ� ���
				System.out.println(
					"[���� ������] " + 
					isa.getHostName());
			} // while
		} catch(Exception e) {
			;;  // ���� ������������ �����߻���, �ƹ��͵� ����??
		} // try-catch

		//--------------------------------
		// ServerSocket, Socket ��ü ���
		// �ڿ���ü��, ����� ������, �ݵ�� close() �����Ͽ�
		// �ڿ��ݳ� ���Ѿ� ��(**** �ſ��߿�, �̸� ���� ��,
		// ���� ��� ���� ****)
		if(!serverSocket.isClosed()) { // �̹� ��������?
			try {
				serverSocket.close();  // �ݾ���(�ڿ��ݳ�)
			} catch (IOException e1) { 
				;; 
			} // try-catch
		} // if
		
	} // main
	
} // end class
