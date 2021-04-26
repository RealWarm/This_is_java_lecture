package sec09.exam03_callback;

import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class CallbackExample {
	// ������ Ǯ ���� ���� �ʵ�
	private ExecutorService executorService;
	

	public CallbackExample() {
		
		// ���ο� ������ Ǯ ����
		// (�ִ밹���� ����� �ھ����ŭ) -> ���ļ� Ȯ��
		executorService = 
			Executors.newFixedThreadPool(
					Runtime.
						getRuntime().
						availableProcessors()
				);
		
	} // constructor
	
	
	// �۾�ó������� Non-blocking ���(��, Callback ���)
	// ���� ���� Callback ��ü �����Ͽ� �ʵ忡 ����
	private CompletionHandler<Integer, Void> callback =
		// �͸�����ü�ڵ� ������� Callback ��ü ����
		new CompletionHandler<Integer, Void>() {
		
			// Task�� ���������� ó���� ��, 
			// �ڵ� Callback�Ǵ� �޼ҵ�
			@Override
			public void completed(
				// Void Ÿ����, void Ű����� ���� �ǹ���
				Integer result, Void attachment) {
				System.out.println(
					"completed() ����: " + result);
			} // completed
		
			// Task ó���� ���ܰ� �߻��� ��, 
			// �ڵ� Callback�Ǵ� �޼ҵ�
			@Override
			public void failed(
				// Void Ÿ����, void Ű����� ���� �ǹ���
				Throwable exc, Void attachment) {
				System.out.println(
					"failed() ����: " + exc.toString());
			} // failed
			
		}; // Callback ��ü ���� �� (�͸�����ü�������)
	
	
	// ���� ó���� Task�� �����ϰ�, �۾���û�ϴ� �޼ҵ�
	public void doWork(final String x, final String y) {
		// ���ο� Runnable Ÿ���� Task��, 
		// �͸�����ü������� ����
		Runnable task = new Runnable() {
			
			// ���� Task�� �������
			@Override
			public void run() {
				
				try {
					int intX = Integer.parseInt(x);
					int intY = Integer.parseInt(y);
					
					int result = intX + intY;
					
					// Task ó�������, �̸� �غ�� 
					// Callback ��ü�� ������ Callback
					// �޼ҵ带 ȣ���Ͽ�, ó����� ��ȯ
					callback.completed(result, null);
					
				} catch(NumberFormatException e) {
					
					// Task ó������ ������ �߻��ϸ�, 
					// �̸� �غ�� Callback ��ü�� 
					// ������ Callback �޼ҵ带 ȣ���Ͽ�, 
					// ó����� ��ȯ
					callback.failed(e, null);
					
				} // try-catch
				
			} // run
			
		}; // Task �����Ϸ�
		
		// ������ Ǯ�� �۾�ó����û(put the task into jobQ)
		executorService.submit(task); // submit �������
		
	} // doWork
	
	
	// �� ����� ������ Ǯ ���� �޼ҵ�
	public void finish() {
		// ������ Ǯ ���� �� �ı�(�ڿ��ݳ�)
		executorService.shutdown();
	} // finish
	
	
	public static void main(String[] args) {
		// Callback ������� Task ó������� ����
		// Callback ��ü ����.
		CallbackExample example = new CallbackExample();
		
		// ���ο� Task�� �����ϰ�, ������ Ǯ�� �۾�ó����û
		// �ϴ� �޼ҵ� ȣ�� #1
		example.doWork("3", "3");	// ȣ�� #1: ����ó��
		example.doWork("3", "��");	// ȣ�� #2: ���ܹ߻�
		
		example.finish();			// ������ Ǯ ����
	} // main
	
} // end class
