package gg;

/**
 * Created by John on 6/21/2016.
 */
public class Logic {
    private Field1 field;
    private FieldVisual fieldvisual;
    private int health;
    private int damage;

    public Logic(int health, int damage) {
        field = new Field1();
        fieldvisual = new FieldVisual();
        this.health = health;
        this.damage = damage;
    }

    public void display_board() {
        fieldvisual.display_board();
    }

    public int get_health() {
        return health;
    }

    public Field1 getField() {
        return field;
    }

    public void set_damage() {
        for(int i = 0; i < field.get_army().size(); i++) {
            if(field.get_army().get(i).available_cells() == 0) {

            } else if (field.get_army().get(i).available_cells() == 1) {
                health = health - 1;
                System.out.println("You were shot for 1!");
            } else if (field.get_army().get(i).available_cells() == 2) {
                health = health - 2;
                System.out.println("You were shot for 2!");
            }else if (field.get_army().get(i).available_cells() == 3) {
                health = health - 5;
                System.out.println("You were shot for 5!");
            } else {
                health = health - damage;
                System.out.println("You were shot for " + damage + "!");
            }
        }
        System.out.println("");
    }

    public boolean attack(int row, int column) {
        if(field.is_hit(row, column)) {
            fieldvisual.set_hit(row, column);
            return true;
        } else {
            fieldvisual.set_miss(row, column);
            return false;
        }
    }

    public boolean game_over() {
        if(health <= 0 || field.number_of_tanks() <= 0) {
            return true;
        }
        return false;
    }

    public void set_lost_board() {
        fieldvisual.set_all_hit(field.get_field());
        fieldvisual.set_blank();
    }

    public boolean winner_loser() {
        if(health <= 0 && field.number_of_tanks() > 0) {
            return false;
        } else {
            return true;
        }
    }
}
