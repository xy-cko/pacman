package view;

import model.User;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class RecordsView extends JFrame {
    private List<User> topPlayers;

    public RecordsView(List<User> topPlayers) {
        File file = new File("C:\\Users\\okoo1\\Desktop\\5th term\\programming 3\\homework\\pacman\\src\\files\\records.txt");
        if(file.length() != 0){
            try(FileInputStream fileIn = new FileInputStream("C:\\Users\\okoo1\\Desktop\\5th term\\programming 3\\homework\\pacman\\src\\files\\records.txt");
                ObjectInputStream objIn = new ObjectInputStream(fileIn)){
                this.topPlayers = (List<User>) objIn.readObject();
            } catch(IOException | ClassNotFoundException e){
                e.printStackTrace();
            }
        }
        setTitle("Top 3 Players");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setResizable(false);

        JLabel titleLabel = new JLabel("Top 3 Players", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(titleLabel, BorderLayout.NORTH);


        String[] columnsNames = {"name", "score", "time"};
        String[][] data = new String[3][columnsNames.length];
        if(topPlayers != null) {

            int i = 0;
            for (User user : topPlayers) {
                data[i][0] = user.getUsername();
                data[i][1] = String.valueOf(user.getScore());
                data[i][2] = String.valueOf(user.getTime());
                i++;
            }
        }
        JTable table = new JTable(data, columnsNames);
        table.setBounds(50,50, 500, 300);
        table.setSize(500, 300);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);


    }
}
