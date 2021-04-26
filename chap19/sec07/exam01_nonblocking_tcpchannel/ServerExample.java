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
	Selector selector;  					// 생성한 Selector 객체를 저장할 필드

	//----------------------------------------------//
	// 기존과 동일
	//----------------------------------------------//
	ServerSocketChannel serverSocketChannel;
	
	List<Client> connections = new Vector<Client>();
	//----------------------------------------------//
	
	

	//----------------------------------------------//
	// Server GUI window 에서, start 버튼을 눌렀을 때에 수행되는 메소드
	//----------------------------------------------//
	void startServer() {
		
		try {
			// 1. Selector 객체 생성 by open()
			selector = Selector.open();
			
			// 2. ServerSocketChannel 객체 생성 by open()
			serverSocketChannel = ServerSocketChannel.open();
			
			// 3. ***주의*** : Selector 에 등록가능한 채널을 아래의 두가지 조건을 
			//    충족해야 함
			// 				1) SelectableChannel 의 하위 타입이어야 함
			//				2) Non-blocking mode 이어야 함
			serverSocketChannel.configureBlocking(false);	// set Non-blocking mode

			//----------------------------------------------//
			// 이전과 동일
			//----------------------------------------------//
			serverSocketChannel.bind(new InetSocketAddress(5001));
						
			//----------------------------------------------//
			// 4. Selector 에 서버소켓채널 등록 수행 (**** 중요 ****)
			//----------------------------------------------//
			serverSocketChannel.register(
				selector,				// 첫번째 매개변수: Selector 객체 
				SelectionKey.OP_ACCEPT	// 두번째 매개변수: 이 채널의 작업유형 지정
			); // register
			
		} catch (Exception e) {
			// 만일 try 블록의 작업 처리 중, 예외가 발생한다면......
			// 이전과 동일
			if(serverSocketChannel.isOpen()) { 
				stopServer(); 
			} // if
			
			return;
		} // try-catch

		
		//----------------------------------------------//
		// 사용자 스레드를 생성하여, 서버소켓의 역할을 수행
		// 이때, Selector의 작용을 이용함.*****
		//----------------------------------------------//
		Thread thread = new Thread() {
			
			@Override
			public void run() {
				
				while(true) { // 무한루프 수행
					
					try {
						//----------------------------------------------//
						// Selector 객체의 select() 호출하여, 
						// Selector에 등록한 채널들에 대한, 감시 시작!!!
						//----------------------------------------------//
						// return value: ready 상태의 채널의 갯수
						int keyCount = selector.select(); 
						
						if(keyCount == 0) { // ready channel 이 0개라면(즉, 없다면)
							continue; // 다시 무한루프의 시작으로 이동(즉, 재 select() 수행)
						} // if

						//----------------------------------------------//
						// keyCount 가 0보다 크다면: 즉, ready 채널이 최소 1개이상이면...
						//----------------------------------------------//
						// Selector의 selected keyset에 저장되어 있는, SelectionKey
						// 객체들을 얻어냄 by selector.selectedKeys() 메소드
						// 이 메소드의 return type: Set<T> Generic interface 임
						//----------------------------------------------//
						Set<SelectionKey> selectedKeys = 
								selector.selectedKeys();

						//----------------------------------------------//
						// selected key set에서, 외부반복자(iterator)를 얻어내어
						// Set 자료구조 안에 있는 각각의 SelectionKey 객체를 순회(traverse)
						//----------------------------------------------//
						Iterator<SelectionKey> iterator = 
								selectedKeys.iterator();
						
						while (iterator.hasNext()) {
							
							// 1. Ready 상태의 SelectionKey 객체를 selector에서 얻어내기
						    SelectionKey selectionKey = iterator.next();
						    
						    // 2. 얻어낸 SelectionKey에 등록된 작업유형 정보 얻어내기
						    if (selectionKey.isAcceptable()) { // if OP_ACCEPT
						    	
						    	// 서버소켓채널로서의 역할을 하기 위한 메소드 호출
						    	accept(selectionKey);
						    	
						    } else if (selectionKey.isReadable()) { // if OP_READ
						    	
						    	// 추가로 전다뢴 첨부객체가 있다면, 얻어내기
						    	// 이 경우는 첨부된 객체가 바로 Client 객체임.
						    	Client client = (Client)selectionKey.attachment();
						    	
						    	// Client 의 receive() 메소드 호출하여, 데이터 수신
						    	client.receive(selectionKey);
						    	
						    } else if (selectionKey.isWritable()) { // if OP_WRITE

						    	// 추가로 전다뢴 첨부객체가 있다면, 얻어내기
						    	// 이 경우는 첨부된 객체가 바로 Client 객체임.
						    	Client client = (Client)selectionKey.attachment();
						    	
						    	// Client 의 receive() 메소드 호출하여, 데이터 송신
						    	client.send(selectionKey);
						    	
						    } // if-else if
						    
						    // Set 에서 현재의 요소(SelectionKey) 삭제
						    // 그런데 왜 삭제해야 하나요?????
						    // Selector가 통지받은 채널을 모아놓은 '선택된 키셋'은 모두
						    // 소비해야 만, 다시 관심키셋을 감시하게 됨.
						    // 즉, 선택된 키셋은 다 소비해야 함!!!!
						    iterator.remove();
						    
						} // while
						
					} catch (Exception e) {
						// 위의 try 블록에서 처리도중 예외가 발생한다면.....
						// 이전과 동일
						if(serverSocketChannel.isOpen()) { 
							stopServer(); 
						} // if
						
						break;	// 무한루프 빠져나감
					} // try-catch
					
				} // while
				
			} // run
			
		}; // 익명자식객체구현 코딩 방식
		
		// 사용자  스레드 시작: NEW -> RUNNABLE
		thread.start();
		
		//----------------------------------------------//
		// 기존과 동일
		Platform.runLater(()->{
			displayText("[서버 시작]");
			btnStartStop.setText("stop");
		});
		
	} // startServer
	
	
	// Client GUI 창에서, 'stop' 버튼이 눌려졌을 때에, 호출되는 메소드
	// 대부분 자원반납 코드임
	void stopServer() {
		
		try {
			//-- List<Client> 의 모든 요소를 삭제함.
			//-- List<Client> 의 모든 통신용 소켓채널객체 닫기
			Iterator<Client> iterator = connections.iterator();
			
			while(iterator.hasNext()) {
				Client client = iterator.next();
				
				client.socketChannel.close();
				
				iterator.remove();
			} // while
			
			// 이전과 동일
			if(serverSocketChannel!=null && serverSocketChannel.isOpen()) { 
				serverSocketChannel.close(); 
			} // if
			
			//----------------------------------------//
			// Selector 객체도 자원객체임. 자원반납 수행
			//----------------------------------------//
			if(selector!=null && selector.isOpen()) {
				selector.close();			// Selector 객체 닫기
			} // if
			
			// 이전과 동일
			Platform.runLater(()->{
				displayText("[서버 멈춤]");
				btnStartStop.setText("start");			
			});	
			
		} catch (Exception e) {;;} // try-catch
		
	} // stopServer	
	
	
	// Selector가 준 SelectionKey 객체를 이용한,
	// 서버소켓객체의 클라이언트 연결요청 처리 (수락)
	void accept(SelectionKey selectionKey) {
		
		try {
			//*** Selector가 돌려준 SelectionKey 객체로부터 등록된 채널객체의 참조 얻기
			// 명심!!!: SelectionKey 객체 안에는 두가지의 정보가 들어있음
			//		    가. Selector에 등록한 채널 객체의 참조
			//		   나. Selector에 채널을 등록당시, 해당채널에 대한 작업유형
			
			// 1) SelectionKey 에 들어있는 등록 채널객체의 참조 얻기 by SelectionKey.channel()
			ServerSocketChannel serverSocketChannel = 
					(ServerSocketChannel) selectionKey.channel();
			
			// 2) 이전과 동일
			SocketChannel socketChannel = serverSocketChannel.accept();
			
			String message = 
					"[연결 수락: " + 
					socketChannel.getRemoteAddress()  + 
					": " + 
					Thread.currentThread().getName() + "]";

			// 3) 이전과 동일
			Platform.runLater(()->displayText(message));

			// 4) 이전과 동일
			Client client = new Client(socketChannel);
			
			connections.add(client);
			
			// 5) JavaFX code: 이전과 동일
			Platform.runLater(() -> displayText(
					"[연결 개수: " + connections.size() + "]")
				);
			
		} catch(Exception e) {
			
			// 이전과 동일
			if(serverSocketChannel.isOpen()) { 
				stopServer(); 
			} // if
			
		} // try-catch
	} // accept
	
	
	// 첨부객체로서의 역할을 하면서,
	// 기존과 동일하게, 연결된 클라이언트 당 하나씩 생서하는 객체로, List<Client> 자료구조의
	// 요소로 관리됨
	class Client {
		// 기존과 동일
		SocketChannel socketChannel;
		String sendData;
		
		
		
		Client(SocketChannel socketChannel) 
				throws IOException {
			
			this.socketChannel = socketChannel;
			
			//** 중요 ** : Selector에 등록가능한 채널은 반드시 2가지 조건을 만족해야 함
			//            1) SelectableChannel의 하위타입이어야 함
			//            2) Non-blocking mode의 채널이어야 함!
			socketChannel.configureBlocking(false);	// Non-blocking mode로 설정
			
			// Selector에 감시할 채널 등록 by using SelectionKey 객체
			SelectionKey selectionKey = 
				socketChannel.register(
					selector,				// 감시역할 Selector 객체 
					SelectionKey.OP_READ	// 등록할 채널의 감시 작업유형 : 읽기작업!
				);
			
			// SelectionKey 객체의 attach(obj) 메소드로, 
			// 첨부객체 저장(attach)
			// 여기서, this가 참조하는 객체는  무엇 ?????? 잘생각해보세요!!!
			selectionKey.attach(this);
		} // 생성자
		
		
		// 데이터 수신 메소드
		// Selector의 선택된 키셋(Q)에서 얻어낸 각 SelectionKey 에 대해서 수행
		void receive(SelectionKey selectionKey) {
			
			try {
				// 이전과 동일
				ByteBuffer byteBuffer = ByteBuffer.allocate(100);
				
				// 이전과 동일
				int byteCount = socketChannel.read(byteBuffer); 

				// 이전과 동일
				if(byteCount == -1) { 
					throw new IOException();
				} // if

				// 이전과 동일
				String message = 
					"[요청 처리: " + 
					socketChannel.getRemoteAddress() + 
					": " + 
					Thread.currentThread().getName() + 
					"]";

				// 이전과 동일
				Platform.runLater(()->displayText(message));

				// 이전과 동일
				byteBuffer.flip();
				
				// 이전과 동일
				Charset charset = Charset.forName("UTF-8");
				String data = charset.decode(byteBuffer).toString();

				// List<Client> 리스트 안에 저장되어 있는 각 Client 객체에 대하여...
				for(Client client : connections) {
					// 송신 데이터 지정
					client.sendData = data;
					
					// **** 매우 중요 **** //
					// Selector의 선택된 키셋으로부터, SelectionKey 객체를 얻어내는 것이
					// 원칙이나, 언제 어느곳에서는, 소켓채널객체만 있으면, keyFor(셀렉터객체)
					// 메소드를 통해, 해당 채널의 SelectionKey 객체의 참조를 얻어낼 수 있음
					
					// 소켓채널의 keyFor()를 통해, Selector가 선택한 SelectionKey 객체를
					// 얻어내기.
					SelectionKey key = client.socketChannel.keyFor(selector);
					
					// **** 매우 중요 *** //
					// 얻어낸 SelectionKey 객체의 아래 메소드를 통해, 
					// 재 감시할 작업유형을 변경할 수 있음
					
					// Selector가 감시할 해당 채널의 작업유형 변경!!!!!!!!!
					key.interestOps(SelectionKey.OP_WRITE);	// -> 쓰기 작업유형으로 변경
				} // enhanced for: List<Client> 리스트 안에 있는 각 Client 객체에 대하여...
				
				// Selector 를 blocking 상태에서 다시 깨움!!!(살짝깨움!)
				// Selector.select() 메소드의 blocking 상태 해제.
				selector.wakeup();
				
			} catch(Exception e) {	
				
				// 예외처리: 이전과 동일
				try {
					connections.remove(this);
					
					String message = 
						"[클라이언트 통신 안됨: " + 
						socketChannel.getRemoteAddress() + 
						": " + 
						Thread.currentThread().getName() + 
						"]";
					
					Platform.runLater(()->displayText(message));
					socketChannel.close();
				} catch (IOException e2) {;;} // try-catch
				
			} // try-catch
			
		} // receive
		
		
		// 데이터 송신 메소드
		// Selector의 선택된 키셋(Q)에서 얻어낸 각 SelectionKey 에 대해서 수행
		void send(SelectionKey selectionKey) {
			
			try {
				
				// 이전과 동일
				Charset charset = Charset.forName("UTF-8");
				ByteBuffer byteBuffer = charset.encode(sendData);
				
				socketChannel.write(byteBuffer);
				
				// SelectionKey 객체의 아래 메소드를 통해, Selector가 감시할
				// 채널의 작업유형 변경
				
				// 1) 감시할 채널의 작업유형 변경
				selectionKey.interestOps(SelectionKey.OP_READ);
				
				// 2) Selector.selector() 메소드의 blocking 깨움
				selector.wakeup();
				
			} catch(Exception e) {
				
				// 이전과 동일
				try {
					
					String message = 
							"[클라이언트 통신 안됨: " + 
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
	// JavaFX code: 이전과 동일
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
