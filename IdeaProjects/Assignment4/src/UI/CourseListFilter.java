package UI;

import model.ObservedSubject;

import javax.swing.*;

/**
 * Created by John on 7/27/2016.
 */
public class CourseListFilter extends PanelAbstractBase {
    JComboBox<String> comboBox;

    public CourseListFilter(ObservedSubject model) {
        super(model, "Course List Filter");
    }
}
