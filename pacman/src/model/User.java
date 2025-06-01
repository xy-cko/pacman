package model;

import java.io.Serializable;

public class User implements Comparable<User>, Serializable {
    private String username;
    private int score;
    private int time;

    public User(String username) {
        this.username = username;
        this.score = score;
        this.time = time;
    }

    public User(String name, int score, int time) {
        this.username = name;
        this.score = score;
        this.time = time;
    }

    public String getUsername() {
        return username;
    }

    public int getScore() {
        return score;
    }

    public int getTime() {
        return time;
    }

    public void setScore(int score) {
        this.score = score;
    }
    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public int compareTo(User other) {
        if (this.score != other.score) {
            return Integer.compare(other.score, this.score);
        }
        return Integer.compare(this.time, other.time);
}

    @Override
    public String toString() {
        return "Username: " + username + ", Score: " + score + ", Time: " + time;
    }
}
