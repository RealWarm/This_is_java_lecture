package sec03.exam02_noname_implement_class;

public class AnonymousChildObject {

	public static void main(String[] args) {
		
		Parent parent = new Parent() {
			public String name = "Yoseph";
			public int age = 24;
					
			
			@Override
			public void method1() {
				System.out.println(
					"- Overried method1 invoked."+name);
			} //method1
			
		}; // 劳疙磊侥按眉 积己 扁过
		
		System.out.println("- parent: "+ parent);
		parent.method1();		// OK
		
//		System.out.println(parent.name);	// X
//		System.out.println(parent.age);		// X
		
		
	} // main

} // end class
