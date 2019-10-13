import java.util.Comparator;

/**
 * Created by John on 8/10/2016.
 */
public class SortPen implements Comparator<Pen> {
    public SortPen() {

    }

    @Override
    public int compare(Pen a, Pen b) {
        return (a.getFilled() - b.getFilled()) * -1;
    }
}
