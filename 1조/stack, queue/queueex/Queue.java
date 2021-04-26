package queueex;

import java.util.Arrays;

public class Queue {
	
	static final int MAX = 10;
	int arr[] = new int[MAX];
	int length;
	
	public void enque(int x) {
		
		if (length < MAX) {
			arr[length++] = x;
			
			System.out.println(length + "번째 값으로 " + x + "를 enque함.");

			int[] result = new int[length];
		
			for (int i = 0; i < length; i++) {
				result[i] = arr[i];
			} // for
			
			System.out.println(Arrays.toString(result));
		} else {
			System.out.println("Overflow");
		} // if-else
		
	} // enque
	
	public void deque() {
		
		if (length <= 0) {
			System.out.println("Underflow");
		} else {
			int x = arr[0];
			
			System.out.println(x +"가 삭제되었습니다.");
			
			int[] result = new int[--length];
		
			for (int i = 1; i <= length; i++) {
				result[i-1] = arr[i];
			} // for
			
			arr[length] = 0;
			
			for (int i = 0; i < length; i++) {
				arr[i] = result[i];
			} // for
			
			System.out.println(Arrays.toString(result));
		} // if-else		
		
	} // deque
	
} // end class
