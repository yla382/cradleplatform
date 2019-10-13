package sfu.cmpt213.as0.Minion;

/**
 * Created by John on 5/16/2016.
 * A class for Minion's personal information including name, height(m), and number of evil deeds.
 */

public class Minion {
    private String name;
    private double height;
    private int evilDeed;

    public Minion(String name, int evilDeed, double height) {
        this.name = name;
        this.height = height;
        this.evilDeed = evilDeed;
    }

    public String getName() {
        return name;
    }

    public int getEvilDeed() {
        return evilDeed;
    }

    public double getHeight() {
        return height;
    }

    public void incrementEvilDeed() {
        evilDeed++;
    }

    //@Override
    public String toString() { //Returns the minion object including its name, height, and number of evil deeds
        return getClass().getPackage().getName() + "[Name:" + name + ", Evil Deeds:" + evilDeed + ", " + "Height:" + height + "]";
    }
}

