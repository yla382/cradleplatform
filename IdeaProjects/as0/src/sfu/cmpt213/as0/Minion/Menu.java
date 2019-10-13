package sfu.cmpt213.as0.Minion;
import java.util.Scanner;

/**
 * Created by John on 5/16/2016.
 * A class to display a menu and aiding main class with user-interface along with main class
 * Includes error handling for picking the correct menu options (between 1-6)
 */

public class Menu {
    private String menuTitle;
    private String[] menuOption;

    public Menu(String menuTitle, String[] menuOption) {
        this.menuTitle = menuTitle;
        this.menuOption = menuOption;
    }

    public void display() {
        System.out.println("*************");
        System.out.println("* " + menuTitle + " *");
        System.out.println("*************");

        for(int i = 1; i <= 6; i++) {
            System.out.println(i + ". " + menuOption[i - 1]);
        }
    }

    public int getSelection() {
        return getNumberBetween(1, 6);
    }

    private int getNumberBetween(int first, int last) {
        Scanner scan = new Scanner(System.in);
        int option = scan.nextInt();

        while((option < first) || (option > last)) {
            System.out.println("Error: Please enter a selection between " + first + " and " + last);
            scan = new Scanner(System.in);
            option = scan.nextInt();
        }

        return option;
    }
}
