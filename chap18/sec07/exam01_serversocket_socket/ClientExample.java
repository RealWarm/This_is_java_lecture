package sec07.exam01_serversocket_socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientExample {
	
	
	public static void main(String[] args) {
		// ������ ��ſ�, Socket ��ü ����
		Socket socket = null;
		
		try {
			// 1. ������ ��ſ� ���� ��ü ����
			socket = new Socket();
			System.out.println(
				"1. Before connecting: "+socket);
			
			// 2. ������ Ŭ���̾�Ʈ �����û ���� �� ����
			System.out.println( "[���� ��û]");
			
			// ���� ������ �����û�� ������ �޼ҵ�� �Ʒ���
			// connect() �޼ҵ���!!!!2
			socket.connect( 
				// SocketAddress : IP�ּҿ� ��Ʈ��ȣ ��������
				// InetSocketAddress extends SocketAddress
				new InetSocketAddress(
					"localhost", 	// ���� IP�ּ�
					5001			// ���� ���ε� ��Ʈ��ȣ
				) // InetSocketAddress
			); // connect
			
			// 3. �������� ������� �� ���ϰ�ü ���
			System.out.println( "[���� ����]");
			System.out.println(
					"2. After connecting: "+socket);
		} catch(Exception e) { // ���ܹ߻��� ó��
			;;
		} finally {
			// �ڿ��ݳ�(Ȯ���� ����!!!)
			if(!socket.isClosed()) {
				try { socket.close(); } 
				catch (IOException e1) {;;} // try-catch
			} // if	
		} // try-catch-finally
		
	} // main
	
} // end class