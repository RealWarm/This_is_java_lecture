package sec05.exam08_objectinputstream_objectoutputstream;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;


public class SerializableWriter {
	
	
	public static void main(String[] args) 
		throws Exception {
		
		// 1. ����Ʈ ����� ���� ��� ��Ʈ�� ����
		FileOutputStream fos = 
			new FileOutputStream("C:/Temp/Object.dat");
		
		// 2. ���� ��½�Ʈ���� ��ü ����� ����
		//    ��ü��� ������Ʈ�� �߰�
		ObjectOutputStream oos = 
			new ObjectOutputStream(fos);		
		
		// 3. OOP�� ������ �Ϲ� Ŭ�����κ��� ��ü ���� ��
		//    �ʵ尪 �ʱ�ȭ
		ClassA classA = new ClassA();
		classA.field1 = 1;
		classA.field2.field1 = 2;	// ClassB Ÿ���ʵ�
		classA.field3 = 3;			// static �ʵ� ***
		classA.field4 = 4;			// transient �ʵ� ***
		
		// 4. ���Ͽ� ClassA Ÿ���� ��ü ���
		//    ObjectOutputStream�� writeObject(Object)
		//    �޼ҵ� ȣ���� ����, ��ü�� ����ȭ�� �̿��Ͽ�
		//    ���Ͽ� �ڹ� ��ü ����
		oos.writeObject(classA);
		
		oos.flush(); // ��¹��ۿ� �ܷ��ϴ� ������ ����flush
		
		// 5. ����� ���� ��� ��Ʈ�� �ݱ�(�����߿�)
		//    ������Ʈ�� �ݱ� > ���� ��Ʈ�� �ݱ�
		oos.close(); 
		fos.close();	
	} // main
	
} // end class
