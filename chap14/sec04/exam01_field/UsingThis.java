package sec04.exam01_field;


class A { ;; }
class B { ;; }


public class UsingThis {	
	public int outterField = 10;
	
	
	public void instanceMethod() {
		int age = 44;		// �������� (local varible)
			
		class LocalClass {  // ����Ŭ����(local class)
			;;
		} // end class: LocalClass
		
	} // instanceMethod

	//-----------------------------------//
	// ��ø Ŭ���� ����(Nested Class)
	//-----------------------------------//
	class Inner {
		int innerField = 20;

		
		void method() {
			
			//-- ���ٽ� ���� -----------------------//
			MyFunctionalInterface fi = () -> {	
				
				//----------------------//
				
				System.out.println(
					"****** this: " + this);
				
				//----------------------//
				
				System.out.println(
					"****** UsingThis.this: " + 
					UsingThis.this);
				
				//----------------------//
				
				System.out.println(
					"outterField: " + 
					outterField);
				
				/**** ���� ****/
				System.out.println(
					"outterField: " + 
					UsingThis.this.outterField + 
					"\n");
				
				//----------------------//
				
				System.out.println(
					"innerField: " + 
					innerField);
				
				System.out.println(
					"innerField: " + 
					this.innerField + 
					"\n");
			}; // ���ٽĿ� ����, �͸�����ü ����
			//-- ���ٽ� �� -----------------------//
			
			fi.method(); // �߻�޼ҵ� ȣ��
			
		} // method
		
	} // end class: Inner
	
} // end class: UsingThis

