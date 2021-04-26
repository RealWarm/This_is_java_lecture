package sec06.exam07_array_copy;

import java.util.Arrays;

public class ArrayCopyExample {
	
	
	public static void main(String[] args) {
		String[] sourceArray = { "java", "array", "copy" };
		String[] targetArray = new String[5];
		
		System.arraycopy( 
				sourceArray,		// 소스배열 참조(주소) 
				0, 					// 소스배열 복사 시작위치(offset)
				targetArray, 		// 타겟배열 참조(주소)
				0, 					// 타겟배열 복사 시작위치(offset)
				sourceArray.length	// 소스배열 복사할 원소의 개수(length)
			);
		
		System.out.println(Arrays.toString(targetArray));
		
//		for(int i=0; i<targetArray.length; i++) {
//			System.out.print(targetArray[i] + ", ");
//		} // for
		
	} // main
	
} // end class