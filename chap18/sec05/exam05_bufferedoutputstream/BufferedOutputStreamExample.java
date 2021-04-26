package sec05.exam05_bufferedoutputstream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class BufferedOutputStreamExample {
	
	// File Copy Program
	public static void main(String[] args) 
		throws Exception {
		
		// 1. �ʿ��� ���������� ����
		FileInputStream fis = null;
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		// 2. �ʿ��� ���������� ����
		int data = -1;	// ���� �о ����Ʈ�� ����
		
		long start = 0;
		long end = 0;
		
		//--------------------------------------------
		// 3. File Copy Logic
		// 3-1. Copy�� Target File�� ���� ����Ʈ �����
		//      �Է½�Ʈ���� ����
		fis = new FileInputStream(
		"C:/temp/FileZilla_3.43.0_win64_sponsored-setup.exe");
		
		// 3-2. �� �� ���� copy ����Ȯ���� ����
		//      Buffered �����Է½�Ʈ���� �߰�
		bis = new BufferedInputStream(fis);
		
		// 3-3. Target file�� Copy ��������,
		//      ����Ʈ ����� ��½�Ʈ�� ����
		fos = new FileOutputStream("C:/Temp/A.exe");
		
		//----------------------------------------------//
		// 4. File Copy �� �������� (1/1000�� ����-�и���)
		//    ������� ������Ʈ���� ������� �ʾ��� ��!!!
		start = System.currentTimeMillis();
		
			while((data = bis.read()) != -1) {
				fos.write(data);
			} // while
			
			fos.flush();
			
		end = System.currentTimeMillis();

		// 5. ����� ��� ��Ʈ�� �ݱ�
		//    �̶� ������ �߿���
		//    (������Ʈ���� ���� ���� ��, ���� ��Ʈ�� �ݱ� ����)
		fos.close(); 	
		bis.close();  
		fis.close();
		
		// 5-1. ����������� ���(1/1000��- �и��� ����)
		System.out.println(
			"������� �ʾ��� ��: " + (end-start) + "ms");
		
		//------------------------------------------//
		// ������� ������Ʈ���� ����Ͽ��� ��
		//------------------------------------------//
		
		// 1. ����Ʈ ����� ��/��� ��Ʈ����, ������� ����
		//    ��Ʈ���� �߰�
		fis = new FileInputStream(
			"C:/temp/FileZilla_3.43.0_win64_sponsored-setup.exe");
		
		// 1-1. ������� �����Է½�Ʈ�� �߰�
		bis = new BufferedInputStream(fis);
		
		// 1-2. ������� ������½�Ʈ�� �߰�
		fos = new FileOutputStream(
				"C:/Temp/A.exe");	
		
		bos = new BufferedOutputStream(fos); // ����
		
		// 2. File copy ��������
		start = System.currentTimeMillis();
		
			// Source File�� ��(EOF)���� �а�
			while((data = bis.read()) != -1) { // if EOF
				bos.write(data); // Target file�� ����
			} // while
			
			// ������� ������Ʈ�� ���� ��¹��ۿ� �ܷ��ϴ�
			// ������ ���� flush ��Ŵ
			bos.flush();	// ��º�����Ʈ�� flush
			
		end = System.currentTimeMillis();

		// 3. ����� ��� ��Ʈ�� �ݱ�
		//    �̶� ������ �߿���
		//    (������Ʈ���� ���� ���� ��, ���� ��Ʈ�� �ݱ� ����)
		bos.close();	// ��º�����Ʈ�� �ݱ� 
		fos.close(); 	// ������ ��½�Ʈ�� �ݱ�
		
		bis.close(); 	// �Էº�����Ʈ�� �ݱ�
		fis.close();	// ������ �Է½�Ʈ�� �ݱ�
		
		// 4. ������� ���(1/1000�� - �и��� ����)
		System.out.println(
			"������� ��: " + (end-start) + "ms");
	} // main
	
} // end class

