package myTest;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Client {
	public static final String HOST = "localHost";
	public static final int PORT = 9000;
	
	public static void main(String[] args) {
		try {
			Frame f = new Frame("채팅 클라이언트");
			f.setSize(400, 500);
			f.setLayout(new BorderLayout());
			
			Panel p = new Panel();
			TextArea ta = new TextArea();
			ta.setEditable(false);
			TextField tf = new TextField(40);
			Button button = new Button("전송");
			Button button1 = new Button("종료");
			p.add(tf);
			p.add(button);
			
			f.add(p, BorderLayout.NORTH);
			f.add(ta, BorderLayout.CENTER);
			f.add(button1, BorderLayout.SOUTH);
			f.setVisible(true);
			
			
		Socket sk = new Socket(HOST,PORT);
		DataInputStream input = new DataInputStream(sk.getInputStream());
		DataOutputStream output = new DataOutputStream(sk.getOutputStream());
		new ServiceThread(input,ta).start();
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					output.writeUTF(tf.getText());
					System.out.println("버튼 클릭");
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	
		
	}

}


class ServiceThread extends Thread {
	DataInputStream input;
	TextArea ta;
	public ServiceThread(DataInputStream input, TextArea ta) {
		try {
		this.ta = ta;
		this.input = input;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void run() {
		try {
		while(true) {
		ta.append(input.readUTF());
		System.out.println("메세지를 클라이언트에서 받음");
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
