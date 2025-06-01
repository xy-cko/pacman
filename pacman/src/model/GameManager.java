package model;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
public class GameManager implements Serializable {
    private final Map map;
    private Pacman pacman;
    private String userName;
    private User user;
    private static boolean isGameEnded;
    private Mover mover;
    private static List<User> records;

    public GameManager(String uName) {
        map = new Map(23, 21);
        map.initializeMap(map);
        isGameEnded = false;

        File file = new File("C:\\Users\\okoo1\\Desktop\\5th term\\programming 3\\homework\\pacman\\src\\files\\records.txt");
        if(file.length() != 0){
            try(FileInputStream fileIn = new FileInputStream("C:\\Users\\okoo1\\Desktop\\5th term\\programming 3\\homework\\pacman\\src\\files\\records.txt");
                ObjectInputStream objIn = new ObjectInputStream(fileIn)){
                records = (List<User>) objIn.readObject();
            } catch (IOException | ClassNotFoundException e){
                e.printStackTrace();
            }
        }

        if(records == null) { records = new ArrayList<>(); }

        this.userName = uName;
        user = new User(userName);
        Pacman pacman = new Pacman(map.getSingleCell(3, 3));
        this.pacman = pacman;
        Ghost ghost1 = new Ghost(map.getSingleCell(11, 9));
        ghost1.setPacman(pacman);
        Ghost ghost2 = new Ghost(map.getSingleCell(11, 10));
        ghost2.setPacman(pacman);
        Ghost ghost3 = new Ghost(map.getSingleCell(11, 12));
        ghost3.setPacman(pacman);
        Ghost ghost4 = new Ghost(map.getSingleCell(11, 13));
        ghost4.setPacman(pacman);
        List<Ghost> ghosts = new ArrayList<>();
        ghosts.add(ghost1);
        ghosts.add(ghost2);
        ghosts.add(ghost3);
        ghosts.add(ghost4);
        mover = new Mover(pacman, ghosts);
        mover.start();
    }

    public void endGame() {
        isGameEnded = true;
        user.setScore(pacman.getEatenDots());
        try{
            Files.writeString(Path.of("C:\\Users\\okoo1\\Desktop\\5th term\\programming 3\\homework\\pacman\\src\\files\\lastGame.txt"), "");
        } catch(IOException e){
            e.printStackTrace();
        }
        if(records == null) {
            records = new ArrayList<>();
        }
        records.add(user);
        Collections.sort(records);
        if(records.size() > 3){
            records.remove(records.size()-1);
        }

        try(FileOutputStream fileOut = new FileOutputStream("C:\\Users\\okoo1\\Desktop\\5th term\\programming 3\\homework\\pacman\\src\\files\\records.txt");
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut)){
            objOut.writeObject(records);
            objOut.close();
        } catch(IOException e){
            e.printStackTrace();
        }

    }

    public Map getMap() {return map;}
    public Pacman getPacman() {return pacman;}
    public String getUserName() {return userName;}
    public static boolean isGameEnded() {return isGameEnded;}
    public Mover getMover() {return mover;}
    public User getUser() {return user;}

    public static List<User> getRecords() {
        File file = new File("C:\\Users\\okoo1\\Desktop\\5th term\\programming 3\\homework\\pacman\\src\\files\\records.txt");
        if(file.length() != 0){
            try(FileInputStream fileIn = new FileInputStream("C:\\Users\\okoo1\\Desktop\\5th term\\programming 3\\homework\\pacman\\src\\files\\records.txt");
                ObjectInputStream objIn = new ObjectInputStream(fileIn)){
                records = (List<User>) objIn.readObject();
            } catch (IOException | ClassNotFoundException e){
                e.printStackTrace();
            }
        }

        if(records == null) { records = new ArrayList<>(); }
        return records;
    }

    public void setName(String name) {userName = name;}
    public static void setIsGameEnded(boolean bool) { isGameEnded = bool;}
}
