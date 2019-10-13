package UI;

import Model.Model;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Created by John on 8/1/2016.
 * A class that contains the main function which will execute all the classes
 */
public class MainUI extends JFrame {
    private Model model = new Model();

    public MainUI() throws IOException {
        setName("FAS Course Planner");
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(1500, 860));

        JPanel left = new JPanel(new BorderLayout());
        left.add(new CourseListFilter(model), BorderLayout.NORTH);
        left.add(new CourseList(model), BorderLayout.CENTER);

        JPanel right = new JPanel(new BorderLayout());
        right.add(new CourseStatistics(model), BorderLayout.NORTH);
        right.add(new CourseDetail(model), BorderLayout.CENTER);

        add(left, BorderLayout.WEST);
        add(new CourseOfferings(model), BorderLayout.CENTER);
        add(right, BorderLayout.EAST);

        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) throws IOException {
        new MainUI();
    }
}
