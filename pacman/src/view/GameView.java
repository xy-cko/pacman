package view;
import controller.InputController;
import model.GameManager;
import model.Map;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class GameView extends JFrame {
    MapView mapView;
    RenderThread renderThread;
    JLabel timerLabel;
    JLabel scoreLabel;
    Timer timer;
    GameManager gameManager;


    public GameView(Map map, InputController inputController, GameManager gameManager) {


        super("Pac-man " + gameManager.getUserName());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1300, 800); // Set the size of the window
        setLocationRelativeTo(null);
        setResizable(false);
        addKeyListener(inputController);


        mapView = new MapView(map, gameManager);
        renderThread = new RenderThread(this, gameManager);
        this.gameManager = gameManager;



        setLayout(new BorderLayout());
        add(mapView, BorderLayout.SOUTH);

        timerLabel = new JLabel("Time: 00:00", SwingConstants.CENTER);
        timerLabel.setFont(new Font("Arial", Font.BOLD, 20));
        timerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        timerLabel.setVerticalAlignment(SwingConstants.NORTH);
        timerLabel.setForeground(Color.BLACK);
        add(timerLabel, BorderLayout.EAST);


        scoreLabel = new JLabel("Score:" + gameManager.getPacman().getEatenDots(), SwingConstants.CENTER);
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 20));
        scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        scoreLabel.setVerticalAlignment(SwingConstants.NORTH);
        scoreLabel.setForeground(Color.BLACK);
        add(scoreLabel, BorderLayout.WEST);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Game");
        JMenuItem save = new JMenuItem("Save");
        save.addActionListener(new ActionListener() {
            String filePath = "C:\\Users\\okoo1\\Desktop\\5th term\\programming 3\\homework\\pacman\\src\\files\\lastGame.txt";
            @Override
            public void actionPerformed(ActionEvent e) {
                try(FileOutputStream fileout = new FileOutputStream(filePath);
                    ObjectOutputStream objOut = new ObjectOutputStream(fileout)){

                    objOut.writeObject(gameManager);
                    objOut.close();
                    System.exit(0);
                } catch(IOException exception) {
                    exception.printStackTrace();
                }
            }
        });
        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menu.add(save);
        menu.add(exit);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        pack();
        initGameDurationTimer();
        renderThread.start();

        setVisible(true);
    }

    public void updateScoreLabel(){
        scoreLabel.setText("Score:" + gameManager.getPacman().getEatenDots());
    }

    private void initGameDurationTimer() {
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!GameManager.isGameEnded()) {
                    gameManager.getUser().setTime(gameManager.getUser().getTime() + 1);

                    timerLabel.setText("Time: " + formatTime(gameManager.getUser().getTime()));
                }
            }
        });

        timer.start();
    }

    private String formatTime(int totalSeconds) {
        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }
    public MapView getMapView() {
        return mapView;
    }
    public GameManager getGameManager() {
        return gameManager;
    }
}
