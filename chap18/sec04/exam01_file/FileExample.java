package sec04.exam01_file;

import java.io.File;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;


public class FileExample {

	
	public static void main(String[] args) 
		throws Exception {
		
		//-------------------------------------//
		// �پ��� ���(���� �Ǵ� ���丮)�� ����
		// File ��ü ����
		//-------------------------------------//
		File dir = new File("C:/Temp/Dir");
		File file1 = new File("C:/Temp/file1.txt");
		File file2 = new File("C:/Temp/file2.txt");
		File file3 = 
			new File(
				// Ư��, URI ��ü�� �̿��Ͽ�, File��ü��
				// ������ ���� ����
				new URI("file:///C:/Temp/file3.txt")
			);
		
		
		//-------------------------------------//
		// File ��ü�� ������ �޼ҵ� ���
		//-------------------------------------//		
		if(dir.exists() == false) {
			// ��λ� ���� ��� ���丮 ����
			dir.mkdirs();  
		} // if
		
		if(file1.exists() == false) {  
			// ũ�Ⱑ 0����Ʈ��, ���ο� ���� ����
			file1.createNewFile();  
		} // if
		
		if(file2.exists() == false) {  
			// ũ�Ⱑ 0����Ʈ��, ���ο� ���� ����
			file2.createNewFile();  
		} // if
		
		if(file3.exists() == false) {  
			// ũ�Ⱑ 0����Ʈ��, ���ο� ���� ����
			file3.createNewFile();  
		} // if
		
		
		//-------------------------------------//
		// ���� â�� dir ���ó�� ���丮 ������
		// ����غ���!!!!!
		//-------------------------------------//
		File temp = new File("C:/Temp");
		
		SimpleDateFormat sdf = 
			new SimpleDateFormat("yyyy-MM-dd a HH:mm:ss.SSS");
		
		File[] contents = temp.listFiles();
		
		// File[] �� ����� �ش� ���丮 ���� ��� ���ϰ�
		// ���丮�� ��¾�Ŀ� �°� ��� ���		
		System.out.println(
			"��¥              �ð�         ����       ũ��    �̸�");
		System.out.println(
			"-------------------------------------------------------------------");
		
		for(File file : contents) {
			
			System.out.print(
				// ������ ��¾�Ŀ� �°�, ���� ������
				// ���� �ֱ��� �������ڸ� ���
				sdf.format(
					new Date( file.lastModified() )
				)
			);
			
			// ���� ���丮���....
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
