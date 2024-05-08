package bubble.test.ex07.upgrade;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Monster extends JLabel {

	private int x;
	private int y;
	private ImageIcon enemyR, enemyL;
	// 방향
	private boolean left;
	private boolean right;
	// 속도
	private int XSPEED = -1;
	private final int YSPEED = 1;
	private boolean flag = true;

	public Monster() {
		initData();
		setInitLayout();
		right();

	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public ImageIcon getEnemyR() {
		return enemyR;
	}

	public void setEnemyR(ImageIcon enemyR) {
		this.enemyR = enemyR;
	}

	public ImageIcon getEnemyL() {
		return enemyL;
	}

	public void setEnemyL(ImageIcon enemyL) {
		this.enemyL = enemyL;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public int getSPEED() {
		return XSPEED;
	}

	public int getJUMPSPEED() {
		return YSPEED;
	}

	private void initData() {
		enemyL = new ImageIcon("img/enemyL.png");
		enemyR = new ImageIcon("img/enemyR.png");

		x = 350;
		y = 180;

		left = true;
		right = true;

	}

	private void setInitLayout() {
		setIcon(enemyL);
		setSize(50, 50);
		setLocation(x, y);
	}

	public void left() {

	}

	public void right() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				int speed = 1;
				while (flag) {
					// x += XSPEED;

					x += XSPEED;
					setLocation(x, y);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (x == 200) {
						setIcon(enemyR);
						XSPEED = 1;
					}
					if (x == 750) {
						setIcon(enemyL);
						XSPEED = -1;
					}

					
					
					
				}
			}
		}).start();

		// boolean flag2 = true;

	}

	// setIcon(enemyR);
	// for (int i = 0; i < 300; i++) {
	// x--;
	// setLocation(x, y);

	// }
	// setIcon(enemyL);
	// for (int i = 0; i < 200; i++) {
	// x--;
	// setLocation(x, y);

}// end of class