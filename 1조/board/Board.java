                                                                                 

public class Board {                                         // 클래스를 만들어서 필드를 선언함.
	
	String subject;
	String content;
	String writer;
	String date;

	public Board(String subject, String content, String writer, String date) {   
		this.subject = subject;                               // 객체가 만들어질 때는 필드를 초기화해야 하므로 각 필드에 맞는 매개변수 값들을 받아야 함. 
		this.content = content;                               // 매개변수를 받아서 그 값들을 초기화 함
		this.writer = writer;
		this.date = date;
	} // cosntructor

} // end class
