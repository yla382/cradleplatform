package UI;

import Model.Model;
import Model.UIObserver;
import Model.CourseOrganized;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

/**
 * Created by John on 8/7/2016.
 * A class that uses displays the bar graphs for number of courses
 * that were available in which campus and semester.
 */
public class CourseStatistics extends PanelAbstractBase {
    private Model model;
    private JLabel courseName = new JLabel("Course:");
    private JLabel blankLineTop = new JLabel(" ");
    private JLabel semesterOffering = new JLabel("Semester Offerings:");
    private JPanel courseTitle = new JPanel(new GridLayout(3, 1));

    private JLabel campusOffering = new JLabel("Campus Offerings:");
    private JLabel blankLineButton = new JLabel(" ");
    private JPanel campusTitle = new JPanel(new GridLayout(2, 1));
    private JPanel semesterStat = new JPanel(new BorderLayout());
    private JPanel campusStat = new JPanel(new BorderLayout());

    private JLabel semesterGraph = new JLabel();
    private JLabel campusGraph = new JLabel();

    private JPanel statPanel = new JPanel(new GridLayout(2, 1));

    public CourseStatistics(Model model) {
        super(model, "Statistics");
        this.model = model;
        int[] initialdata = {0, 0, 0};
        String[] initialVariables = {"", "", ""};
        BarGraphModel initialgraphModel = new BarGraphModel(initialdata, initialVariables);

        courseTitle.add(courseName);
        courseTitle.add(blankLineTop);
        courseTitle.add(semesterOffering);
        semesterGraph.setIcon(new BarGraphIcon(initialgraphModel, 400, 250));
        semesterStat.add(courseTitle, BorderLayout.NORTH);
        semesterStat.add(semesterGraph, BorderLayout.CENTER);

        campusTitle.add(blankLineButton);
        campusTitle.add(campusOffering);
        campusGraph.setIcon(new BarGraphIcon(initialgraphModel,400, 250));
        campusStat.add(campusTitle, BorderLayout.NORTH);
        campusStat.add(campusGraph, BorderLayout.CENTER);

        statPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.black, Color.gray));
        statPanel.add(semesterStat);
        statPanel.add(campusStat);

        add(statPanel, BorderLayout.CENTER);

        registerAsObserver();
    }

    private void setCourseName() {
        courseName.setText("Course: " + model.getSelectedCourse().getSubject() +
                " " + model.getSelectedCourse().getCataloguNumber());
    }

    private void setSemesterGraph() {
        int[] semesterBar = new int[3];
        for(CourseOrganized organized: model.getSelectedCourse().getList()) {
            if(organized.getWhichSemester().equals("Spring")) {
                semesterBar[0]++;
            } else if(organized.getWhichSemester().equals("Summer")) {
                semesterBar[1]++;
            } else if(organized.getWhichSemester().equals("Fall")) {
                semesterBar[2]++;
            } else {

            }
        }

        String[] semesterVariables = {"Spring", "Summer", "Fall"};

        BarGraphModel graphModel = new BarGraphModel(semesterBar, semesterVariables);
        BarGraphIcon icon = new BarGraphIcon(graphModel, 400, 250);

        semesterGraph.setIcon(icon);
    }

    private void setCampusGraph() {
        int[] campusBar = new int[4];
        for(CourseOrganized organized: model.getSelectedCourse().getList()) {
            if(organized.getCampus().equals("BURNABY")) {
                campusBar[0]++;
            } else if(organized.getCampus().equals("SURREY")) {
                campusBar[1]++;
            } else if(organized.getCampus().equals("HRBRCNTR")) {
                campusBar[2]++;
            } else {
                campusBar[3]++;
            }
        }

        String[] campusVariables = {"Bby", "Sry", "Van", "Other"};

        BarGraphModel graphModel = new BarGraphModel(campusBar, campusVariables);
        BarGraphIcon icon = new BarGraphIcon(graphModel, 400, 250);

        campusGraph.setIcon(icon);
    }

    private void setDefaultCourseName() {
        courseName.setText("Course: ");
    }

    private void setDefaultSemesterGraph() {
        int[] semesterBar = {0, 0, 0};
        String[] semesterVariables = {"", "", ""};

        BarGraphModel graphModel = new BarGraphModel(semesterBar, semesterVariables);
        BarGraphIcon icon = new BarGraphIcon(graphModel, 400, 250);

        semesterGraph.setIcon(icon);
    }

    private void setDefaultCampusGraph() {
        String[] campusVariables = {"", "", "", ""};
        int[] campusBar = {0, 0, 0, 0,};

        BarGraphModel graphModel = new BarGraphModel(campusBar, campusVariables);
        BarGraphIcon icon = new BarGraphIcon(graphModel, 400, 250);

        campusGraph.setIcon(icon);
    }

    private void registerAsObserver() {
        model.addObserver(new UIObserver() {
            @Override
            public void stateChanged() {
                setDefaultCourseName();
                setDefaultSemesterGraph();
                setDefaultCampusGraph();
            }
        });

        model.addObserverAgain(new UIObserver() {
            @Override
            public void stateChanged() {
                setCourseName();
                setSemesterGraph();
                setCampusGraph();
            }
        });
    }
}
