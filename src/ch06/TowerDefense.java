package ch06;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class TowerDefense extends JFrame {
    private static final int FRAME_WIDTH = 800;
    private static final int FRAME_HEIGHT = 600;
    private static final int ENEMY_SIZE = 30;
    private static final int TOWER_SIZE = 30;
    private static final int TOWER_RANGE = 100;
    private static final int ENEMY_SPEED = 2;
    private static final int ENEMY_SPAWN_INTERVAL = 1000;

    private ArrayList<Enemy> enemies;
    private ArrayList<Tower> towers;

    public TowerDefense() {
        setTitle("Tower Defense");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        enemies = new ArrayList<>();
        towers = new ArrayList<>();

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                towers.add(new Tower(e.getX(), e.getY()));
            }
        });

        Timer enemyTimer = new Timer();
        enemyTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                spawnEnemy();
            }
        }, 0, ENEMY_SPAWN_INTERVAL);

        Timer gameTimer = new Timer();
        gameTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                moveEnemies();
                checkCollisions();
                repaint();
            }
        }, 0, 10);
    }

    private void spawnEnemy() {
        enemies.add(new Enemy(FRAME_WIDTH, (int) (Math.random() * (FRAME_HEIGHT - ENEMY_SIZE))));
    }

    private void moveEnemies() {
        for (Enemy enemy : enemies) {
            enemy.move();
        }
    }

    private void checkCollisions() {
        for (Tower tower : towers) {
            for (Enemy enemy : enemies) {
                if (tower.inRange(enemy)) {
                    enemy.hit();
                }
            }
        }
        enemies.removeIf(Enemy::isDead);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (Enemy enemy : enemies) {
            enemy.draw(g);
        }
        for (Tower tower : towers) {
            tower.draw(g);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TowerDefense game = new TowerDefense();
            game.setVisible(true);
        });
    }

    private class Enemy {
        private int x;
        private int y;
        private int health;

        public Enemy(int x, int y) {
            this.x = x;
            this.y = y;
            health = 100;
        }

        public void move() {
            x -= ENEMY_SPEED;
        }

        public void hit() {
            health -= 10;
        }

        public boolean isDead() {
            return health <= 0;
        }

        public void draw(Graphics g) {
            g.setColor(Color.RED);
            g.fillRect(x, y, ENEMY_SIZE, ENEMY_SIZE);
        }
    }

    private class Tower {
        private int x;
        private int y;

        public Tower(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean inRange(Enemy enemy) {
            return Math.sqrt(Math.pow(enemy.x - x, 2) + Math.pow(enemy.y - y, 2)) <= TOWER_RANGE;
        }

        public void draw(Graphics g) {
            g.setColor(Color.BLUE);
            g.fillRect(x, y, TOWER_SIZE, TOWER_SIZE);
        }
    }
}