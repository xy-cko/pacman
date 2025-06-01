package model;

import java.io.Serializable;

public class Map implements Serializable {
    private Cell[][] cells;
    private int width;
    private int height;
    private int dotNumber;

    public Map(int w, int h) {
        cells = new Cell[h][w];
        width = w;
        height = h;
        dotNumber = 0;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void initializeMap(Map map) {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                cells[i][j] = new Cell(i, j, this);
            }
        }
        for(int i = 0; i < width; i++) {
            cells[0][i].setWalkable(false);
            cells[height-1][i].setWalkable(false);
        }
        for(int i = 0; i < height; i++) {
            cells[i][0].setWalkable(false);
            cells[i][width-1].setWalkable(false);
        }
        if(height >= 21 && width >= 23) {
            cells[1][4].setWalkable(false);
            cells[1][18].setWalkable(false);
            cells[2][4].setWalkable(false);
            cells[2][18].setWalkable(false);
            cells[2][2].setWalkable(false);
            cells[2][6].setWalkable(false);
            cells[2][7].setWalkable(false);
            cells[2][8].setWalkable(false);
            cells[2][9].setWalkable(false);
            cells[2][10].setWalkable(false);
            cells[2][12].setWalkable(false);
            cells[2][13].setWalkable(false);
            cells[2][14].setWalkable(false);
            cells[2][15].setWalkable(false);
            cells[2][16].setWalkable(false);
            cells[2][20].setWalkable(false);
            cells[3][8].setWalkable(false);
            cells[3][14].setWalkable(false);
            cells[4][1].setWalkable(false);
            cells[4][2].setWalkable(false);
            cells[4][4].setWalkable(false);
            cells[4][6].setWalkable(false);
            cells[4][8].setWalkable(false);
            cells[4][10].setWalkable(false);
            cells[4][11].setWalkable(false);
            cells[4][12].setWalkable(false);
            cells[4][14].setWalkable(false);
            cells[4][16].setWalkable(false);
            cells[4][18].setWalkable(false);
            cells[4][20].setWalkable(false);
            cells[4][21].setWalkable(false);
            cells[5][4].setWalkable(false);
            cells[5][6].setWalkable(false);
            cells[5][8].setWalkable(false);
            cells[5][10].setWalkable(false);
            cells[5][12].setWalkable(false);
            cells[5][14].setWalkable(false);
            cells[5][16].setWalkable(false);
            cells[5][18].setWalkable(false);
            cells[6][2].setWalkable(false);
            cells[6][4].setWalkable(false);
            cells[6][6].setWalkable(false);
            cells[6][8].setWalkable(false);
            cells[6][10].setWalkable(false);
            cells[6][11].setWalkable(false);
            cells[6][12].setWalkable(false);
            cells[6][14].setWalkable(false);
            cells[6][16].setWalkable(false);
            cells[6][18].setWalkable(false);
            cells[6][20].setWalkable(false);
            cells[7][4].setWalkable(false);
            cells[7][6].setWalkable(false);
            cells[7][16].setWalkable(false);
            cells[7][18].setWalkable(false);
            cells[8][1].setWalkable(false);
            cells[8][2].setWalkable(false);
            cells[8][3].setWalkable(false);
            cells[8][4].setWalkable(false);
            cells[8][6].setWalkable(false);
            cells[8][8].setWalkable(false);
            cells[8][9].setWalkable(false);
            cells[8][10].setWalkable(false);
            cells[8][11].setWalkable(false);
            cells[8][12].setWalkable(false);
            cells[8][13].setWalkable(false);
            cells[8][14].setWalkable(false);
            cells[8][16].setWalkable(false);
            cells[8][18].setWalkable(false);
            cells[8][19].setWalkable(false);
            cells[8][20].setWalkable(false);
            cells[8][21].setWalkable(false);
            cells[9][6].setWalkable(false);
            cells[9][16].setWalkable(false);
            cells[10][2].setWalkable(false);
            cells[10][3].setWalkable(false);
            cells[10][4].setWalkable(false);
            cells[10][5].setWalkable(false);
            cells[10][6].setWalkable(false);
            cells[10][8].setWalkable(false);
            cells[10][9].setWalkable(false);
            cells[10][10].setWalkable(false);
            cells[10][12].setWalkable(false);
            cells[10][13].setWalkable(false);
            cells[10][14].setWalkable(false);
            cells[10][16].setWalkable(false);
            cells[10][17].setWalkable(false);
            cells[10][18].setWalkable(false);
            cells[10][19].setWalkable(false);
            cells[10][20].setWalkable(false);
            cells[11][8].setWalkable(false);
            cells[11][14].setWalkable(false);
            cells[12][2].setWalkable(false);
            cells[12][3].setWalkable(false);
            cells[12][4].setWalkable(false);
            cells[12][5].setWalkable(false);
            cells[12][6].setWalkable(false);
            cells[12][8].setWalkable(false);
            cells[12][9].setWalkable(false);
            cells[12][10].setWalkable(false);
            cells[12][11].setWalkable(false);
            cells[12][12].setWalkable(false);
            cells[12][13].setWalkable(false);
            cells[12][14].setWalkable(false);
            cells[12][16].setWalkable(false);
            cells[12][17].setWalkable(false);
            cells[12][18].setWalkable(false);
            cells[12][19].setWalkable(false);
            cells[12][20].setWalkable(false);
            cells[13][6].setWalkable(false);
            cells[13][16].setWalkable(false);
            cells[14][1].setWalkable(false);
            cells[14][2].setWalkable(false);
            cells[14][3].setWalkable(false);
            cells[14][4].setWalkable(false);
            cells[14][6].setWalkable(false);
            cells[14][8].setWalkable(false);
            cells[14][9].setWalkable(false);
            cells[14][10].setWalkable(false);
            cells[14][11].setWalkable(false);
            cells[14][12].setWalkable(false);
            cells[14][13].setWalkable(false);
            cells[14][14].setWalkable(false);
            cells[14][16].setWalkable(false);
            cells[14][18].setWalkable(false);
            cells[14][19].setWalkable(false);
            cells[14][20].setWalkable(false);
            cells[14][21].setWalkable(false);
            cells[15][4].setWalkable(false);
            cells[15][6].setWalkable(false);
            cells[15][16].setWalkable(false);
            cells[15][18].setWalkable(false);
            cells[16][2].setWalkable(false);
            cells[16][4].setWalkable(false);
            cells[16][6].setWalkable(false);
            cells[16][8].setWalkable(false);
            cells[16][10].setWalkable(false);
            cells[16][11].setWalkable(false);
            cells[16][12].setWalkable(false);
            cells[16][14].setWalkable(false);
            cells[16][16].setWalkable(false);
            cells[16][18].setWalkable(false);
            cells[16][20].setWalkable(false);
            cells[17][4].setWalkable(false);
            cells[17][6].setWalkable(false);
            cells[17][8].setWalkable(false);
            cells[17][10].setWalkable(false);
            cells[17][12].setWalkable(false);
            cells[17][14].setWalkable(false);
            cells[17][16].setWalkable(false);
            cells[17][18].setWalkable(false);
            cells[18][1].setWalkable(false);
            cells[18][2].setWalkable(false);
            cells[18][4].setWalkable(false);
            cells[18][6].setWalkable(false);
            cells[18][8].setWalkable(false);
            cells[18][10].setWalkable(false);
            cells[18][11].setWalkable(false);
            cells[18][12].setWalkable(false);
            cells[18][14].setWalkable(false);
            cells[18][16].setWalkable(false);
            cells[18][18].setWalkable(false);
            cells[18][20].setWalkable(false);
            cells[18][21].setWalkable(false);
            cells[19][8].setWalkable(false);
            cells[19][14].setWalkable(false);
            cells[20][4].setWalkable(false);
            cells[20][18].setWalkable(false);
            cells[20][2].setWalkable(false);
            cells[20][6].setWalkable(false);
            cells[20][7].setWalkable(false);
            cells[20][8].setWalkable(false);
            cells[20][9].setWalkable(false);
            cells[20][10].setWalkable(false);
            cells[20][12].setWalkable(false);
            cells[20][13].setWalkable(false);
            cells[20][14].setWalkable(false);
            cells[20][15].setWalkable(false);
            cells[20][16].setWalkable(false);
            cells[20][20].setWalkable(false);
            //cells[10][11].setWalkable(false);
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (!cells[i][j].isWalkable()) {
                        cells[i][j].setDotOn(false);
                    }
                }
            }

        }
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                if(cells[i][j].isWalkable()){
                    cells[i][j].setDotOn(true);
                    dotNumber += 1;
                }
            }
        }
        cells[11][9].setDotOn(false); cells[11][10].setDotOn(false); cells[11][11].setDotOn(false); cells[11][12].setDotOn(false); cells[11][13].setDotOn(false);
        cells[5][11].setDotOn(false); cells[17][11].setDotOn(false); cells[10][11].setDotOn(false);
        dotNumber -= 8;
        System.out.println(dotNumber);
    }

    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public Cell getSingleCell(int row, int col) {
        return cells[row][col];
    }
    public int getDotNumber() { return dotNumber;}

    public void printMap(){
        System.out.println("  0 1 2 3  4 5 6 7 8  9");
        for (int i = 0; i < this.getHeight(); i++) {
            System.out.print(i);
            for (int j = 0; j < this.getWidth(); j++) {
                if (!this.getSingleCell(i, j).isWalkable()) {
                    System.out.print("\uD83E\uDDF1");
                } else if (this.getSingleCell(i, j).isGhostOn()) {
                    System.out.print("\uD83D\uDC7B");
                } else if (this.getSingleCell(i, j).isPacmanOn()) {
                    System.out.print(Character.toString(0x1F60E));
                } else {
                    System.out.print("⚫");
                }
            }
            System.out.println();
        }
    }
}
