package main;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {

    final int originalSize = 16;// Tamanho original de pixels=16
    final int scale = 3;// scala de pixels
    final int tileSize = originalSize * scale;// Tamanho de pixels modificado com a scala=48
    final int maxScreenCol = 27;// coluna horizontal em pixels
    final int maxScreenRow = 23;// coluna vertical em pixels
    final int screenWidth = tileSize * maxScreenCol;// Largura da tela
    final int screenHeight = tileSize * maxScreenRow;// Altura da tela

    Thread gameThread;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLUE);
        this.setDoubleBuffered(true);

    }

    public void startGameThreads() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

    }
}
