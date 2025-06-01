package view;

import javax.swing.*;
import java.awt.*;

public class MenuView extends JFrame {
    JButton newGame;
    JButton quit;
    JButton continueLast;
    JButton records;
    public MenuView() {
        JFrame frame = new JFrame("Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout());
        frame.setSize(1000, 1000);
        frame.setResizable(false);

        ImageIcon backgroundImage = new ImageIcon("C:\\Users\\okoo1\\Desktop\\5th term\\programming 3\\homework\\pacman\\src\\images\\pattern.png");
        Image scaledImage = backgroundImage.getImage().getScaledInstance(600, 400, Image.SCALE_SMOOTH);
        ImageIcon scaledBackground = new ImageIcon(scaledImage);
        JLabel backgroundLabel = new JLabel(scaledBackground);
        backgroundLabel.setLayout(new BorderLayout());

        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        menuPanel.setBorder(BorderFactory.createEmptyBorder(200, 200, 200, 200));

        menuPanel.add(backgroundLabel);

        newGame = new JButton("New Game");
        newGame.setPreferredSize(new Dimension(150, 40));
        newGame.setMaximumSize(new Dimension(150, 40));
        newGame.setMinimumSize(new Dimension(150, 40));
        quit = new JButton("Quit");
        quit.setPreferredSize(new Dimension(150, 40));
        quit.setMaximumSize(new Dimension(150, 40));
        quit.setMinimumSize(new Dimension(150, 40));
        continueLast = new JButton("Continue");
        continueLast.setPreferredSize(new Dimension(150, 40));
        continueLast.setMaximumSize(new Dimension(150, 40));
        continueLast.setMinimumSize(new Dimension(150, 40));
        records = new JButton("Records");
        records.setPreferredSize(new Dimension(150, 40));
        records.setMaximumSize(new Dimension(150, 40));
        records.setMinimumSize(new Dimension(150, 40));

        menuPanel.add(Box.createVerticalGlue());

        menuPanel.add(newGame);
        menuPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        menuPanel.add(continueLast);
        menuPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        menuPanel.add(records);
        menuPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        menuPanel.add(quit);
        menuPanel.add(Box.createVerticalGlue());

        frame.add(menuPanel);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public JButton getNewGame() {
        return newGame;
    }
    public JButton getQuit() {
        return quit;
    }
    public JButton getContinueLast() {
        return continueLast;
    }
    public JButton getRecords() {
        return records;
    }
}
