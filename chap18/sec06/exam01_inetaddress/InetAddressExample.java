package sec06.exam01_inetaddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressExample {
	
	
	public static void main(String[] args) {
		try {
			//------------------------------//
			// 1. ���� IP�ּҸ� Ȯ���غ���!!!
			//------------------------------//
			// InetAddress getLocalHost() �޼ҵ� ȣ���� ����,
			// ���� ����PC�� Host Address ������
			// InetAddress ��ü�� ��ȯ
			InetAddress local = 
				InetAddress.getLocalHost();
			
			// InetAddress ��ü�� String getHostAddress()
			// �޼ҵ带 ȣ���ϸ�, IP�ּҸ� Ȯ�ΰ���
			System.out.println(
				"����ǻ�� IP�ּ�: " + 
				local.getHostAddress());
			
			//------------------------------//
			// 2. Ư�� �������� IP�ּҸ� Ȯ���غ���!!
			//------------------------------//
			// getAllByName() �޼ҵ� ȣ���� �ϸ�,
			// ������ ������ �Ķ���Ͱ��� IP�ּҷ�
			// ��ȯ�ϱ� ���Ͽ�, DNS Lookup�� �����ϰ�
			// ��ȯ�� IP�ּҵ�(InetAddress)�� �迭�� ��ȯ
			InetAddress[] iaArr = 
				InetAddress.getAllByName("www.naver.com");
			
			// ��ȯ�� InetAddress[] �迭(��ȯ�� IP�ּҵ�)��
			// ��� ���(����: �迭�� �⺻������ Iterable�ϹǷ�
			// enhanced for ���� ��밡��!!!)
			for(InetAddress remote : iaArr) {
				// String getHostAddress() �޼ҵ� ȣ����
				// ���� IP�ּ� ���
				System.out.println(
					"www.naver.com IP�ּ�: " + 
					remote.getHostAddress());
			} // enhanced for
			
		} catch(UnknownHostException e) { // �ָ�!!!
			// try block���� ���ܰ� �߻��ϸ�,
			// ������ Stack Trace ���
			e.printStackTrace(); 
		} // try-catch
	} // main
	
} // end class

