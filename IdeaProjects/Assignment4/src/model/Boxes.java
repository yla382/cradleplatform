package model;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Created by John on 7/22/2016.
 */
public class Boxes extends JPanel {
    public Boxes(String[] list) {
        super();

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(scrollDepartment(list), BorderLayout.NORTH);
        panel.add(checkBox(), BorderLayout.CENTER);
        panel.add(updateButton(), BorderLayout.SOUTH);
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        super.setLayout(new BorderLayout());
        super.add(panelTitle("Course List Filter"), BorderLayout.NORTH);
        super.add(panel, BorderLayout.CENTER);

    }

    private JLabel panelTitle(String string) {
        JLabel label = new JLabel(string);
        label.setForeground(Color.BLUE);
        return label;
    }

    private JPanel scrollDepartment(String[] list) {
        JLabel department = new JLabel("Department ");
        JComboBox comboBox = new JComboBox(list);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
        panel.add(department);
        panel.add(comboBox);

        return panel;
    }

    private JPanel updateButton() {
        JButton button = new JButton("Update");

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(button, BorderLayout.EAST);

        return panel;
    }

    private JPanel checkBox() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));
        panel.setLayout(new GridLayout(2, 1));
        panel.add(new JCheckBox("Include undergrad courses", false));
        panel.add(new JCheckBox("Include grad courses"));

        return panel;
    }



    public static void main(String[] args) throws IOException {

        CourseDataBase data = new CourseDataBase();
        String[] list = new String[data.getSubjects().size()];
        for(int i = 0; i < data.getSubjects().size(); i++) {
            list[i] = data.getSubjects().get(i);
        }

        Boxes box = new Boxes(list);

        JFrame frame = new JFrame();
        frame.add(box);

        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
