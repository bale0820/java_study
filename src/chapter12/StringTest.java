package chapter12;

public class StringTest {

	public static void main(String[] args) {
		String name1 = "홍길동";
		String name2 = new String("홍길동");
		String num = String.valueOf(123);
		name2 = "wel-comeToJava!!";
		
		String phone = "010-6234-1263";
		String subject = "java,css,html,mysql";
		String[] phones = phone.split("-");
		String[] subjects = subject.split(",");
		
		String jphone = String.join("-" ,phones);
		
		
		
		
		
		System.out.println(subject.contains("html")); //true
		System.out.println(jphone); 
		System.out.println(subjects[0]); 
		System.out.println(phones[0]); 
		
		System.out.println(phones[0]); 
		System.out.println(name2.substring(7,10)); 
		System.out.println(name2.substring(7)); 
		System.out.println(name2.length()); //문자하나하나를 배열로 만들어서 출력한다. 
		System.out.println(name2.toUpperCase());
		System.out.println(name2.toLowerCase());
		
		System.out.println(num+10);
		
		
		System.out.println(name1.hashCode()); //원래는 같아야하지만 서로다른 객체라서 해쉬값이 달라진다.
		System.out.println(name2.hashCode());
		
		System.out.println(System.identityHashCode(name1));
		System.out.println(System.identityHashCode(name2));
		if(name1 == name2 ) System.out.println("true"); //값과 주소비교
		else System.out.println("false");
		
		if(name1.equals(name2) ) System.out.println("true"); 
		else System.out.println("false");
	}

}
