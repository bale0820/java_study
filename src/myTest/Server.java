package myTest;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static final int PORT = 9000;

	public static void main(String[] args) {

		try {
			ServerSocket ss = new ServerSocket(PORT);
			System.out.println("서버 대기중" + PORT);

			while (true) {
				Socket sk = ss.accept();
				System.out.println("클라이언트 접속!");
				new ClientHandler(sk).start();

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

class ClientHandler extends Thread {
	DataOutputStream output;
	DataInputStream input;
	Socket sk;

	public ClientHandler(Socket sk) {
		try {
			this.sk = sk;
			this.output = new DataOutputStream(sk.getOutputStream());
			this.input = new DataInputStream(sk.getInputStream());
			output.writeUTF("환영합니다");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run() {
		try {
		while(true) {
			System.out.println("메세지 들어옴");
		String receivedMsg = input.readUTF();
		output.writeUTF("[반응]"+receivedMsg);
		}
		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
