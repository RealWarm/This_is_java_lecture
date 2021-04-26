package sec02.exam04_writer_write;

import java.io.FileWriter;
import java.io.Writer;


public class WriteExample1 {

	public static void main(String[] args) 
		throws Exception {
		
		//------------------------------------//
		// ���ڱ���� '����' ��½�Ʈ�� ��ü ����
		// Lvalue Type : �߻�Ŭ����
		// Rvalue Type : Lvalue�� ����(�ڽ�)Ŭ����
		Writer writer = 
			new FileWriter("C:/Temp/test.txt");
		
		//------------------------------------//
		// ��½�ų ���ڿ���, char[]�� ��ȯ
		// ��, ���ڿ� ----> char[]
		char[] data = "ȫ�浿".toCharArray();
		
		// ���ڿ��� ���̸�ŭ, ������ ���鼭
		// 1���� ���ھ� ��½�Ʈ���� ����
		// ���� �����, ��½�Ʈ���� ������ 
		// '��¹���(�ִ�8192����)' �� ����ϴ� ����!!!
		for(int i=0; i<data.length; i++) {
			// �Ű������� Ÿ���� int�� 
			// �׷���, ����(char type)�� �����ص� OK!????
			writer.write(data[i]); // 1�� ���� ����
		} // for
		
		//------------------------------------//
		
		writer.flush(); // ��¹��ۿ� �ܷ��ϴ� ���ڵ��� flush
		writer.close(); // ��½�Ʈ�� �ݱ�(�ڿ��ݳ�)
	} // main

} // end class
