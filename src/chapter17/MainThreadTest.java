package chapter17;

public class MainThreadTest {

	public static void main(String[] args) { //mainThread 메인메소드실행시 생성과동시에실행
		//1~10 정수 출력
		for(int i=0;i<=10;i++) {
			System.out.println(i);
		}
		
		
		ThreadExtend te = new ThreadExtend(); //te Thread : 독립적 실행 - 각자 실행 후 종료
		te.start();// 쓰레드는 메인스레드에 간섭을 받지않는다 main쓰레드가 먼저 종료
		
		Thread t = new Thread(new RunnableImpl()); //t Thread : 독립적 실행 - 각자 실행 후 종료 
		//둘중 어느게 실행될지는 jvm이 알아서
		t.start();
		
		System.out.println("-- main 메소드 종료 --"); //mainThread 종료
		
		
	}

}
