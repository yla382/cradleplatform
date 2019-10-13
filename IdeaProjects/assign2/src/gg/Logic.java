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

    public int[] get_coordinate(String location) {
        int coordinate[] = new int[2];
        char row = location.charAt(0);
        row = Character.toUpperCase(row);
        int first_coordinate = row - 'A' + 1; //will minus the ASCII code eg. "A" -"A" + 1 = 1
        int second_coordinate = location.charAt(1);
        int coordinates[] = {first_coordinate,second_coordinate};
        return coordinates;

    }

    public void damage_user() {
        for(int i = 0; i < )
    }

}
