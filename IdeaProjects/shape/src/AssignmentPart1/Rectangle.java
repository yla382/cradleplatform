package AssignmentPart1;

/**
 * Created by John on 7/6/2016.
 * A class that contains algorithm
 * used to by ShapeImpl to draw a
 * rectangle
 */
public class Rectangle extends ShapeImpl {
    private int x;
    private int y;
    private int width;
    private int height;

    public Rectangle(int x, int y, int width, int height) {
        super(x, y, width, height);

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    protected boolean isBorder(int xPos, int yPos) {
        for(int i = x; i < x + width; i++) {
            if((i == xPos && y == yPos) || (i == xPos && y + height - 1 == yPos)) {
                return true;
            }
        }

        for(int j = y + 1; j < y + height - 1; j++) {
            if((x == xPos && j == yPos) || (x + width - 1 == xPos && j == yPos)) {
                return true;
            }
        }
        return false;
    }

    @Override
    protected boolean isInside(int xPos, int yPos) {
        for(int i = y + 1; i < y + height - 1; i++) {
            for(int j = x + 1; j < x + width - 1; j++) {
                if(i == yPos && j == xPos) {
                    return true;
                }
            }
        }
        return false;
    }
}
