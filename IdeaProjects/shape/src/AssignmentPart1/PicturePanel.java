package AssignmentPart1;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by John on 7/6/2016.
 * A class that extends JPanel
 * It add a canvasIcon that contains
 * several shapes to JPanel. Later the
 * object of this class is added to the
 * JFrame
 */
public class PicturePanel extends JPanel {
    private String string;
    private int width;
    private int height;
    private Canvas canvas;
    private List<Shape> shapeList;

    public PicturePanel(String string, int width, int height) {
        super();
        this.string = string;
        this.width = width;
        this.height = height;
        this.canvas = new Canvas(width, height);
        shapeList = new ArrayList<>();
        setLayout(new BorderLayout());
        JLabel label = new JLabel(string);
        add(label, BorderLayout.NORTH);
        setBorder(BorderFactory.createLineBorder(Color.blue, 2));
    }

    public void addFront(Shape shape) {
            shapeList.add(shape);
            for(Shape s: shapeList) {
                s.draw(canvas);
            }
            CanvasIcon icon = new CanvasIcon(canvas);
            JLabel jLabel = new JLabel(icon);
            add(jLabel, BorderLayout.SOUTH);
    }

    public void addBack(Shape shape) {
        shapeList.add(0 ,shape);
        for(Shape s: shapeList) {
            s.draw(canvas);
        }
        CanvasIcon icon = new CanvasIcon(canvas);
        JLabel jLabel = new JLabel(icon);
        add(jLabel, BorderLayout.SOUTH);
    }

}
