package UI;

import Model.Model;
import Model.CourseOrganizeAgain;
import Model.UIObserver;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.Vector;


/**
 * Created by John on 8/2/2016.
 * A class that displays the list of courses after it has been
 * filtered by the the Course list filter panel.
 */
public class CourseList extends PanelAbstractBase {
    private Model model;
    private JScrollPane pane;
    private JList jListView;
    private int index = 0;

    public CourseList(Model model) {
        super(model, "Course List");
        this.model = model;
        add(pane = new JScrollPane(jListView = new JList()), BorderLayout.CENTER);
        pane.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.black, Color.gray));
        registerAsObserver();
    }

    private void setJListView() {
        Vector<String> vector = new Vector<>();
        for(CourseOrganizeAgain again: model.getOrganizeAgainList()) {
            vector.add(again.getSubject() + " " + again.getCataloguNumber());
        }

        jListView.setListData(vector);
        jListView.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        jListView.setVisibleRowCount(-1);
        jListView.setFixedCellWidth(100);
        jListView.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                if(jListView.getSelectedIndex() == -1) {

                } else {
                    index = jListView.getSelectedIndex();
                    model.setSelectedCourse(index);
                }

                if(model.getSelectedCourse() != null) {
                    model.notifyObserversAgain();
                }
            }
        });

    }

    private void registerAsObserver() {
        model.addObserver(new UIObserver() {
            @Override
            public void stateChanged() {
                setJListView();
            }
        });
    }
}
