package sec04.exam01_hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class HashMapExample1 {

	// Map 컬렉션의 대전제
	// 	1) 키=값 순서쌍 형태로 요소가 들어감
	//  2) 키는 중복이 허용안됨
	//  3) 값은 중복이 허용됨
	public static void main(String[] args) {
		//---- 1. Map 컬렉션 생성
		Map map = new HashMap();
		
		//---- 2. Map 컬렉션에 요소 저장
		// 이때, Map 컬렉션 내부에는, Map.Entry 타입의 객체
		// 가 생성되어 저장됨. 이 Map.Entry 객체가 아래의
		// 이름=값 형태로 데이터를 보관
		map.put("신용권", 85);
		map.put("홍길동", 90);
		map.put("동장군", 80);
		map.put("홍길동", 95);
		
		System.out.println("- map: "+ map);
		
		Set keys = map.keySet();
		System.out.println("- keys: "+ keys);
		
		for ( Object key  : keys) {
			String strKey = (String) key;
			System.out.println("\t+ strKey: "+ strKey);
			
			Object value = map.get(strKey);
			int val = (Integer) value;
			System.out.println("\t+ val: "+ val);			
		} // enhanced for
		
		
		
		System.exit(0);
		
		
		
		
		//---- 3. 현재 Map 컬렉션의 요소개수 확인
		System.out.println("총 Entry 수: " + map.size());
		
		//---- 4. 현재 Map 컬렉션에 들어있는 요소 찾기		
		System.out.println(
				"\t홍길동 : " + 
				map.get("홍길동"));
		
		System.out.println();
		
		//--------------------------------------//
		
		//---- 5. 요소를 하나씩 처리하고자 할때에는,
		
		// 5-1. Map 컬렉션 안에 들어있는 모든 요소의 key만 
		//      추출해서, 구슬주머니(Set)에 담아서 반환.
		Set keySet = map.keySet();
		
		// 5-2. Set<Key> 컬렉션으로부터, 반복자(Iterator)를
		//      추출하여, 각 Key를 뽑아냄
		Iterator keyIterator = keySet.iterator();
		
		while(keyIterator.hasNext()) {
		  String key = (String) keyIterator.next();	//각 Key를 얻음
		  Integer value = (Integer) map.get(key); //각 value를 얻음
		  
		  System.out.println("\t" + key + " : " + value);
		} // while
		
		System.out.println();
		
//		System.exit(0);	
		
		//--------------------------------------//
		
		//--- 6. 요소(Entry) 삭제
		map.remove("홍길동");
		
		System.out.println("총 Entry 수: " + map.size());
		
		//--------------------------------------//
		
		//--- 7. Map 컬렉션안에 들어있는 요소(Entry)를 
		//       하나씩 처리(Traverse)하는 코드
		Set entrySet = map.entrySet();
		
		System.out.println("- entrySet: "+ entrySet);
//		System.exit(0);
		
		// 7-1. Set 컬렉션으로부터, 반복자(Iterator) 획득
		Iterator entryIterator = entrySet.iterator();
		
		// 7-2. 얻어낸 반복자를 이용하여, 각 요소를 순회(traverse)
		while(entryIterator.hasNext()) {
		  Map.Entry entry = 
				  (Map.Entry) entryIterator.next();
		  
		  String key = (String) entry.getKey();
		  Integer value = (Integer) entry.getValue();
		  
		  System.out.println("\t" + key + " : " + value);
		} // while
		
		System.out.println();
		
		//객체 전체 삭제
		map.clear();
		System.out.println("총 Entry 수: " + map.size());
	}
}

