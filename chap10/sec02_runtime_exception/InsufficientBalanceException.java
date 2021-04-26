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
					"계좌잔고가 1천원이 부족합니다."
				);
	} //method
	
} // end class
