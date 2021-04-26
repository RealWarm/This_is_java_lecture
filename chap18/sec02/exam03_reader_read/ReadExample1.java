package sec02.exam03_reader_read;

import java.io.FileReader;
import java.io.Reader;


public class ReadExample1 {

	
	public static void main(String[] args) 
		throws Exception {
		//--------------------------------------//
		Reader reader = 
			new FileReader("C:/Temp/test.txt");
		
		//--------------------------------------//
		
		int readData;	// �Է½�Ʈ������ ���� 1���� ���ڸ�
						// ������ ��������
		
		while( true ) {
			readData = reader.read(); // 1���� ���ڸ� ����
			
			if(readData == -1) { // �Է½�Ʈ���� ��(EOF)��
				                // �����ϸ�, loop�� ��������
				break;     
			} // if
			
			// �о 1���� ���ڸ� ���
			// �׷���, �� char Ÿ������ ��������ȯ�� �ʿ��ұ�?
			System.out.print( (char) readData );
		} // while
		
		//--------------------------------------//
		
		reader.close();	// �Է½�Ʈ�� �ݱ�(�ڿ��ݳ�)
	
	} // main

} // end class
