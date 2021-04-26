package sec02.exam04_writer_write;

import java.io.FileWriter;
import java.io.Writer;


// �ڹ� ��/����� ������ ��, �߻������� ��κ��� ����(exception)
// �� java.io.IOException �� �߻���Ű���� �Ǿ� ����
public class WriteExample2 {

	public static void main(String[] args) 
		throws Exception {
		
		try (Writer writer = 
				new FileWriter("C:/Temp/test.txt");) {
			
			char[] data = "ȫ�浿".toCharArray();
			
			writer.write(data);

			writer.flush();
			
		} // try-with-resources
		
		
		
		
		
		
		
		
		
	} // main

} // end class
