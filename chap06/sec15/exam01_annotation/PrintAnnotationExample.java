package sec15.exam01_annotation;

import java.lang.reflect.Method;
import java.util.Arrays;


public class PrintAnnotationExample {

	
	public static void main(String[] args) {
		
		//-----------------------------------------//
		// Service Ŭ�����κ��� �޼ҵ� ������ ����		
		//-----------------------------------------//
//		Method[] declaredMethods = 
//				Service.class.getDeclaredMethods();
		
		java.lang.Class clazz = Service.class;
		
		Method[] declaredMethods = 
				clazz.getDeclaredMethods();
		
//		System.out.println(
//				Arrays.toString(declaredMethods)
//			);
		
		//-----------------------------------------//
		
		// Method ��ü�� �ϳ��� ó��
		for(Method method : declaredMethods) {
			
			// PrintAnnotation�� ����Ǿ����� Ȯ��
			if(method.
				isAnnotationPresent(
					PrintAnnotation.class)
				) {
				
				// PrintAnnotation ��ü ���
				PrintAnnotation printAnnotation = 
						method.getAnnotation(
								PrintAnnotation.class
						);
				
				//-----------------------------------//
				
				// �޼ҵ� �̸� ���
				System.out.println(
						"[" + method.getName() + "] "
					);
				
				//-----------------------------------//
				
				//���м� ���
//				for(int i=0; i<printAnnotation.number(); i++) {
//					System.out.print(printAnnotation.value());
//				} // for
//				
//				System.out.println();
				
				//-----------------------------------//
				
				try {
					//�޼ҵ� ȣ��
					method.invoke(new Service());
				} catch (Exception e) {;;}
				
				System.out.println();
				
			} // if
			
		} // enhanced for
		
	} // main
	
} //end class
