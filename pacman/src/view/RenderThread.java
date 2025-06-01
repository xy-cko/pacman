package view;

import model.GameManager;


public class RenderThread extends Thread {
    GameView view;
    GameManager gameManager;
    public RenderThread(GameView gameView, GameManager gameManager) {
        this.view = gameView;
        this.gameManager = gameManager;
    }
    @Override
    public void run() {
        while (!GameManager.isGameEnded()) {
            view.updateScoreLabel();
            view.getMapView().repaint();
            view.getMapView().renderMap(view.getMapView().map);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        view.updateScoreLabel();
        view.getMapView().repaint();
        view.getMapView().renderMap(view.getMapView().map);

        if(gameManager.getPacman().getEatenDots() >= 226){
            WinWindow win = new WinWindow(view);
        } else {
            LoseWindow lose = new LoseWindow(view);
        }

        gameManager.endGame();
    }
}
