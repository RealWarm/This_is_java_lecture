package sec02.exam01_createthread;

import java.awt.Toolkit;


public class BeepPrintExample1 {
	
	
	public static void main(String[] args) {
		//-------------------------------------
		// 1. Java AWT Toolkit ��ü�� ����. 
		// ��? �������� �︮�� ����� �ֱ� ������..
		Toolkit toolkit = Toolkit.getDefaultToolkit();

		//-------------------------------------
		// 2. �� 5�� �ݺ��ؼ�, ������ �� Tookit ��ü��
		//    �޼ҵ�(beep)�� ȣ���Ͽ�, ���� �������� �߻���Ŵ
		for(int i=0; i<5; i++) {		
			toolkit.beep();
			
			// �Ź� �������� �︮������, 0.5�� ���
			try { Thread.sleep(1000L * 10); } 
			catch(Exception e) { ;; }
		} // for

		//-------------------------------------
		// 3. �� 5�� �ݺ��ؼ�, console�� '��' ���ڸ� ���
		for(int i=0; i<5; i++) {
			System.out.println("��");

			// �Ź� �������� �︮������, 0.5�� ���
			try { Thread.sleep(500); } 
			catch(Exception e) { ;; }
		} // for
		
	} // main

} // end class
