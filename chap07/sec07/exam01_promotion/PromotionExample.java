package sec07.exam01_promotion;


public class PromotionExample {
	
	
	public static void main(String[] args) {
		//-------------------------------//
		// 각각의 타입별로 객체생성
		//-------------------------------//
		B b = new B();	
		C c = new C();
		D d = new D();
		E e = new E();		
		
		//-------------------------------//
		// 다형성-1 실험: 부모타입에는 모든 자식객체 대입가능
		//-------------------------------//
		// A 는 할아버지!!!!
		A a1 = b;	// B 는 아버지, A는 할아버지
		System.out.println("1. A <- B: " + a1);
		
		
		
		A a2 = c;	// C 는 아버지, A는 할아버지
		A a3 = d;	// D 는 나!, A는 할아버지
		A a4 = e;	// E 는 나!, A는 할아버지
		
		B b1 = d;	// D 는 나!, B는 아버지	
		C c1 = e;	// E 는 나!, C는 아버지

		
		// 자식을 일단 껴앉고, 나중에 얼굴을 보았더니 
		// 내 자식이 아니네!?
		//B b3 = e;
		//C c2 = d;
	} // main
	
} // end class

