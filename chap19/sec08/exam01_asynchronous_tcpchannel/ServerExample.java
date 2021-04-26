package sec08.exam01_asynchronous_tcpchannel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.Executors;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class ServerExample extends Application {
	//------------------------------------------------//
	// �ʵ� ����	
	//------------------------------------------------//
	// 1. ���� ��������� ������ �񵿱� ä�� �׷� ��ü�� ����
	AsynchronousChannelGroup channelGroup;
	
	// 2. �񵿱� ��������ä�� ��ü�� ����
	AsynchronousServerSocketChannel serverSocketChannel;
	
	// 3. Ŭ���̾�Ʈ�κ��� ���� �޽�����, ��� Ŭ���̾�Ʈ�� �߰��ϱ� ���ؼ�,
	//    ����� Ŭ���̾�Ʈ���� ���� ������ Client ��ü�� ��ҷ� �����ϴ� ����Ʈ ��ü ����
	//    List ������ü��, Thread-safe �� Vector ���
	List<Client> connections = new Vector<Client>();
	

	//------------------------------------------------//
	// Server GUI �� 'start' ��ư�� ����������, ȣ��Ǵ� �޼ҵ�	
	//------------------------------------------------//
	
	// ���� ���� �޼ҵ�
	void startServer() {
		
		try {
			//------------------------------------------------//
			// 1. ���� ��������� �񵿱� ä�α׷� ����
			//------------------------------------------------//
			//    ��? ���� �����ϳ���?
			//    - �⺻ �񵿱�ä�α׷���, ������ Ǯ�� ������ Integer.MAX_VALUE
			//      ������ŭ ������ �� �ֵ��� �Ǿ��־�, ���������� ��ϱ� ����
			//    - ���� ��������� �񵿱� ä�α׷��� ������ ��,
			//      �����ڰ� ����, ���� ������Ǯ�� �۾� ������ ������ ���������ϱ� ����
			//------------------------------------------------//
			channelGroup = 
				AsynchronousChannelGroup.
					withFixedThreadPool( // ��������� ������ ������ Ǯ ����
						// ������ ���ļ��� Ȯ���ϱ� ����, ������ ������ Ǯ��
						// �۾������� �ִ� ������, CPU Cores ����ŭ ����
						Runtime.getRuntime().availableProcessors(),
						// �۾������带 �����ϴ� ������ �ϴ�, 
						// ������ ����(ThreadFactory) ��ü �����Ͽ� ����
						Executors.defaultThreadFactory() // �����޼ҵ� ���
					); // withFixedThreadPool

			//------------------------------------------------//
			// 2. �񵿱� ��������ä�� ����
			//------------------------------------------------//
			serverSocketChannel = 
				// ������ �񵿱� ��������ä���� �Ҽӵ� �񵿱� ä�α׷��� 
				// �Ű������� �����Ͽ�, �ҼӼ���
				AsynchronousServerSocketChannel.open(channelGroup);

			//------------------------------------------------//
			// 3. �񵿱� ��������ä���� ���ε� �۾� ����
			//------------------------------------------------//
			serverSocketChannel.bind(new InetSocketAddress(5001));
			
		} catch(Exception e) {
			// try ��Ͽ��� ���ܰ� �߻��ϴ� ���....
			if(serverSocketChannel.isOpen()) { 
				stopServer(); 	// �ڿ��ݳ��ڵ尡 ���ִ� �޼ҵ� ȣ���Ͽ�, ����
			} // if
			
			return;			// �޼ҵ� ��� ����
		} // try-catch

		//------------------------------------------------//
		// JavaFX code
		//------------------------------------------------//
		// Server GUI �޽��� â��, �޽��� ���
		Platform.runLater(()->{				// Lambda Expression
			displayText("[���� ����]");		// ����� �޽��� ǥ��
			
			// ��ư�� �󺧸��� start -> stop���� ����
			btnStartStop.setText("stop");	
		});
		
		// -- ���� ��� startServer() �޼ҵ� �ڵ� �����ϰ� �ִ� ��!
		//    �ƶ��� ���� ������!!


		//------------------------------------------------//
		// 4. ������ �񵿱� ��������ä���� ������ �۾� ���� 
		//    ��, ������ ����
		//------------------------------------------------//
		// ** �߿� ** : ��������ä�ΰ�ü.accept() �޼ҵ��� �Ű������� ����!!!
		serverSocketChannel.
			accept(
				null,		// ù��° �Ű�����: �ʿ�� ÷���� ÷�ΰ�ü ����
				
				// �ι�° �Ű�����: �۾�ó�� �Ϸ�� Callback �� ��ü
				// �͸�����ü �ڵ�������� �ٷ� �����Ͽ�, �Ű������� ����
				new CompletionHandler<AsynchronousSocketChannel, Void>() {
					
					// �۾�ó�� ������, �ڵ�ȣ��� �ݹ� �޼ҵ� ����
					@Override
					public void completed(
						// ù��° �Ű�������, ��ſ� �񵿱� ����ä�� ��ü ����
						AsynchronousSocketChannel socketChannel, 
						// �ι�° �Ű�������, ÷������ ��ü ����
						// ÷�ΰ�ü�� �ʿ������, �Ʒ��� ���� Ÿ���� Void �� ����!!!
						Void attachment 	// Void: ÷���� ��ü ����!!
					) {
						// JavaFX code
						// Server GUI �޼��� â��, �޽��� ���
						try {
							String message = 
								"[���� ����: " + 
								socketChannel.getRemoteAddress()  + 
								": " + 
								Thread.currentThread().getName() + 
								"]";
							
							Platform.runLater(()->displayText(message));
						} catch (IOException e) {;;} // try-catch
						
						// Ŭ���̾�Ʈ �����û�� ������ ������, �����Ǵ� ��ſ�
						// �񵿱� ����ä�ΰ�ü�� �ʵ�� ������ Client ��ü ����
						Client client = new Client(socketChannel);
						
						// �ٷ� ������ ������ Client ��ü�� List�� ��ҷ� ����!!!
						connections.add(client);
						
						// JavaFX code : GUI �޽��� â�� �޽��� ǥ��
						Platform.runLater(()->displayText(
							"[���� ����: " + 
							connections.size() + 
							"]"
						 )
						);
						
						// �񵿱� �������� ä���� ���������, Ŭ���̾�Ʈ �����û���!
						// �׷���, ���� �� �޼ҵ��, �ݹ�޼ҵ��, �۾��������� ó��
						// �� �Ϸ�Ǿ��� ����, �ڵ� ȣ��Ǵ� �޼ҵ忡��, �� �ٽ�???
						// ���������� accept() �޼ҵ�� ��?!!!!, Listen �����??
						serverSocketChannel.accept(null, this);
						
					} // completed
					
					
					// ������Ǯ�� �۾������尡 �۾�ó�� ���н�(���ܹ߻���...)
					// �۾������忡 ȣ��Ǵ� �ݹ� �޼ҵ� ����
					@Override
					public void failed(Throwable exc, Void attachment) {
						// ��������ä�� �ݱ�(�ڿ��ݳ�)
						if(serverSocketChannel.isOpen()) { 
							stopServer(); 
						} // if
					} // failed
					
				}); // �͸�����ü �ڵ��������, Callback ��ü ����
		
	} // startServer
	
	
	//-------------------------------------------------//
	// Server GUI �����쿡��, stop ��ư�� ���� ��쿡 ����Ǵ� �޼ҵ�
	//-------------------------------------------------//
	// �ַ� �ڿ��ݳ� �ڵ���� ������
	//-------------------------------------------------//
	void stopServer() {
		
		try {
			// 1. List ��ü clear ��Ŵ(�ڿ��ݳ�)
			connections.clear();
			
			// 2. �񵿱�ä�α׷� �����ϱ�(by shutdownNow)
			if(channelGroup!=null && !channelGroup.isShutdown()) {
				channelGroup.shutdownNow();
			}
			
			// 3. JavaFX code
			//    GUI �޽��� â��, �޽��� ǥ��
			Platform.runLater(()->{
				displayText("[���� ����]");
				btnStartStop.setText("start");			
			});	
			
		} catch (Exception e) {;;} // try-catch
		
	} // stopServer
	
	
	//------------------------------------------//
	// ���� ������, Ŭ���̾�Ʈ ���� �����ϴ� ��ü�� ����
	// Ŭ���� ���� (��ø Ŭ���� ���)
	// ��κ��� �ֿ������, �� Ŭ���� �ȿ� �ֱ⶧����, �ڵ�����
	// ���� ū ����
	//------------------------------------------//
	class Client {
		//------------------------------------------//
		// �ʵ� �����
		//------------------------------------------//
		// 1. ��ſ� �񵿱� ����ä�� ��ü�� ����
		AsynchronousSocketChannel socketChannel;
		

		//------------------------------------------//
		// 2. ������ ����: �Ű�������, ��ſ� �񵿱� ����ä�� ��ü ����
		//------------------------------------------//
		Client(AsynchronousSocketChannel socketChannel) {
			this.socketChannel = socketChannel;
			
			receive(); // ä���� ����, ������ ���� ����
		} // constructor
		

		//------------------------------------------//
		// 3. ��ſ� ����ä���� ����, ������ ���� ���� �޼ҵ� ����
		//------------------------------------------//
		void receive() {
			// 3-1. 100����Ʈ ũ����, Non-direct ByteBuffer ����
			ByteBuffer byteBuffer = ByteBuffer.allocate(100);
			
			// 3-2. �ʵ忡 ����Ǿ��ִ�, ��ſ� �񵿱� ����ä�η� READ ����
			socketChannel.
				read(
					byteBuffer, 		// ByteBuffer
					byteBuffer, 		// ÷�ΰ�ü�� ���� ����Ʈ���� ����
					
					// �񵿱� ä�ι�Ŀ���, ������ Ǯ�� �۾������尡 task ó��
					// �Ϸ�� ȣ���� �޼ҵ带 ������ Callback ��ü ����
					// : �͸�����ü �ڵ�������� ���� �� ����
					new CompletionHandler<Integer, ByteBuffer>() {						
						
						// �������� �۾�ó�� �Ϸ�� �ڵ����� ȣ��� �ݹ� �޼ҵ�
						@Override
						public void completed(Integer result, ByteBuffer attachment) {
							try {
								String message = "[��û ó��: " + socketChannel.getRemoteAddress() + ": " + Thread.currentThread().getName() + "]";
								Platform.runLater(()->displayText(message));
								
								attachment.flip();
								Charset charset = Charset.forName("utf-8");
								String data = charset.decode(attachment).toString();
				
								for(Client client : connections) {
									client.send(data);
								}
							
								ByteBuffer byteBuffer = ByteBuffer.allocate(100);
								socketChannel.read(byteBuffer, byteBuffer, this);
							} catch(Exception e) {;;} // try-catch
						} // completed
						
						// �۾�ó�� ���� ���ܹ߻���(����), 
						// �ڵ����� ȣ��� �ݹ� �޼ҵ�
						@Override
						public void failed(
							Throwable exc, 			// �߻��� ���ܰ�ü ����
							ByteBuffer attachment 	// ÷�ΰ�ü ����
						) {
							
							try {
								// GUI �޽��� â�� ǥ���� �޽��� ����
								String message = 
									"[Ŭ���̾�Ʈ ��� �ȵ�: " + 
									socketChannel.getRemoteAddress() + 
									": " + 
									Thread.currentThread().getName() + 
									"]";
								
								// JavaFX code: GUI �޽��� â��, �޽��� ���
								Platform.runLater(()->displayText(message));
								
								// List ��ü����, ���� Ŭ���̾�Ʈ ��ü ����
								connections.remove(Client.this);
								
								// ��ſ� �񵿱� ����ä�ΰ�ü ����(�ڿ��ݳ�)
								socketChannel.close();
							} catch (IOException e) {;;} // try-catch
							
						} // failed
						
					}); // �͸�����ü �ڵ�������� ���� �� ����
			
		} // receive
		

		//------------------------------------------//
		// 4. ��ſ� ����ä���� ����, ������ �۽� ���� �޼ҵ� ����
		//------------------------------------------//
		// ������ ���� ���ڿ� �޽�����, 
		// List�� ��ϵ� ��� Ŭ���̾�Ʈ�� �޽��� �߰�
		void send(String data) {
			// String -> ByteBuffer ����ȯ�� ���� Charset ��ü ����
			Charset charset = Charset.forName("utf-8");		
			
			// ����ȯ ����: String -> ByteBuffer
			ByteBuffer byteBuffer = charset.encode(data);
			
			// �񵿱� ����ä���� ����, WRITE �۾� ����
			socketChannel.write(
				byteBuffer, 		// NIO ����
				
				null, 				// attachment : ÷�ΰ�ü ����
				
				// �ݹ鰴ü �����Ͽ� ���� : �͸�����ü���� �ڵ����
				new CompletionHandler<Integer, Void>() {

					// �������� �۾�ó�� �Ϸ�� �ڵ����� ȣ��� �ݹ� �޼ҵ�
					@Override
					public void completed(Integer result, Void attachment) {
						;;
					} // completed

					// �۾�ó�� ���� ���ܹ߻���(����), 
					// �ڵ����� ȣ��� �ݹ� �޼ҵ�
					@Override
					public void failed(Throwable exc, Void attachment) {
						try {
							String message = 
								"[Ŭ���̾�Ʈ ��� �ȵ�: " + 
								socketChannel.getRemoteAddress() + 
								": " + 
								Thread.currentThread().getName() + "]";
							
							// JavaFX code
							Platform.runLater(()->displayText(message));
							
							// List ���� ���޵� Client ��ü ����
							connections.remove(Client.this);
							
							// �񵿱� ����ä�� �ݱ�(�ڿ��ݳ�)
							socketChannel.close();
						} catch (IOException e) {;;}
					} // failed
					
				} // �͸�����ü �ڵ� �������, ��ü ����
				
			);  // write
			
		} // send
		
	} // end class: Client
	
	
	///////////////////////////////////////////	
	// JavaFX code to build a GUI window
	///////////////////////////////////////////	
	TextArea txtDisplay;
	Button btnStartStop;
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();
		root.setPrefSize(500, 300);
		
		txtDisplay = new TextArea();
		txtDisplay.setEditable(false);
		BorderPane.setMargin(txtDisplay, new Insets(0,0,2,0));
		root.setCenter(txtDisplay);
		
		btnStartStop = new Button("start");
		btnStartStop.setPrefHeight(30);
		btnStartStop.setMaxWidth(Double.MAX_VALUE);
		btnStartStop.setOnAction(e->{
			if(btnStartStop.getText().equals("start")) {
				startServer();
			} else if(btnStartStop.getText().equals("stop")){
				stopServer();
			}
		});
		root.setBottom(btnStartStop);
		
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("app.css").toString());
		primaryStage.setScene(scene);
		primaryStage.setTitle("Server");
		primaryStage.setOnCloseRequest(event->stopServer());
		primaryStage.show();
	} // start
	
	void displayText(String text) {
		txtDisplay.appendText(text + "\n");
	} // displayText
	
	
	public static void main(String[] args) {
		launch(args);
	} // main
	
} // end class

