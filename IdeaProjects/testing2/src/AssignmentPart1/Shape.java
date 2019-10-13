package AssignmentPart1;

import java.awt.*;

/**
 * Created by John on 7/6/2016.
 * Interface used by ShapeImpl class
 * Contains empty functions for ShapeImpl to
 * Override
 */
public interface Shape {
    public int getLocationX();
    public int getLocationY();

    public void setBorderChar(char character);
    public char getBorderChar();

    public void setColor(Color color);
    public Color getColor();

    public void draw(Canvas canvas);
}
