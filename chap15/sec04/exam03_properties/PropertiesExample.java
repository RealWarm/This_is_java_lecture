package sec04.exam03_properties;

import java.io.FileReader;
import java.net.URLDecoder;
import java.util.Properties;


public class PropertiesExample {
	
	
	public static void main(String[] args) 
		throws Exception {

		//----------------------------------//
		// db.properties ������ ������ �о,
		// Map ������ü�� Properties�� ����(�ε��̶�� ��)
		Properties properties  = new Properties();
		
		// 1. �о���� db.properties ������ �����θ� Ȯ����
		String path = 
				PropertiesExample.
				class.
				getResource("db.properties").
				getPath();
		
		System.out.println("- 1. path: "+ path);		
		
		// ����, db.properties ���Ͽ� �ѱ۰� ���� �ٱ��� ����
		// �� ��� ������, �̸� ���ڵ�(decoding)�Ͽ� �����
		// �ѱ۷� �о��
		path = URLDecoder.decode(path, "utf-8");
		System.out.println(
				"- 2. path after decode: "+ path);	
		
		// db.properties ������ ���� Map ��ü�� �ε�
		properties.load( new FileReader(path) );
		
		//----------------------------------//
		// Map�� �ε��� db.properties ������ ����
		// (key=value) ���� ���� ��
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

