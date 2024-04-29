package ch05;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ColorChangeFrame2 extends JFrame implements ActionListener {

	private JPanel panel;
	private JButton button1;
	private JButton button2;

	public ColorChangeFrame2() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		panel = new JPanel();
		panel.setBackground(Color.yellow);
		button1 = new JButton("click1");
		button2 = new JButton("click2");
	}

	private void setInitLayout() {
		add(button1, BorderLayout.NORTH);
		add(button2, BorderLayout.SOUTH);
		add(panel, BorderLayout.CENTER);
		setVisible(true);
	}

//이 메서드에 책임은 이벤트리스너만 등록
	private void addEventListener() {
		button1.addActionListener(this);

		button2.addActionListener(this);
//		// 이벤트 리스너를 구현하는 두번째 방법
//		button1.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.out.println("button1 이 눌러 졌어요.");
//			}
//		});
	}

//이벤트가 일어나면 호출 되어지는 메서드
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(button1)){
			System.out.println(button1);
			panel.setBackground(Color.BLACK);
		}if(e.getSource().equals(button2)) {
		System.out.println(button2);
		panel.setBackground(Color.BLUE);
	}
	}

	public static void main(String[] args) {
		new ColorChangeFrame2();
	}

}
