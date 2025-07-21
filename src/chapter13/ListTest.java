package chapter13;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * List 인터페이스
 */
public class ListTest {

	public static void main(String[] args) {//메인쓰레드가 작업 병력처리가능 독립적실행
		//제너릭을<>을 통해 데이터타입을 정의한 후 사용함!!
		List<Integer> list1 = new ArrayList<Integer>();
		List<String> list2 = new LinkedList<String>();
		List<Double> list3 = new Vector<Double>();
		
		
		//1. 데이터 저장 : C(create)
		list1.add(100);
		list1.add(200);
		list2.add("100");
		list2.add("홍길동");
		list3.add(1.23);
		list3.add(100.1234);
		
		
		//2. 데이터 출력 : R(read) size는 들어와있는거 기준 길이 count느낌
		for(int i=0;i<list1.size();i++) {
			System.out.println(list1.get(i));
		}
		//Iterable 알아서 순회한다. 배열에서는 forEach쓸수없다 Iterable을 상속받앗을때만 forEach를 쓸수있다.
		for(String str : list2) {
			System.out.println(str);
		}
		
		//forEach의 매개변수는 람다식 메소드 호출 방식을 갖는다.
		//() -> {}
		list3.forEach((dnum) ->{
			System.out.println(dnum);
		}); //Iterable을 꼭 상속해야한다
		
		list3.forEach(dnum ->System.out.println(dnum)); //Iterable을 꼭 상속해야한다
		
		
		list3.forEach(System.out::println);
		
		
		//3. 데이터 업데이트 : U(Update)
		list1.set(0, 1000);
		list2.set(0, "이순신");
		list3.set(0, 999.987);
		list1.forEach(System.out::println);
		list2.forEach(System.out::println);
		list3.forEach(System.out::println);
		
		//4. 데이터 삭제 : D(Delete)
		list1.remove(0);
		list2.remove(0);
		list3.remove(0);
		
		list1.forEach(System.out::println);
		list2.forEach(System.out::println);
		list3.forEach(System.out::println);
		
		
		//** 데이터 삭제시 인덱스 중복으로 인한 내부 에러 발생함!!
		//Iterable 인터페이스를 통한 삭제를 권장
		List<String> list4 = new ArrayList<String>();
		list4.add("java");       list4.add("mySql");
		list4.add("html");       list4.add("css");
		list4.add("java");       list4.add("css");
		
		list4.forEach(System.out::println);
		 
		
		System.out.println("------------------------------");
		Iterator<String> ie = list4.iterator();
		
		while(ie.hasNext()) {
			String element = ie.next();
			if(element.equals("html")) ie.remove();;
		}
		//iterator라는 주머니에서 해당과정을 처리후 기존 배열을 다시 그에맞게 iterator가 재배열에 들어간다
		list4.forEach(System.out::println);
		
		
		
		
		
	}

}
