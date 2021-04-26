package sec05.exam08_objectinputstream_objectoutputstream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class NonSerializableParentExample {

	
	public static void main(String[] args) 
		throws Exception {
		
		// 1. ��ü�� ����ȭ�� ����, ���Ͽ� �ڹ� ��ü�� �����ϱ�
		//    ����, �켱 ����Ʈ ����� ������½�Ʈ�� ����
		FileOutputStream fos = 
				new FileOutputStream("C:/Temp/Object.dat");
		
		
		// 2. ������½�Ʈ���� ��ü����ȭ ������Ʈ�� �߰�
		ObjectOutputStream oos = 
				new ObjectOutputStream(fos);
		
		
		// 3. Serializable �������̽��� �������� ����
		//    Child ��ü�� ���� �� �ʵ尪 �ʱ�ȭ
		Child child = new Child();
		child.field1 = "ȫ�浿";
		child.field2 = "ȫ���";
		
		
		// 4. ��ü��º�����Ʈ���� writeObject(Object)
		//    �޼ҵ带 ȣ���Ͽ�, ��½�Ʈ������ ���(����)
		oos.writeObject(child);
		
		oos.flush(); // ��¹��ۿ� �ܷ��ϴ� ������ ����flush
		
		// 5. ����� ��� ��Ʈ�� ��ü �ݱ�(���� �߿�)
		//    ������Ʈ�� �ݱ� > ������Ʈ�� �ݱ�		
		oos.close(); 
		fos.close();	
		
		//------------------------------------------//
		// 
		
		FileInputStream fis = 
			new FileInputStream("C:/Temp/Object.dat");
		
		
		ObjectInputStream ois = 
			new ObjectInputStream(fis);
		
		Child v = (Child) ois.readObject();
		
		
		System.out.println("field1: " + v.field1);
		System.out.println("field2: " + v.field2);
		
		
		ois.close(); 
		fis.close();
	} // main
	
} // end class
