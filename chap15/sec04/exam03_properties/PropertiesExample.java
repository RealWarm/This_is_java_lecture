package sec04.exam03_properties;

import java.io.FileReader;
import java.net.URLDecoder;
import java.util.Properties;


public class PropertiesExample {
	
	
	public static void main(String[] args) 
		throws Exception {

		//----------------------------------//
		// db.properties 파일의 내용을 읽어서,
		// Map 구현객체인 Properties에 보관(로딩이라고도 함)
		Properties properties  = new Properties();
		
		// 1. 읽어들일 db.properties 파일의 절대경로를 확보함
		String path = 
				PropertiesExample.
				class.
				getResource("db.properties").
				getPath();
		
		System.out.println("- 1. path: "+ path);		
		
		// 만일, db.properties 파일에 한글과 같은 다국어 문자
		// 가 들어 있으면, 이를 디코딩(decoding)하여 제대로
		// 한글로 읽어내기
		path = URLDecoder.decode(path, "utf-8");
		System.out.println(
				"- 2. path after decode: "+ path);	
		
		// db.properties 파일을 실제 Map 객체로 로딩
		properties.load( new FileReader(path) );
		
		//----------------------------------//
		// Map에 로딩된 db.properties 파일의 내용
		// (key=value) 쌍의 값을 얻어냄
		String value1 = 
				properties.getProperty("key1");
		
		String value2 = 
				properties.getProperty("key2");
		
		String value3 = 
				properties.getProperty("key3"); 
		
		System.out.println("value1 : " + value1);
		System.out.println("value2 : " + value2);
		System.out.println("value3 : " + value3);
	} // main
	
} // end class

