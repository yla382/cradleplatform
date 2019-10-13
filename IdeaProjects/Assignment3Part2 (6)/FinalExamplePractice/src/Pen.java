import java.util.Comparator;

/**
 * Created by John on 8/10/2016.
 */
public class Pen {
    private String color;
    private int filled;

    public Pen(String color, int filled) {
        this.color = color;
        this.filled = filled;
    }

    public int getFilled() {
        return filled;
    }


    public void display() {
        System.out.println("Pen[" + color + ", " + filled + "%]");
    }
}
