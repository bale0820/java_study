package chapter08;

public class ObjectTypeCastingTest {

	public static void main(String[] args) {
		Circle yellowC = new Circle("노랑",1);
		Rectangle blueR = new Rectangle("파랑", 1 , 2);
		Shape s = new Circle("초록색", 2); //자동(묵시적) 형변환 
		//자식안에 부모가 있기 때문에 부모에있는것만 엑세스할 수 있다. 전체적인 모습은 Circle지만 엑세스는 Shape만 가능 숨겨져있는거 뿐이다.
		Circle cs = (Circle)s; //강제(명시적) 형변환
//		Rectangle r = (Rectangle)s; //이것도 에러 : 생성된 같은 모습의 자식만 가능!!
		Circle s1 = new Circle("초록색1", 2);
		
		Shape s2 = new Shape("빨강"); //메모리할당은 크게만들수없다
//		Circle cs2 = (Circle)s2; //바꿀 수 없다 왜냐하면 s2에는 Circle이 없기 때문이다
		
		
		
		//인터페이스를 통해 자식의 모습으로 객체를 구현하는 것을 권장한다.
		ShapeInterface si = new Circle("코랄", 1);
		si.draw(); //자식인 Circle의 draw() 호출됨
		System.out.println(si.getArea());
		//이렇게 써야한다
		System.out.println();
		Circle cs3 = (Circle)si;
		cs3.draw();//자식인 Circle의 draw() 호출됨
		System.out.println(cs3.getArea());
		
		
		//상속받은 인터페이스 통한 객체 생성
		//사각형, 삼각형
		//이렇게 꼭 만들어야한다
		ShapeInterface si2 = new Rectangle("초록",1,2);
		ShapeInterface si3 = new Triangle("노랑");
		(추상메소드)  -- 다형성 구현 -- (상속받아 오버라이딩)
		
		si2.draw();
		si3.draw();
		
		
		
		
		
		cs.draw();
//		cs2.draw();
		
		
		
		yellowC.draw();
		blueR.draw();
//		s.draw(); //Shape 클래스는 draw() 메소드를 정의하지 않음
		System.out.println(s.color); //부모의 타입으로 만들어졌으니까 바로 접근 가능
		
//		ShapeInterface e = new Circle("파랑색", 2);
	}

}
