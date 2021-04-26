package sec03.exam01_hashset;


public class Member {
	public String name;	// �̸�
	public int age;		// ����

	
	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	} // ������

	//---------------------------------------
	// User-defined Class (�����ڰ� ������ Ŭ������
	// Set �÷��ǿ� ������ ��, �ߺ�(����)��ü ���θ�
	// �Ǵ��ϱ� ���� ������, �����ڰ� ���ϰ� ����!!!!
	//---------------------------------------
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member) {
			Member member = (Member) obj;
			
			return member.name.equals(name) && 
				   (member.age==age) ;
		} else {
			return false;
		} // if-else
	} // equals

	@Override
	public int hashCode() {
		return name.hashCode() + age;
	} // hashCode
	
	// System.out.println(obj)��, obj�� toString() �޼ҵ�
	// �� ȣ���Ͽ� �� ���ϰ��� �״�� ����ϴ� ����
	@Override
	public String toString() {
		return "("+name+", "+age+")";
	} // toString
	
} // end class
