package sec15.exam01_annotation;


public class TTT {
	
	
	public static void main(String[] args) {
		Class serviceClazz = Service.class;
		System.out.println(
				"1. serviceClazz: " + serviceClazz
			);
		
		System.out.println(
				"1-1. hashCode: "+ 
				serviceClazz.hashCode());
		
		//-----------------------------------------//
		
		Service service = new Service();
		serviceClazz = service.getClass();
		System.out.println(
				"2. serviceClazz: " + serviceClazz
			);
		
		System.out.print(
				"2-1. hashCode: "+ 
				serviceClazz.hashCode());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	} // main

} // end class
