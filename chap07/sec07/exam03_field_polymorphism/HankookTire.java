package sec07.exam03_field_polymorphism;


public class HankookTire extends Tire {
	//�ʵ�
	
	
	//������
	public HankookTire(
			String location,	// Ÿ�̾� ��ġ 
			int maxRotation		// �ִ�ȸ����(Ÿ�̾����)
		) {
		// �θ� ��ü�� ������ȣ�� ->�θ�ü �ʱ�ȭ ����
		// �ݵ�� ù ���ο� ���;� ��!!
		super(location, maxRotation);
	} // constructor
	
	//�޼ҵ� �������̵�(!!!!)
	@Override
	public boolean roll() {
		++accumulatedRotation; // ����ȸ���� 1����
		
		if(accumulatedRotation < maxRotation) { 
			// ���� Ÿ�̾� ����(��,�ִ�ȸ������ �̵���)��
			// ����������
			System.out.println(
					location + 
					" HankookTire ����: " + 
					(maxRotation-accumulatedRotation) + 
					"ȸ"
				);
			
			return true; // ���� �ִ���� �̵��� �ǹ�
		} else { // Ÿ�̾� ����(��, �ִ�ȸ���� ����)��
			     // ���ϸ�,��ũ�߻� --> ��ü�ʿ�
			System.out.println(
					"*** " + 
					location + 
					" HankookTire ��ũ ***"
				);
			
			return false; // Ÿ�̾� �ִ���� ����(��ũ)�ǹ�
		} // if-else
		
	} //main
	
} // end class
