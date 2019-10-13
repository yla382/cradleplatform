package UI;

import Model.Model;
import Model.UIObserver;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

/**
 * Created by John on 8/1/2016.
 * An abstract class for setting all the panel's title's color
 * and their layout.
 */
public abstract class PanelAbstractBase extends JPanel {
    private Model model;

    public PanelAbstractBase(Model model, String string) {
        this.model = model;
        setLayout(new BorderLayout());
        JLabel title = new JLabel(string);
        title.setForeground(Color.BLUE);
        add(title, BorderLayout.NORTH);
    }

    protected Model getModel() {
        return model;
    }

}
