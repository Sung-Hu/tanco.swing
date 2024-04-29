package ch02;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

//내부 클래스를 활용해서 코드를 완성시켜주세요
public class PaintFrame extends JFrame {

	MYpaintFrame mypaintframe;

	public PaintFrame() {
		initData();
		setInitLayout();
	}

	private void initData() {
		setTitle("개굴");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mypaintframe = new MYpaintFrame();
	}

	private void setInitLayout() {
		add(mypaintframe);
		setVisible(true);
	}

	class MYpaintFrame extends JPanel {
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			g.drawOval(150, 150, 300, 300);
			g.drawOval(150, 150, 150, 150);
			g.drawOval(300, 150, 150, 150);
			g.drawOval(300, 350, 60, 15);
			g.setColor(Color.GREEN);
			g.fillOval(200, 250, 80, 15);
			g.fillOval(350, 250, 80, 15);
			g.drawOval(200, 250, 80, 15);
			g.drawOval(350, 250, 80, 15);
			g.setColor(Color.GRAY);
			g.drawRect(320, 350, 200, 15);
			g.drawRect(500, 350, 20, 15);
			g.drawString("💨", 510, 350);
			g.drawString("💨", 500, 340);
			g.drawString("💨", 510, 330);
			g.drawString("💨", 500, 320);
			g.drawString("💨", 510, 310);
			g.drawString("💨", 500, 300);
			g.drawString("💨", 510, 290);
			g.drawString("💨", 500, 280);
			g.drawString("💨", 510, 270);

		}
	}
}
