package sec02.exam01_path;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;


public class PathExample {
	
	
	public static void main(String[] args) 
			throws Exception {
		
		//------------------------------------
		//-- 1. Path 의 구현객체 얻어내기
		//------------------------------------
		//   Path 인터페이스의 주요목적은, 파일시스템상의
		//   경로(Path)를 자바 객체로 모델링 하는 것임
		Path path = 
			Paths.get("C:/Temp/sunnydays.mp3");
		
		System.out.println("- path: "+path);
		System.out.println("- path class: "+path.getClass().getName());

		//------------------------------------
		//-- 2. Path 의 구현객체로부터 여러 속성정보 얻어내기
		//------------------------------------
		System.out.println(
			"[파일명] " + path.getFileName() );
		
		System.out.println(
			"[부모 디렉토리명]: " + 
			path.getParent().getFileName() );
		
		System.out.println(
			"중첩 경로수: " + path.getNameCount() );
		//------------------------------------
		
		
		System.out.println();
		

		//------------------------------------
		for(int i=0; i<path.getNameCount(); i++) {
			System.out.println( path.getName(i) );
		} // for
		//------------------------------------
		
		
		System.out.println();
		

		//------------------------------------
		Iterator<Path> iterator = path.iterator();
		
		while(iterator.hasNext()) {
			Path temp = iterator.next();
			
			System.out.println(temp.getFileName());
		} // while
		//------------------------------------
		
	} // main
	
} // end class
