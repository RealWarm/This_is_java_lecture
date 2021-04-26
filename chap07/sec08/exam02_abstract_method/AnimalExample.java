package sec08.exam02_abstract_method;

public class AnimalExample {
	
	
	public static void main(String[] args) {
		//---------------------------------------//
		Dog dog = new Dog();
		Cat cat = new Cat();

		//---------------------------------------//
		dog.sound();	// �� ��ü�� ������ �԰��� Ȯ��
		cat.sound();	// �� ��ü�� ������ �԰��� Ȯ��
		
		System.out.println("-----");
		
		//---------------------------------------//
		// ������ �ڵ� Ÿ�� ��ȯ
		//---------------------------------------//
		Animal animal = null;	// �θ�(�߻�Ŭ����) Ÿ�Ժ���
		animal = new Dog();		// ������-1
		animal.sound();			// ������-2
		animal = new Cat();		// ������-1
		animal.sound();			// ������-2
		System.out.println("-----");
		
		//---------------------------------------//
		//�Ű������� �ڵ� Ÿ�� ��ȯ
		//---------------------------------------//		
		animalSound(new Dog());	// ������-1
		animalSound(new Cat()); // ������-1
	} // main
		
	// �Ű������� ������!!!
	// Animal animal = new Dog();
	// Animal animal = new Cat();
	public static void animalSound(Animal animal) {
		animal.sound();  		// ������-2 
	} // animalSound
	
} // end class
