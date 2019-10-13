/**
 * Created by John on 7/22/2016.
 */

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class FeedbackPanel extends JPanel {

    public FeedbackPanel() {
        setLayout(new BorderLayout());
        add(makeLabel(), BorderLayout.NORTH);
        add(makeTextBox(), BorderLayout.CENTER);
        add(makeButton(), BorderLayout.SOUTH);
    }

    private Component makeLabel() {
        JLabel label = new JLabel("Message:");
        return label;
    }
    private Component makeTextBox() {
        final int NUM_COLUMNS_TEXT = 20;
        final int NUM_ROWS_TEXT = 5;
        JTextArea textBox = new JTextArea(NUM_ROWS_TEXT, NUM_COLUMNS_TEXT);
        textBox.setText("Hello world...");
        return textBox;
    }
    private Component makeButton() {
        JButton button = new JButton("Do Something");
        // button.addActionListener(...)
        return button;
    }

}