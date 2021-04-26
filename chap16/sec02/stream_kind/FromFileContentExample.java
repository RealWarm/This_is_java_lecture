package sec02.stream_kind;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;


public class FromFileContentExample {
	
	// ���ڱ�� ������ ������ ��Ʈ���� ���� �ֿܼ� ����ϴ� ����
	public static void main(String[] args) 
		throws IOException {
		//------------------------------------------------
		// 1. Paths Utility Class�� static �޼ҵ带 �̿��Ͽ�
		//    �����ϰ� ��θ� �𵨸��� Path ��ü ����
		//------------------------------------------------
		Path path = Paths.get(
				"C:/Temp/web-app_2_4.xsd"
			);
		
//		Stream<String> stream;	// ��Ʈ�� ���� ��������
		

		//------------------------------------------------
		// 2. Files Utility Class�� static �޼ҵ带 �̿��Ͽ�
		//    Path���� ������ ��ο� ���� ��Ʈ�� ��ü ����
		//------------------------------------------------
		// 2-1. ������ ��ο� ���� ��Ʈ�� ���
		Stream<String> stream = Files.lines(
				path,			// �� 1���� ���� ��ΰ�ü 
				Charset.defaultCharset() // ���ڵ� ��������
			);
		
		// 2-2. ��Ʈ���� ����ó�� �޼ҵ��� forEach() �޼ҵ带
		//      �̿��Ͽ�, ������ ��� �ؿ� �ִ� ��� ���ϰ� ��
		//      -�丮 ����� �ַܼ� ���
		stream.forEach( System.out :: println );
		
		// 2-3. ��Ʈ�� �ݱ�(�ڿ��ݳ�) *** �߿� ***
		stream.close();
				
		System.out.println();

		//------------------------------------------------
		// 3. BufferedReader�� ������ �ҽ��� �̿��Ͽ�,
		//    ������ ���ڱ�������� ������ ��Ʈ���� �̿��Ͽ�
		//    �ֿܼ� ���
		//------------------------------------------------
		// 3-1. Path ��ü�� toFile()�޼ҵ带 �̿��Ͽ�, File
		//      ��ü ����
		File file = path.toFile();
		
		// 3-2. File ��ü�� ���Ͽ�, ���ڱ�� ���� �Է½�Ʈ�����
		FileReader fileReader = new FileReader(file);
		
		// 3-3. ���ɺ�����Ʈ���� BufferedReader �ΰ�!
		BufferedReader br = new BufferedReader(fileReader);
		
		// 3-4. ���ɺ�����Ʈ�����κ���, ��Ʈ�� ���� *****
		stream = br.lines();
		
		// 3-5. ��Ʈ���� ����ó�� �޼ҵ���, forEach() �޼ҵ带
		//      �̿��Ͽ�, ������ ������ ������ **���پ�** �ַܼ�
		//      ����ϱ�
		stream.forEach( System.out :: println );
		
		//------------------------------------------------
		// 4. ����� ��� ���� ��Ʈ�� �ݱ�(***�ڿ��ݳ�***)
		stream.close();
	} // main
	
} // end class
