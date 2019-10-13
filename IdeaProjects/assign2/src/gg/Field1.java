package gg;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by John on 6/16/2016.
 */
public class Field1 {
    private char field[][];
    private List<Tank>


            army;

    public Field1() {
        field = new char[10][10];
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                field[i][j] = '~';
            }
        }

        army = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            army.add(new Tank());
        }

        set_Tank_location(0, 4);
        set_Tank_location(1, 4);
        set_Tank_location(2, 4);
        set_Tank_location(3, 4);
        set_Tank_location(4, 4);
    }

    private void set_first_location(int index) {
        Random random = new Random();
        int row = random.nextInt(10);
        int column = random.nextInt(10);

        while(field[row][column] == 'T') {
            row = random.nextInt(10);
            column = random.nextInt(10);
        }

        field[row][column] = 'T';
        army.get(index).set_cells(0, row, column);
    }

    private boolean check_availability(boolean availability[]) {
        int count = 0;
        for(boolean bool: availability) {
            if(!bool) {
                count ++;
            }
        }

        if(count == availability.length) {
            return false;
        } else {
            return true;
        }
    }

    private boolean set_location_helper(int index, int cell) {
        Random random = new Random();
        int pick;
        boolean location_picked = false;
        int row = army.get(index).get_cell_row(cell);
        int column = army.get(index).get_cell_column(cell);
        int new_row;
        int new_column;
        boolean availablity[] = new boolean[4];

        for(int i = 0; i < 4; i++) {
            availablity[i] = true;
        }

        while(!location_picked) {
            pick = random.nextInt(4);

            if (pick == 0) {
                new_row = row;
                new_column = column - 1;
                if ((new_row >= 0 && new_row < 10) && new_column >= 0 && new_column < 10) {
                    if (field[new_row][new_column] == '~') {
                        field[new_row][new_column] = 'T';
                        army.get(index).set_cells(army.get(index).get_set(), new_row, new_column);
                        location_picked = true;
                    } else {
                        availablity[0] = false;
                    }
                } else {
                    availablity[0] = false;
                }
            } else if (pick == 1) {
                new_row = row;
                new_column = column + 1;
                if ((new_row >= 0 && new_row < 10) && new_column >= 0 && new_column < 10) {
                    if (field[new_row][new_column] == '~') {
                        field[new_row][new_column] = 'T';
                        army.get(index).set_cells(army.get(index).get_set(), new_row, new_column);
                        location_picked = true;
                    } else {
                        availablity[1] = false;
                    }
                } else {
                    availablity[1] = false;
                }
            } else if (pick == 2) {
                new_row = row + 1;
                new_column = column;
                if ((new_row >= 0 && new_row < 10) && new_column >= 0 && new_column < 10) {
                    if (field[new_row][new_column] == '~') {
                        field[new_row][new_column] = 'T';
                        army.get(index).set_cells(army.get(index).get_set(), new_row, new_column);
                        location_picked = true;
                    } else {
                        availablity[2] = false;
                    }
                } else {
                    availablity[2] = false;
                }
            } else if (pick == 3) {
                new_row = row - 1;
                new_column = column;
                if ((new_row >= 0 && new_row < 10) && new_column >= 0 && new_column < 10) {
                    if (field[new_row][new_column] == '~') {
                        field[new_row][new_column] = 'T';
                        army.get(index).set_cells(army.get(index).get_set(), new_row, new_column);
                        location_picked = true;
                    } else {
                        availablity[3] = false;
                    }
                } else {
                    availablity[3] = false;
                }
            }

            if(!check_availability(availablity)) {
                break;
            }
        }

        return location_picked;

    }

    private void reset_tank_location(int index) {
        for(int i = 0; i < army.get(index).get_set(); i++) {
            field[army.get(index).get_cell_row(i)][army.get(index).get_cell_column(i)] = '~';
        }

        army.get(index).re_set();
    }

    private void set_Tank_location(int index, int count) {
        if(count == 0) {

        } else {
            if(army.get(index).get_set() == 0) {
                set_first_location(index);
                set_Tank_location(index, count - 1);
            } else if (army.get(index).get_set() == 1) {
                set_location_helper(index, 0);
                set_Tank_location(index, count - 1);
            } else {
                int control = 0;
                Random random = new Random();
                int random_pick = random.nextInt(army.get(index).get_set());
                army.get(index).swap_cells(0, random_pick);

                for(int i = 0; i < army.get(index).get_set(); i++) {
                    if(set_location_helper(index, i)) {
                        break;
                    } else {
                        control++;
                    }
                }

                if(control == army.get(index).get_set()) {
                    reset_tank_location(index);
                    set_Tank_location(index, count);
                } else {
                    set_Tank_location(index, count - 1);
                }
            }
        }
    }

    public char[][] get_field() {
        return field;
    }

    public int number_of_tanks() {
        int count = 0;
        for(Tank tank: army) {
            if(tank.is_alive()) {
                count++;
            }
        }

        return count;
    }

    public boolean is_hit(int row, int column) {
        for(Tank tank: army) {
            if(tank.location_exist(row, column)) {
                tank.set_health(row, column);
                return true;
            }
        }
        return false;
    }

}
