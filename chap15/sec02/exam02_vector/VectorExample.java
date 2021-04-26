package sec02.exam02_vector;

import java.util.List;
import java.util.Vector;


public class VectorExample {
	
	
	// 대전제:
	//   1) List 컬렉션은, 순서를 유지
	//	 2) 중복저장을 허용
	public static void main(String[] args) {
		// Vector 자료구조는, 스레드 동기화가 되어있어
		// 다중 스레드 환경하에서, Thread-Safe 하다!!!
		// 단, 성능에 단점을 가진다!!!
		List<Board> list = new Vector<>();
		
		// Vector의 내부구조는, ArrayList에 기반한다!!!
	
		list.add(new Board("제목1", "내용1", "글쓴이1"));
		list.add(new Board("제목2", "내용2", "글쓴이2"));
		list.add(new Board("제목3", "내용3", "글쓴이3"));
		list.add(new Board("제목4", "내용4", "글쓴이4"));
		list.add(new Board("제목5", "내용5", "글쓴이5"));
		
		list.remove(2);
		list.remove(3);
		
//		for(int i=0; i<list.size(); i++) {
//			Board board = list.get(i);
//		
//			System.out.println(
//				board.subject + 
//				"\t" + 
//				board.content + 
//				"\t" + 
//				board.writer);
//		} // for
		
		for(Board board : list) {
			System.out.println(
				board.subject + 
				"\t" + 
				board.content + 
				"\t" + 
				board.writer);
		} // enhanced for
		
		
		
	} // main
	
} // end class

