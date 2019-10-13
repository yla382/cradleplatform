package sfu.cmpt213.as0.Minion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *  Created by John on 5/17/2016.
 *  A class for user-interface and manage minion database
 *  Allow adding and deleting minions
 *  Controls which minion gains an evil deed
 *  Includes error handling for deleting and incrementing evil deed (value from 0 - number of minions)
 */


public class Main {
    public static void main(String[] args) {
        String mainTitle = "Main Menu";
        String[] mainOption = {"List minions", "Add a new minion", "Remove a minion", "Attribute evil deed to a minion",
                "DEBUG, Dump objects (toString)", "Exit"}; //Menu options from 1 to 6
        String listMinions = "List of Minions:\n****************";

        Menu menu = new Menu(mainTitle, mainOption);
        List<Minion> minions = new ArrayList<>();

        System.out.println("***************************************\nWelcome to the Evil Minion Tracker" +
                " (tm)\nby Your Name Here.\n***************************************\n");

        while(true) {
            menu.display();
            int choice = menu.getSelection();

            if(choice == 1) {  //Displays list of minions in database (shows name, height, and number of evil deeds)
                if(minions.size() == 0) {
                    System.out.println(listMinions);
                    System.out.println("No minions Found.\n");
                } else {
                    System.out.println(listMinions);
                    int count = 1;
                    for(Minion minion: minions) {
                        System.out.println(count + ". " + minion.getName() + ", " + minion.getHeight() + "m, "
                                + minion.getEvilDeed() + " evil deed(s)");
                        count++;
                    }
                    System.out.println("");
                }
            } else if(choice == 2) {   //Adding a new minion (name, height, and 0 evil deed)
                System.out.println("Enter minion's name:");
                Scanner nameInput = new Scanner(System.in);
                String name = nameInput.nextLine();

                System.out.println("Enter minion's height:");
                Scanner heightInput = new Scanner(System.in);
                double height = heightInput.nextDouble();

                minions.add(new Minion(name, 0, height));
            } else if(choice == 3) {   //Remove a minion from the database
                System.out.println(listMinions);

                if(minions.size() == 0) {
                    System.out.println("No minions found.\n(Enter 0 to cancel)");
                } else {
                    int count = 1;

                    for (Minion minion : minions) {
                        System.out.println(count + ". " + minion.getName() + ", " + minion.getHeight() + "m, "
                                + minion.getEvilDeed() + " evil deed(s)");
                        count++;
                    }

                    System.out.println("Enter 0 to cancel");
                }

                Scanner whichMinion = new Scanner(System.in);
                int whichMin = whichMinion.nextInt();

                while(whichMin < 0 || whichMin > minions.size()) {
                    System.out.println("Error: Please enter a selection between 0 and " + minions.size());
                    whichMin = whichMinion.nextInt();
                }

                if(whichMin == 0) {

                } else {
                    minions.remove(whichMin - 1);
                }
            } else if(choice == 4){  //Increment a minion's evil deed
                System.out.println(listMinions);

                if(minions.size() == 0) {
                    System.out.println("No minions found.\n(Enter 0 to cancel)");
                } else {
                    int count = 1;

                    for (Minion minion : minions) {
                        System.out.println(count + ". " + minion.getName() + ", " + minion.getHeight() + "m, "
                                + minion.getEvilDeed() + " evil deed(s)");
                        count++;
                    }

                    System.out.println("Enter 0 to cancel");
                }

                Scanner whoEvil = new Scanner(System.in);
                int whoE = whoEvil.nextInt();

                while(whoE < 0 || whoE > minions.size()) {
                    System.out.println("Error: Please enter a selection between 0 and " + minions.size());
                    whoE = whoEvil.nextInt();
                }

                if(whoE == 0) {

                } else {
                    (minions.get(whoE - 1)).incrementEvilDeed();
                    System.out.println(minions.get(whoE-1).getName() + " has now down " + minions.get(whoE-1).getEvilDeed()
                            + " evil deeds!");
                }
            } else if(choice == 5) {  //Displays all the minion objects and their name, height, and number of evil deeds
                System.out.println("All minion objects:");
                int count = 1;
                for(Minion minion: minions) {
                    System.out.println(count + ". " + minion.toString());
                    count++;
                }
                System.out.println("");
            } else if(choice == 6) { //Ends the program
                break;
            }
        }
    }
}

