package sec05.stream_mapping;

import java.util.Arrays;
import java.util.stream.IntStream;


public class AsDoubleStreamAndBoxedExample {
	
	
	public static void main(String[] args) {
		//----------------------------------------------//
		// 1. ������ ��ҷ� ������ �迭 ��ü ����
		//----------------------------------------------//
		// ���� �������, �迭���ͷ� ��ü ����
		int[] intArray = { 1, 2, 3, 4, 5};

		
		//----------------------------------------------//
		// 2. ��Ʈ�� ���������� ���� #1
		//----------------------------------------------//
		// 2-1. �迭��ü�κ���, ��Ʈ�� ����
		IntStream intStream = Arrays.stream(intArray);
		
		// 2-2. ��Ʈ�� ���������� ����
		intStream.
			asDoubleStream(). // �߰�ó��:doubleŸ������ ��ȯ
			// ����ó��: ��� ��� ��ȸ �� ���ٽ� ����(�ܼ����)
			forEach( d -> System.out.println(d) );
			
		System.out.println();

		//----------------------------------------------//
		// 3. ��Ʈ�� ���������� ���� #2
		//----------------------------------------------//
		// 3-1. �����迭��ü�κ��� ��Ʈ�� ����
		intStream = Arrays.stream(intArray);
		
		// 3-2. ��Ʈ�� ���������� ����
		intStream
			.boxed()	// �߰�ó��: Auto-Boxing ����
			// ����ó��: ��� ��� ��ȸ �� ���ٽ� ����(�ܼ����)
			.forEach(
				// �Ʒ��� ���ٽ���, �޼ҵ� �����κ�ȯ�Ұ�
				// ��? �Ű������� ������ ���ԵǾ�����
				obj -> System.out.println( obj.intValue() )
			);
	} // main
	
} // end class
