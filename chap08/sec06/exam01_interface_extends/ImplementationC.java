package sec06.exam01_interface_extends;

public class ImplementationC 
	implements InterfaceC {
	/* 
	 * ���߻���� �������̽��� �����ϴ� Ŭ������,
	 * �ش� �������̽��� ���ǵ� �߻�޼ҵ� �Ӹ� �ƴ϶�, 
	 * ��ӹ��� �߻� �޼ҵ���� ��� �����ؾ� ��!!!
	 */
	
	public void methodA() {	// interfaceA �� �߻�޼ҵ�
		System.out.println(
				"- ImplementationC::methodA() invoked.");
	} // methodA
	
	public void methodB() { // interfaceB �� �߻�޼ҵ�
		System.out.println(
				"- ImplementationC::methodB() invoked.");
	} // methodB
	
	public void methodC() { // interfaceC �� �߻�޼ҵ�
		System.out.println(
				"- ImplementationC::methodC() invoked.");
	} // methodC
	 
} // end class

