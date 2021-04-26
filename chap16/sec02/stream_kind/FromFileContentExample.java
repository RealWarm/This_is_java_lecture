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
	
	// 문자기반 파일의 내용을 스트림을 통해 콘솔에 출력하는 예제
	public static void main(String[] args) 
		throws IOException {
		//------------------------------------------------
		// 1. Paths Utility Class의 static 메소드를 이용하여
		//    간단하게 경로를 모델링한 Path 객체 생성
		//------------------------------------------------
		Path path = Paths.get(
				"C:/Temp/web-app_2_4.xsd"
			);
		
//		Stream<String> stream;	// 스트림 저장 변수선언
		

		//------------------------------------------------
		// 2. Files Utility Class의 static 메소드를 이용하여
		//    Path으로 지정한 경로에 대해 스트림 객체 얻어내기
		//------------------------------------------------
		// 2-1. 지정된 경로에 대한 스트림 얻기
		Stream<String> stream = Files.lines(
				path,			// 위 1에서 만든 경로객체 
				Charset.defaultCharset() // 인코딩 문자집합
			);
		
		// 2-2. 스트림의 최종처리 메소드인 forEach() 메소드를
		//      이용하여, 지정된 경로 밑에 있는 모든 파일과 디렉
		//      -토리 목록을 콘솔로 출력
		stream.forEach( System.out :: println );
		
		// 2-3. 스트림 닫기(자원반납) *** 중요 ***
		stream.close();
				
		System.out.println();

		//------------------------------------------------
		// 3. BufferedReader를 데이터 소스로 이용하여,
		//    지정된 문자기반파일의 내용을 스트림을 이용하여
		//    콘솔에 출력
		//------------------------------------------------
		// 3-1. Path 객체의 toFile()메소드를 이용하여, File
		//      객체 얻어내기
		File file = path.toFile();
		
		// 3-2. File 객체에 대하여, 문자기반 파일 입력스트림얻기
		FileReader fileReader = new FileReader(file);
		
		// 3-3. 성능보조스트림인 BufferedReader 부가!
		BufferedReader br = new BufferedReader(fileReader);
		
		// 3-4. 성능보조스트림으로부터, 스트림 얻어내기 *****
		stream = br.lines();
		
		// 3-5. 스트림의 최종처리 메소드인, forEach() 메소드를
		//      이용하여, 지정된 파일의 내용을 **한줄씩** 콘솔로
		//      출력하기
		stream.forEach( System.out :: println );
		
		//------------------------------------------------
		// 4. 사용이 모두 끝난 스트림 닫기(***자원반납***)
		stream.close();
	} // main
	
} // end class
