package sec02.exam03_abstract_method;


public interface RemoteControl {
	// 1. ���(�Һ��� ������)
	public static final int MAX_VOLUME = 10;
	public static final int MIN_VOLUME = 0;
	
	
	// 2. �߻� �޼ҵ� 
	//    --> �԰�(�𵨸� ����� �Ǵ� ��ü�� �ݵ�� ���Ѿ���
	//             �ּ��� �԰��� �����ϴ� ��!!!)
	public abstract void turnOn();
	public abstract void turnOff();
	public abstract void setVolume(int volume);

} // end interface









