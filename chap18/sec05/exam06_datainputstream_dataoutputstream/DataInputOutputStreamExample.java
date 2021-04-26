package sec05.exam06_datainputstream_dataoutputstream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DataInputOutputStreamExample {
	
	
	public static void main(String[] args) 
		throws Exception {
		
		// �⺻Ÿ���� ������ ����� �����͸� ������
		// ��/����� �����ϰ��� �� ������,
		// DataInputStream/DataOutputStream�� ���
		
		// ������ ����Ʈ����� ������½�Ʈ�� ����
		FileOutputStream fos = 
			new FileOutputStream("C:/Temp/primitive.dat");
		
		// �⺻Ÿ�� ����� ���� ��½�Ʈ�� �߰�
		DataOutputStream dos = 
				new DataOutputStream(fos);
		
		//----------------------------------
		// �⺻Ÿ���� ������ ��¼���
		//----------------------------------
		dos.writeUTF("ȫ�浿");		// 1. ���ڿ� ���
		dos.writeDouble(95.5);		// 2. double �� ���
		dos.writeInt(1);			// 3. int �� ���
		
		dos.writeUTF("���ڹ�");		// 4. ���ڿ� ���
		dos.writeDouble(90.3);		// 5. double �� ���
		dos.writeInt(2);			// 6. int �� ���
		
		// ����� ��Ʈ�� �ݱ� (�ݴ� ���� �߿�)
		// ������Ʈ�� �ݱ� > ������ ��Ʈ�� �ݱ� ������...
		dos.flush(); 
		dos.close(); 
		fos.close();
		
		//-------------------------------------//
		// �� ������ ������ �о
		//-------------------------------------//
		
		FileInputStream fis = 
			new FileInputStream("C:/Temp/primitive.dat");
		
		// �⺻Ÿ������ �Է¼������� ������Ʈ�� �߰�
		DataInputStream dis = new DataInputStream(fis);
		
		// 2ȸ�� ���ļ�...
		for(int i=0; i<2; i++) {
			String name = dis.readUTF();	// 1. ���ڿ�
			double score = dis.readDouble();// 2. double	
			int order = dis.readInt();		// 3. int
			
			System.out.println(
				name + " : " + 
				score + " : " + 
				order);
		} // for
		
		// ����� ���� ��Ʈ�� �ݱ�(�ݴ¼��� �߿�)
		dis.close(); 
		fis.close();
	} // main
	
} // end class

