package sec04.exam01_hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class HashMapExample1 {

	// Map �÷����� ������
	// 	1) Ű=�� ������ ���·� ��Ұ� ��
	//  2) Ű�� �ߺ��� ���ȵ�
	//  3) ���� �ߺ��� ����
	public static void main(String[] args) {
		//---- 1. Map �÷��� ����
		Map map = new HashMap();
		
		//---- 2. Map �÷��ǿ� ��� ����
		// �̶�, Map �÷��� ���ο���, Map.Entry Ÿ���� ��ü
		// �� �����Ǿ� �����. �� Map.Entry ��ü�� �Ʒ���
		// �̸�=�� ���·� �����͸� ����
		map.put("�ſ��", 85);
		map.put("ȫ�浿", 90);
		map.put("���屺", 80);
		map.put("ȫ�浿", 95);
		
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
		
		
		
		
		//---- 3. ���� Map �÷����� ��Ұ��� Ȯ��
		System.out.println("�� Entry ��: " + map.size());
		
		//---- 4. ���� Map �÷��ǿ� ����ִ� ��� ã��		
		System.out.println(
				"\tȫ�浿 : " + 
				map.get("ȫ�浿"));
		
		System.out.println();
		
		//--------------------------------------//
		
		//---- 5. ��Ҹ� �ϳ��� ó���ϰ��� �Ҷ�����,
		
		// 5-1. Map �÷��� �ȿ� ����ִ� ��� ����� key�� 
		//      �����ؼ�, �����ָӴ�(Set)�� ��Ƽ� ��ȯ.
		Set keySet = map.keySet();
		
		// 5-2. Set<Key> �÷������κ���, �ݺ���(Iterator)��
		//      �����Ͽ�, �� Key�� �̾Ƴ�
		Iterator keyIterator = keySet.iterator();
		
		while(keyIterator.hasNext()) {
		  String key = (String) keyIterator.next();	//�� Key�� ����
		  Integer value = (Integer) map.get(key); //�� value�� ����
		  
		  System.out.println("\t" + key + " : " + value);
		} // while
		
		System.out.println();
		
//		System.exit(0);	
		
		//--------------------------------------//
		
		//--- 6. ���(Entry) ����
		map.remove("ȫ�浿");
		
		System.out.println("�� Entry ��: " + map.size());
		
		//--------------------------------------//
		
		//--- 7. Map �÷��Ǿȿ� ����ִ� ���(Entry)�� 
		//       �ϳ��� ó��(Traverse)�ϴ� �ڵ�
		Set entrySet = map.entrySet();
		
		System.out.println("- entrySet: "+ entrySet);
//		System.exit(0);
		
		// 7-1. Set �÷������κ���, �ݺ���(Iterator) ȹ��
		Iterator entryIterator = entrySet.iterator();
		
		// 7-2. �� �ݺ��ڸ� �̿��Ͽ�, �� ��Ҹ� ��ȸ(traverse)
		while(entryIterator.hasNext()) {
		  Map.Entry entry = 
				  (Map.Entry) entryIterator.next();
		  
		  String key = (String) entry.getKey();
		  Integer value = (Integer) entry.getValue();
		  
		  System.out.println("\t" + key + " : " + value);
		} // while
		
		System.out.println();
		
		//��ü ��ü ����
		map.clear();
		System.out.println("�� Entry ��: " + map.size());
	}
}

