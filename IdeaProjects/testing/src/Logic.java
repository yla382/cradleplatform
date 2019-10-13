import java.util.ArrayList;
import java.util.List;

/**
 * The Logic class checks the state of the game and determines when the game is over and whether it is a won or lost.
 * Checks if the inputted move is a hit or miss and adjusts the state of the game accordingly.
 * Determines the amount of damage done to the user based on the remaining health of tanks.
 * Sets remaining fortress structure.
 *
 * @author Michelle Wan, YoonHong Lee
 * @since 2016-06-19
 */
public class Logic {
    private Field field;
    private FieldVisual fieldVisual;
    private int health;
    private int damage;
    private List<String> damages;

    public Logic(int health, int damage) {
        field = new Field();
        fieldVisual = new FieldVisual();
        this.health = health;
        this.damage = damage;
        damages = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            damages.add(" ");
        }
    }

    public void displayBoard() {
        fieldVisual.displayBoard();
    }

    public int getHealth() {
        if(health < 0) {
            return 0;
        } else {
            return health;
        }
    }

    public FieldVisual getFieldVisual() {
        return fieldVisual;
    }

    public Field getField() {
        return field;
    }

    public List<String> getDamages() {
        return damages;
    }

    public void setDamage() {
        damages.clear();

        for(int i = 0; i < field.getEnemy().size(); i++) {
            if (field.getEnemy().get(i).availableCells() == 0) {

            } else if (field.getEnemy().get(i).availableCells() == 1) {
                health = health - 1;
                damages.add("You were shot for 1!");
            } else if (field.getEnemy().get(i).availableCells() == 2) {
                health = health - 2;
                damages.add("You were shot for 2!");
            } else if (field.getEnemy().get(i).availableCells() == 3) {
                health = health - 5;
                damages.add("You were shot for 5!");
            } else {
                health = health - damage;
                damages.add("You were shot for " + damage + "!");
            }
        }

        if(damages.size() < 5) {
            while(damages.size() < 5) {
                damages.add("  ");
            }
        }
    }

    public void resetDamages() {
        damages.clear();
    }

    public boolean attack(int row, int column) {
        if(field.isHit(row, column)) {
            fieldVisual.setHit(row, column);
            return true;
        } else {
            fieldVisual.setMiss(row, column);
            return false;
        }
    }

    public boolean gameOver() {
        if(health <= 0 || field.numberOfTanks() <= 0) {
            return true;
        }
        return false;
    }

    public void setLostBoard() {
        fieldVisual.setAllHit(field.getField());
        fieldVisual.setBlank();
    }

    public boolean winnerLoser() {
        if(health <= 0 && field.numberOfTanks() > 0) {
            return false;
        } else {
            return true;
        }
    }
}

