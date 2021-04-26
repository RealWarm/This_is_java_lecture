package sec03.exam01_system_in_out;

import java.io.InputStream;

public class SystemInExample2 {
	
	
	public static void main(String[] args) 
		throws Exception {
		
		// 1. ǥ���Է�(����Ʈ��� ��Ʈ��) ���
		InputStream is = System.in;
		
		// 2. �ֿܼ��� ����ڰ� Ű����� �Է��� �޽����� ������
		// ��������(����Ʈ �迭. ��? ����Ʈ��� �Է½�Ʈ���̱⿡)
		byte[] datas = new byte[100]; // �ִ�100����Ʈ����
		
		// 3. ǥ��������� �޽��� ǥ��
		System.err.print("1. �̸��� �Է��ϼ���: ");
		
		// 4. ǥ���Է�(����Ʈ��� �Է½�Ʈ��)���κ���,
		//    ����ڰ� �Է��� �޽����� �о��(��ä��...)
		int nameBytes = is.read(datas);
		// (����) nameBytes : ���� �о�� ����Ʈ�� ����
		
		// 5. ǥ���Է�(����Ʈ��� �Է½�Ʈ��)���� ��ä��
		//    �о�� ����Ʈ �迭(�ִ�100����Ʈ)�� ���ڿ��κ�ȯ
		//    ��, byte[] ----> String
		//    (����***) �̶�, ����Ʈ �迭�� �� ������ 2����Ʈ
		//              �� ���ڿ��� ��ȯ��Ű�� �ʰ� ���ܽ�Ŵ.
		//              ��????
		String name = new String(datas, 0, nameBytes-2);

		// 5. ǥ��������� �޽��� ǥ��
		System.err.print("2. �ϰ� �������� �Է��ϼ���: ");

		// 6. ǥ���Է�(����Ʈ��� �Է½�Ʈ��)���κ���,
		//    ����ڰ� �Է��� �޽����� �о��(��ä��...)
		int commentBytes = is.read(datas);
		// (����) commentBytes : ���� �о�� ����Ʈ�� ����
		
		// 7. ǥ���Է�(����Ʈ��� �Է½�Ʈ��)���� ��ä��
		//    �о�� ����Ʈ �迭(�ִ�100����Ʈ)�� ���ڿ��κ�ȯ
		//    ��, byte[] ----> String
		//    (����***) �̶�, ����Ʈ �迭�� �� ������ 2����Ʈ
		//              �� ���ڿ��� ��ȯ��Ű�� �ʰ� ���ܽ�Ŵ.
		//              ��????
		String comment = 
				new String(datas, 0, commentBytes-2);
		
		// 8. ǥ�����(����Ʈ��� ��½�Ʈ��)����
		//    ����ڰ� �Է��� �̸��� �ϰ���� ���� ���ڿ��� 
		//    �����
		System.err.println("�Է��� �̸�: " + name);	
		System.err.println("�Է��� �ϰ� ������: " + comment);
		
	} // main
	
} // end class

