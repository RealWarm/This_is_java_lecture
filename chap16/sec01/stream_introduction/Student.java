package sec01.stream_introduction;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
public class Student {	
	@Getter private String name;
	private @Getter int score;
	
} // end class
