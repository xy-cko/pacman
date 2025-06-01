package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WinWindow extends JDialog {

    public  WinWindow(JFrame mainGameWindow) {

        super(mainGameWindow, "You Win!", true);
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Use DISPOSE_ON_CLOSE, not EXIT
        setLocationRelativeTo(null);

        JLabel messageLabel = new JLabel("Congratulations, You Won!", SwingConstants.CENTER);
        messageLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(messageLabel, BorderLayout.CENTER);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                mainGameWindow.dispose();
            }
        });

        setVisible(true);
    }
}

