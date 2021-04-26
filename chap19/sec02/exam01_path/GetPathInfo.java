package sec02.exam01_path;

import java.nio.file.FileSystem;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import static java.lang.System.*
;
public class GetPathInfo {
	
	
	public static void main(String[] args) {
		//-----------------------------------------
		// 1. Path �������̽��� ������ü ����#2
		//-----------------------------------------
		// Paths.get() �޼ҵ�� �������� �����ε� �Ǿ�����
		// ��: Paths.get("��θ�");
		//     Paths.get("�̸�1", "�̸�2", .... );
		//     Paths.get(new URI("file:///C:/temp/sunnydays.mp3"));
		Path path = Paths.get("C:/Temp", "sunnydays.mp3");
		
		System.out.println("- path: "+path);
		//-----------------------------------------

		//-----------------------------------------
		System.out.println(
			"\t+ getFileName: "+path.getFileName());
		
		System.out.println(
			"\t+ getParent: "+
			path.getParent().getFileName());
		
		System.out.println(
			"\t+ getNameCount: "+path.getNameCount());
		//-----------------------------------------

		//-----------------------------------------
		for(int i=0; i<path.getNameCount(); i++) {
			System.out.println(
				"\t\t* getName: "+path.getName(i));
			
		} // for

		//-----------------------------------------
		Iterator<Path> iterator = path.iterator();
		System.out.println("- iterator: "+ iterator);
		
		while(iterator.hasNext()) {
			Path p = iterator.next();
			System.out.println(
				"\t+ path: "+p.getFileName());
			
		} // while
		//-----------------------------------------

		//-----------------------------------------
		out.println("- toString: "+path.toString());		
		out.println("- toUri: "+ path.toUri());
		out.println(
			"\t+ toUri.getPath: "+ path.toUri().getPath());
		out.println(
			"\t+ toUri.getHost: "+path.toUri().getHost());
		out.println(
			"\t+ toUri.getFragment: "+
					path.toUri().getFragment());
		out.println(
			"\t+ toUri.getQuery: "+path.toUri().getQuery());
		//-----------------------------------------
		
		//-----------------------------------------
		out.println("- toFile: "+ path.toFile());
		
		Path root = path.getRoot();
		out.println("- getRoot: "+ root);
		
		Path path2 = Paths.get("C:/Temp/HncDownload/../");
		out.println("- normalize: "+path2.normalize());
		
		// 1. �� ���ϰ�ΰ� �����ϸ�, 0�� ����
		// 2. �� ���ϰ���߿�, ���ذ�ΰ� �񱳰�κ���, ��������̸�
		//    ������ ����
		// 3. �� ���ϰ���߿�, ���ذ�ΰ� �񱳰�κ���, ��������̸�
		//    ����� ����
		int result = path.compareTo(path);
		out.println("- compareTo: "+result);
		
		int result2 = path2.compareTo(path);
		out.println("- compareTo: "+result2);
		
		int result3 = path.compareTo(path2);
		out.println("- compareTo: "+result3);
		//-----------------------------------------
		
		//-----------------------------------------
		FileSystem fs = path.getFileSystem();
		System.out.println("- getFileSystem: "+fs);
		//-----------------------------------------
		
	} // main

} // end class
