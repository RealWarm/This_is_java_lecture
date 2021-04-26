package sec02.exam01_inputstream_read;

import java.io.FileInputStream;
import java.io.InputStream;

public class ReadExample3 {

	
	public static void main(String[] args) 
		throws Exception {
		
		// ����Ʈ ����� ���� �Է½�Ʈ�� ����
		// ��� ������ ������ ���� �� ����(�ؽ�Ʈ���ϵ� ����)
		InputStream is = 
			new FileInputStream("C:/Temp/test.txt");
		
		int readByteNo;	// ���� �о�� ����Ʈ�� ��������
		
		// �ѹ��� �Է½�Ʈ������ ����Ʈ�� �о�� �� �ִ�,
		// ��ä�� ũ�⸦ 8����Ʈ �迭�� ����
		byte[] readBytes = new byte[8];
		
		// ����° read() �޼ҵ忡, ��ä(8����Ʈũ��)�� ����
		// �Ͽ�, �ִ� 8����Ʈ�� �Է½�Ʈ������ �б� ����
		// ������, read(byte[], int offset, int length)
		// �� �޼ҵ带 �̿��ϱ� ������, ��ä�� ��ü ũ�⸦
		// �̿����� �ʰ�, ���� 3����Ʈ���� �о���� �Ͽ���
//		readByteNo = is.read(readBytes, 2, 3);
		
		readByteNo = is.read(readBytes, 0, readBytes.length);
		readByteNo = is.read(readBytes);
		
		
		// ���� �о�� ����Ʈ�� ���� �ַܼ� ���
		for(int i=0; i<readBytes.length; i++) {
			System.out.println(readBytes[i]);
		} // for
		
		is.close();	// �ڿ��ݳ�
	} // main

} // end class
