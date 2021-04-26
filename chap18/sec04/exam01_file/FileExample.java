package sec04.exam01_file;

import java.io.File;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;


public class FileExample {

	
	public static void main(String[] args) 
		throws Exception {
		
		//-------------------------------------//
		// 다양한 경로(파일 또는 디렉토리)에 대한
		// File 객체 생성
		//-------------------------------------//
		File dir = new File("C:/Temp/Dir");
		File file1 = new File("C:/Temp/file1.txt");
		File file2 = new File("C:/Temp/file2.txt");
		File file3 = 
			new File(
				// 특히, URI 객체를 이용하여, File객체를
				// 생성할 수도 있음
				new URI("file:///C:/Temp/file3.txt")
			);
		
		
		//-------------------------------------//
		// File 객체의 유용한 메소드 사용
		//-------------------------------------//		
		if(dir.exists() == false) {
			// 경로상에 없는 모든 디렉토리 생성
			dir.mkdirs();  
		} // if
		
		if(file1.exists() == false) {  
			// 크기가 0바이트인, 새로운 파일 생성
			file1.createNewFile();  
		} // if
		
		if(file2.exists() == false) {  
			// 크기가 0바이트인, 새로운 파일 생성
			file2.createNewFile();  
		} // if
		
		if(file3.exists() == false) {  
			// 크기가 0바이트인, 새로운 파일 생성
			file3.createNewFile();  
		} // if
		
		
		//-------------------------------------//
		// 도스 창의 dir 명령처럼 디렉토리 내용을
		// 출력해보자!!!!!
		//-------------------------------------//
		File temp = new File("C:/Temp");
		
		SimpleDateFormat sdf = 
			new SimpleDateFormat("yyyy-MM-dd a HH:mm:ss.SSS");
		
		File[] contents = temp.listFiles();
		
		// File[] 에 저장된 해당 디렉토리 안의 모든 파일과
		// 디렉토리를 출력양식에 맞게 모두 출력		
		System.out.println(
			"날짜              시간         형태       크기    이름");
		System.out.println(
			"-------------------------------------------------------------------");
		
		for(File file : contents) {
			
			System.out.print(
				// 지정한 출력양식에 맞게, 현재 파일의
				// 가장 최근의 수정일자를 출력
				sdf.format(
					new Date( file.lastModified() )
				)
			);
			
			// 만일 디렉토리라면....
			if(file.isDirectory()) {
				System.out.print(
					"\t<DIR>\t\t\t" + file.getName());
			} else {
				System.out.print(
				"\t\t\t" + file.length() + "\t" + file.getName());
			} // if-else
			
 			System.out.println();
 			
		} // enhanced for
		
	} // main
	
} // end class
