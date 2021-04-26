package queueex;

public class QueueExample {
	
	
	public static void main(String[] args) {
		Queue q = new Queue();
		
		for (int i = 0; i < args.length; i++) {
			q.enque(Integer.parseInt(args[i]));
		} // for
		
		q.deque();
		q.deque();
	} // main
	
} // end class
