package gg;

import java.util.Random;


/**
 * Created by John on 6/9/2016.
 */
public class Field {
    private char field[][] = new char[10][10];

    public Field() {
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                field[i][j] = '~';
            }
        }
    }

   public void set_first_location() {
        Random random_location = new Random();
        int row = random_location.nextInt(10);
        int column = random_location.nextInt(10);

        while(field[row][column] == 'T') {
            row = random_location.nextInt(10);
            column = random_location.nextInt(10);
        }

        field[row][column] = 'T';
        display();
        set_next_location(row, column, 3);
    }


    public void set_next_location(int row, int column, int count) {
        if (count == 0) {

        } else {
            int new_row = row;
            int new_column = column;
            Random choice = new Random();
            int pick;
            boolean data = false;
            while (!data) {
                pick = choice.nextInt(4);

                if (pick == 0) {
                    new_row = row;
                    new_column = column - 1;
                    if ((new_row >= 0 && new_row < 10) && new_column >= 0 && new_column < 10) {
                        if (field[new_row][new_column] == '~') {
                            field[new_row][new_column] = 'T';
                            data = true;
                        }
                    }
                } else if (pick == 1) {
                    new_row = row;
                    new_column = column + 1;
                    if ((new_row >= 0 && new_row < 10) && new_column >= 0 && new_column < 10) {
                        if (field[new_row][new_column] == '~') {
                            field[new_row][new_column] = 'T';
                            data = true;
                        }
                    }
                } else if (pick == 2) {
                    new_row = row + 1;
                    new_column = column;
                    if ((new_row >= 0 && new_row < 10) && new_column >= 0 && new_column < 10) {
                        if (field[new_row][new_column] == '~') {
                            field[new_row][new_column] = 'T';
                            data = true;
                        }
                    }
                } else if (pick == 3) {
                    new_row = row - 1;
                    new_column = column;
                    if ((new_row >= 0 && new_row < 10) && new_column >= 0 && new_column < 10) {
                        if (field[new_row][new_column] == '~') {
                            field[new_row][new_column] = 'T';
                            data = true;
                        }
                    }
                }
            }
            pick = choice.nextInt(2);
            display();
            if (pick == 0) {
                set_next_location(new_row, new_column, count - 1);
            } else {
                if((row == 0 && column == 0) || (row == 9 && column == 0) || (row == 0 && column == 9) || (row == 9 && column == 9)) {
                    set_next_location(new_row, new_column, count - 1);
                } else {
                    set_next_location(row, column, count - 1);
                }
            }
        }
    }


    public void display() {
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                System.out.print(field[i][j] + "\t");
            }
            System.out.println("");
        }
        System.out.println("");
    }


    public static void main(String[] args) {
        Field field = new Field();
        field.display();
        field.set_first_location();
        field.set_first_location();
        field.set_first_location();
        field.set_first_location();
        field.set_first_location();
    }
}
