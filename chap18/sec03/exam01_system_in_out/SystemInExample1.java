package sec03.exam01_system_in_out;

import java.io.InputStream;


public class SystemInExample1 {
	
	public static void main(String[] args) 
		throws Exception {
		
		//-----------------------------------------//
		
		System.out.println("=== �޴� ===");
		System.out.println("1. ���� ��ȸ");
		System.out.println("2. ���� ���");
		System.out.println("3. ���� �Ա�");
		System.out.println("4. ���� �ϱ�");
		System.out.println();
		
		System.out.print("* �޴��� �����ϼ���: ");
		
		//-----------------------------------------//
		
		// �ü���� �ڵ����� �Ҵ�����, ǥ���Է½�Ʈ���� ����
		// �̶� ǥ���Է½�Ʈ���� Ÿ���� ����Ʈ��� �Է½�Ʈ��!
		InputStream is = System.in;
		
		// ǥ���Է�(System.in, ��, �ְܼ� �����)���κ���, 
		// 1���� ����Ʈ �о��. 
		// �о�� 1���� ����Ʈ�� ����Ÿ������ ��������ȯ
		// ��? ����ڰ� ������ �޴��� �������� �˱� ����, 
		// ���ڷ� ���� ����ȯ�� (�׷���, ������ ������ ����)
		char inputChar = (char) is.read();	
		
		//-----------------------------------------//
		
		// ����ڰ� ������ �޴��� ���������� ����, �ٸ�
		// ������ �ֿܼ� ǥ�����(System.out)�� ���� �����!!!
		switch(inputChar) {
			case '1':		// ������ �޴��� 1�̸�,
				System.
					out.	// ǥ�����
					println("���� ��ȸ�� �����ϼ̽��ϴ�.");
				
				break;
			case '2':		// ������ �޴��� 2�̸�,
				System.
					out.	// ǥ�����
					println("���� ��ݸ� �����ϼ̽��ϴ�.");
				
				break;
			case '3':		// ������ �޴��� 3�̸�,
				System.
					out.	// ǥ�����
					println("���� �Աݸ� �����ϼ̽��ϴ�.");
				
				break;
			case '4':		// ������ �޴��� 4�̸�,
				System.
					err.	// ǥ�ؿ���
					println("���� �ϱ⸦ �����ϼ̽��ϴ�.");
				
				break;
		} // switch		 	
	} // main
	
} // end class
