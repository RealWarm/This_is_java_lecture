package sec05.exam01_inputstreamreader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;


public class InputStreamReaderExample {
	
	
	public static void main(String[] args) 
		throws Exception {
		
		// 1. ����Ʈ ����� �Է½�Ʈ����, ���ڱ���� �Է½�Ʈ������ ��ȯ
		//    ��, ���� �Է½�Ʈ�� + ������Ʈ��(���ں�ȯ) ����
		InputStream is = System.in;
		Reader reader = new InputStreamReader(is);	
		
		// 2. ���ں�ȯ ������Ʈ���� �̿��Ͽ�, �Է� ����
		int readCharNo;				 // �Է½�, ���� ���� ���ڼ� ����
		char[] cbuf = new char[100]; // 100����ũ���� ��ä ����
		
		// 3. �Է½�Ʈ���� ��(EOF,-1��)���� �ݺ������� read ����
		while ((readCharNo=reader.read(cbuf)) != -1) {
			// ���� ���ڼ���ŭ�� ���ڹ迭(��ä) --> ���ڿ��� ��ȯ!
			String data = new String(cbuf, 0, readCharNo);
			
			System.out.println(data);	// ��ȯ�� ���ڿ� ���
		} // while
		
		// 4. ��/��� ��Ʈ���� �� ����ϰ� ����, �ݵ�� �ݾ��ش�!(�ڿ��ݳ�)
//		reader.close();
	} // main
	
} // end class

