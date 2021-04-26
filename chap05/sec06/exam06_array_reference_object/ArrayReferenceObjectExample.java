package sec06.exam06_array_reference_object;


public class ArrayReferenceObjectExample {
	
	public static void main(String[] args) {		
		String[] strArray = new String[3];
		
		strArray[0] = "Java";
		strArray[1] = "Java";
		strArray[2] = new String("Java");

//		System.out.println( strArray[0] == strArray[1]);
//		System.out.println( strArray[0] == strArray[2] );    
//		System.out.println( strArray[0].equals(strArray[2]) );
		
		//-------------------------------------------------//
		
//		System.out.println("1. strArray[0]: "+strArray[0]);
//		System.out.println("2. strArray[2]: "+strArray[2]);
		
		//-------------------------------------------------//
//		 해시코드란, 힙 영역에 생성된 개별 객체의 식별자(Identifier)
//		 dB로 치면, 테이블의 PK와 비슷한 개념임.
		 
		System.out.println("3. strArray[0]: "+strArray[0].hashCode());
		System.out.println("4. strArray[2]: "+strArray[2].hashCode());
		
		//-------------------------------------------------//
		Object o1 = new Object();
		Object o2 = new Object();
		
		System.out.println("1. o1: " + o1);
		System.out.println("2. o2: " + o2);
		
		System.out.println("3. o1: " + o1.hashCode());
		System.out.println("4. o2: " + o2.hashCode());
		
		int o1_hashCode = o1.hashCode();
		int o2_hashCode = o2.hashCode();
		System.out.println("3. o1: " + Integer.toHexString(o1_hashCode));
		System.out.println("4. o2: " + Integer.toHexString(o2_hashCode));
		
		
		
		
		
		
		
		
		
	} // main
	
} // end class

