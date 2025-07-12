package chapter07;

public class Student {
//	<<물리적 설계>>
//	[클래스명 : 학생]
//	Field : name:String, kor:int, eng:int, math:int
//	constructor : Student()
//	Method :
	
	String name;
	int kor,eng,math;
	
//	int tot = kor+eng+math;
//	int avg = tot/3;
//	
	
	
	
	
	public Student(){
		
	}
	
	//Method
	public int getTot() {
		return kor+eng+math;
	}
	
	public int getAvg() {
		return (kor+eng+math)/3;
	}
	
	

}
