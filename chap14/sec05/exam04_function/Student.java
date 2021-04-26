package sec05.exam04_function;


public class Student {
	private String name;		// �л��� �̸�
	private int englishScore;	// �л��� ��������
	private int mathScore;		// �л��� ��������
	
	
	public Student(
		String name, 
		int englishScore, 
		int mathScore) {
		
		this.name = name;
		this.englishScore = englishScore;
		this.mathScore = mathScore;
		
	} // ������

	public String getName() { 
		return name; 
	} // getName
	
	public int getEnglishScore() { 
		return englishScore; 
	} // getEnglishScore
	
	public int getMathScore() { 
		return mathScore; 
	} // getMathScore
	
} // end class
