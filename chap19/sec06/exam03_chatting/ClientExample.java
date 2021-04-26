package sec06.exam03_chatting;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class ClientExample 
	extends Application {
	
	// 1. ��ſ� ����ä�ΰ�ü�� ������ �ʵ�
	SocketChannel socketChannel;
	
	
	// Client GUI Window ����, start ��ư�� ������ ���� ȣ��� �޼ҵ�
	void startClient() {
		
		// ���� User Thread ��ü ����(��?... ���Ϸ���???)
		// ForkJoin Thread Pool�� �� ������� ����????
		Thread thread = new Thread() {
			
			// �����尡 ������ ������ ������ �ִ� �޼ҵ�
			// �̹� Thread Ŭ���� �ȿ�, run() �޼ҵ尡 �⺻ �����Ǿ�������,
			// ���� ������ �ƹ��͵� ����!!!(�ϴ°� ���ٴ� ������)
			@Override
			public void run() {
				
				try {
					// ��ſ� ����ä�ΰ�ü ���� by static method: open()
					socketChannel = SocketChannel.open();
					
					// ������ ����ä���� ����¹���� Blocking ���� ����
					socketChannel.configureBlocking(true);
					
					// ��ſ� ����ä�ΰ�ü�� connect() �޼ҵ带 �̿��Ͽ�,
					// ������ ��������ä�ΰ�ü��, �����û�� ����� �۽�
					socketChannel.connect(
							new InetSocketAddress(
								"localhost",		// ������ ������ IP�ּ� ���� 
								5001				// ������ ������ Listen Port ����
							)
						); // connect
					
					// JavaFX code: GUI �޽��� â�� �Ʒ� �޽��� ���
					// ������ �����Ǿ����� ǥ��.
					Platform.runLater(()->{
						
						try {
							// GUI �޽��� â��, ����� ǥ��!!??? (����)
							displayText(
								"[���� �Ϸ�: "  + 
								socketChannel.getRemoteAddress() + 
								"]"
							);
							
							// ��ư�� �󺧸���, start -> stop ���� ����
							btnConn.setText("stop");
							
							// �޽��� ���� ��ư��, enable ���·� ����
							btnSend.setDisable(false);
						} catch (Exception e) {;;}
						
					}); // runLater.
					
				} catch(Exception e) {
					// ��ſ� ����ä���� ����, ��������ä�ΰ��� ����õ���,
					// ���ܰ� �߻��ϴ� ���, �Ʒ����� ó��.
					
					// GUI �޽��� â�� �޼��� ǥ��.
					Platform.runLater(()->displayText("[���� ��� �ȵ�]"));
					
					// *** �߿� *** : ������ ��ſ� ����ä�ΰ�ü �ݱ�!!!
					if(socketChannel.isOpen()) { 
						stopClient(); 
					} // if
					
					return;		// run() �޼ҵ� ��� ���� --> ��, ������ �����Ŵ
				} // try-catch
				
				// �������� �����û�� ���������� �̷��������, 
				// �ٷ�, ������ ���� �õ�!!!!
				receive();
				
			} //run
			
		}; // �͸��ڽİ�ü �ڵ��������, Thread ��ü ����
		
		// ������ ������ ������ ��ü�� ����, User ������ ������Ŵ
		// ������ ����: NEW -> RUNNABLE <-> RUNNING / SUSPEND -> TERMINATED
		thread.start();
	} // startClient    : GUI â����, 'start' ��ư�� ������ ����, ȣ��� �޼ҵ� ����.
	
	
	// Client GUI â����, 'stop' ��ư�� ������ ����, ȣ��� �޼ҵ� ����.
	// �ַ� �ϴ� ������ ���� �ڿ��ݳ� ó����.
	void stopClient() {
		
		try {
			// JavaFX code: GUI �޽��� â��, ���� ���� ���� �޽��� ���
			Platform.runLater(()->{
				displayText("[���� ����]");		// �޽��� ���
				
				btnConn.setText("start");		// stop ��ư�� �󺧸� -> start�� ����
				btnSend.setDisable(true);		// �޽��� �۽� ��ư ��Ȱ��ȭ ó��
			}); // runLater
			
			// ����� ����, ��ſ� ����ä�� ��ü �ڿ��ݳ�.
			if(socketChannel!=null && socketChannel.isOpen()) {
				socketChannel.close();	// ä�� �ݱ�.
			} // if
			
		} catch (IOException e) {;;} // try-catch
		
	} // stopClient
	
	
	// �� �޼ҵ��, ��Ȯ����, �޽����� �߰��ϴ� �����κ���, �޽����� �����ϱ� ����
	// �뵵�� ������ �����ϴ� �޼ҵ�.
	void receive() {
		
		// �� ������ ������!. �޽��� ���� ����, ���� �����κ���, �޽����� �� �� �𸣱� ������
		// ���ŷ �ǰ���?.. �׷���, �� �޽��� ���� task ����, ���ѷ����� ���鼭, ������
		// ���� �޽����� ����ó���ؾ� �մϴ�.
		while(true) {	// ���ѷ��� ����
			
			try {
				// �޽��� ���� �� READ ������ ����, NIO ByteBuffer ��ü ����
				// ũ��� 100 ����Ʈ. (Non-direct Buffer �� ����)
				ByteBuffer byteBuffer = ByteBuffer.allocate(100);
				
				// ��ſ� ����ä�� ��ü�� read(ByteBuffer) �޼ҵ带 �����Ͽ�,
				// ����� ä���� ����, �����Ͱ� ���� ������ ��ٸ�(��, ���ŷ��!)
				// ä���� read(buffer) �޼ҵ�� �Ʒ��� ���� 3���� ��쿡 ���ŷ ���¿���
				// Ǯ��:
				// 		1) ������ ������������ �������� ��� IOException �߻�
				//		2) ����� �����(�츮���� ����, ������ ��ſ� ����ä�� ��ü)��
				//         ä���� ��������(��, ��������� ä��.close() ȣ���� ���)�Ǹ�,
				//         -1 (EOF) ��ȯ
				//      3) ����� �����(�츮���� ����, ������ ��ſ� ����ä�� ��ü)����
				//         ���������� �޽����� ���� ���(�̶���, ���� ������ ����Ʈ ���� ��ȯ)
				int readByteCount = socketChannel.read(byteBuffer);
				
				
				// 2) ������ ���������� Socket�� close()�� ȣ������ ���: -1 (EOF) ��ȯ
				if(readByteCount == -1) {
					// IOException ���ܸ� ���� �����Ͽ� throw (���ܹ߻�) ��Ŵ
					throw new IOException();
				} // if
				
				// ä��.read() �� ���������� �����͸� ������ �� �޴ٸ�....
				// ByteBuffer.flip() �޼ҵ� ȣ���, �б� ���� ����
				byteBuffer.flip();
				
				// �����(��Ȯ����, ������ ���� ���ڿ� �޽���)�� �����͸� ������ ������(���ڿ�)
				// �� ����ȯ ����. ��, ByteBuffer -> CharBuffer -> String ����ȯ.
				
				// ����ȯ�� ����, Charset ��ü ����(�̶�, �����ڰ� ������ ���ڼ�����...)
				Charset charset = Charset.forName("UTF-8");
				
				// ����ȯ ���� by using Charset ��ü�� decode()�޼ҵ�
				// : ByteBuffer > CharBuffer > String(by .toString()) ����ȯ ����
				// ������ ���� ���ڿ� �޽��� ���� �Ϸ�
				String data = charset.decode(byteBuffer).toString();
				
				// JavaFX code:
				// Client GUI �޽��� â��, �����κ��� ����, �߰� �޽��� ǥ��
				Platform.runLater(()->displayText("[�ޱ� �Ϸ�] "  + data));
				
			} catch (Exception e) {
				// ������ ���� �õ���, ���� ���ܰ� �߻��Ѵٸ�.......
				
				// Client GUI �޽��� â�� �Ʒ� �޼��� ǥ��.
				Platform.runLater(()->displayText("[���� ��� �ȵ�]"));
				
				// �ڿ��ݳ��ڵ尡 ���ִ� �޼ҵ� �����Ͽ�, 
				// ��ſ� ����ä�ΰ�ü �ݱ�
				stopClient();
				
				// ���̻� ����� �����(��, ������ ��ſ� ����ä��)���� �����
				// �Ұ�������, ���ѷ����� ��������(Ż���ڵ�)
				break;		// Ż��
			} // try-catch
			
		} // while : ���ѷ������� ����������, �����κ����� �߰� �޽��� ���ſ��� ����
		
	} // receive
	
	
	// ����� �����(��, ������ ��ſ� ����ä�ΰ�ü)���� �޽����� �۽��ϴ� �޼ҵ�
	void send(String data) {
		
		// �� ���� ����, ������ User �����带 �����Ͽ�, ������ Worker Thread��
		// ó���ϵ��� ��
		Thread thread = new Thread() {
			
			
			@Override
			public void run() {
				
				try {
					// ������ �� Task��, ������ �޽����� ������ ������!?
					// �� ������ �°� �ڵ��� �����մϴ�.
					
					// String �޽����� ByteBuffer�� ����ȯ ����.
					// ��, String -> Charset ���� -> ByteBuffer �� ����ȯ ����
					
					// 1. ����ȯ�� ����, Charset ��ü ����
					Charset charset = Charset.forName("UTF-8");
					
					// 2. Charset ��ü�� encode(data) ����ȯ �޼ҵ� ����
					//    String -> ByteBuffer ��ü�� ��ȯ.
					ByteBuffer byteBuffer = charset.encode(data);
					
					// 3. ��ſ� ����ä�� ��ü�� write(ByteBuffer) �޼ҵ� ����,
					//    ����� �����(��Ȯ����, ������ ��ſ� ����ä�� ��ü)��
					//    ����ȯ�� ByteBuffer�� ������ �۽�
					socketChannel.write(byteBuffer);
					
					// 4. JavaFX code: Client GUI �޽��� â��, ���ۿϷ� �޽��� ���
					Platform.runLater(()->displayText("[������ �Ϸ�]"));
					
				} catch(Exception e) {
					// ����, ������, ��ſ� ����ä�� ��ü��, �޽��� �۽� ����
					// ���ܰ� �߻��Ѵٸ�??? ������ �ؾ� �ұ�???
					
					// Client GUI �޽��� â��, ���� �޽��� ǥ��
					Platform.runLater(()->displayText("[���� ��� �ȵ�]"));
					
					// �ڿ��ݳ� �ڵ尡 ���մ� stopClient() �޼ҵ� ȣ���Ͽ�,
					// ������ ��� �ڿ� �ݳ�(���� �߿��� ����, ��ſ� ����ä�� ��ü �ݱ�.)
					stopClient();
				} // try-catch
				
			} // run
			
		}; // �͸��ڽİ�ü �ڵ� �������, Thread ��ü ����
		
		// ������ ������ ��ü ����!!! (NEW -> RUNNABLE)
		thread.start();
		
	} // send
	
	
	
	//////////////////////////////////////////////////////
	//            JavaFX code: Client GUI ����                  //
	//////////////////////////////////////////////////////
	TextArea txtDisplay;
	TextField txtInput;
	Button btnConn, btnSend;
	
	@Override
	public void start(Stage primaryStage) 
			throws Exception {
		
		BorderPane root = new BorderPane();
		root.setPrefSize(500, 300);
		
		txtDisplay = new TextArea();
		txtDisplay.setEditable(false);
		BorderPane.setMargin(txtDisplay, new Insets(0,0,2,0));
		root.setCenter(txtDisplay);
		
		BorderPane bottom = new BorderPane();
		
			txtInput = new TextField();
			txtInput.setPrefSize(60, 30);
			BorderPane.setMargin(txtInput, new Insets(0,1,1,1));
			
			btnConn = new Button("start");
			btnConn.setPrefSize(60, 30);
			btnConn.setOnAction(e->{
				if(btnConn.getText().equals("start")) {
					startClient();
				} else if(btnConn.getText().equals("stop")){
					stopClient();
				}
			});
			
			btnSend = new Button("send"); 
			btnSend.setPrefSize(60, 30);
			btnSend.setDisable(true);
			btnSend.setOnAction(e->send(txtInput.getText()));
			
			bottom.setCenter(txtInput);
			bottom.setLeft(btnConn);
			bottom.setRight(btnSend);
			
		root.setBottom(bottom);
		
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("app.css").toString());
		primaryStage.setScene(scene);
		primaryStage.setTitle("Client");
		primaryStage.setOnCloseRequest(event->stopClient());
		primaryStage.show();
	} // start
	
	void displayText(String text) {
		txtDisplay.appendText(text + "\n");
	} // displayText
	
	
	// ����Ŭ������ entry point
	public static void main(String[] args) {
		launch(args);	// JavaFX �ڵ� ����
	} // main
	
} // end
