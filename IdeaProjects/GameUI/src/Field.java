import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * The Field class initializes the 10 x 10 field and the locations of the tanks.
 *
 * @author Michelle Wan, Yoonhong Lee
 * @since 2016-06-18
 */
public class Field {
    private char field[][];
    private List<Tank> enemy;

    public Field() {
        field = new char[10][10];
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                field[i][j] = '~';
            }
        }

        enemy = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            enemy.add(new Tank());
        }

        setTankLocation(0, 4);
        setTankLocation(1, 4);
        setTankLocation(2, 4);
        setTankLocation(3, 4);
        setTankLocation(4, 4);
    }

    private void setFirstLocation(int index) {
        Random random = new Random();
        int row = random.nextInt(10);
        int column = random.nextInt(10);

        while(field[row][column] == 'T') {
            row = random.nextInt(10);
            column = random.nextInt(10);
        }

        field[row][column] = 'T';
        enemy.get(index).setCells(0, row, column);
    }

    private boolean checkAvailability(boolean availability[]) {
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

    private boolean setLocationHelper(int index, int cell) {
        Random random = new Random();
        int pick;
        boolean locationPicked = false;
        int row = enemy.get(index).getCellRow(cell);
        int column = enemy.get(index).getCellColumn(cell);
        int newRow;
        int newColumn;
        boolean availablity[] = new boolean[4];

        for(int i = 0; i < 4; i++) {
            availablity[i] = true;
        }

        while(!locationPicked) {
            pick = random.nextInt(4);

            if (pick == 0) {
                newRow = row;
                newColumn = column - 1;
                if ((newRow >= 0 && newRow < 10) && newColumn >= 0 && newColumn < 10) {
                    if (field[newRow][newColumn] == '~') {
                        field[newRow][newColumn] = 'T';
                        enemy.get(index).setCells(enemy.get(index).getSet(), newRow, newColumn);
                        locationPicked = true;
                    } else {
                        availablity[0] = false;
                    }
                } else {
                    availablity[0] = false;
                }
            } else if (pick == 1) {
                newRow = row;
                newColumn = column + 1;
                if ((newRow >= 0 && newRow < 10) && newColumn >= 0 && newColumn < 10) {
                    if (field[newRow][newColumn] == '~') {
                        field[newRow][newColumn] = 'T';
                        enemy.get(index).setCells(enemy.get(index).getSet(), newRow, newColumn);
                        locationPicked = true;
                    } else {
                        availablity[1] = false;
                    }
                } else {
                    availablity[1] = false;
                }
            } else if (pick == 2) {
                newRow = row + 1;
                newColumn = column;
                if ((newRow >= 0 && newRow < 10) && newColumn >= 0 && newColumn < 10) {
                    if (field[newRow][newColumn] == '~') {
                        field[newRow][newColumn] = 'T';
                        enemy.get(index).setCells(enemy.get(index).getSet(), newRow, newColumn);
                        locationPicked = true;
                    } else {
                        availablity[2] = false;
                    }
                } else {
                    availablity[2] = false;
                }
            } else if (pick == 3) {
                newRow = row - 1;
                newColumn = column;
                if ((newRow >= 0 && newRow < 10) && newColumn >= 0 && newColumn < 10) {
                    if (field[newRow][newColumn] == '~') {
                        field[newRow][newColumn] = 'T';
                        enemy.get(index).setCells(enemy.get(index).getSet(), newRow, newColumn);
                        locationPicked = true;
                    } else {
                        availablity[3] = false;
                    }
                } else {
                    availablity[3] = false;
                }
            }

            if(!checkAvailability(availablity)) {
                break;
            }
        }

        return locationPicked;

    }

    private void resetTankLocation(int index) {
        for(int i = 0; i < enemy.get(index).getSet(); i++) {
            field[enemy.get(index).getCellRow(i)][enemy.get(index).getCellColumn(i)] = '~';
        }

        enemy.get(index).reSet();
    }

    private void setTankLocation(int index, int count) {
        if(count == 0) {

        } else {
            if(enemy.get(index).getSet() == 0) {
                setFirstLocation(index);
                setTankLocation(index, count - 1);
            } else if (enemy.get(index).getSet() == 1) {
                setLocationHelper(index, 0);
                setTankLocation(index, count - 1);
            } else {
                int control = 0;
                Random random = new Random();
                int randomPick = random.nextInt(enemy.get(index).getSet());
                enemy.get(index).swapCells(0, randomPick);

                for(int i = 0; i < enemy.get(index).getSet(); i++) {
                    if(setLocationHelper(index, i)) {
                        break;
                    } else {
                        control++;
                    }
                }

                if(control == enemy.get(index).getSet()) {
                    resetTankLocation(index);
                    setTankLocation(index, count);
                } else {
                    setTankLocation(index, count - 1);
                }
            }
        }
    }

    public char[][] getField() {
        return field;
    }

    public int numberOfTanks() {
        int count = 0;
        for(Tank tank: enemy) {
            if(tank.isAlive()) {
                count++;
            }
        }

        return count;
    }

    public List<Tank> getEnemy() {
        return enemy;
    }

    public boolean isHit(int row, int column) {
        for(Tank tank: enemy) {
            if(tank.locationExist(row, column)) {
                tank.setHealth(row, column);
                return true;
            }
        }
        return false;
    }

}
