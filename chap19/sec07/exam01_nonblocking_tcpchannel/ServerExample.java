package sec07.exam01_nonblocking_tcpchannel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


// Server
public class ServerExample extends Application {
	//----------------------------------------------//
	Selector selector;  					// ������ Selector ��ü�� ������ �ʵ�

	//----------------------------------------------//
	// ������ ����
	//----------------------------------------------//
	ServerSocketChannel serverSocketChannel;
	
	List<Client> connections = new Vector<Client>();
	//----------------------------------------------//
	
	

	//----------------------------------------------//
	// Server GUI window ����, start ��ư�� ������ ���� ����Ǵ� �޼ҵ�
	//----------------------------------------------//
	void startServer() {
		
		try {
			// 1. Selector ��ü ���� by open()
			selector = Selector.open();
			
			// 2. ServerSocketChannel ��ü ���� by open()
			serverSocketChannel = ServerSocketChannel.open();
			
			// 3. ***����*** : Selector �� ��ϰ����� ä���� �Ʒ��� �ΰ��� ������ 
			//    �����ؾ� ��
			// 				1) SelectableChannel �� ���� Ÿ���̾�� ��
			//				2) Non-blocking mode �̾�� ��
			serverSocketChannel.configureBlocking(false);	// set Non-blocking mode

			//----------------------------------------------//
			// ������ ����
			//----------------------------------------------//
			serverSocketChannel.bind(new InetSocketAddress(5001));
						
			//----------------------------------------------//
			// 4. Selector �� ��������ä�� ��� ���� (**** �߿� ****)
			//----------------------------------------------//
			serverSocketChannel.register(
				selector,				// ù��° �Ű�����: Selector ��ü 
				SelectionKey.OP_ACCEPT	// �ι�° �Ű�����: �� ä���� �۾����� ����
			); // register
			
		} catch (Exception e) {
			// ���� try ����� �۾� ó�� ��, ���ܰ� �߻��Ѵٸ�......
			// ������ ����
			if(serverSocketChannel.isOpen()) { 
				stopServer(); 
			} // if
			
			return;
		} // try-catch

		
		//----------------------------------------------//
		// ����� �����带 �����Ͽ�, ���������� ������ ����
		// �̶�, Selector�� �ۿ��� �̿���.*****
		//----------------------------------------------//
		Thread thread = new Thread() {
			
			@Override
			public void run() {
				
				while(true) { // ���ѷ��� ����
					
					try {
						//----------------------------------------------//
						// Selector ��ü�� select() ȣ���Ͽ�, 
						// Selector�� ����� ä�ε鿡 ����, ���� ����!!!
						//----------------------------------------------//
						// return value: ready ������ ä���� ����
						int keyCount = selector.select(); 
						
						if(keyCount == 0) { // ready channel �� 0�����(��, ���ٸ�)
							continue; // �ٽ� ���ѷ����� �������� �̵�(��, �� select() ����)
						} // if

						//----------------------------------------------//
						// keyCount �� 0���� ũ�ٸ�: ��, ready ä���� �ּ� 1���̻��̸�...
						//----------------------------------------------//
						// Selector�� selected keyset�� ����Ǿ� �ִ�, SelectionKey
						// ��ü���� �� by selector.selectedKeys() �޼ҵ�
						// �� �޼ҵ��� return type: Set<T> Generic interface ��
						//----------------------------------------------//
						Set<SelectionKey> selectedKeys = 
								selector.selectedKeys();

						//----------------------------------------------//
						// selected key set����, �ܺιݺ���(iterator)�� ����
						// Set �ڷᱸ�� �ȿ� �ִ� ������ SelectionKey ��ü�� ��ȸ(traverse)
						//----------------------------------------------//
						Iterator<SelectionKey> iterator = 
								selectedKeys.iterator();
						
						while (iterator.hasNext()) {
							
							// 1. Ready ������ SelectionKey ��ü�� selector���� ����
						    SelectionKey selectionKey = iterator.next();
						    
						    // 2. �� SelectionKey�� ��ϵ� �۾����� ���� ����
						    if (selectionKey.isAcceptable()) { // if OP_ACCEPT
						    	
						    	// ��������ä�ημ��� ������ �ϱ� ���� �޼ҵ� ȣ��
						    	accept(selectionKey);
						    	
						    } else if (selectionKey.isReadable()) { // if OP_READ
						    	
						    	// �߰��� ���ٷ� ÷�ΰ�ü�� �ִٸ�, ����
						    	// �� ���� ÷�ε� ��ü�� �ٷ� Client ��ü��.
						    	Client client = (Client)selectionKey.attachment();
						    	
						    	// Client �� receive() �޼ҵ� ȣ���Ͽ�, ������ ����
						    	client.receive(selectionKey);
						    	
						    } else if (selectionKey.isWritable()) { // if OP_WRITE

						    	// �߰��� ���ٷ� ÷�ΰ�ü�� �ִٸ�, ����
						    	// �� ���� ÷�ε� ��ü�� �ٷ� Client ��ü��.
						    	Client client = (Client)selectionKey.attachment();
						    	
						    	// Client �� receive() �޼ҵ� ȣ���Ͽ�, ������ �۽�
						    	client.send(selectionKey);
						    	
						    } // if-else if
						    
						    // Set ���� ������ ���(SelectionKey) ����
						    // �׷��� �� �����ؾ� �ϳ���?????
						    // Selector�� �������� ä���� ��Ƴ��� '���õ� Ű��'�� ���
						    // �Һ��ؾ� ��, �ٽ� ����Ű���� �����ϰ� ��.
						    // ��, ���õ� Ű���� �� �Һ��ؾ� ��!!!!
						    iterator.remove();
						    
						} // while
						
					} catch (Exception e) {
						// ���� try ��Ͽ��� ó������ ���ܰ� �߻��Ѵٸ�.....
						// ������ ����
						if(serverSocketChannel.isOpen()) { 
							stopServer(); 
						} // if
						
						break;	// ���ѷ��� ��������
					} // try-catch
					
				} // while
				
			} // run
			
		}; // �͸��ڽİ�ü���� �ڵ� ���
		
		// �����  ������ ����: NEW -> RUNNABLE
		thread.start();
		
		//----------------------------------------------//
		// ������ ����
		Platform.runLater(()->{
			displayText("[���� ����]");
			btnStartStop.setText("stop");
		});
		
	} // startServer
	
	
	// Client GUI â����, 'stop' ��ư�� �������� ����, ȣ��Ǵ� �޼ҵ�
	// ��κ� �ڿ��ݳ� �ڵ���
	void stopServer() {
		
		try {
			//-- List<Client> �� ��� ��Ҹ� ������.
			//-- List<Client> �� ��� ��ſ� ����ä�ΰ�ü �ݱ�
			Iterator<Client> iterator = connections.iterator();
			
			while(iterator.hasNext()) {
				Client client = iterator.next();
				
				client.socketChannel.close();
				
				iterator.remove();
			} // while
			
			// ������ ����
			if(serverSocketChannel!=null && serverSocketChannel.isOpen()) { 
				serverSocketChannel.close(); 
			} // if
			
			//----------------------------------------//
			// Selector ��ü�� �ڿ���ü��. �ڿ��ݳ� ����
			//----------------------------------------//
			if(selector!=null && selector.isOpen()) {
				selector.close();			// Selector ��ü �ݱ�
			} // if
			
			// ������ ����
			Platform.runLater(()->{
				displayText("[���� ����]");
				btnStartStop.setText("start");			
			});	
			
		} catch (Exception e) {;;} // try-catch
		
	} // stopServer	
	
	
	// Selector�� �� SelectionKey ��ü�� �̿���,
	// �������ϰ�ü�� Ŭ���̾�Ʈ �����û ó�� (����)
	void accept(SelectionKey selectionKey) {
		
		try {
			//*** Selector�� ������ SelectionKey ��ü�κ��� ��ϵ� ä�ΰ�ü�� ���� ���
			// ���!!!: SelectionKey ��ü �ȿ��� �ΰ����� ������ �������
			//		    ��. Selector�� ����� ä�� ��ü�� ����
			//		   ��. Selector�� ä���� ��ϴ��, �ش�ä�ο� ���� �۾�����
			
			// 1) SelectionKey �� ����ִ� ��� ä�ΰ�ü�� ���� ��� by SelectionKey.channel()
			ServerSocketChannel serverSocketChannel = 
					(ServerSocketChannel) selectionKey.channel();
			
			// 2) ������ ����
			SocketChannel socketChannel = serverSocketChannel.accept();
			
			String message = 
					"[���� ����: " + 
					socketChannel.getRemoteAddress()  + 
					": " + 
					Thread.currentThread().getName() + "]";

			// 3) ������ ����
			Platform.runLater(()->displayText(message));

			// 4) ������ ����
			Client client = new Client(socketChannel);
			
			connections.add(client);
			
			// 5) JavaFX code: ������ ����
			Platform.runLater(() -> displayText(
					"[���� ����: " + connections.size() + "]")
				);
			
		} catch(Exception e) {
			
			// ������ ����
			if(serverSocketChannel.isOpen()) { 
				stopServer(); 
			} // if
			
		} // try-catch
	} // accept
	
	
	// ÷�ΰ�ü�μ��� ������ �ϸ鼭,
	// ������ �����ϰ�, ����� Ŭ���̾�Ʈ �� �ϳ��� �����ϴ� ��ü��, List<Client> �ڷᱸ����
	// ��ҷ� ������
	class Client {
		// ������ ����
		SocketChannel socketChannel;
		String sendData;
		
		
		
		Client(SocketChannel socketChannel) 
				throws IOException {
			
			this.socketChannel = socketChannel;
			
			//** �߿� ** : Selector�� ��ϰ����� ä���� �ݵ�� 2���� ������ �����ؾ� ��
			//            1) SelectableChannel�� ����Ÿ���̾�� ��
			//            2) Non-blocking mode�� ä���̾�� ��!
			socketChannel.configureBlocking(false);	// Non-blocking mode�� ����
			
			// Selector�� ������ ä�� ��� by using SelectionKey ��ü
			SelectionKey selectionKey = 
				socketChannel.register(
					selector,				// ���ÿ��� Selector ��ü 
					SelectionKey.OP_READ	// ����� ä���� ���� �۾����� : �б��۾�!
				);
			
			// SelectionKey ��ü�� attach(obj) �޼ҵ��, 
			// ÷�ΰ�ü ����(attach)
			// ���⼭, this�� �����ϴ� ��ü��  ���� ?????? �߻����غ�����!!!
			selectionKey.attach(this);
		} // ������
		
		
		// ������ ���� �޼ҵ�
		// Selector�� ���õ� Ű��(Q)���� �� �� SelectionKey �� ���ؼ� ����
		void receive(SelectionKey selectionKey) {
			
			try {
				// ������ ����
				ByteBuffer byteBuffer = ByteBuffer.allocate(100);
				
				// ������ ����
				int byteCount = socketChannel.read(byteBuffer); 

				// ������ ����
				if(byteCount == -1) { 
					throw new IOException();
				} // if

				// ������ ����
				String message = 
					"[��û ó��: " + 
					socketChannel.getRemoteAddress() + 
					": " + 
					Thread.currentThread().getName() + 
					"]";

				// ������ ����
				Platform.runLater(()->displayText(message));

				// ������ ����
				byteBuffer.flip();
				
				// ������ ����
				Charset charset = Charset.forName("UTF-8");
				String data = charset.decode(byteBuffer).toString();

				// List<Client> ����Ʈ �ȿ� ����Ǿ� �ִ� �� Client ��ü�� ���Ͽ�...
				for(Client client : connections) {
					// �۽� ������ ����
					client.sendData = data;
					
					// **** �ſ� �߿� **** //
					// Selector�� ���õ� Ű�����κ���, SelectionKey ��ü�� ���� ����
					// ��Ģ�̳�, ���� �����������, ����ä�ΰ�ü�� ������, keyFor(�����Ͱ�ü)
					// �޼ҵ带 ����, �ش� ä���� SelectionKey ��ü�� ������ �� �� ����
					
					// ����ä���� keyFor()�� ����, Selector�� ������ SelectionKey ��ü��
					// ����.
					SelectionKey key = client.socketChannel.keyFor(selector);
					
					// **** �ſ� �߿� *** //
					// �� SelectionKey ��ü�� �Ʒ� �޼ҵ带 ����, 
					// �� ������ �۾������� ������ �� ����
					
					// Selector�� ������ �ش� ä���� �۾����� ����!!!!!!!!!
					key.interestOps(SelectionKey.OP_WRITE);	// -> ���� �۾��������� ����
				} // enhanced for: List<Client> ����Ʈ �ȿ� �ִ� �� Client ��ü�� ���Ͽ�...
				
				// Selector �� blocking ���¿��� �ٽ� ����!!!(��¦����!)
				// Selector.select() �޼ҵ��� blocking ���� ����.
				selector.wakeup();
				
			} catch(Exception e) {	
				
				// ����ó��: ������ ����
				try {
					connections.remove(this);
					
					String message = 
						"[Ŭ���̾�Ʈ ��� �ȵ�: " + 
						socketChannel.getRemoteAddress() + 
						": " + 
						Thread.currentThread().getName() + 
						"]";
					
					Platform.runLater(()->displayText(message));
					socketChannel.close();
				} catch (IOException e2) {;;} // try-catch
				
			} // try-catch
			
		} // receive
		
		
		// ������ �۽� �޼ҵ�
		// Selector�� ���õ� Ű��(Q)���� �� �� SelectionKey �� ���ؼ� ����
		void send(SelectionKey selectionKey) {
			
			try {
				
				// ������ ����
				Charset charset = Charset.forName("UTF-8");
				ByteBuffer byteBuffer = charset.encode(sendData);
				
				socketChannel.write(byteBuffer);
				
				// SelectionKey ��ü�� �Ʒ� �޼ҵ带 ����, Selector�� ������
				// ä���� �۾����� ����
				
				// 1) ������ ä���� �۾����� ����
				selectionKey.interestOps(SelectionKey.OP_READ);
				
				// 2) Selector.selector() �޼ҵ��� blocking ����
				selector.wakeup();
				
			} catch(Exception e) {
				
				// ������ ����
				try {
					
					String message = 
							"[Ŭ���̾�Ʈ ��� �ȵ�: " + 
							socketChannel.getRemoteAddress() + 
							": " + 
							Thread.currentThread().getName() + 
							"]";
					
					Platform.runLater(()->displayText(message));
					
					connections.remove(this);
					
					socketChannel.close();
					
				} catch (IOException e2) {;;} // try-catch
				
			} // try-catch
			
		} // send
		
	} // end class
	

	///////////////////////////////////////////	
	// JavaFX code: ������ ����
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
