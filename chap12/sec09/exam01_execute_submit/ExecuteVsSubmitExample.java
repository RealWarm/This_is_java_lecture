package sec09.exam01_execute_submit;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;


public class ExecuteVsSubmitExample {
	
	
	public static void main(String[] args) 
		throws Exception {
		
		//----------------------------------------
		// 1. Thread Pool ����(= ExecuterSevice ������ü)
		ExecutorService executorService = 
			// �ʱ�: 0, �ھ�: nThread, �ִ�: nThread
			// ������ ������Ǯ ��ü�� �����Ͽ� ��ȯ
			Executors.newFixedThreadPool(
//				Runtime.getRuntime().availableProcessors()
					2
			);

		//----------------------------------------
		// 2. �� 10���� �ݺ��� ���鼭, �� ���θ���,
		//    ���ο� Task(RunnableŸ������)�� �����
		//    ������ ������ ������Ǯ�� ����(�۾�ó����û)�Ͽ�
		//    ������ Ǯ�� JobQ�� ����
		//	  (ó�� ����= Delegation Pattern)
		for(int i=0; i<10; i++) {
			
			// 3. ���ο� Runnable Ÿ���� Task ����
			//    �͸�����ü �ڵ� ������� ������ü ����
			Runnable newTask = new Runnable() {
				
				// Task�� ������ run() �޼ҵ��� ������
				@Override
				public void run() {
					//-------------------------------
					// 4. ������ ������ Ǯ�� ������ ���
					//    ������ �� ���� �� �۾� ������ �̸� ���
					
					// ***�߿�*** : Executors Ŭ������ ������� ������Ǯ��
					// ���� Ÿ���� �Ʒ��� ����, ThreadPoolExecutor Ŭ������
					// ������ Ǯ�� ������ ���� ���ؼ�, ������ Ÿ�� ��,
					// �θ� ǰ���� ��� �ڱ��� ���� Ÿ������ ����ȯ
					ThreadPoolExecutor threadPoolExecutor = 
						(ThreadPoolExecutor) executorService;
					
					// 4-1. ���� ������ Ǯ �ȿ� ����ִ� �������� ������?
					int poolSize = threadPoolExecutor.getPoolSize();
					
					// 4-2. ���� �Ʒ��ڵ带 �����ϴ� �������� �̸��� ��
					//      �� ������� �ᱹ, ������ Ǯ �ȿ� �ִ� Ư�� ������
					//      �� ��. ��? --> ���� Task�� �����ϴ� ����, Ǯ ��
					//      �� �ִ� Worker Thread �̱� ����.
					String threadName = 
						Thread.currentThread().getName();
					
					// 4-3. ������ Ǯ�� ������, ���� Task�� ó���ϴ� Worker
					//      Thread �� ������ �Բ� ���
					System.out.println(
						"[�� ������ ����: " + 
						poolSize + 
						"] �۾� ������ �̸�: " + 
						threadName
					);
					
					// 5. *****���� ***** : �Ϻη�, ���� �߻� ��Ŵ
					//    NumberFormatException �߻���Ŵ
					int value = Integer.parseInt("��"); 
				} // run
			};
			
			// 6. ������ Ǯ�� JobQ�� ������ ������ Task�� ����
			//    ��, �۾�ó����û ���� (2���� ��� ����)
			
			// 6-1. ù��° �۾�ó����û���(�۾�ó������� ������)
//			executorService.execute(newTask);
			
			// 6-2. �ι�° �۾�ó����û���
			//      (�۾�ó������� �ްų�, �˰���� ��)
			executorService.submit(newTask);
			
			Thread.sleep(10);	// 0.10�� ���� TIMED_WAITING
		} // for
		
		// ������ Ǯ ����
		executorService.shutdown();
		
	} // main
}
