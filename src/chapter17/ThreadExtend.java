package chapter17;

public class ThreadExtend extends Thread {
	
	public ThreadExtend() {
		super("쓰레드1");
		
		
	}
	
	
	//메인메소드는 jvm
	//스레드는 스레드풀에서
	@Override
	public void run() {
		//1~10 까지 출력을 해주세요
		for(int i=0;i<=10;i++) {
			try {sleep(1000);//1초쉬면서 내려가고 그자리에 다음 스레드가 올라온다 스레드는 공백이있을 수 없다
			System.out.println(getName() + "----->"+i);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
