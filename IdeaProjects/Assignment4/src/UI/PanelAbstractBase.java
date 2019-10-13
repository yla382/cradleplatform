package UI;

import model.ObservedSubject;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

/**
 * Created by John on 7/27/2016.
 */
public abstract class PanelAbstractBase extends JPanel {
    private ObservedSubject model;

    public PanelAbstractBase(ObservedSubject model, String string) {
        this.model = model;
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.black, Color.gray));

        JLabel title = new JLabel(string);
        add(title, BorderLayout.NORTH);
    }

    protected ObservedSubject getModel() {
        return model;
    }
}
