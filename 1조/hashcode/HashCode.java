package Day7;

public class HashCode {
	public static void main(String[] args) {
		String[] strArray = new String[4];

		strArray[0] = "Java";	// 문자형 리터럴
		strArray[1] = new String("Java");	// new 객체생성연산자
		strArray[2] = "";	// 빈문자열
		strArray[3] = "AB"; // 65 * 31^(2 - 1) + 66 * 31^(2-2) = 2081

		System.out.println("3. strArray[0]: " + strArray[0].hashCode());
		System.out.println("3. strArray[1]: " + strArray[1].hashCode());
		System.out.println("4. strArray[2]: " + strArray[2].hashCode());
		System.out.println("5. strArray[3]: " + strArray[3].hashCode());
	}
}
