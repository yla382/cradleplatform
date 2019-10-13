package gg;

/**
 * Created by John on 6/8/2016.
 */
public class FieldVisual {
    private char board[][];


    public FieldVisual() {
        board = new char[10][10];

        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                board[i][j] = '~';
            }
        }
    }

    public void set_hit(int row, int column) {
        board[row][column] = 'X';
    }

    public void set_miss(int row, int column) {
        board[row][column] = '.';
    }

    public void set_blank(int row, int column) {
        board[row][column] = ' ';
    }

    public void display_board() {
        System.out.print("\t");

        for(int i = 1; i <= 10; i++) {
            System.out.print(i + "\t");
        }

        System.out.println("");
        char column = 'A';

        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 11; j++) {
                if(j == 0) {
                    System.out.print(column + "\t");
                    column++;
                } else {
                    System.out.print(board[i][j - 1] + "\t");
                }
            }
            System.out.println("");
        }

    }

}
