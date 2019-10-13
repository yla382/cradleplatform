package gg;
import java.util.Scanner;

/**
 * Created by miche_000 on 6/16/2016.
 */
public class UserInterface {
    static final char ROW_COORDINATES [] = {'A','B','C','D','E','F','G','H','I','J'};
    static final String COLUMN_COORDINATES [] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

    static boolean valid_row(char row){
        for (char element: ROW_COORDINATES){
            if (element == row){
                return true;
            }
        }
        return false;
    }

    static boolean valid_column(String column){
        for (String element: COLUMN_COORDINATES){
            if (element.equals(column)){
                return true;
            }
        }
        return false;
    }

    public static int[] get_coordinates(){
        Scanner scan = new Scanner(System.in);
        boolean valid_move = false;
        int empty_coordinates[] = {};

        while (!valid_move){
            System.out.print("Enter your move:");
            String move = scan.nextLine();

            if (move.length() < 2 || move.length() > 3){
                System.out.println("Invalid target. Please enter a coordinate such as F7.");
            } else {
                char row = move.toUpperCase().charAt(0);
                StringBuilder stringBuilder = new StringBuilder(move);
                stringBuilder.deleteCharAt(0);
                String column = stringBuilder.toString();

                if (valid_row(row) && valid_column(column)) {
                    int first_coordinate = row - 'A';
                    int second_coordinate = Integer.parseInt(column) - 1;
                    int coordinates[] = {first_coordinate, second_coordinate};
                    return coordinates;
                } else {
                    System.out.println("Invalid target. Please enter a coordinate such as F7.");
                    valid_move = false;
                }
            }
        }
        return empty_coordinates;
    }

    public static void main(String[] args) {
        System.out.println("---------------------------------");
        System.out.println("Welcome to Fortress Defense!");
        System.out.println(" by Michelle Wan and Yoonhong Lee");
        System.out.println("---------------------------------\n");

        Logic game_logic = new Logic(1500, 20);

        while(!game_logic.game_over()) {
            game_logic.display_board();
            System.out.println("Fortress Structure Left:\t" + game_logic.get_health());
            int coordinates[] = get_coordinates();

            if(game_logic.attack(coordinates[0], coordinates[1])) {
                System.out.println("HIT!");
            } else {
                System.out.println("Miss.");
            }

            game_logic.set_damage();
        }

        if(game_logic.winner_loser()) {
            game_logic.display_board();
            System.out.println("Fortress Structure Left:	" + game_logic.get_health());
            System.out.println("Congratulations! You won!");
        } else {
            game_logic.display_board();
            System.out.println("Fortress Structure Left: 0");
            System.out.println("I'm sorry, your fortress has been smashed!");
            game_logic.set_lost_board();
            game_logic.display_board();
            System.out.println("Fortress Structure Left 0.");
        }
    }

}