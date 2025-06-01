package model;

import java.util.Random;

public class Ghost extends Player {
    private double distance;
    private Pacman pacman;
    public Ghost(Cell location){
        super(location);
        location.setGhostOn(true);
        distance = 0;
    }
    public double getDistance(){ return distance; }
    public Pacman getPacman(){ return pacman; }
    public void setPacman(Pacman pacman){ this.pacman = pacman; }
    @Override
    public void move(){
        if(this.distance > 8){
            Random rand = new Random();
            int rand_int1 = rand.nextInt(100);
            if(rand_int1 < 24){ this.changeDirection(Direction.UP);}
            else if(rand_int1 < 49 && rand_int1 >= 25){ this.changeDirection(Direction.DOWN);}
            else if(rand_int1 < 74 && rand_int1 >= 50){ this.changeDirection(Direction.LEFT);}
            else if(rand_int1 < 100 && rand_int1 >= 75){ this.changeDirection(Direction.RIGHT);}

        } else{
            chasePacman();
        }
        switch(this.direction){
            case Direction.UP:
                if(this.location.getRow() - 1 >= 0 && this.location.getUpperCell().isWalkable()){
                    changeLocation(this.location.getUpperCell());
                }
                break;
            case Direction.DOWN:
                if(this.location.getRow() + 1 < this.location.getMap().getHeight() && this.location.getDownCell().isWalkable()){
                    changeLocation(this.location.getDownCell());
                }
                break;
            case Direction.LEFT:
                if(this.location.getCol() - 1 >= 0 && this.location.getLeftCell().isWalkable() ){
                    changeLocation(this.location.getLeftCell());
                }
                break;
            case Direction.RIGHT:
                if(this.location.getCol() + 1 < this.location.getMap().getWidth() && this.location.getRightCell().isWalkable()){
                    changeLocation(this.location.getRightCell());
                }
                break;
        }
        if(this.location == pacman.getLocation()){
            killPacman();
        }
    }
    public void chasePacman(){
        int diffx = pacman.getLocation().getCol() - this.location.getCol();
        int diffy = pacman.getLocation().getRow() - this.location.getRow();
        Random rand = new Random();
        int rand_int1 = rand.nextInt(100);
        if(rand_int1 < 50) {
            if (diffx < 0) {
                this.changeDirection(Direction.LEFT);
            } else {
                this.changeDirection(Direction.RIGHT);
            }
        } else {
            if (diffy < 0) {
                this.changeDirection(Direction.UP);
            } else {
                this.changeDirection(Direction.DOWN);
            }
        }
    }
    @Override
    public void changeLocation(Cell newLocation){
        this.location.setGhostOn(false);
        this.location = newLocation;
        this.location.setGhostOn(true);
    }
    public void calculateDistance(){
        double sqrX = (pacman.getLocation().getRow() - location.getRow()) * (pacman.getLocation().getRow() - location.getRow());
        double sqrY = (pacman.getLocation().getCol() - location.getCol()) * (pacman.getLocation().getCol() - location.getCol());
        this.distance = Math.sqrt(sqrX + sqrY);
    }
    public void killPacman(){
        pacman.setAlive(false);
        GameManager.setIsGameEnded(true);
    }
}
