package stackex;

import java.util.Arrays;

public class Stack {
	
	static final int MAX = 10;
	int arr[] = new int[MAX];
	int topPoint;
	
	public void push(int x) {

		if (topPoint < MAX) {
			arr[topPoint++] = x;
			System.out.println(topPoint + "번째 값으로 " + x + "를 push함.");

			int[] result = new int[topPoint];

			for (int i = 0; i < topPoint; i++) {
				result[i] = arr[i];
			} // for

			System.out.println(Arrays.toString(result));
		} else {
			System.out.println("Overflow");
		} // if-else

	} // push

	public void pop() {
		if (topPoint <= 0) {
			System.out.println("Undeflow");
		} else {
			int x = arr[--topPoint];
			System.out.println(x + "를 pop함.");

			int[] result = new int[topPoint];

			for (int i = 0; i < topPoint; i++) {
				result[i] = arr[i];
			} // for

			System.out.println(Arrays.toString(result));
		} // if-else
		
	} // pop

	public int topPointer() {
		int x = arr[topPoint - 1];
		
		return x;
	} // topPointer

}
