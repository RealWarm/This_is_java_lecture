package sec02_runtime_exception;


public class InsufficientBalanceException 
	extends RuntimeException {
	
	
	public InsufficientBalanceException() {
		super();
	} // constructor
	
	public InsufficientBalanceException(String message) {
		super(message);
	} // constructor

} // end class


class Test {
	
	void method() {
		Exception e = 
			new InsufficientBalanceException();
		
		e = 
			new InsufficientBalanceException(
					"�����ܰ� 1õ���� �����մϴ�."
				);
	} //method
	
} // end class
