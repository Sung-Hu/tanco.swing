package ch06;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MiniGame1 extends JFrame {

	private JLabel jPlayer;
	// 변수는 변하는 수 이기도 하다.
	private int jPlayerX = 100;
	private int jPlayerY = 100;
	private final int MOVE_DISTANCE = 50;
	private final int FRAME_WIDTH = 500;
	private final int FRAME_HEIGHT = 500;
	private final String PLAYER_NAME = "야스오";
	private final int PLAYER_WIDTH = 100;
	private final int PLAYER_HEIGHT = 100;

	public MiniGame1() {
		initData();
		setINitLayout();
		addEventListener();
	}

	private void initData() {
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jPlayer = new JLabel(PLAYER_NAME);
		jPlayer.setSize(PLAYER_WIDTH, PLAYER_HEIGHT);
		
	}

	private void setINitLayout() {
		// 좌표 기반으로 배치 관리자 변경
		setLayout(null);
		add(jPlayer);
		jPlayer.setLocation(jPlayerX, jPlayerY);
		setVisible(true);
	}

	private void addEventListener() {
		// jPlayer 객체에게서만 keyListener 동작을 시키고자 한다면
		// 익명 구현 클래스로 KeyListener 인터페이스를 재 정의 할 수 있다.
		// jPlayer.addKeyListener(this);
		
		this.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_UP) {
					System.out.println("위");
					// 변수는 변하는 수 이기도 하다.
					//jPlayerY = jPlayerY - 10;
					jPlayerY -= MOVE_DISTANCE;
					
				} else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					System.out.println("왼쪽");
					jPlayerX -= MOVE_DISTANCE;
				}
				else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
					System.out.println("오른쪽");
					jPlayerX += MOVE_DISTANCE;
				}
				else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
					System.out.println("아래");
					jPlayerY += MOVE_DISTANCE;
				}
				jPlayer.setLocation(jPlayerX, jPlayerY);
			}
		});

	}

	// 코드테스트
	public static void main(String[] args) {

		new MiniGame1();

	}

}
