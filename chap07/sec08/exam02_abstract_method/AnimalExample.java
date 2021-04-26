package sec08.exam02_abstract_method;

public class AnimalExample {
	
	
	public static void main(String[] args) {
		//---------------------------------------//
		Dog dog = new Dog();
		Cat cat = new Cat();

		//---------------------------------------//
		dog.sound();	// 각 실체가 구현한 규격을 확인
		cat.sound();	// 각 실체가 구현한 규격을 확인
		
		System.out.println("-----");
		
		//---------------------------------------//
		// 변수의 자동 타입 변환
		//---------------------------------------//
		Animal animal = null;	// 부모(추상클래스) 타입변수
		animal = new Dog();		// 다형성-1
		animal.sound();			// 다형성-2
		animal = new Cat();		// 다형성-1
		animal.sound();			// 다형성-2
		System.out.println("-----");
		
		//---------------------------------------//
		//매개변수의 자동 타입 변환
		//---------------------------------------//		
		animalSound(new Dog());	// 다형성-1
		animalSound(new Cat()); // 다형성-1
	} // main
		
	// 매개변수의 다형성!!!
	// Animal animal = new Dog();
	// Animal animal = new Cat();
	public static void animalSound(Animal animal) {
		animal.sound();  		// 다형성-2 
	} // animalSound
	
} // end class
