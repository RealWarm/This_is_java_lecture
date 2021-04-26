package sec04.exam02_local_variable;



public class UsingLocalVariable {
	MyFunctionalInterface fi2;
	
	
	
	void method(final int arg) {  //arg는 final 특성을 가짐
		final int localVar = 40; 	//localVar는 final 특성을 가짐
		int localVar2 = 100;
		
//		arg = 31;  		//final 특성 때문에 수정 불가
		//localVar = 41; 	//final 특성 때문에 수정 불가
        
		//----- 람다식 ------------------------//
		MyFunctionalInterface fi= () -> {
			//로컬변수 사용
			System.out.println("arg: " + arg); 
			System.out.println(
				"localVar: " + localVar + "\n");
		}; // 타켓타입의 익명구현객체를 생성
		
		fi2 = fi;
		
		fi.method();
		
		localVar2 = 1000;
	} // method
	
} // end class

