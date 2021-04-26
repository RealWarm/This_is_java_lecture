package sec09.stream_aggregate;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;


public class OptionalExample {
	
	
	public static void main(String[] args) {
		//--------------------------------------//
		// 1. Integer ��ü�� ��ҷ� ������ ����Ʈ ����
		//--------------------------------------//
		List<Integer> list = new ArrayList<>();

		//--------------------------------------//
		// 2. Integer ��ü�� ��ҷ� ������ ����Ʈ ����
		//--------------------------------------//
		// ����Ʈ�� ��Ұ� �ϳ��� ���� ���¿���, ��Ʈ��
		// ���������� �����Ǹ�, ��� �ɱ�???? (*�߿�*)
		// ���� �߻�(java.util.NoSuchElementException)
/*		double avg = 
			list.
				stream().
				mapToInt(Integer :: intValue).
				average().	
				getAsDouble();*/
		
//		System.exit(0);

		//--------------------------------------//
		// 3. �� 2�� ������ �ذ��ϴ� ��� #1
		//--------------------------------------//
		// ��Ʈ�������������� ����ó������� ��-��� ��ü
		// (��, OptionalXXX ��ü)�� ����.
		// �� ��-��� ��ü�� �޼ҵ带 �̿��Ͽ�, �پ��� ��쿡
		// ����
/*		OptionalDouble optional = 
			list.
				stream().
				mapToInt(
//						Integer :: intValue
						
						Integer::intValue
				).
				average();
		
		// 3-1. ����ó������� �ֽ��ϱ�??
		if(optional.isPresent()) {
			System.out.println(
				"���1_���: " + 
				optional.getAsDouble()
			);
		} else {
			System.out.println("���1_���: 0.0");
		} // if-else
		System.exit(0);*/
		
		//--------------------------------------//
		// 4. �� 2�� ������ �ذ��ϴ� ��� #2
		//--------------------------------------//
		// ��Ʈ�������������� ����ó������� ��-��� ��ü
		// (��, OptionalXXX ��ü)�� ����.
		// �� ��-��� ��ü�� �޼ҵ带 �̿��Ͽ�, �پ��� ��쿡
		// ����
/*		double avg2 = 
			list.
				stream().
				mapToInt(Integer :: intValue).
				average().
				orElse(100); // ����ó������ ������, 
							 // ������ �⺻�� ��ȯ
		
		System.out.println("���2_���: " + avg2);
		System.exit(0);*/
		
		//--------------------------------------//
		// 5. �� 2�� ������ �ذ��ϴ� ��� #3
		//--------------------------------------//
		// ��Ʈ�������������� ����ó������� ��-��� ��ü
		// (��, OptionalXXX ��ü)�� ����.
		// �� ��-��� ��ü�� �޼ҵ带 �̿��Ͽ�, �پ��� ��쿡
		// ����
		list.add(1);
		
		list.
			stream().
			mapToInt(Integer :: intValue).
			average().
			ifPresent(
				a -> System.out.println(
						"���3_���: " + a
					)
			);
		
	} // main
	
} // end class
