package sec05.exam08_objectinputstream_objectoutputstream;

import java.io.FileInputStream;
import java.io.ObjectInputStream;


public class SerializableReader {
	
	
	public static void main(String[] args) 
		throws Exception {
		
		// 1. ��ü�� ����Ǿ� �ִ� ���Ϸκ���, �ڹٰ�ü��
		//    �����Ͽ� ����ϱ� ����, 
		//    �켱, ����Ʈ����� �Է½�Ʈ�� ����
		FileInputStream fis = 
			new FileInputStream("C:/Temp/Object.dat");
		
		
		// 2. ��ü�Է� ������Ʈ�� �߰�
		ObjectInputStream ois = 
			new ObjectInputStream(fis);
		
		
		// 3. ObjectInputStream �� Object readObject()
		//    �޼ҵ带 ȣ���Ͽ�, ��ü�� ������ȭ �� �ڹٰ�ü����
		//    return type�� Object �̹Ƿ� ����Ÿ������ ����
		//    ����ȯ �ʿ�.
		ClassA v = (ClassA) ois.readObject();
		
		
		// 4. ������ �ڹٰ�ü�� �ʵ尪�� ����� �����ν�,
		//    ó������ ��ü�� ����ȭ���� ���ܵ� �ʵ尡 ���
		//    �����Ǵ��� Ȯ���ʿ�!!!
		System.out.println("field1: " + v.field1);
		System.out.println(
				"field2.field1: " + v.field2.field1);
		
		System.out.println("field3: " + v.field3);
//		System.out.println("field3: " + ClassA.field3);
		
		System.out.println("field4: " + v.field4);
		
		
		// 5. ����� ���� ��� ��Ʈ�� �ݱ�(�����߿�)
		//    ������Ʈ�� �ݱ� > ���� ��Ʈ�� �ݱ�
		ois.close(); 
		fis.close();	
	} // main
	
} // end class
