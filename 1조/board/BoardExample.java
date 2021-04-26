
                                                               
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.Vector;


public class BoardExample {
	

	public static void main(String[] args) {
		
		Vector<Board> board = new Vector<Board>();              // vector는 길이조절이 자유자재로 가능하고, 객체의 저장이 가능한 배열
		                                                        // 클래스도 타입이 될 수 있으므로 board를 타입으로 넣어줌.
		Scanner sc = new Scanner(System.in);                    // scanner라는 클래스를 사용하여 사용자의 입력값을 받을 수 있게 함.  
		
		String subject;
		String content;
		String writer;
		
		Date date = Calendar.getInstance().getTime();            // Calendar와 SimpleDateFormat 클래스를 사용하여 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");// 날짜를 받아오고 날짜의 형식을 정할 수 있다.
		String strDate = dateFormat.format(date);

		/* 데이터 추가 */
		board.add(new Board("Subject", "Content", "Writer", "Date"));    // 반환되서 생성된 객체가 vectoer의 내장함수인 add를 통해서 벡터로 들어감.
		board.add(new Board("Hello", "Hello Java", "AA123", "2019-08-04"));  // 게시판의 목록과 추가, 수정, 삭제의 기능을 보기 위해 임의로 게시글을 넣어줌
		board.add(new Board("Hey guys", "First posting!!!!", "d__j789", "2019-08-05"));
		board.add(new Board("this is board", "hihihihihihihi", "abcd123", "2019-08-05"));

		while (true) {                                                       // whileloop를 사용하여 게시판 내용이 순서대로 출력되게 하고, 
			System.out.println("----------------------------------------");
			System.out.println("무엇을 도와드릴까요?");
			System.out.println("1. 추가");
			System.out.println("2. 수정");
			System.out.println("3. 삭제");
			System.out.println("4. 테이블 전체 보기");
			System.out.println("나가시려면 exit를 입력해주세요.");
			System.out.println("----------------------------------------");

			String input = sc.nextLine();                                     // 스캐너의 nextLine메소드를 사용하여 추가나 수정을 할 수 있게 함.
			String num;
			
			switch (input) {                                                  // switch문을 사용하여 게시판의 추가,수정,삭제 ,테이블 전체보기를 선택할 수있게 함. 
			
			case "1":
				
				System.out.println("추가하기를 선택하셨습니다.");               // 한 줄에 입력된 값이 공백을 포함하여 하나의 입력값으로 인식할 수 있게 함.
				System.out.println("제목을 입력해주세요.");
				subject = sc.nextLine();
				System.out.println("내용을 입력해주세요.");
				content = sc.nextLine();
				System.out.println("이름을 입력해주세요.");
				writer = sc.nextLine();
				board.add(new Board(subject, content, writer, strDate));
				System.out.println("데이터 추가 완료되었습니다.\n");

				break;

			case "2":
				
				System.out.println("수정하기를 선택하셨습니다.");
				System.out.println("몇번째 게시물을 수정하시겠습니까?");
				
				num = sc.nextLine();
				
				if (Integer.parseInt(num) >= board.size() || Integer.parseInt(num) == 0) {       // board에는 문자열이 들어오므로, 보드의 사이즈와 비교하기 위해 integer을 사용하여 문자열로 들어온 숫자를 형변환 시켜줌.
					System.out.println(num + "번째 게시물이 존재하지 않습니다.");                   // 들어온 입력값을 비교하여 board사이즈를 넘어서거나 0보다 작거나 같은 값일 경우 메시지 호출
				} else {
					System.out.println(Integer.parseInt(num) + "번째 게시물 수정");
					
					System.out.println("제목을 입력해주세요");
					subject = sc.nextLine();
					
					System.out.println("내용을 입력해주세요.");
					content = sc.nextLine();
					
					System.out.println("이름을 입력해주세요.");
					writer = sc.nextLine();
					
					board.setElementAt(new Board(subject, content, writer, strDate), Integer.parseInt(num)); // 저장된 객체를 반환해주는 역할을 해주는 vector의 setElementAt 메소드를 이용해서 새로 입력된 값으로 수정해줌
					System.out.println("데이터 수정이 완료되었습니다.\n");                                     
				} // if-else

				break;

			case "3":

				if (board.size()== 1) { 
					System.out.println("더 이상 삭제할 게시물이 없습니다.");                          // 게시글이 모두 삭제 되면 목록만 남게 되므로 번호를 입력하면 삭제할 게시글이 없다는 출력이 나오게 됨.
					break;
				} else {
					System.out.println("삭제하기를 선택하셨습니다.");
				} // if-else
				
				System.out.println("몇번째 게시물을 삭제하시겠습니까?");
				num = sc.nextLine();
				
				if (Integer.parseInt(num) >= board.size() || Integer.parseInt(num) == 0) {           
					System.out.println(num + "번째 게시물이 존재하지 않습니다.");
				} else {
					board.remove(Integer.parseInt(num));
					System.out.println(num + "번째 게시물 삭제가 완료되었습니다.\n");
				} // if-else

				break;

			case "4":
				
				for (Board i : board) {                                                           // enhanced forloop를 사용하여 게시판을 다 보여줌.
					if (board.indexOf(i) == 0) {                                                  // 게시판의 목록과 게시글 부분을 구분해서 넣어줌.
						System.out.printf("%-10s %-20s %-20s %-15s %-10s\n", "Number", i.subject, i.content, i.writer,
								i.date);
					} else {
						System.out.printf("%-10s %-20s %-20s %-15s %-10s\n", board.indexOf(i), i.subject, i.content,
								i.writer, i.date);
					} // if-else

				} // for
				
				System.out.println();
				break;

			case "exit":
				System.out.println("프로그램을 종료합니다.\n");
				System.exit(0);                                                                  // 사용자가 exit를 입력하면 프로그램은 종료되고,
			default:
				System.out.println("잘못 입력하셨습니다\n");                                      // 다른 숫자를 입력하면 잘 못 입력했다는 메시지와 함께 처음으로 돌아감.
				break;
			} // switch

		} // while

	} // main

} // end class

 