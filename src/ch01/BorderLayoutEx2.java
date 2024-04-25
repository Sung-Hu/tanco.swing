package ch01;

import java.awt.BorderLayout;
import java.awt.Button;
import java.security.PublicKey;

import javax.swing.JButton;
import javax.swing.JFrame;

//단축키 습관 ctrl + shift + s, f, o
public class BorderLayoutEx2 extends JFrame {

	JButton[] buttons;
	String[] directions = { BorderLayout.EAST, BorderLayout.WEST, BorderLayout.NORTH, BorderLayout.SOUTH,
			BorderLayout.CENTER };

	public BorderLayoutEx2() {
		initData();
		setInitLayout();
	}

	public void initData() {
		setTitle("borderLayout 연습");
		setSize(600, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		buttons = new JButton[5];
	}

	public void setInitLayout() {
		// 배치 관리자 선정 (컨테이너)
		// BorderLayout --- 컴포넌트들을 동서남북 가운데로 배치 시켜주는 레이아웃이다.
		setLayout(new BorderLayout());

		// 반복문을 활용해서 코드를 완성하세요
		for(int i = 0; i < 5; i++) {
			buttons[i] = new JButton("버튼" + i);
		}
		
		for(int i = 0; i < buttons.length; i++) {
			super.add(buttons[i], directions[i]);
		}
	}

	public static void main(String[] args) {
		new BorderLayoutEx2();
	}
}
