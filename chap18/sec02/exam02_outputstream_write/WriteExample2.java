package sec02.exam02_outputstream_write;

import java.io.FileOutputStream;
import java.io.OutputStream;


public class WriteExample2 {

	public static void main(String[] args) 
		throws Exception {
		
		//--------------------------------------//
		
		OutputStream os = 
			new FileOutputStream("C:/Temp/test2.txt", true);
		
		System.out.println("- os: "+ os);
		
		//--------------------------------------//
		
		byte[] data = "\r\n�ȳ��ϼ���4".getBytes();
		
		//--------------------------------------//
		
		os.write(data);
		
		//--------------------------------------//
		
		os.flush();
		os.close();
		
		//--------------------------------------//
		
	} // main

} // end class
