package sec02.exam01_inputstream_read;

import java.io.FileInputStream;
import java.io.InputStream;


public class ReadExample2 {

	
	public static void main(String[] args) 
		throws Exception {
		
		InputStream is = 
			new FileInputStream("C:/Temp/test.txt");
		
		int readByteNo;
		
		// ����Ʈ ����� �Է½�Ʈ�����κ���, ������ ũ�⸸ŭ
		// �ѹ��� ���� ����Ʈ�� �о���� ����
		byte[] readBytes = new byte[3];   // ũ�Ⱑ 3�ι迭
		
		String data = "";
		
		while( true ) {
			readByteNo = is.read(readBytes);
			
			if(readByteNo == -1) { // if EOF(-1)
				break;
			} // if
			
			data += new String(readBytes, 0, readByteNo);
		} // while
		
		System.out.println(data);
		
		is.close(); // �ڿ��ݳ�
	} // main

}
