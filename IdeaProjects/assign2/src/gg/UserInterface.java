package gg;

import java.util.Scanner;

/**
 * Created by John on 6/22/2016.
 */
public class UserInterface {
    public static void main(String[] args){
        System.out.println("---------------------------------");
        System.out.println("Welcome to Fortress Defense!");
        System.out.println(" by Michelle Wan and Yoonhong Lee");
        System.out.println("---------------------------------");

        Scanner scan = new Scanner(System.in);
        FieldVisual field = new FieldVisual();
        field.display_board();

        boolean valid_move = false;
        while (!valid_move){
            System.out.print("Enter your move:");

            String move = scan.nextLine().toString().toUpperCase();
            char row = move.charAt(0);
            StringBuilder stringBuilder = new StringBuilder(move);
            stringBuilder.deleteCharAt(0);
            String column = stringBuilder.toString();
            int first_coordinate = row - 'A' + 1; //will minus the ASCII code eg. "A" -"A" + 1 = 1
            int second_coordinate = Integer.parseInt(column);
            System.out.println(first_coordinate + "," + second_coordinate);

            if(first_coordinate < 0 || first_coordinate > 10 || second_coordinate < 0 || second_coordinate > 10){
                System.out.println("Invalid target. Please enter a coordinate such as F7.");
            }
            else{
                valid_move = true;
            }
        }
    }

}
