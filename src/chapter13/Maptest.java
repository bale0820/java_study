package chapter13;

import java.util.HashMap;
import java.util.Map;

/**
 * Set 인터페이스 
 */
public class Maptest {

	public static void main(String[] args) {
		Map<Integer, String> subjects = new HashMap<Integer, String>();
		//컬렉션클래스안에 배열에는 무조건 객체가
		subjects.put(1, "java");
		subjects.put(2, "mysql");
		subjects.put(3, "html");
		//1, 데이터 저장 : C(Create)
		subjects.put(1, "java");
		subjects.put(2, "mysql");
		subjects.put(3, "html");
		
		//2, 데이터 출력 : R(Read)
//		subjects.forEach(System.out::println); key를 출력하라는건지 값을 출력하려는건지 알수없어서 에러 값이 명확하지 않다
		subjects.forEach((key, value) -> System.out.println(key +", "+value));
		
		//3, 데이터 수정 : C(Update)
		if(subjects.containsKey(2)) subjects.replace(2, "oracle");
//		subjects.put(2, "oracle");
		System.out.println();
		subjects.forEach((key, value) -> System.out.println(key +", "+value));
		
	
		
		//4, 데이터 삭제 : C(Delete)
		//oracle 삭제
		subjects.remove(2); //리스트일때만 while문통해서 지워주면 된다 map 은 필요없다
		
		System.out.println();
		subjects.forEach((key, value) -> System.out.println(key +", "+value));
		
		
		subjects.clear(); //전체 삭제
		
		System.out.println("-- 전체 삭제 왼료 --");
		subjects.forEach((key, value) -> System.out.println(key +", "+value));
		
	
		

		
		

}
}
