package gg;

/**
 * Created by John on 6/8/2016.
 */

public class Tank {
    private int tank_cells[][];
    private boolean tank_life[];
    int set;

    public Tank() {
        tank_cells = new int[4][2];
        tank_life = new boolean[4];
        set = 0;

        for(boolean bool: tank_life) {
            bool = false;
        }
    }

    public int[][] get_tank_cells() {
        return tank_cells;
    }

    public void set_cells(int i, int row, int column) {
        tank_cells[i][0] = row;
        tank_cells[i][1] = column;
        set++;
    }
    public int get_cell_row(int i) {
        return tank_cells[i][0];
    }

    public int get_cell_column(int i) {
        return tank_cells[i][1];
    }

    public int get_set() {
        return set;
    }

    public boolean location_exist(int row, int column) {
        for(int i = 0 ; i < 4; i++) {
            if(tank_cells[i][0] == row && tank_cells[i][1] == column){
                return true;
            }
        }
        return false;
    }

    public void re_set() {
        set = 0;

        for(int i = 0; i < 4; i++) {
            tank_cells[i] = null;
        }
    }

    public void swap_cells (int first_cell, int second_cell) {
        int row = tank_cells[first_cell][0];
        int column = tank_cells[first_cell][1];

        tank_cells[first_cell][0] = tank_cells[second_cell][0];
        tank_cells[first_cell][1] = tank_cells[second_cell][1];

        tank_cells[second_cell][0] = row;
        tank_cells[second_cell][1] = column;
    }

    public int current_health() {
        int count = 0;
        for(boolean bool: tank_life) {
            if(!bool) {
                count++;
            }
        }
        return count;
    }

    public boolean is_alive() {
        if(current_health() == 0) {
            return false;
        }
        return true;
    }

    public void set_health(int row, int column) {
        for(int i = 0; i < 4; i++) {
            if(tank_cells[i][0] == row && tank_cells[i][1] == column) {
                tank_life[i] = true;
            }
        }
    }
}
