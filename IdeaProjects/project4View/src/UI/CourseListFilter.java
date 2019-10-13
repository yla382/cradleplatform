package UI;

import Model.UIObserver;
import Model.Model;
import Model.CourseOrganized;
import Model.CourseOrganizeAgain;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

/**
 * Created by John on 8/1/2016.
 * A class that filters the course databases based on
 * subject, graduate, and undergraduate.
 */
public class CourseListFilter extends PanelAbstractBase {
    private Model model;
    private JComboBox<String> comboBox;
    private JCheckBox underGrad;
    private JCheckBox grad;
    private JButton button;
    private String selectedDepartment = "ATHL";
    private Boolean isUnderGrad = false;
    private Boolean isGrad = false;

    CourseListFilter(Model model) {
        super(model, "Course List Filter");
        this.model = model;
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.black, Color.gray));
        panel.add(scrollDepartment(super.getModel().getOptions()), BorderLayout.NORTH);
        panel.add(checkBox(), BorderLayout.CENTER);
        panel.add(updateButton(), BorderLayout.SOUTH);

        setPreferredSize(new Dimension(250, 130));
        super.add(panel, BorderLayout.CENTER);
    }

    private JPanel scrollDepartment(Vector<String> vector) {
        JLabel label = new JLabel("Department  ");
        comboBox = new JComboBox<String>(vector);
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedDepartment = comboBox.getItemAt(comboBox.getSelectedIndex());
//                }
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
        panel.add(label);
        panel.add(comboBox);

        return panel;
    }

    private JPanel checkBox() {
        underGrad = new JCheckBox("Include undergrad courses", false);
        underGrad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isUnderGrad = underGrad.isSelected();
            }
        });

        grad = new JCheckBox("Include grad courses", false);
        grad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isGrad = grad.isSelected();
            }
        });

        JPanel panel = new JPanel(new GridLayout(2, 1));
        panel.add(underGrad);
        panel.add(grad);

        return panel;
    }

    private JPanel updateButton() {
        button = new JButton("Update");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setDepartment(selectedDepartment);
                model.setGradAndUnderGrad(isUnderGrad, isGrad);
                model.setOrganizeAgainList();
                for(CourseOrganizeAgain again: model.getOrganizeAgainList()) {
                    again.dumpAgain();
                    System.out.println("");
                }
            }
        });

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(button, BorderLayout.EAST);

        return panel;
    }
}
