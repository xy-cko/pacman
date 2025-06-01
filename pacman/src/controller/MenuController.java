package controller;

import model.GameManager;
import view.GameView;
import view.MenuView;
import view.RecordsView;
import view.UserNameWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class MenuController {
    MenuView view;
    public MenuController(MenuView view) {
        this.view = view;

        view.getNewGame().addActionListener(new MenuButtonListener());
        view.getQuit().addActionListener(new MenuButtonListener());
        view.getRecords().addActionListener(new MenuButtonListener());
        view.getContinueLast().addActionListener(new MenuButtonListener());
    }
    private class MenuButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton pressedButton = (JButton) e.getSource();
            if (pressedButton == view.getQuit()) {
                System.exit(0);
            } else if (pressedButton == view.getContinueLast()) {
                String filePath = "C:\\Users\\okoo1\\Desktop\\5th term\\programming 3\\homework\\pacman\\src\\files\\lastGame.txt";
                File file = new File(filePath);
                if(file.length() == 0){
                    JDialog dialog = new JDialog();
                    dialog.setSize(200, 100);
                    dialog.setModal(true);
                    dialog.setLocationRelativeTo(null);
                    dialog.setTitle("error");
                    dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

                    JLabel label = new JLabel("the file is empty!");
                    label.setHorizontalAlignment(SwingConstants.CENTER);
                    dialog.add(label);
                    dialog.setVisible(true);
                } else {
                    try (FileInputStream fileIn = new FileInputStream(filePath);
                         ObjectInputStream objIn = new ObjectInputStream(fileIn)) {
                        GameManager gameManager = (GameManager) objIn.readObject();
                        gameManager.getPacman().setAlive(true);
                        gameManager.getMover().start();
                        InputController inputController = new InputController(gameManager);
                        GameView gv = new GameView(gameManager.getMap(), inputController, gameManager);

                    } catch (IOException | ClassNotFoundException exception) {
                        exception.printStackTrace();
                    }
                }
            } else if (pressedButton == view.getNewGame()) {
                UserNameWindow userNameWindow = new UserNameWindow();
            } else if (pressedButton == view.getRecords()) {

                RecordsView recordsView = new RecordsView(GameManager.getRecords());
            }
        }
    }
}
