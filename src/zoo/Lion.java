package zoo;
/**
 * Animal 클래스를 상속받은 자식 클래스 정의
 */
public class Lion extends Animal {
	int a1 = 1;
	public Lion() {
		this("삼바", 5);
	}
	public Lion(String name, int age) {
		super(name, age);
		
	}
}
