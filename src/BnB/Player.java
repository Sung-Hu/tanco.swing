package BnB;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends JLabel{

	Player player = new Player();
	
	private int x;
	private int y;
	private ImageIcon woonieB, woonieF, woonieL, woonieR;
	
	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;
	
	private final int SPEED = 4;
	private final int JUMPSPEED = 2;
	
	
	
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
	public ImageIcon getWoonieB() {
		return woonieB;
	}
	public void setWoonieB(ImageIcon woonieB) {
		this.woonieB = woonieB;
	}
	public ImageIcon getWoonieF() {
		return woonieF;
	}
	public void setWoonieF(ImageIcon woonieF) {
		this.woonieF = woonieF;
	}
	public ImageIcon getWoonieL() {
		return woonieL;
	}
	public void setWoonieL(ImageIcon woonieL) {
		this.woonieL = woonieL;
	}
	public ImageIcon getWoonieR() {
		return woonieR;
	}
	public void setWoonieR(ImageIcon woonieR) {
		this.woonieR = woonieR;
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
	public boolean isUp() {
		return up;
	}
	public void setUp(boolean up) {
		this.up = up;
	}
	public boolean isDown() {
		return down;
	}
	public void setDown(boolean down) {
		this.down = down;
	}
	public int getSPEED() {
		return SPEED;
	}
	public int getJUMPSPEED() {
		return JUMPSPEED;
	}
	public Player() {
		initData();
		setInitLayout();
	}
	private void initData() {
		woonieB = new ImageIcon("img/woonie_back.png");
		woonieF = new ImageIcon("img/woonie_front.png");
		woonieL = new ImageIcon("img/woonie_left.png");
		woonieR = new ImageIcon("img/woonie_right.png");
		
		left = false;
		right = false;
		up = false;
		down = false;
		
		x = 100;
		y = 500;
	}
	private void setInitLayout() {
		setIcon(woonieF);
		setSize(100, 100);
		setLocation(x, y);
		
	}
	public void left() {
		left = true;
		setIcon(woonieL);
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(left) {
					x = x + SPEED;
					setLocation(x, y);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} 
				}
			}
		}).start();
	}
	public void right() {
		right = true;
		setIcon(woonieR);
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(right) {
					x = x + SPEED;
					setLocation(x, y);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} 
				}
			}
		}).start();
	}
	public void up() {
		up = true;
		setIcon(woonieB);
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(up) {
					y = y - SPEED;
					setLocation(x, y);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} 
				}
			}
		}).start();
	}
	public void down() {
		down = true;
		setIcon(woonieF);
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(down) {
					y = y + SPEED;
					setLocation(x, y);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} 
				}
			}
		}).start();
	}
	public static void main(String[] args) {
		new Player();
	}
}// end of class
