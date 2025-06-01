package model;

import java.io.Serializable;

public class Cell implements Serializable {
    private int row;
    private int col;
    private boolean isGhostOn;
    private boolean isPacmanOn;
    private boolean isWalkable;
    private boolean isDotOn;
    private Map map;
    public Cell(int x, int y, Map map) {
        this.row = x;
        this.col = y;
        setMap(map);
        this.isGhostOn = false;
        this.isPacmanOn = false;
        this.isWalkable = true;
        this.isDotOn = false;
    }
    public Map getMap(){ return map; }
    public boolean isGhostOn(){ return isGhostOn; }
    public boolean isPacmanOn(){ return isPacmanOn; }
    public boolean isWalkable(){ return isWalkable; }
    public boolean isDotOn(){ return isDotOn; }
    public int getRow() { return row; }
    public int getCol() { return col; }
    public void setMap(Map map){ this.map = map;}
    public void setGhostOn(boolean on){ isGhostOn = on; }
    public void setPacmanOn(boolean on){ isPacmanOn = on; }
    public void setWalkable(boolean on){ isWalkable = on; }
    public void setDotOn(boolean on){ isDotOn = on; }

    public Cell getLeftCell(){
        return this.map.getSingleCell(row, col - 1);
    }
    public Cell getRightCell(){
        return this.map.getSingleCell(row, col + 1);
    }
    public Cell getUpperCell(){
        return this.map.getSingleCell(row - 1, col);
    }
    public Cell getDownCell(){
        return this.map.getSingleCell(row + 1, col);
    }
    @Override
    public String toString(){
        return "(" + row + ", " + col + ")";
    }

}
