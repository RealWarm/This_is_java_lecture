package sec02.exam01_inputstream_read;

import java.io.FileInputStream;
import java.io.InputStream;


public class ReadExample1 {

	
	public static void main(String[] args) 
		throws Exception {
		
		// ������ ���Ϸκ���, ������ �����͸� �о,
		// console�� ����ϴ� ���� 
		// (�Է¿���: Reader or InputStream) 
		
		// ������ �Է¼ҽ��� �ϴ�,����Ʈ ����� �Է½�Ʈ�� ����
		InputStream is = 
			new FileInputStream("C:/Temp/test.txt");
		
		int readByte; // �о 1����Ʈ�� ������ ��������
		
		while(true) {
			// �Է½�Ʈ������, 1����Ʈ �� �о!!!!
			readByte = is.read();	
			
			// ������ �дٰ�, ������ ��(EOF, End Of File)�� 
			// ������, read() �޼ҵ�� -1�� ��ȯ��
			if(readByte == -1) { 
				break; // loop�� ��������!!!
			} // if
			
			// �о '����Ʈ'�� '����'�� ��������ȯ�Ͽ� ��� 
			System.out.print( (char) readByte );
		} // while
		
		is.close(); // �Է½�Ʈ�� �ݱ�(�ڿ��ݳ�)
	} // main
	
} // end class
