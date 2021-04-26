package sec05.exam04_function;


public class Student {
	private String name;		// 학생의 이름
	private int englishScore;	// 학생의 영어점수
	private int mathScore;		// 학생의 수학점수
	
	
	public Student(
		String name, 
		int englishScore, 
		int mathScore) {
		
		this.name = name;
		this.englishScore = englishScore;
		this.mathScore = mathScore;
		
	} // 생성자

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
