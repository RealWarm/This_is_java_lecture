package sec15.exam01_annotation;


@PrintAnnotation
/*@PrintAnnotation*/ public /*@PrintAnnotation*/ 
class Service {
	
	@PrintAnnotation
	String name;
	
	
	
	@PrintAnnotation
	/*@PrintAnnotation*/ public /*@PrintAnnotation*/ 
		Service() {
		;;
	} //constructor
	
	
	
	
	
	
	@PrintAnnotation
	/*@PrintAnnotation*/ public /*@PrintAnnotation*/ int age;
	
	
	
	@PrintAnnotation
	/*@PrintAnnotation*/ public /*@PrintAnnotation*/ void method1() {
		System.out.println("- Service::method1 invoked.");
	} // method1

	
	@PrintAnnotation("*")
	public void method2() {
		System.out.println("- Service::method2 invoked.");
	} // method2	 
	
	
	@PrintAnnotation(value="#", number=20)
	public void method3() {
		System.out.println("- Service::method3 invoked.");
	} // method3	
	
	
	public void method4(@PrintAnnotation String name, @PrintAnnotation int age) {
		@PrintAnnotation
		int height = 0;
		
		@PrintAnnotation
		/*@PrintAnnotation*/ String s = null;
		
		
		
	} // method4
	
} // end class









