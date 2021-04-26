package sec09.exam01_execute_submit;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;


public class ExecuteVsSubmitExample {
	
	
	public static void main(String[] args) 
		throws Exception {
		
		//----------------------------------------
		// 1. Thread Pool 생성(= ExecuterSevice 구현객체)
		ExecutorService executorService = 
			// 초기: 0, 코어: nThread, 최대: nThread
			// 형태의 스레드풀 객체를 생성하여 반환
			Executors.newFixedThreadPool(
//				Runtime.getRuntime().availableProcessors()
					2
			);

		//----------------------------------------
		// 2. 총 10번의 반복을 돌면서, 각 루핑마다,
		//    새로운 Task(Runnable타입으로)를 만들어
		//    위에서 생성한 스레드풀에 제출(작업처리요청)하여
		//    스레드 풀의 JobQ에 넣음
		//	  (처리 위임= Delegation Pattern)
		for(int i=0; i<10; i++) {
			
			// 3. 새로운 Runnable 타입의 Task 생성
			//    익명구현객체 코딩 기법으로 구현객체 생성
			Runnable newTask = new Runnable() {
				
				// Task의 내용은 run() 메소드의 로직임
				@Override
				public void run() {
					//-------------------------------
					// 4. 생성된 스레드 풀의 정보를 출력
					//    스레드 총 개수 및 작업 스레드 이름 출력
					
					// ***중요*** : Executors 클래스가 만들어준 스레드풀의
					// 실제 타입은 아래와 같이, ThreadPoolExecutor 클래스임
					// 스레드 풀의 정보를 얻어내기 위해서, 원래의 타입 즉,
					// 부모 품에서 벗어난 자기의 원래 타입으로 형변환
					ThreadPoolExecutor threadPoolExecutor = 
						(ThreadPoolExecutor) executorService;
					
					// 4-1. 현재 스레드 풀 안에 들어있는 스레드의 갯수는?
					int poolSize = threadPoolExecutor.getPoolSize();
					
					// 4-2. 현재 아래코드를 수행하는 스레드의 이름을 얻어냄
					//      이 스레드는 결국, 스레드 풀 안에 있는 특정 스레드
					//      가 됨. 왜? --> 현재 Task를 수행하는 것은, 풀 안
					//      에 있는 Worker Thread 이기 때문.
					String threadName = 
						Thread.currentThread().getName();
					
					// 4-3. 스레드 풀의 정보와, 현재 Task를 처리하는 Worker
					//      Thread 의 정보를 함께 출력
					System.out.println(
						"[총 스레드 개수: " + 
						poolSize + 
						"] 작업 스레드 이름: " + 
						threadName
					);
					
					// 5. *****주의 ***** : 일부러, 예외 발생 시킴
					//    NumberFormatException 발생시킴
					int value = Integer.parseInt("삼"); 
				} // run
			};
			
			// 6. 스레드 풀의 JobQ에 위에서 생성한 Task를 넣음
			//    즉, 작업처리요청 수행 (2가지 방법 수행)
			
			// 6-1. 첫번째 작업처리요청방식(작업처리결과가 없을때)
//			executorService.execute(newTask);
			
			// 6-2. 두번째 작업처리요청방식
			//      (작업처리결과를 받거나, 알고싶을 때)
			executorService.submit(newTask);
			
			Thread.sleep(10);	// 0.10초 동안 TIMED_WAITING
		} // for
		
		// 스레드 풀 종료
		executorService.shutdown();
		
	} // main
}
