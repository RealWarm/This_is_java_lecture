package sec02.exam02_outputstream_write;

import java.io.FileOutputStream;
import java.io.OutputStream;


public class WriteExample1 {

	
	public static void main(String[] args) 
		throws Exception {
		
		// 1. '����Ʈ' ����� '����' ��½�Ʈ�� ����
		OutputStream os = 
			new FileOutputStream("C:/Temp/test1.txt");
		
		//----------------------------------------//
		
		// 2. ��½�Ʈ���� ��½�ų ������ ����
		//    ���ڿ� -> ����Ʈ �迭�� ��ȯ ********
//		byte[] data = "�赿��".getBytes();
		byte[] data = "�赿��".getBytes("UTF-8");
		
		//----------------------------------------//
		
		// 3. ��¹��ۿ� write ����
		for(int i=0; i<data.length; i++) {
			// ��¹��ۿ� '����Ʈ �迭' ���
			// (����Ʈ��� ��½�Ʈ�� �̱� ����)
			
			os.write(data[i]); // ��������Ʈ���� �ѹ��� ���	
			
			// ��¹���(�ִ�8kb)�� �� ����, �ڵ����� flush��
			// �̸� 'autoFlush'��� ��. ������, ������ ���
			// ����, �� ��¹��۰� �� ���� ������, autoFlush
			// �� �߻����� �ʱ� ������, ��½�Ʈ���� �ݱ� ����
			// �ݵ�� �ѹ� ��������� flush() �޼ҵ带 ȣ��
			// �ؾ� ��!!! (����)
			
		} // for
		
		//----------------------------------------//
		
		os.flush();	// ��¹��ۿ� �ܷ��� ����Ʈ���� flush
		os.close(); // ��� ��Ʈ���� ����(�ڿ��ݳ�)
	} // main

} // end class
