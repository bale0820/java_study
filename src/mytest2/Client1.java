package mytest2;

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

public class Client1 {
	public static final int PORT = 9090;

	public static void main(String[] args) {
		String s = "localHost";
		try {
			Frame f = new Frame();
			Panel p = new Panel();
			f.setLayout(new BorderLayout());
			TextArea ta = new TextArea();
			TextField tf = new TextField(40);
			Button button = new Button("전송");
			Button button1 = new Button("종료");
			ta.setEditable(false);
			p.add(tf);
			p.add(button);

			f.add(ta, new BorderLayout().CENTER);
			f.add(button1, new BorderLayout().SOUTH);
			f.add(p, new BorderLayout().NORTH);
			f.setVisible(true);
			f.setSize(400, 500);
			Socket sk = new Socket(s, PORT);
			DataInputStream input = new DataInputStream(sk.getInputStream());
			DataOutputStream output = new DataOutputStream(sk.getOutputStream());
			clientHandler ch = new clientHandler(input, ta);
			ch.start();
			
			
			
			
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					try {
					output.writeUTF(tf.getText());
					System.out.println("클라이언트 메세지전송완료");
					}catch(Exception e1) {
						e1.printStackTrace();
					}
				}
			});
	
					
			button1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
					output.writeUTF("exit");
					System.exit(0);
					} catch(Exception e1) {
						e1.printStackTrace();
					}
				}
			});
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

class clientHandler extends Thread {
	DataInputStream input;
	TextArea ta;

	public clientHandler(DataInputStream input, TextArea ta) {
		this.input = input;
		this.ta = ta;
	}

	public void run() {

		try {
			while (true) {
				ta.append(input.readUTF()+"\n");
				System.out.println("텍스트에어리어에 출력완료");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
