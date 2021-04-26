package sec05.exam08_objectinputstream_objectoutputstream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;



public class ObjectInputOutputStreamExample {
	
	
	public static void main(String[] args) 
		throws Exception {
		
		// 1. ����Ʈ����� ���� ��½�Ʈ�� ����
		FileOutputStream fos = 
			new FileOutputStream("C:/Temp/Object.dat");
		
		// 2. ������ ������½�Ʈ���� ��ü��� ������Ʈ�� �߰�
		ObjectOutputStream oos = 
			new ObjectOutputStream(fos);		
		
		// 3. ��ü������Ʈ���� �����ϴ� writeObject(Object)
		//    �޼ҵ带 ȣ���Ͽ�, ���Ͽ� �ڹ� ��ü ����
		oos.writeObject(new Integer(10)); // Integer��ü
		oos.writeObject(new Double(3.14)); // Double��ü
		oos.writeObject(new int[] { 1, 2, 3 }); // �迭��ü
		oos.writeObject(new String("ȫ�浿")); // ���ڿ���ü
		
		oos.flush(); // ��¹��ۿ� �ܷ��ϴ� ����Ʈ ���� Flush	
		
		// 4. ��� ��Ʈ�� ��ü �ݱ�(�ݴ� ���� �߿�)
		//    ������Ʈ�� �ݱ� > ������ ��Ʈ�� �ݱ�
		oos.close(); 
		fos.close();
		
//		System.exit(0);
		
		
		
		
		//-----------------------------------------//
		// Part2: ��ü�� ������ȭ ������ ����, ���Ͽ� �����
		//        �ڹٰ�ü�� ����(�б�)
		//-----------------------------------------//
		
		// 1. ����Ʈ ����� �����Է½�Ʈ�� ����
		FileInputStream fis = 
				new FileInputStream("C:/Temp/Object.dat");
		
		// 2. ��ü�� ������ȭ ������ �̿��� �ڹٰ�ü�� ���Ϸκ���
		//    �����ϱ� ���Ͽ� ��ü �Էº�����Ʈ�� ����
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		// 3. ObjectInputStream �� readObject() �޼ҵ带
		//    ȣ���Ͽ�, ���Ͽ� ����� ���� �ڹ� ��ü�� ����(����)
		Integer obj1 = (Integer) ois.readObject();
		Double obj2 = (Double) ois.readObject();
		int[] obj3 = (int[]) ois.readObject();
		String obj4 = (String) ois.readObject();

		// 4. ��� ��Ʈ�� ��ü �ݱ�(�ݴ� ���� �߿�)
		//    ������Ʈ�� �ݱ� > ������ ��Ʈ�� �ݱ�
		ois.close(); 
		fis.close();
		
		// 5. ���Ϸκ��� ������ �ڹٰ�ü ���
		System.out.println(obj1);
		System.out.println(obj2);
		System.out.println(
			obj3[0] + "," + obj3[1] + "," + obj3[2]);
		System.out.println(obj4);
	} // main
	
} // end class
