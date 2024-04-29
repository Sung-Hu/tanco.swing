package ch05;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ColorClick extends JFrame implements ActionListener {
	private JPanel panel;
	private JPanel buttonPanel;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JLabel img;

	public ColorClick() {
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
		buttonPanel = new JPanel();
		button1 = new JButton("click1");
		button2 = new JButton("click2");
		button3 = new JButton("click3");
	}

	private void setInitLayout() {
		buttonPanel.add(button1);
		buttonPanel.add(button2);
		buttonPanel.add(button3);
		add(buttonPanel, BorderLayout.SOUTH);
		add(panel, BorderLayout.CENTER);
		setVisible(true);
	}

	private void addEventListener() {
		button1.addActionListener(this);

		button2.addActionListener(this);

		button3.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(button1)) {
			System.out.println(button1);
			panel.setBackground(Color.BLACK);
		}
		if (e.getSource().equals(button2)) {
			System.out.println(button2);
			panel.setBackground(Color.BLUE);
		}
		if (e.getSource().equals(button3)) {
			System.out.println(button3);
			panel.setBackground(Color.GREEN);
		}

	}

	public static void main(String[] args) {
		new ColorClick();
	}

}
