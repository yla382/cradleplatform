package UI;

import Model.Model;
import Model.UIObserver;
import Model.CourseOrganized;
import Model.CourseOrganizeAgain;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

/**
 * Created by John on 8/2/2016.
 * A class that displays list of previous course offering of a specific
 * course that was chosen in Course List panel;
 */
public class CourseOfferings extends PanelAbstractBase {
    private Model model;
    private int row;
    private int begin;

    private JPanel panel = new JPanel(new GridBagLayout());
    private GridBagConstraints gbc = new GridBagConstraints();

    private JLabel[] semesterLabels = new JLabel[3];
    private JPanel semesterPanel = new JPanel(new GridLayout(1, 3));
    private String[] semester = {"Spring", "Summer", "Fall"};

    private GridLayout yearGrid = new GridLayout();
    private JPanel yearPanel = new JPanel(yearGrid);
    private JLabel[] yearLabels = new JLabel[10];

    private GridLayout courseGrid = new GridLayout();
    private JPanel coursePanel = new JPanel(courseGrid);

    public CourseOfferings(Model model) {
        super(model, "Course Offerings");
        this.model = model;
        setSemesters();

        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        semesterPanel.setVisible(false);
        panel.add(semesterPanel, gbc);

        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;
        gbc.weighty = 0;
        panel.add(yearPanel, gbc);
        coursePanel.setVisible(false);

        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        panel.add(coursePanel, gbc);
        panel.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.black, Color.gray));
        panel.setOpaque(true);
        panel.setBackground(Color.WHITE);
        add(panel, BorderLayout.CENTER);

        registerAsObserver();
    }

    private void setSemesters() {
        for(int i = 0; i < 3; i++) {
            semesterLabels[i] = new JLabel(semester[i]);
            semesterLabels[i].setOpaque(true);
            semesterLabels[i].setBackground(Color.WHITE);
            semesterPanel.add(semesterLabels[i]);
        }
    }

    private void setYears() {
        begin = model.getSelectedCourse().getList().get(0).getYear();
        int end = model.getSelectedCourse().getList().get(model.getSelectedCourse().getList().size() - 1).getYear();
        row = end - begin + 1;

        yearPanel.removeAll();
        yearPanel.revalidate();
        yearPanel.repaint();
        yearLabels = new JLabel[row];
        yearGrid.setColumns(1);
        yearGrid.setRows(row);

        int j = 0;
        for(int i = begin; i <= end; i++) {
            yearLabels[j] = new JLabel(Integer.toString(i));
            yearLabels[j].setOpaque(true);
            yearLabels[j].setBackground(Color.WHITE);
            yearPanel.add(yearLabels[j]);
            j++;
        }
    }

    private int getYearsRow(int year) {
        int yearRow = 0;
        for(int i = 0; i < yearLabels.length; i++) {
            if(Integer.parseInt(yearLabels[i].getText()) == year) {
                yearRow = i;
            }
        }

        return yearRow;
    }

    private void setCourses() {
        coursePanel.removeAll();
        coursePanel.revalidate();
        coursePanel.repaint();

        courseGrid.setRows(row);
        courseGrid.setColumns(3);

        List<CourseButton> buttons = new ArrayList<>();
        for(CourseOrganized organized: model.getSelectedCourse().getList()) {
            CourseButton button = new CourseButton(organized);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    model.setSelectedCourseDetail(button.getOrganized());
                    model.notifyObserversAgainAgain();
                }
            });
            buttons.add(button);
        }

        JPanel[][] panels = new JPanel[row][3];
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < 3; j++) {
                panels[i][j] = new JPanel(new GridLayout(0, 1));
                panels[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                coursePanel.add(panels[i][j]);
            }
        }

        for(CourseButton button: buttons) {
            panels[getYearsRow(button.getOrganized().getYear())][button.getColumn()].add(button);
        }
    }

    private void setDefaultYears() {
        yearPanel.removeAll();
        yearPanel.revalidate();
        yearPanel.repaint();
        yearGrid.setColumns(1);
        yearGrid.setRows(11);

        int j = 0;
        for(int i = 0; i <= 10; i++) {
            JLabel label = new JLabel(Integer.toString(2000 + i));
            label.setOpaque(true);
            label.setBackground(Color.WHITE);
            yearPanel.add(label);
        }

    }

    private void setDefaultCourse() {
        coursePanel.removeAll();
        coursePanel.revalidate();
        coursePanel.repaint();

        courseGrid.setRows(11);
        courseGrid.setColumns(3);

        for(int i = 0; i < 33; i++) {
            JLabel label = new JLabel();
            label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            coursePanel.add(label);
        }
    }

    private void registerAsObserver() {
        model.addObserver(new UIObserver() {
            @Override
            public void stateChanged() {
                semesterPanel.setVisible(true);
                coursePanel.setVisible(true);
                setDefaultYears();
                setDefaultCourse();
            }
        });

        model.addObserverAgain(new UIObserver() {
            @Override
            public void stateChanged() {
                setYears();
                setCourses();
            }
        });
    }
}
