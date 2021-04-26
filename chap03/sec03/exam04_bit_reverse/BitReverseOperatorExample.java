package sec03.exam04_bit_reverse;

public class BitReverseOperatorExample {
	
	public static void main(String[] args) {
		int v1 = 10;
		int v2 = ~v1;	// ~ : 비트반전연산자로, 결과는 1의 보수
		int v3 = ~v1 + 1;	// 1의 보수 + 1 -> 2의 보수 (즉, 음수값 생성)
		
		System.out.println(
				toBinaryString(v1) + " (십진수: " + v1 + ")");
		System.out.println(
				toBinaryString(v2) + " (십진수: " + v2 + ")");
		System.out.println(
				toBinaryString(v3) + " (십진수: " + v3 + ")");
		System.out.println();
		
		//----------------------------------//
		
//		int v4 = -10;
//		int v5 = ~v4;
//		int v6 = ~v4 + 1;
//		System.out.println(toBinaryString(v4) + " (십진수: " + v4 + ")");
//		System.out.println(toBinaryString(v5) + " (십진수: " + v5 + ")");
//		System.out.println(toBinaryString(v6) + " (십진수: " + v6 + ")");
	} // main
	
	public static String toBinaryString(int value) {
		String str = Integer.toBinaryString(value);
		
		while(str.length() < 32) {
			str = "0" + str;
		} // while
		
		return str;
	} // toBinaryString
	
	
//	public static void main(String[] args) {
//		String str = toBinaryString(100);
//		
//		System.out.println("- str: "+ str);
//	} // main
	
} // end class












