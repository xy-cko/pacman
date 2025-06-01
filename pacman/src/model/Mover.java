package model;

import java.io.Serializable;
import java.util.List;

public class Mover extends Thread implements Serializable {
    Pacman pacman;
    List<Ghost> ghosts;
    public Mover(Pacman pacman, List<Ghost> ghosts) {
        this.pacman = pacman;
        this.ghosts = ghosts;
    }
    @Override
    public void run() {

        while(!GameManager.isGameEnded()) {
            pacman.move();
            for (Ghost ghost : ghosts) {
                ghost.calculateDistance();
                ghost.move();
            }
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
