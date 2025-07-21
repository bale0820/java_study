package mytest2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server1 {
	public static final int PORT = 9090;
	public static List<ServerHandler> list = new ArrayList<>();
	public static void main(String[] args) {

		try {
			ServerSocket sc = new ServerSocket(PORT);
			while(true) {
			System.out.println("서버 대기중");
			Socket io = sc.accept();
			System.out.println("클라이언트 접속");
			DataOutputStream output = new DataOutputStream(io.getOutputStream());
			DataInputStream input = new DataInputStream(io.getInputStream());
			output.writeUTF("안녕하세요");
			ServerHandler ch = new ServerHandler(output, input);
			list.add(ch);
			ch.start();
			
			}
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}

class ServerHandler extends Thread {
	DataOutputStream output;
	DataInputStream input;
	
	public ServerHandler(DataOutputStream output, DataInputStream input) {
		this.output = output;
		this.input = input;
	}
	
	public void run() {
		boolean flag = true;
		while(true) {
			try {
				String s = input.readUTF();
				if(s.equals("exit")) {
					flag = false;
				}else {
					Server1.list.forEach(ch -> {
						try {
						ch.output.writeUTF(s);
						}catch(Exception e) {
							e.printStackTrace();
						}
						
						
					});
					
					System.out.println("받고 다시돌려보냄");	
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
