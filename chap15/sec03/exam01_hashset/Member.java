package sec03.exam01_hashset;


public class Member {
	public String name;	// 이름
	public int age;		// 나이

	
	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	} // 생성자

	//---------------------------------------
	// User-defined Class (개발자가 선헌한 클래스를
	// Set 컬렉션에 저장할 때, 중복(동등)객체 여부를
	// 판단하기 위한 기준을, 개발자가 정하고 있음!!!!
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
	
	// System.out.println(obj)은, obj의 toString() 메소드
	// 를 호출하여 얻어낸 리턴값을 그대로 출력하는 것임
	@Override
	public String toString() {
		return "("+name+", "+age+")";
	} // toString
	
} // end class
