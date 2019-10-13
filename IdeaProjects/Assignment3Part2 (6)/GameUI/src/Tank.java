/**
 * The Tank class stores the locations each tank's cells and keeps track if tank is alive.
 * @author Michelle Wan, Yoonhong Lee
 * @since 2016-06-08
 */

public class Tank {
    private int tankCells[][];
    private boolean tankLife[];
    int set;

    public Tank() {
        tankCells = new int[4][2];
        tankLife = new boolean[4];
        set = 0;

        for(boolean bool: tankLife) {
            bool = false;
        }
    }

    public int[][] getTankCells() {
        return tankCells;
    }

    public void setCells(int i, int row, int column) {
        tankCells[i][0] = row;
        tankCells[i][1] = column;
        set++;
    }
    public int getCellRow(int i) {
        return tankCells[i][0];
    }

    public int availableCells() {
        int count = 0;
        for(int i = 0; i < tankLife.length; i++) {
            if(!tankLife[i]) {
                count++;
            }
        }
        return count;
    }

    public int getCellColumn(int i) {
        return tankCells[i][1];
    }

    public int getSet() {
        return set;
    }

    public boolean locationExist(int row, int column) {
        for(int i = 0 ; i < 4; i++) {
            if(tankCells[i][0] == row && tankCells[i][1] == column){
                return true;
            }
        }
        return false;
    }

    public void reSet() {
        set = 0;

        for(int i = 0; i < 4; i++) {
            tankCells[i] = null;
        }
    }

    public void swapCells(int firstCell, int secondCell) {
        int row = tankCells[firstCell][0];
        int column = tankCells[firstCell][1];

        tankCells[firstCell][0] = tankCells[secondCell][0];
        tankCells[firstCell][1] = tankCells[secondCell][1];

        tankCells[secondCell][0] = row;
        tankCells[secondCell][1] = column;
    }

    public int currentHealth() {
        int count = 0;
        for(boolean bool: tankLife) {
            if(!bool) {
                count++;
            }
        }
        return count;
    }

    public boolean isAlive() {
        if(currentHealth() == 0) {
            return false;
        }
        return true;
    }

    public void setHealth(int row, int column) {
        for(int i = 0; i < 4; i++) {
            if(tankCells[i][0] == row && tankCells[i][1] == column) {
                tankLife[i] = true;
            }
        }
    }
}


