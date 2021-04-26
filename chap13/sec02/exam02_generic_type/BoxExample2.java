package sec02.exam02_generic_type;


public class BoxExample2 {

	
	public static void main(String[] args) {
		Box<String> box = 
				new Box<String>() {
			
			String name;
			int age;
			
			
			public void method() {
				
			} // method
			
		}; // 제네릭 익명자식객체 생성코드
	} // main

} // end class
