package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean wPrecionado, sPrecionado, aPrecionado, dPrecionado;

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            wPrecionado = true;
        }

        if (code == KeyEvent.VK_S) {
            sPrecionado = true;
        }

        if (code == KeyEvent.VK_A) {
            aPrecionado = true;
        }

        if (code == KeyEvent.VK_D) {
            dPrecionado = true;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            wPrecionado = false;
        }

        if (code == KeyEvent.VK_S) {
            sPrecionado = false;
        }

        if (code == KeyEvent.VK_A) {
            aPrecionado = false;
        }

        if (code == KeyEvent.VK_D) {
            dPrecionado = false;
        }

    }

}
