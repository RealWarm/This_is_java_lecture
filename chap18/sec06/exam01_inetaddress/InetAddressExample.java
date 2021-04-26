package sec06.exam01_inetaddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressExample {
	
	
	public static void main(String[] args) {
		try {
			//------------------------------//
			// 1. 나의 IP주소를 확인해보자!!!
			//------------------------------//
			// InetAddress getLocalHost() 메소드 호출을 통해,
			// 현재 구동PC의 Host Address 정보를
			// InetAddress 객체로 반환
			InetAddress local = 
				InetAddress.getLocalHost();
			
			// InetAddress 객체의 String getHostAddress()
			// 메소드를 호출하면, IP주소를 확인가능
			System.out.println(
				"내컴퓨터 IP주소: " + 
				local.getHostAddress());
			
			//------------------------------//
			// 2. 특정 도메인의 IP주소를 확인해보자!!
			//------------------------------//
			// getAllByName() 메소드 호출을 하면,
			// 지정된 도메인 파라미터값을 IP주소로
			// 변환하기 위하여, DNS Lookup을 수행하고
			// 변환된 IP주소들(InetAddress)을 배열로 반환
			InetAddress[] iaArr = 
				InetAddress.getAllByName("www.naver.com");
			
			// 반환된 InetAddress[] 배열(변환된 IP주소들)을
			// 모두 출력(주의: 배열은 기본적으로 Iterable하므로
			// enhanced for 문을 사용가능!!!)
			for(InetAddress remote : iaArr) {
				// String getHostAddress() 메소드 호출을
				// 통해 IP주소 출력
				System.out.println(
					"www.naver.com IP주소: " + 
					remote.getHostAddress());
			} // enhanced for
			
		} catch(UnknownHostException e) { // 주목!!!
			// try block에서 예외가 발생하면,
			// 예외의 Stack Trace 출력
			e.printStackTrace(); 
		} // try-catch
	} // main
	
} // end class

