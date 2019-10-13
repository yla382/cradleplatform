package UI;

import Model.CourseOrganized;
import javax.swing.*;

/**
 * Created by John on 8/6/2016.
 * A class that "is a" JButton
 * it stored a CourseOrganized object.
 * So that specific course data can be accessed
 * when clicked. This class is used for CourseOffering
 * class to generate buttons.
 */
public class CourseButton extends JButton {
    private CourseOrganized organized;
    private int column;

    public CourseButton(CourseOrganized organized) {
        super();
        setText(organized.getSubject() + " " + organized.getCataloguNumber()
        + "-" + organized.getCampus());

        this.organized = organized;
        setColumn();
    }

    private void setColumn() {
        if(organized.getWhichSemester().equals("Spring")) {
            column = 0;
        } else if(organized.getWhichSemester().equals("Summer")) {
            column = 1;
        } else if(organized.getWhichSemester().equals("Fall")) {
            column = 2;
        } else {

        }
    }

    public int getColumn() {
        return column;
    }

    public CourseOrganized getOrganized() {
        return organized;
    }
}
