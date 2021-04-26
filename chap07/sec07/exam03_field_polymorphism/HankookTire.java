package sec07.exam03_field_polymorphism;


public class HankookTire extends Tire {
	//필드
	
	
	//생성자
	public HankookTire(
			String location,	// 타이어 위치 
			int maxRotation		// 최대회전수(타이어수명)
		) {
		// 부모 객체의 생성자호출 ->부모객체 초기화 수행
		// 반드시 첫 라인에 나와야 함!!
		super(location, maxRotation);
	} // constructor
	
	//메소드 오버라이딩(!!!!)
	@Override
	public boolean roll() {
		++accumulatedRotation; // 누적회전수 1증가
		
		if(accumulatedRotation < maxRotation) { 
			// 아직 타이어 수명(즉,최대회전수에 미도달)이
			// 남아있으면
			System.out.println(
					location + 
					" HankookTire 수명: " + 
					(maxRotation-accumulatedRotation) + 
					"회"
				);
			
			return true; // 아직 최대수명에 미도달 의미
		} else { // 타이어 수명(즉, 최대회전수 도달)이
			     // 다하면,펑크발생 --> 교체필요
			System.out.println(
					"*** " + 
					location + 
					" HankookTire 펑크 ***"
				);
			
			return false; // 타이어 최대수명에 도달(펑크)의미
		} // if-else
		
	} //main
	
} // end class
