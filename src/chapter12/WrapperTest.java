package chapter12;

public class WrapperTest {

	public static void main(String[] args) {
		int num1 = 100;
		Integer num2 = new Integer(num1); //이 줄은 사라질수도있다고 표시하는거임 Deprecated예정
		Integer num3 = Integer.valueOf(num1); //권장
		int num4 = Integer.parseInt("123");
		double dnum = Double.valueOf("123.60"); //자동 형변환
		
		
		
		
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num3);
		System.out.println(num4);
		System.out.println(dnum);
	}

}
