package model;

public class Pacman extends Player {
    private static boolean isAlive;
    private int eatenDots;

    public Pacman(Cell location){
        super(location);
        location.setPacmanOn(true);
        isAlive = true;
        eatenDots = 0;
    }
    public boolean isAlive(){ return isAlive;}
    public void setAlive(boolean bool){ isAlive = bool;}
    @Override
    public void move(){
        Direction currentDirection = this.getDirection();
            switch (currentDirection) {
                case UP:
                    if (this.location.getRow() - 1 >= 0 && this.location.getUpperCell().isWalkable()) {
                        changeLocation(this.location.getUpperCell());
                        eatDot();
                    }
                    break;
                case DOWN:
                    if (this.location.getRow() + 1 < this.location.getMap().getHeight() && this.location.getDownCell().isWalkable()) {
                        changeLocation(this.location.getDownCell());
                        eatDot();
                    }
                    break;
                case LEFT:
                    if (this.location.getCol() - 1 >= 0 && this.location.getLeftCell().isWalkable()) {
                        changeLocation(this.location.getLeftCell());
                        eatDot();
                    }
                    break;
                case RIGHT:
                    if (this.location.getCol() + 1 < this.location.getMap().getWidth() && this.location.getRightCell().isWalkable()) {
                        changeLocation(this.location.getRightCell());
                        eatDot();
                    }
                    break;
            }

    }
    @Override
    public void changeLocation(Cell newLocation){
        this.location.setPacmanOn(false);
        this.location = newLocation;
        this.location.setPacmanOn(true);
    }
    public void eatDot(){
        if(this.location.isDotOn()) {
            this.location.setDotOn(false);
            eatenDots++;
        }
        if(eatenDots >= 226){
            GameManager.setIsGameEnded(true);
        }
    }
    public int getEatenDots(){
        return eatenDots;
    }

}
