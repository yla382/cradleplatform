package AssignmentPart1;

/**
 * Created by John on 7/6/2016.
 * A class that contains algorithms used
 * by ShapeImpl to create a triangle on
 * Canvas
 */
public class Triangle extends ShapeImpl {
    private int x;
    private int y;
    private int size;

    public Triangle(int x, int y, int size) {
        super(x, y, size, size);

        this.x = x;
        this.y = y;
        this.size = size;
    }

    @Override
    protected boolean isBorder(int xPos, int yPos) {
        for(int i = 0; i < size; i++) {
            if((y + i == yPos && x == xPos) || (y + i == yPos && x + i == xPos)) {
                return true;
            }
        }

        for(int j = x + 1; j < x + size - 1; j++) {
            if(j == xPos && y + size - 1 == yPos) {
                return true;
            }
        }
        return false;
    }

    @Override
    protected boolean isInside(int xPos, int yPos) {
        int xDirection = x + 1;
        for(int i = y + 2; i < y + size - 1; i++) {
            for(int j = x + 1; j < xDirection + 1; j++) {
                if(i == yPos && j == xPos) {
                    return true;
                }
            }
            xDirection++;
        }
        return false;
    }
}
