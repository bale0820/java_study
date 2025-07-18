package chapter12;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap();
		map.put(1, "홍길동");
		map.put(2, "홍길동");
		map.put(3, "홍길동");
		for(Map.Entry<Integer, String> m :map.entrySet()) {
			System.out.println(m);
		}
		for(Integer m: map.keySet()) {
			System.out.println(m);
		}
		
		for(String m: map.values()) {
			System.out.println(m);
		}
		

	}

}
