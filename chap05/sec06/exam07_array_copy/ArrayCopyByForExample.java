package sec06.exam07_array_copy;

import java.util.Arrays;

public class ArrayCopyByForExample {
	
	public static void main(String[] args) {
		int[] sourceArray = { 1, 2, 3 };
//		int[] targetArray = new int[5];
		
//		for(int i=0; i<sourceArray.length; i++) {
//			targetArray[i] = sourceArray[i];
//		} // for
//		
//		System.out.println(
//				Arrays.toString(targetArray)
//			);
		
		//---------------------------------------//
		// Using Arrays.
		//---------------------------------------//
		int[] targetArray = Arrays.copyOf(sourceArray, 10);		
		System.out.println(Arrays.toString(targetArray));
		
		
		
		
		
		
		
	} // main
	
} // end class





