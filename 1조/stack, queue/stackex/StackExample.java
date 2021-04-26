package stackex;

public class StackExample {
	
	
	public static void main(String args[]) {
		 Stack s = new Stack();

		for (int i = 0; i < args.length; i++) {
			s.push(Integer.parseInt(args[i]));
		} // for

		System.out.println("top pointer: " + s.topPointer());

		s.pop();
	} // main
	
} // end class
