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
	
	// 1. 통신용 소켓채널객체를 저장할 필드
	SocketChannel socketChannel;
	
	
	// Client GUI Window 에서, start 버튼을 눌렀을 때에 호출된 메소드
	void startClient() {
		
		// 직접 User Thread 객체 생성(왜?... 뭐하려고???)
		// ForkJoin Thread Pool을 왜 사용하지 않지????
		Thread thread = new Thread() {
			
			// 스레드가 수행할 로직을 가지고 있는 메소드
			// 이미 Thread 클래스 안에, run() 메소드가 기본 구현되어있지만,
			// 실제 로직은 아무것도 없음!!!(하는게 없다는 뜻이죠)
			@Override
			public void run() {
				
				try {
					// 통신용 소켓채널객체 생성 by static method: open()
					socketChannel = SocketChannel.open();
					
					// 생성한 소켓채널의 입출력방식을 Blocking 모드로 설정
					socketChannel.configureBlocking(true);
					
					// 통신용 소켓채널객체의 connect() 메소드를 이용하여,
					// 서버측 서버소켓채널객체에, 연결요청을 만들어 송신
					socketChannel.connect(
							new InetSocketAddress(
								"localhost",		// 연결할 서버의 IP주소 지정 
								5001				// 연결할 서버의 Listen Port 지정
							)
						); // connect
					
					// JavaFX code: GUI 메시지 창에 아래 메시지 출력
					// 연결이 성공되었음을 표시.
					Platform.runLater(()->{
						
						try {
							// GUI 메시지 창에, 멧돼지 표시!!??? (ㅋㅋ)
							displayText(
								"[연결 완료: "  + 
								socketChannel.getRemoteAddress() + 
								"]"
							);
							
							// 버튼의 라벨명을, start -> stop 으로 변경
							btnConn.setText("stop");
							
							// 메시지 전송 버튼을, enable 상태로 변경
							btnSend.setDisable(false);
						} catch (Exception e) {;;}
						
					}); // runLater.
					
				} catch(Exception e) {
					// 통신용 소켓채널을 통해, 서버소켓채널과의 연결시도시,
					// 예외가 발생하는 경우, 아래로직 처리.
					
					// GUI 메시지 창에 메세지 표시.
					Platform.runLater(()->displayText("[서버 통신 안됨]"));
					
					// *** 중요 *** : 생성한 통신용 소켓채널객체 닫기!!!
					if(socketChannel.isOpen()) { 
						stopClient(); 
					} // if
					
					return;		// run() 메소드 즉시 종료 --> 즉, 스레드 종료시킴
				} // try-catch
				
				// 서버로의 연결요청이 성공적으로 이루어졌으면, 
				// 바로, 데이터 수신 시도!!!!
				receive();
				
			} //run
			
		}; // 익명자식객체 코딩방식으로, Thread 객체 생성
		
		// 위에서 생성한 스레드 객체를 통해, User 스레드 구동시킴
		// 스레드 상태: NEW -> RUNNABLE <-> RUNNING / SUSPEND -> TERMINATED
		thread.start();
	} // startClient    : GUI 창에서, 'start' 버튼을 눌렀을 때에, 호출될 메소드 정의.
	
	
	// Client GUI 창에서, 'stop' 버튼을 눌렀을 때에, 호출될 메소드 정의.
	// 주로 하는 역할을 각종 자원반납 처리임.
	void stopClient() {
		
		try {
			// JavaFX code: GUI 메시지 창에, 연결 종료 관련 메시지 출력
			Platform.runLater(()->{
				displayText("[연결 끊음]");		// 메시지 출력
				
				btnConn.setText("start");		// stop 버튼의 라벨명 -> start로 변경
				btnSend.setDisable(true);		// 메시지 송신 버튼 비활성화 처리
			}); // runLater
			
			// 사용이 끝난, 통신용 소켓채널 객체 자원반납.
			if(socketChannel!=null && socketChannel.isOpen()) {
				socketChannel.close();	// 채널 닫기.
			} // if
			
		} catch (IOException e) {;;} // try-catch
		
	} // stopClient
	
	
	// 이 메소드는, 정확히는, 메시지를 중계하는 서버로부터, 메시지를 수신하기 위한
	// 용도의 역할을 수행하는 메소드.
	void receive() {
		
		// 잘 생각해 보세요!. 메시지 수신 역시, 언제 서버로부터, 메시지가 올 지 모르기 때문에
		// 블록킹 되겠죠?.. 그래서, 이 메시지 수신 task 역시, 무한루프를 돌면서, 언젠가
		// 들어올 메시지를 수신처리해야 합니다.
		while(true) {	// 무한루프 수행
			
			try {
				// 메시지 수신 즉 READ 수행을 위한, NIO ByteBuffer 객체 생성
				// 크기는 100 바이트. (Non-direct Buffer 로 생성)
				ByteBuffer byteBuffer = ByteBuffer.allocate(100);
				
				// 통신용 소켓채널 객체의 read(ByteBuffer) 메소드를 수행하여,
				// 연결된 채널을 통해, 데이터가 들어올 때까지 기다림(즉, 블록킹됨!)
				// 채널의 read(buffer) 메소드는 아래와 같이 3가지 경우에 블록킹 상태에서
				// 풀림:
				// 		1) 서버가 비정상적으로 종료했을 경우 IOException 발생
				//		2) 연결된 상대편(우리같은 경우는, 서버측 통신용 소켓채널 객체)의
				//         채널이 정상종료(즉, 명시적으로 채널.close() 호출한 경우)되면,
				//         -1 (EOF) 반환
				//      3) 연결된 상대편(우리같은 경우는, 서버측 통신용 소켓채널 객체)에서
				//         정상적으로 메시지를 보낸 경우(이때는, 실제 수신한 바이트 개수 반환)
				int readByteCount = socketChannel.read(byteBuffer);
				
				
				// 2) 서버가 정상적으로 Socket의 close()를 호출했을 경우: -1 (EOF) 반환
				if(readByteCount == -1) {
					// IOException 예외를 직접 생성하여 throw (예외발생) 시킴
					throw new IOException();
				} // if
				
				// 채널.read() 가 정상적으로 데이터를 수신을 다 햇다면....
				// ByteBuffer.flip() 메소드 호출로, 읽기 모드로 변경
				byteBuffer.flip();
				
				// 상대편(정확히는, 서버가 보낸 문자열 메시지)의 데이터를 원래의 데이터(문자열)
				// 로 역변환 수행. 즉, ByteBuffer -> CharBuffer -> String 역변환.
				
				// 역변환을 위한, Charset 객체 생성(이때, 개발자가 지정한 문자셋으로...)
				Charset charset = Charset.forName("UTF-8");
				
				// 역변환 수행 by using Charset 객체의 decode()메소드
				// : ByteBuffer > CharBuffer > String(by .toString()) 역변환 수행
				// 서버가 보낸 문자열 메시지 복원 완료
				String data = charset.decode(byteBuffer).toString();
				
				// JavaFX code:
				// Client GUI 메시지 창에, 서버로부터 받은, 중계 메시지 표시
				Platform.runLater(()->displayText("[받기 완료] "  + data));
				
			} catch (Exception e) {
				// 데이터 수신 시도시, 만일 예외가 발생한다면.......
				
				// Client GUI 메시지 창에 아래 메세지 표시.
				Platform.runLater(()->displayText("[서버 통신 안됨]"));
				
				// 자원반납코드가 모여있는 메소드 수행하여, 
				// 통신용 소켓채널객체 닫기
				stopClient();
				
				// 더이상 연결된 상대편(즉, 서버의 통신용 소켓채널)과의 통신이
				// 불가함으로, 무한루프를 빠져나감(탈출코드)
				break;		// 탈출
			} // try-catch
			
		} // while : 무한루프에서 지속적으로, 서버로부터의 중계 메시지 수신역할 수행
		
	} // receive
	
	
	// 연결된 상대편(즉, 서버의 통신용 소켓채널객체)으로 메시지를 송신하는 메소드
	void send(String data) {
		
		// 이 역할 역시, 별도의 User 스레드를 생성하여, 별개의 Worker Thread가
		// 처리하도록 함
		Thread thread = new Thread() {
			
			
			@Override
			public void run() {
				
				try {
					// 현재의 이 Task는, 서버로 메시지를 보내는 것이죠!?
					// 이 목적에 맞게 코딩을 시작합니다.
					
					// String 메시지를 ByteBuffer로 순변환 수행.
					// 즉, String -> Charset 통해 -> ByteBuffer 로 순변환 수행
					
					// 1. 순변환을 위한, Charset 객체 생성
					Charset charset = Charset.forName("UTF-8");
					
					// 2. Charset 객체의 encode(data) 순변환 메소드 통해
					//    String -> ByteBuffer 객체로 변환.
					ByteBuffer byteBuffer = charset.encode(data);
					
					// 3. 통신용 소켓채널 객체의 write(ByteBuffer) 메소드 통해,
					//    연결된 상대편(정확히는, 서버의 통신용 소켓채널 객체)에
					//    순변환된 ByteBuffer의 데이터 송신
					socketChannel.write(byteBuffer);
					
					// 4. JavaFX code: Client GUI 메시지 창에, 전송완료 메시지 출력
					Platform.runLater(()->displayText("[보내기 완료]"));
					
				} catch(Exception e) {
					// 만일, 서버측, 통신용 소켓채널 객체로, 메시지 송신 도중
					// 예외가 발생한다면??? 무엇을 해야 할까???
					
					// Client GUI 메시지 창에, 관련 메시지 표시
					Platform.runLater(()->displayText("[서버 통신 안됨]"));
					
					// 자원반납 코드가 모여잇는 stopClient() 메소드 호출하여,
					// 생성된 모든 자원 반납(가장 중요한 것은, 통신용 소켓채널 객체 닫기.)
					stopClient();
				} // try-catch
				
			} // run
			
		}; // 익명자식객체 코딩 기법으로, Thread 객체 생성
		
		// 생성한 스레드 객체 시작!!! (NEW -> RUNNABLE)
		thread.start();
		
	} // send
	
	
	
	//////////////////////////////////////////////////////
	//            JavaFX code: Client GUI 생성                  //
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
	
	
	// 실행클래스의 entry point
	public static void main(String[] args) {
		launch(args);	// JavaFX 코드 수행
	} // main
	
} // end
