package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {

    // Scala e dimensão dos pixels
    // ##########################################################################################
    final int originalSize = 16;// Tamanho original
    final int scale = 3;// Escala de pixels
    final int tileSize = originalSize * scale;// Pixels modificado com a escala(16*3=48px)
    final int maxScreenCol = 27;// coluna horizontal
    final int maxScreenRow = 23;// coluna vertical
    final int screenWidth = tileSize * maxScreenCol;// Largura da tela
    final int screenHeight = tileSize * maxScreenRow;// Altura da tela
    // ##########################################################################################

    KeyHandler keyHandler = new KeyHandler(); // Atributo do tipo KeyHandler, utilizado para determinar a interação e
                                              // qual botão foi usado
    Thread gameThread;

    // variavel de locomoção do player(default position)
    int playerX = 100; // position X
    int playerY = 100; // position Y
    int playerSpeed = 4; // quantidade de pixels que o player ira andar

    int FPS = 60;// FPS

    // construtor
    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));// determina a dimensão do painel
        this.setBackground(Color.BLACK);// cor do painel
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
    }

    public void startGameThreads() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while (gameThread != null) {

            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
                drawCount++;
            }

            if (timer >= 1000000000) {
                System.out.println("FPS:" + drawCount);
                timer = 0;
                drawCount = 0;
            }
        }
    }

    public void update() {

        if (keyHandler.wPrecionado == true) {
            playerY -= playerSpeed;
        }

        else if (keyHandler.sPrecionado == true) {
            playerY += playerSpeed;
        }

        else if (keyHandler.aPrecionado == true) {
            playerX -= playerSpeed;
        }

        else if (keyHandler.dPrecionado == true) {
            playerX += playerSpeed;
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.white);
        g2.fillRect(playerX, playerY, tileSize, tileSize);
        g2.dispose();
    }
}
