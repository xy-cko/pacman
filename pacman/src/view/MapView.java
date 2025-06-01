package view;

import model.GameManager;
import model.Map;

import javax.swing.*;
import java.awt.*;


public class MapView extends JPanel {
    Map map;
    JLabel[][] labels;
    GameManager gameManager;
    public MapView(Map map, GameManager gameManager) {
        this.map = map;
        this.gameManager = gameManager;
        labels = new JLabel[map.getHeight()][map.getWidth()];
        for(int i = 0; i < map.getHeight(); i++) {
            for(int j = 0; j < map.getWidth(); j++) {
                labels[i][j] = new JLabel();
                labels[i][j].setOpaque(true);
                labels[i][j].setPreferredSize(new Dimension(25, 25));
                add(labels[i][j]);
            }
        }
        setLayout(new GridLayout(map.getHeight(), map.getWidth(), 1, 1));
        setPreferredSize(new Dimension(1300, 800));
    }

    public Map getMap() {
        return map;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

    }
    public void renderMap(Map map){
        for(int i = 0; i < map.getHeight(); i++){
            for(int j = 0 ; j < map.getWidth(); j++){
                if(map.getSingleCell(i, j).isWalkable()){
                    labels[i][j].setBackground(Color.BLACK);
                }  else {
                    labels[i][j].setBackground(Color.BLUE);
                }
                if(map.getSingleCell(i,j).isGhostOn()){
                    ImageIcon originalGhost = new ImageIcon("C:\\Users\\okoo1\\Desktop\\5th term\\programming 3\\homework\\pacman\\src\\images\\ghost.png");
                    ImageIcon scaledGhost = new ImageIcon(originalGhost.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
                    labels[i][j].setIcon(scaledGhost);
                    labels[i][j].setHorizontalAlignment(JLabel.CENTER);
                    labels[i][j].setVerticalAlignment(JLabel.CENTER);
                }
                if (map.getSingleCell(i,j).isPacmanOn()){
                    ImageIcon originalPacman;
                    ImageIcon scaledPacman;
                    if(gameManager.getPacman().isAlive()) {
                        originalPacman = new ImageIcon("C:\\Users\\okoo1\\Desktop\\5th term\\programming 3\\homework\\pacman\\src\\images\\pacman.png");
                        scaledPacman = new ImageIcon(originalPacman.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
                    } else {
                        originalPacman = new ImageIcon("C:\\Users\\okoo1\\Desktop\\5th term\\programming 3\\homework\\pacman\\src\\images\\died.png");
                        scaledPacman = new ImageIcon(originalPacman.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
                    }
                    labels[i][j].setIcon(scaledPacman);
                    labels[i][j].setHorizontalAlignment(JLabel.CENTER);
                    labels[i][j].setVerticalAlignment(JLabel.CENTER);
                }
                if(!map.getSingleCell(i,j).isPacmanOn() && !map.getSingleCell(i,j).isGhostOn()){
                    if(!map.getSingleCell(i,j).isDotOn()) {
                        labels[i][j].setIcon(null);
                    }
                    if(map.getSingleCell(i,j).isDotOn()){
                        ImageIcon originalDot = new ImageIcon("C:\\Users\\okoo1\\Desktop\\5th term\\programming 3\\homework\\pacman\\src\\images\\dot.png");
                        ImageIcon scaledDot = new ImageIcon(originalDot.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
                        labels[i][j].setIcon(scaledDot);
                        labels[i][j].setHorizontalAlignment(JLabel.CENTER);
                        labels[i][j].setVerticalAlignment(JLabel.CENTER);
                    }
                }
            }
        }

    }
}
