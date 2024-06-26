package bubble.test.ex02;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BubbleFrame extends JFrame {

    private JLabel backgroundMap;
    private Player player;

    public BubbleFrame() {
        initData();
        setInitLayout();
        addEventListener();
        
        // Player 백그라운드 서비스 시작
        
    }

    private void initData() {
    	// todo 이미지 변경
//        backgroundMap = new JLabel(new ImageIcon("img/backgroundMapService.png"));
        backgroundMap = new JLabel(new ImageIcon("img/test.png"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Frame --> root Panel
        setContentPane(backgroundMap);
        setSize(1000, 640);

        player = new Player();
    }

    private void setInitLayout() {
        // 좌표 값으로 배치
        setLayout(null);
        setResizable(false); // 프레임 조절 불가
        setLocationRelativeTo(null); // JFrame 여러분 모니터 가운데 자동 배치
        setVisible(true);

        add(player);

    }

    private void addEventListener() {
        this.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
               
            	System.out.println("key code : " + e.getKeyCode());

                switch (e.getKeyCode()) {

                case KeyEvent.VK_LEFT:
                    player.left();
                    break;
                case KeyEvent.VK_RIGHT:
                    // 구현
                	player.right();
                    break;
                case KeyEvent.VK_UP:
                    // 구현
                	player.up();
                    break;
                case KeyEvent.VK_DOWN:
                	player.down();
                	break;

                }

            } // end of KeyPressed
            
            @Override
            public void keyReleased(KeyEvent e) {
            	
            	switch (e.getKeyCode()) {

                case KeyEvent.VK_LEFT:
                    player.setLeft(false);
                    break;
                    
                case KeyEvent.VK_RIGHT:
                    // 구현
                	player.setRight(false);
                    break;
                }
            	
            	
            }//end of keyReleased
            
        });

    }
    
    public static void main(String[] args) {
		new BubbleFrame();
	}
}
