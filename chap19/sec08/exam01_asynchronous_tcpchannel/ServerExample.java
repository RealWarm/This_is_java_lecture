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
	// 필드 선언	
	//------------------------------------------------//
	// 1. 직접 명시적으로 생성한 비동기 채널 그룹 객체를 저장
	AsynchronousChannelGroup channelGroup;
	
	// 2. 비동기 서버소켓채널 객체를 저장
	AsynchronousServerSocketChannel serverSocketChannel;
	
	// 3. 클라이언트로부터 받은 메시지를, 모든 클라이언트에 중계하기 위해서,
	//    연결된 클라이언트마다 각각 생성한 Client 객체를 요소로 저장하는 리스트 객체 생성
	//    List 구현객체로, Thread-safe 한 Vector 사용
	List<Client> connections = new Vector<Client>();
	

	//------------------------------------------------//
	// Server GUI 의 'start' 버튼이 눌렸을때에, 호출되는 메소드	
	//------------------------------------------------//
	
	// 서버 시작 메소드
	void startServer() {
		
		try {
			//------------------------------------------------//
			// 1. 직접 명시적으로 비동기 채널그룹 생성
			//------------------------------------------------//
			//    왜? 직접 생성하나요?
			//    - 기본 비동기채널그룹은, 스레드 풀의 개수가 Integer.MAX_VALUE
			//      개수만큼 증가할 수 있도록 되어있어, 현실적으로 운영하기 힘듦
			//    - 직접 명시적으로 비동기 채널그룹을 생성할 때,
			//      개발자가 역시, 직접 스레드풀의 작업 스레드 개수를 지정가능하기 때문
			//------------------------------------------------//
			channelGroup = 
				AsynchronousChannelGroup.
					withFixedThreadPool( // 명시적으로 생성할 스레드 풀 설정
						// 진정한 병렬성을 확보하기 위해, 생성될 스레드 풀의
						// 작업스레드 최대 개수를, CPU Cores 수만큼 지정
						Runtime.getRuntime().availableProcessors(),
						// 작업스레드를 생성하는 역할을 하는, 
						// 스레드 공장(ThreadFactory) 객체 생성하여 전달
						Executors.defaultThreadFactory() // 정적메소드 사용
					); // withFixedThreadPool

			//------------------------------------------------//
			// 2. 비동기 서버소켓채널 생성
			//------------------------------------------------//
			serverSocketChannel = 
				// 생성할 비동기 서버소켓채널의 소속될 비동기 채널그룹을 
				// 매개변수로 전달하여, 소속설정
				AsynchronousServerSocketChannel.open(channelGroup);

			//------------------------------------------------//
			// 3. 비동기 서버소켓채널의 바인딩 작업 수행
			//------------------------------------------------//
			serverSocketChannel.bind(new InetSocketAddress(5001));
			
		} catch(Exception e) {
			// try 블록에서 예외가 발생하는 경우....
			if(serverSocketChannel.isOpen()) { 
				stopServer(); 	// 자원반납코드가 모여있는 메소드 호출하여, 정리
			} // if
			
			return;			// 메소드 즉시 종료
		} // try-catch

		//------------------------------------------------//
		// JavaFX code
		//------------------------------------------------//
		// Server GUI 메시지 창에, 메시지 출력
		Platform.runLater(()->{				// Lambda Expression
			displayText("[서버 시작]");		// 출력할 메시지 표시
			
			// 버튼의 라벨명을 start -> stop으로 변경
			btnStartStop.setText("stop");	
		});
		
		// -- 현재 계속 startServer() 메소드 코드 구현하고 있는 중!
		//    맥락을 잊지 마세요!!


		//------------------------------------------------//
		// 4. 생성한 비동기 서버소켓채널의 고유의 작업 수행 
		//    즉, 연결대기 수행
		//------------------------------------------------//
		// ** 중요 ** : 서버소켓채널객체.accept() 메소드의 매개변수에 주의!!!
		serverSocketChannel.
			accept(
				null,		// 첫번째 매개변수: 필요시 첨부할 첨부객체 전달
				
				// 두번째 매개변수: 작업처리 완료시 Callback 될 객체
				// 익명구현객체 코딩방식으로 바로 구현하여, 매개변수에 전달
				new CompletionHandler<AsynchronousSocketChannel, Void>() {
					
					// 작업처리 성공시, 자동호출될 콜백 메소드 선언
					@Override
					public void completed(
						// 첫번째 매개변수로, 통신용 비동기 소켓채널 객체 전달
						AsynchronousSocketChannel socketChannel, 
						// 두번째 매개변수로, 첨부파일 객체 전달
						// 첨부객체가 필요없으면, 아래와 같이 타입을 Void 로 지정!!!
						Void attachment 	// Void: 첨부할 객체 없음!!
					) {
						// JavaFX code
						// Server GUI 메세지 창에, 메시지 출력
						try {
							String message = 
								"[연결 수락: " + 
								socketChannel.getRemoteAddress()  + 
								": " + 
								Thread.currentThread().getName() + 
								"]";
							
							Platform.runLater(()->displayText(message));
						} catch (IOException e) {;;} // try-catch
						
						// 클라이언트 연결요청이 수락될 때마다, 생성되는 통신용
						// 비동기 소켓채널객체를 필드로 가지는 Client 객체 생성
						Client client = new Client(socketChannel);
						
						// 바로 위에서 생성한 Client 객체를 List에 요소로 저장!!!
						connections.add(client);
						
						// JavaFX code : GUI 메시지 창에 메시지 표시
						Platform.runLater(()->displayText(
							"[연결 개수: " + 
							connections.size() + 
							"]"
						 )
						);
						
						// 비동기 서버소켓 채널의 고유기능인, 클라이언트 연결요청대기!
						// 그런데, 현재 이 메소드는, 콜백메소드로, 작업스레드의 처리
						// 가 완료되었을 때에, 자동 호출되는 메소드에서, 왜 다시???
						// 서버소켓이 accept() 메소드로 왜?!!!!, Listen 재수행??
						serverSocketChannel.accept(null, this);
						
					} // completed
					
					
					// 스레드풀의 작업스레드가 작업처리 실패시(예외발생등...)
					// 작업스레드에 호출되는 콜백 메소드 선언
					@Override
					public void failed(Throwable exc, Void attachment) {
						// 서버소켓채널 닫기(자원반납)
						if(serverSocketChannel.isOpen()) { 
							stopServer(); 
						} // if
					} // failed
					
				}); // 익명구현객체 코딩방식으로, Callback 객체 생성
		
	} // startServer
	
	
	//-------------------------------------------------//
	// Server GUI 윈도우에서, stop 버튼을 누른 경우에 수행되는 메소드
	//-------------------------------------------------//
	// 주로 자원반납 코드들의 모음임
	//-------------------------------------------------//
	void stopServer() {
		
		try {
			// 1. List 객체 clear 시킴(자원반납)
			connections.clear();
			
			// 2. 비동기채널그룹 종료하기(by shutdownNow)
			if(channelGroup!=null && !channelGroup.isShutdown()) {
				channelGroup.shutdownNow();
			}
			
			// 3. JavaFX code
			//    GUI 메시지 창에, 메시지 표시
			Platform.runLater(()->{
				displayText("[서버 멈춤]");
				btnStartStop.setText("start");			
			});	
			
		} catch (Exception e) {;;} // try-catch
		
	} // stopServer
	
	
	//------------------------------------------//
	// 연결 수락된, 클라이언트 마다 생성하는 객체를 위한
	// 클래스 선언 (중첩 클래스 방식)
	// 대부분의 주요로직이, 이 클래스 안에 있기때문에, 코딩량이
	// 조금 큰 편임
	//------------------------------------------//
	class Client {
		//------------------------------------------//
		// 필드 선언부
		//------------------------------------------//
		// 1. 통신용 비동기 소켓채널 객체를 저장
		AsynchronousSocketChannel socketChannel;
		

		//------------------------------------------//
		// 2. 생성자 선언: 매개변수로, 통신용 비동기 소켓채널 객체 전달
		//------------------------------------------//
		Client(AsynchronousSocketChannel socketChannel) {
			this.socketChannel = socketChannel;
			
			receive(); // 채널을 통한, 데이터 수신 수행
		} // constructor
		

		//------------------------------------------//
		// 3. 통신용 소켓채널을 통한, 데이터 수신 수행 메소드 선언
		//------------------------------------------//
		void receive() {
			// 3-1. 100바이트 크기의, Non-direct ByteBuffer 생성
			ByteBuffer byteBuffer = ByteBuffer.allocate(100);
			
			// 3-2. 필드에 저장되어있는, 통신용 비동기 소켓채널로 READ 수행
			socketChannel.
				read(
					byteBuffer, 		// ByteBuffer
					byteBuffer, 		// 첨부객체로 역시 바이트버퍼 설정
					
					// 비동기 채널방식에서, 스레드 풀의 작업스레드가 task 처리
					// 완료시 호출할 메소드를 가지는 Callback 객체 생성
					// : 익명구현객체 코딩방식으로 구현 및 생성
					new CompletionHandler<Integer, ByteBuffer>() {						
						
						// 성공적인 작업처리 완료시 자동으로 호출될 콜백 메소드
						@Override
						public void completed(Integer result, ByteBuffer attachment) {
							try {
								String message = "[요청 처리: " + socketChannel.getRemoteAddress() + ": " + Thread.currentThread().getName() + "]";
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
						
						// 작업처리 도중 예외발생시(실패), 
						// 자동으로 호출될 콜백 메소드
						@Override
						public void failed(
							Throwable exc, 			// 발생한 예외객체 전달
							ByteBuffer attachment 	// 첨부객체 전달
						) {
							
							try {
								// GUI 메시지 창에 표시할 메시지 생성
								String message = 
									"[클라이언트 통신 안됨: " + 
									socketChannel.getRemoteAddress() + 
									": " + 
									Thread.currentThread().getName() + 
									"]";
								
								// JavaFX code: GUI 메시지 창에, 메시지 출력
								Platform.runLater(()->displayText(message));
								
								// List 객체에서, 현재 클라이언트 객체 삭제
								connections.remove(Client.this);
								
								// 통신용 비동기 소켓채널객체 닫음(자원반납)
								socketChannel.close();
							} catch (IOException e) {;;} // try-catch
							
						} // failed
						
					}); // 익명구현객체 코딩방식으로 구현 및 생성
			
		} // receive
		

		//------------------------------------------//
		// 4. 통신용 소켓채널을 통한, 데이터 송신 수행 메소드 선언
		//------------------------------------------//
		// 서버가 받은 문자열 메시지를, 
		// List에 등록된 모든 클라이언트에 메시지 중계
		void send(String data) {
			// String -> ByteBuffer 순변환을 위한 Charset 객체 생성
			Charset charset = Charset.forName("utf-8");		
			
			// 순변환 수행: String -> ByteBuffer
			ByteBuffer byteBuffer = charset.encode(data);
			
			// 비동기 소켓채널을 통해, WRITE 작업 수행
			socketChannel.write(
				byteBuffer, 		// NIO 버퍼
				
				null, 				// attachment : 첨부객체 전달
				
				// 콜백객체 생성하여 전달 : 익명구현객체생성 코딩방식
				new CompletionHandler<Integer, Void>() {

					// 성공적인 작업처리 완료시 자동으로 호출될 콜백 메소드
					@Override
					public void completed(Integer result, Void attachment) {
						;;
					} // completed

					// 작업처리 도중 예외발생시(실패), 
					// 자동으로 호출될 콜백 메소드
					@Override
					public void failed(Throwable exc, Void attachment) {
						try {
							String message = 
								"[클라이언트 통신 안됨: " + 
								socketChannel.getRemoteAddress() + 
								": " + 
								Thread.currentThread().getName() + "]";
							
							// JavaFX code
							Platform.runLater(()->displayText(message));
							
							// List 에서 전달된 Client 객체 삭제
							connections.remove(Client.this);
							
							// 비동기 소켓채널 닫기(자원반납)
							socketChannel.close();
						} catch (IOException e) {;;}
					} // failed
					
				} // 익명구현객체 코딩 방식으로, 객체 생성
				
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

