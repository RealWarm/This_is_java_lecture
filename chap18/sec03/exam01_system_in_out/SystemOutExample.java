package sec03.exam01_system_in_out;

import java.io.OutputStream;

public class SystemOutExample {
	
	
	public static void main(String[] args) 
		throws Exception {
		
		// 1. �ü���� �ڵ����� �Ҵ�����, 
		// ǥ�����(����Ʈ����� ��½�Ʈ��) ȹ��.
		OutputStream os = System.out;
		
		// 2. From 48 to 57 ���� ������ ��������
		//    ǥ�����(����Ʈ����� ��½�Ʈ��)�� ���.
		for(byte b=48; b<58; b++) {
			os.write(b); // ������ ��½�Ų ����� ??
		} // for		
		
		// 3. ���� 10�� ��½�Ų ����� ???
		os.write(10);	// 10 = Line Feed	 
		
		// 4. From 97 to 122 ���� ������ ��������
		//    ǥ�����(����Ʈ����� ��½�Ʈ��)�� ���.
		for(byte b=97; b<123; b++) {
			os.write(b); // ������ ��½�Ų ����� ??
		} // for		
		
		// 5. ���� 10�� ��½�Ų ����� ???
		os.write(10);	// 10 = Line Feed	

		// 6. �ѱ� ��~�� ������ ������ ���ڿ���
		//    ����Ʈ �迭(byte[])�� ��ȯ.
		//    ��, String ----> byte[] �� ��ȯ.
		//    �� ��ȯ�ϳ���?.. ��½�Ʈ���� ����Ʈ��� ��Ʈ��
		//    �̱� ��������!!
		String hangul = "�����ٶ󸶹ٻ������īŸ����";
		
		byte[] hangulBytes = hangul.getBytes();
		
		// 7. ��ȯ�� ����Ʈ �迭(byte[])�� ǥ�����
		//    (����Ʈ����� ��½�Ʈ��)�� ���
		os.write(hangulBytes);
		
		// 8. ��½�Ʈ���� �����ϴ�, ��¹���(8192����Ʈ, 8KB)
		//    �� �ܷ��ϴ� �����͸� ������ flush ��Ŵ.
		//    ��/��� ��Ʈ���� �ݱ�(close)���� �ݵ�� �ѹ���
		//    ȣ���ʿ�!!!!(����)
		os.flush();
		
		// 9. ǥ�� ��½�Ʈ�� �ݱ�!!! ---> �̷��ø� �ȵ˴ϴ�!
		//    �� ǥ����½�Ʈ���� ������ �ȵɱ��???
//		os.close();
	} // main
	
} // end class

