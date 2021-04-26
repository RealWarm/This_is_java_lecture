package sec06.exam01_protected.package2;

import sec06.exam01_protected.package1.A;


public class D extends A {
	
	
	public D() {
		//반드시 첫라인에 나와야 함 
		//생략가능-이때에는 자바컴파일러가 코드를 직접 넣어줌
		super();		// 부모생성자호출
		
		this.field = "value";
		this.method();
	} // constructor
	
} // end class
