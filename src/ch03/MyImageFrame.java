package ch03;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * 중첩 클래스 --> 외부, 내부 클래스로 -->내부 클래스로 --> 인스턴스 클래스, static 클래스
 */
public class MyImageFrame extends JFrame {

	// 내부 클래스로 정의한 데이터 타입 이다.
	private MyImagePanel myImagePanel;

	public MyImageFrame() {
		initData();
		setInitLayout();
	}

	private void initData() {
		setTitle("이미지활용 연습");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		myImagePanel = new MyImagePanel();
	}

	private void setInitLayout() {
		add(myImagePanel);
		setVisible(true);
		

	Timer timer = new Timer(100, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            myImagePanel.repaint();
        }
    });
    timer.start();
}

	// 내부 클래스 --> static 키워드 활용
	// 정적(static) 내부 클래스라고 한다.
	static class MyImagePanel extends JPanel {
		private Image image;
		private Image image2;
		private Image image3;
		private Image image4;

		public MyImagePanel() {
			// ImageIcon 데이터 타입 안에 getImage 라는 메서드를 호출하면
			// image 데이터 타입을 만들어 낼 수 있다.
			image = new ImageIcon("1.png").getImage();
			image2 = new ImageIcon("2.png").getImage();
			image3 = new ImageIcon("3.gif").getImage();
			image4 = new ImageIcon("4.gif").getImage();
		}

		// paints --> x
		// print --> x
		// paint --> o
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			g.drawImage(image, 100, 100, 200, 100, null);
			g.drawImage(image2, 200, 200, 200, 100, null);
			g.drawImage(image3, 300, 300, 200, 100, null);
			g.drawImage(image4, 400, 100, 200, 100, null);
		}

	}

}
