package chapter10;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button1 {

	public static void main(String[] args) {
		Frame f = new Frame();
		Panel p = new Panel();
		f.setLayout(new BorderLayout());
		Button btnClick = new Button("Button1");
		p.add(btnClick);
		
		f.add(p, BorderLayout.NORTH);
		f.setTitle("버튼 테스트");
		f.setSize(300, 400);
		f.setVisible(true);
		
		
//		btnClick.addActionListener(new Button1.ButtonListener());
		
//		btnClick.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				System.out.println("클릭!!!");
//			}
//		});
		
		btnClick.addActionListener((e) ->{System.out.println("클릭!!!");});
		
		
		
	}
	
	public static class ButtonListener implements ActionListener {
		 public void actionPerformed(ActionEvent e) {
			 System.out.println("클릭!!!");
			 System.out.println("클릭!!!");
		 }
	}

}
