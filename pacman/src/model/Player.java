package model;

import java.io.Serializable;

public abstract class Player implements Serializable {
    protected Cell location;
    protected Direction direction;
    public Player(Cell location) {
        this.location = location;
        direction = Direction.UP;
    }
    public void move(){};
    public void changeDirection(Direction direction){
        switch(direction){
            case UP:
                if(this.location.getRow() - 1 >= 0 && this.location.getUpperCell().isWalkable()){
                    this.direction = direction;
                }
                break;
            case DOWN:
                if(this.location.getRow() + 1 < this.location.getMap().getHeight() && this.location.getDownCell().isWalkable()){
                    this.direction = direction;
                }
                break;
            case LEFT:
                if(this.location.getCol() - 1 >= 0 && this.location.getLeftCell().isWalkable() ){
                    this.direction = direction;
                }
                break;
            case RIGHT:
                if(this.location.getCol() + 1 < this.location.getMap().getWidth() && this.location.getRightCell().isWalkable()){
                    this.direction = direction;
                }
                break;
        }
    }
    public Direction getDirection(){
        return direction;
    }

    public Cell getLocation(){
        return location;
    }
    public void changeLocation(Cell location){}
}
