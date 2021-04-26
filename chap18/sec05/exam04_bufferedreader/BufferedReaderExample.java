package sec05.exam04_bufferedreader;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;


public class BufferedReaderExample {

	
	public static void main(String[] args) 
		throws Exception {
		
		// 1. ����Ʈ ����� ǥ���Է½�Ʈ���� ���������� ����
		InputStream is = System.in;
		
		// 2. ����Ʈ ����� �Է½�Ʈ�� --> ���ڱ���� �Է½�Ʈ��
		//    ���� ��ȯ(��, InputStream --> Reader�� ����)
		//    ���ִ� ������Ʈ���� InputStreamReader ���
		Reader reader = new InputStreamReader(is);	
		
		// 3. ������Ʈ�� ü�� ����
		//    ��ȯ�� ���ڱ�� �Է½�Ʈ���� �ٽ�,
		//    ������� ������Ʈ���� �߰�
		BufferedReader br = new BufferedReader(reader);
		
		// 4. ���ڱ���� �Է½�Ʈ���� ����, ����ڰ� �ֿܼ�
		//    �Է��ϴ� �����͸� ����(������� �Է¹���)
		System.out.print("�Է�: ");
		String lineString = br.readLine();
		
		// 5. ����ڰ� �Է��� �����͸� ǥ��������� ���
		System.out.println("���: " + lineString);	
	} // main
	
} // end class