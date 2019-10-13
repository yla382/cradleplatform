/**
 * Created by John on 7/22/2016.
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Demonstrate how to create a UI using layouts.
 */
public class UILayoutDemo {
    private static final int THICKNESS = 10;

    public static void main(String[] args) {
        new UILayoutDemo();
    }

    public UILayoutDemo() {
        JFrame frame = new JFrame("GUI Layout Demo");

        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.PAGE_AXIS));
        frame.add(makeRowOfButtons());
        frame.add(makeChangePanel());
        frame.add(makeGameField());
//		frame.add(new FeedbackPanel());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private JPanel makeRowOfButtons() {
        JPanel buttonRow = new JPanel();
        buttonRow.setLayout(new BoxLayout(buttonRow, BoxLayout.LINE_AXIS));

        buttonRow.add(makeButton());
        buttonRow.add(makeButton());
        buttonRow.add(makeButton());

        buttonRow.add(Box.createHorizontalGlue());
        buttonRow.setBorder(BorderFactory.createLineBorder(Color.BLUE, THICKNESS));
        return buttonRow;
    }


    public JPanel makeChangePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        panel.add(makeRowOfButtons(), BorderLayout.NORTH);
        panel.add(makeLabel(), BorderLayout.WEST);
        panel.add(makeTextBox(), BorderLayout.CENTER);

        panel.add(makeButtonColumn(), BorderLayout.EAST);
        panel.add(makeButton(), BorderLayout.EAST);

        panel.add(makeStatusLabel(), BorderLayout.SOUTH);

        panel.setBorder(BorderFactory.createLineBorder(Color.RED, THICKNESS));
        return panel;
    }


    private Component makeGameField() {
        final int NUMBER_ROWS = 4;
        final int NUMBER_COLS = 5;

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(NUMBER_ROWS, NUMBER_COLS));

        for (int row = 0; row < NUMBER_ROWS; row++) {
            for (int col = 0; col < NUMBER_COLS; col++) {
                // Make an effectively final variable for use in inner class
                String text = "At " + row + ", " + col;
                JButton button = new JButton(text);
                button.addActionListener(makeButtonListener(row, col));
                panel.add(button);
            }
        }

        panel.setBorder(BorderFactory.createLineBorder(Color.CYAN, THICKNESS));
        return panel;
    }

    private ActionListener makeButtonListener(int row, int col) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("You clicked at " + row + " x " + col);
            }
        };
    }

    private Component makeLabel() {
        JLabel label = new JLabel("Message:");
        return label;
    }
    private Component makeTextBox() {
        final int NUM_COLUMNS_TEXT = 20;
        JTextField textBox = new JTextField(NUM_COLUMNS_TEXT);
        textBox.setText("Hello world...");
        return textBox;
    }
    private Component makeButton() {
        JButton button = new JButton("Do Something");
        // button.addActionListener(...)
        return button;
    }
    private JPanel makeButtonColumn() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.add(new JButton("Do Something 1"));
        panel.add(new JButton("Do Something 2"));
        panel.add(new JButton("Do Something 3"));
        // button.addActionListener(...)
        return panel;
    }
    private Component makeStatusLabel() {
        JLabel label = new JLabel("The status message goes here.");
        return label;
    }
}