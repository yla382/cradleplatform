package AssignmentPart1;

import java.awt.*;

/**
 * Created by John on 7/6/2016.
 * Implements Shape class.
 * Sets character and color to the Canvas
 */
public abstract class ShapeImpl implements Shape {
    private int x;
    private int y;
    private int width;
    private int height;
    private char character;
    private Color color;

    public ShapeImpl(int x, int y, int width, int height) {
        this.x = x;
        this.y =y;
        this.width = width;
        this.height = height;
        this.character = '*';
        this.color = Color.YELLOW;
    }

    @Override
    public void setBorderChar(char character) {
        this.character = character;
    }

    @Override
    public char getBorderChar() {
        return character;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public int getLocationX() {
        return x;
    }

    @Override
    public int getLocationY() {
        return y;
    }

    protected int getWidth() {
        return width;
    }

    protected int getHeight() {
        return height;
    }

    @Override
    public void draw(Canvas canvas) {
        for(int i = 0; i < canvas.getSizeX(); i++) {
            for(int j = 0; j < canvas.getSizeY(); j++) {
               if(isBorder(i, j) && !isInside(i, j)) {
                    canvas.setPointText(i, j, character);
                    canvas.setPointColor(i, j, color);
                } else if (!isBorder(i, j) && isInside(i, j)){
                    canvas.setPointText(i, j, ' ');
                    canvas.setPointColor(i, j, color);
                } else {

               }
            }
        }
    }

    protected abstract boolean isBorder(int xPos, int yPos);

    protected abstract boolean isInside(int xPos, int yPos);
}
