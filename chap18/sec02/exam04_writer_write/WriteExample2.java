package sec02.exam04_writer_write;

import java.io.FileWriter;
import java.io.Writer;


// 자바 입/출력을 수행할 때, 발생가능한 대부분의 예외(exception)
// 는 java.io.IOException 을 발생시키도록 되어 있음
public class WriteExample2 {

	public static void main(String[] args) 
		throws Exception {
		
		try (Writer writer = 
				new FileWriter("C:/Temp/test.txt");) {
			
			char[] data = "홍길동".toCharArray();
			
			writer.write(data);

			writer.flush();
			
		} // try-with-resources
		
		
		
		
		
		
		
		
		
	} // main

} // end class
