package view;

import controller.InputController;
import model.GameManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserNameWindow extends JFrame{
    private JTextField userNameField;
    private JButton submitButton;
    private String userName;

    public UserNameWindow() {
        setTitle("User Name");
        setSize(300, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel label = new JLabel("Enter Username:");
        userNameField = new JTextField(15);
        submitButton = new JButton("Submit");

        JPanel inputPanel = new JPanel();
        inputPanel.add(label);
        inputPanel.add(userNameField);

        add(inputPanel, BorderLayout.CENTER);
        add(submitButton, BorderLayout.SOUTH);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userName = userNameField.getText().trim();
                if (!userName.isEmpty()) {
                    dispose();
                    GameManager gm = new GameManager(userName);
                    InputController inputController = new InputController(gm);
                    GameView gv = new GameView(gm.getMap(), inputController, gm);
                } else {
                    JOptionPane.showMessageDialog(UserNameWindow.this, "Username cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        setVisible(true);
    }


    public String getUserName() {
        return userName;
    }
}



