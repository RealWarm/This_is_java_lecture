package sec06.exam07_array_copy;

import java.util.Arrays;

public class ArrayCopyExample {
	
	
	public static void main(String[] args) {
		String[] sourceArray = { "java", "array", "copy" };
		String[] targetArray = new String[5];
		
		System.arraycopy( 
				sourceArray,		// �ҽ��迭 ����(�ּ�) 
				0, 					// �ҽ��迭 ���� ������ġ(offset)
				targetArray, 		// Ÿ�ٹ迭 ����(�ּ�)
				0, 					// Ÿ�ٹ迭 ���� ������ġ(offset)
				sourceArray.length	// �ҽ��迭 ������ ������ ����(length)
			);
		
		System.out.println(Arrays.toString(targetArray));
		
//		for(int i=0; i<targetArray.length; i++) {
//			System.out.print(targetArray[i] + ", ");
//		} // for
		
	} // main
	
} // end class