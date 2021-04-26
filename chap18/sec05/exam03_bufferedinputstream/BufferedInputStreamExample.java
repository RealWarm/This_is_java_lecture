package sec05.exam03_bufferedinputstream;

import java.io.BufferedInputStream;
import java.io.FileInputStream;


public class BufferedInputStreamExample {
	
	
	public static void main(String[] args) 
		throws Exception {
		
		long start = 0;
		long end = 0;
		
		// 1. Original InputStream ���� (����Ʈ ���)
		FileInputStream fis1 = 
			new FileInputStream(
					"C:/temp/FileZilla_3.43.0_win64_sponsored-setup.exe");
		
		// 2. �������� 1
		start = System.currentTimeMillis();
		
			while(fis1.read() != -1);// ���๮���� ����. �б⸸����
		
		end = System.currentTimeMillis();

		// 3. �������� 1
		System.out.println(
			"1. ������� �ʾ��� ��: " + (end-start) + "ms");
		
		fis1.close();	// 4. �ڿ��ݳ�
		
		//-------------------------------------//
		
		// 1. Original InputStream ���� (����Ʈ ���)
		FileInputStream fis2 = 
			new FileInputStream(
				"C:/temp/FileZilla_3.43.0_win64_sponsored-setup.exe");
		
		// 2. �������� ������Ʈ�� ����
		BufferedInputStream bis = 
			new BufferedInputStream(fis2);
		
		// 3. �������� 1
		start = System.currentTimeMillis();
		
			while(bis.read() != -1);// ���๮���� ����. �б⸸����

		// 4. �������� 2
		end = System.currentTimeMillis();
		
		System.out.println(
			"2. ������� ��: " + (end-start) + "ms");
		
		// 5. ��Ʈ�� �ݱ� -> �ڿ��ݳ�
		//    *** ���ǻ��� 1 ***
		//    ������Ʈ���� ����ϴ� ���, ��Ʈ���� �ݴ� ������,
		//    ������Ʈ������ �ݰ�, ���������� original ��Ʈ���� ����
		// 
		//    *** ���ǻ��� 2 ***
		//    ������Ʈ������ ��Ʈ�� ü���� ������ ��쿡��,
		//    ���� �ٱ��� ���� ��Ʈ������ �ݰ�, ���������� ������ ��Ʈ���� ����
		//
		//    *** ���ǻ��� 3 ***
		//    ������Ʈ���� ���� ���� ���ߴ� �ϴ���, �ݵ�� ������ ��Ʈ����
		//    �ݰ� �ȴٸ�, ������ ��� ������Ʈ���� �Բ� ����
		//
		//    *** ���ǻ��� 4 ***
		//    Ư��, ��� ��Ʈ���� ���� ������Ʈ���� �����Ͽ�,
		//    ���(����)��Ʈ���� �ݱ�����, ������ ����, �ݵ�� flush()�� 
		//    �����Ͽ�, ���ۿ� �ܷ��ϴ� �����͸� ���۽�Ű�� ����!!!
		
		bis.close();
		fis2.close();
	} // main
	
} // end class

