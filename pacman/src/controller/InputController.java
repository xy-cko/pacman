package controller;

import model.Cell;
import model.Direction;
import model.GameManager;
import view.GameView;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class InputController implements KeyListener {
    GameManager gameManager;
    public InputController(GameManager gameManager) {
        this.gameManager = gameManager;

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_UP:
                gameManager.getPacman().changeDirection(Direction.UP);
                break;
            case KeyEvent.VK_DOWN:
                gameManager.getPacman().changeDirection(Direction.DOWN);
                break;
            case KeyEvent.VK_LEFT:
                gameManager.getPacman().changeDirection(Direction.LEFT);
                break;
            case KeyEvent.VK_RIGHT:
                gameManager.getPacman().changeDirection(Direction.RIGHT);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {}
}
