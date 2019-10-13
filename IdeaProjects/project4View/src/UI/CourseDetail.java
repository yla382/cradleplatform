package UI;

import Model.Model;
import Model.UIObserver;
import Model.CourseOrganized;
import Model.CourseComponentCode;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by John on 8/2/2016.
 * Displays the specification of the course that was
 * picked from the Course Offering.
 * Displays semester, instructor, components, and so on
 */
public class CourseDetail extends PanelAbstractBase {
    private Model model;
    private JPanel detailPanel = new JPanel(new BorderLayout());

    private JPanel detailParts = new JPanel(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    private JTextArea field = new JTextArea();

    private JPanel sectionType = new JPanel();
    private JPanel sectionNumber = new JPanel();

    private JPanel courseDetailList = new JPanel(new GridLayout(4, 1));
    private JLabel courseName = new JLabel();
    private JLabel courseSemester = new JLabel();
    private JLabel courseLocation = new JLabel();
    private JLabel courseInstructor = new JLabel();

    public CourseDetail(Model model) {
        super(model, "Course Detail");
        this.model = model;

        courseName.setText("Course Name:             ");
        courseSemester.setText("Semester:");
        courseLocation.setText("Location:");
        courseInstructor.setText("Instructors:");
        courseDetailList.add(courseName);
        courseDetailList.add(courseSemester);
        courseDetailList.add(courseLocation);
        courseDetailList.add(courseLocation);
        courseDetailList.add(courseInstructor);

        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        detailParts.add(courseDetailList, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        detailParts.add(field, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;
        gbc.weighty = 0;
        detailParts.add(sectionType, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 0;
        gbc.weighty = 0;
        detailParts.add(sectionNumber, gbc);

        detailPanel.add(detailParts, BorderLayout.NORTH);
        detailPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.black, Color.gray));
        add(detailPanel, BorderLayout.CENTER);

        registerAsObserver();
    }

    private void setField() {
        field.setLineWrap(true);
        CourseOrganized organized = model.getSelectedCourseDetail();

        field.setEditable(false);
        field.setText(organized.getSubject() + organized.getCataloguNumber() +
        "\n" + organized.getSemester() + "\n" + organized.getCampus()
        + "\n" + organized.getInstructorList());
    }

    private void setSectionType() {
        sectionType.removeAll();

        List<CourseComponentCode> components = model.getSelectedCourseDetail().getComponentCodes();
        List<JLabel> componentCodes = new ArrayList<>();

        for(CourseComponentCode code: components) {
            componentCodes.add(new JLabel(code.getComponentCode()));
        }

        sectionType.setLayout(new GridLayout(components.size() + 1, 1));
        sectionType.add(new JLabel("Section Type"));
        for(JLabel label: componentCodes) {
            sectionType.add(label);
        }
    }

    private void setSectionNumber() {
        sectionNumber.removeAll();

        List<CourseComponentCode> components = model.getSelectedCourseDetail().getComponentCodes();
        List<JLabel> componentCodes = new ArrayList<>();

        for(CourseComponentCode code: components) {
            componentCodes.add(new JLabel(Integer.toString(code.getEnrollTotal()) +
            "/" + Integer.toString(code.getEnrollCapacity())));
        }

        sectionNumber.setLayout(new GridLayout(components.size() + 1, 1));
        sectionNumber.add(new JLabel("Enrollment (filled/cap)"));
        for(JLabel label: componentCodes) {
            sectionNumber.add(label);
        }
    }

    private void setDefaultField() {
        field.setText("");
        field.setEditable(false);
    }

    private void registerAsObserver() {
        model.addObserver(new UIObserver() {
            @Override
            public void stateChanged() {
                setDefaultField();
                sectionType.removeAll();
                sectionNumber.removeAll();
            }
        });

        model.addObserversAgainAgain(new UIObserver() {
            @Override
            public void stateChanged() {
                setField();
                setSectionType();
                setSectionNumber();
            }
        });
    }
}
