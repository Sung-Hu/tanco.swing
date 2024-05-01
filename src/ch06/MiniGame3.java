package ch06;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class MiniGame3 extends JFrame {

	private static final int ATTACK_HEIGHT = 0;
	private JLabel jPlayer;
	private JLabel backgroundImage;
	private JLabel attact;
	private final int MOVE_DISTANCE = 50;
	private final int FRAME_WIDTH = 1100;
	private final int FRAME_HEIGHT = 800;
	private final int PLAYER_WIDTH = 100;
	private final int PLAYER_HEIGHT = 100;
	private int jPlayerX = 100;
	private int jPlayerY = 100;
	private final String[] playerImages = { "images/playerR.png", "images/playerL.png",

			// 추가 이미지 경로를 여기에 계속 추가합니다.
	};
	private int currentImageIndex = 0;
	private JLabel attack;

	public MiniGame3() {
		initData();
		setINitLayout();
		addEventListener();
	}

	private void initData() {
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		jPlayer = new JLabel();
		jPlayer.setSize(PLAYER_WIDTH, PLAYER_HEIGHT);

		ImageIcon backgroundIcon = new ImageIcon("images/backgroundMap.png");
		backgroundImage = new JLabel(backgroundIcon);
		backgroundImage.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		backgroundImage.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT); // 배경 이미지의 위치와 크기 설정
		add(backgroundImage);

		ImageIcon playerIcon = new ImageIcon(playerImages[currentImageIndex]);
		jPlayer = new JLabel(playerIcon);
		jPlayer.setSize(PLAYER_WIDTH, PLAYER_HEIGHT);
		jPlayer.setLocation(jPlayerX, jPlayerY);
		backgroundImage.add(jPlayer);

		ImageIcon bubble = new ImageIcon("images/bubble.pug");
	    attack = new JLabel(bubble);
	    attack.setSize(50, 50); // 공격 이미지의 크기 설정
	    attack.setVisible(false); // 초기에는 보이지 않도록 설정
	    backgroundImage.add(attack); // 배경 이미지에 attack 추가
	}

	private void setINitLayout() {
		// 좌표 기반으로 배치 관리자 변경
		setLayout(null);
		setVisible(true);
	}

	private void addEventListener() {
		this.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_UP:
					jPlayerY -= MOVE_DISTANCE;
					jPlayer.setLocation(jPlayerX, jPlayerY);
					break;
				case KeyEvent.VK_LEFT:
					jPlayerX -= MOVE_DISTANCE;
					jPlayer.setIcon(new ImageIcon("images/playerL.png"));
					jPlayer.setLocation(jPlayerX, jPlayerY);
					break;
				case KeyEvent.VK_RIGHT:
					jPlayerX += MOVE_DISTANCE;
					jPlayer.setIcon(new ImageIcon("images/playerR.png"));
					jPlayer.setLocation(jPlayerX, jPlayerY);
					break;
				case KeyEvent.VK_DOWN:
					jPlayerY += MOVE_DISTANCE;
					jPlayer.setLocation(jPlayerX, jPlayerY);
					break;
				case KeyEvent.VK_SPACE:
					attack.setIcon(new ImageIcon("images/bubble.png"));
					attack();
					break;

				}
			}
		});
	}

	private void attack() {
		int attackX = jPlayerX + jPlayer.getWidth();
		int attackY = jPlayerY + (jPlayer.getHeight() / 2) - (ATTACK_HEIGHT / 2);
		attack.setLocation(attackX, attackY);
		attack.setVisible(true);
	
    Timer timer = new Timer(20, new ActionListener() {
        int distance = 0;

        @Override
        public void actionPerformed(ActionEvent e) {
            distance += 10; // 이동 속도
            attack.setLocation(attackX + distance, attackY);
            if (distance >= 300) { // x축으로 300 이동 후에는 공격 숨김
                attack.setVisible(false);
                ((Timer) e.getSource()).stop(); // 타이머 정지
            }
        }
    });
    timer.start();
}

	// 코드테스트
	public static void main(String[] args) {
		new MiniGame3();
	}
}