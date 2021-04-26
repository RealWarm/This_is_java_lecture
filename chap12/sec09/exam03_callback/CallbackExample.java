package sec09.exam03_callback;

import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class CallbackExample {
	// 스레드 풀 참조 저장 필드
	private ExecutorService executorService;
	

	public CallbackExample() {
		
		// 새로운 스레드 풀 생성
		// (최대갯수는 장비의 코어갯수만큼) -> 병렬성 확보
		executorService = 
			Executors.newFixedThreadPool(
					Runtime.
						getRuntime().
						availableProcessors()
				);
		
	} // constructor
	
	
	// 작업처리결과를 Non-blocking 방식(즉, Callback 방식)
	// 으로 받을 Callback 객체 생성하여 필드에 저장
	private CompletionHandler<Integer, Void> callback =
		// 익명구현객체코딩 기법으로 Callback 객체 생성
		new CompletionHandler<Integer, Void>() {
		
			// Task가 성공적으로 처리될 때, 
			// 자동 Callback되는 메소드
			@Override
			public void completed(
				// Void 타입은, void 키워드와 같은 의미임
				Integer result, Void attachment) {
				System.out.println(
					"completed() 실행: " + result);
			} // completed
		
			// Task 처리중 예외가 발생될 때, 
			// 자동 Callback되는 메소드
			@Override
			public void failed(
				// Void 타입은, void 키워드와 같은 의미임
				Throwable exc, Void attachment) {
				System.out.println(
					"failed() 실행: " + exc.toString());
			} // failed
			
		}; // Callback 객체 구현 끝 (익명구현객체기법으로)
	
	
	// 실제 처리할 Task를 생성하고, 작업요청하는 메소드
	public void doWork(final String x, final String y) {
		// 새로운 Runnable 타입의 Task를, 
		// 익명구현객체기법으로 생성
		Runnable task = new Runnable() {
			
			// 실제 Task의 수행로직
			@Override
			public void run() {
				
				try {
					int intX = Integer.parseInt(x);
					int intY = Integer.parseInt(y);
					
					int result = intX + intY;
					
					// Task 처리결과를, 미리 준비된 
					// Callback 객체의 지정된 Callback
					// 메소드를 호출하여, 처리결과 반환
					callback.completed(result, null);
					
				} catch(NumberFormatException e) {
					
					// Task 처리도중 오류가 발생하면, 
					// 미리 준비된 Callback 객체의 
					// 지정된 Callback 메소드를 호출하여, 
					// 처리결과 반환
					callback.failed(e, null);
					
				} // try-catch
				
			} // run
			
		}; // Task 생성완료
		
		// 스레드 풀에 작업처리요청(put the task into jobQ)
		executorService.submit(task); // submit 방식으로
		
	} // doWork
	
	
	// 다 사용한 스레드 풀 종료 메소드
	public void finish() {
		// 스레드 풀 종료 및 파괴(자원반납)
		executorService.shutdown();
	} // finish
	
	
	public static void main(String[] args) {
		// Callback 방식으로 Task 처리결과를 받을
		// Callback 객체 생성.
		CallbackExample example = new CallbackExample();
		
		// 새로운 Task를 생성하고, 스레드 풀에 작업처리요청
		// 하는 메소드 호출 #1
		example.doWork("3", "3");	// 호출 #1: 정상처리
		example.doWork("3", "삼");	// 호출 #2: 예외발생
		
		example.finish();			// 스레드 풀 종료
	} // main
	
} // end class
