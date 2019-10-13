import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by John on 7/13/2016.
 * Creates GUI of Tank Battlefield using the codes from
 * Assignment 2.
 */
public class GameUI {
    static public ImageIcon getScaleImageIcon(ImageIcon icon, int width, int height) {
        return new ImageIcon(getScaledImage(icon.getImage(), width, height));
    }

    static private Image getScaledImage(Image srcImg, int width, int height){
        BufferedImage resizedImg =
                new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();
        g2.setRenderingHint(
                RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, width, height, null);
        g2.dispose();
        return resizedImg;
    }

    public static void main(String[] Args) {
        boolean buttonValid = true;
        Logic logic = new Logic(1500, 20);
        JFrame frame = new JFrame("Tank Battlefield");
        JLabel currentHealth = new JLabel("Fortress Health: " + logic.getHealth());
        JButton[][] buttons = new JButton[10][10];

        List<JLabel> damage = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            JLabel label = new JLabel(logic.getDamages().get(i));
            damage.add(label);
        }

        JPanel damageDisplay  = new JPanel(new GridLayout(5, 1));
        for(int i = 0; i < 5; i++) {
            damageDisplay.add(damage.get(i));
        }

        JPanel grid = new JPanel(new GridLayout(10, 10));
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                JButton button = new JButton(getScaleImageIcon(logic.getFieldVisual().getImages(i, j), 100, 100));
                buttons[i][j] = button;
                grid.add(buttons[i][j]);

                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(logic.gameOver()) {
                                if(logic.winnerLoser()) {
                                    JOptionPane.showMessageDialog(frame, "Congratulations! You won!");
                                } else {
                                    JOptionPane.showMessageDialog(frame, "I'm sorry;you lost.");
                                }

                        } else {
                            for(int i = 0; i < 10; i++) {
                                for(int j = 0; j < 10; j++) {
                                    if(buttons[i][j] == button) {
                                        logic.attack(i, j);
                                        logic.setDamage();
                                        currentHealth.setText("Fortress Health: " + logic.getHealth());
                                        buttons[i][j].setIcon(getScaleImageIcon(logic.getFieldVisual().getImages(i, j), 100, 100));

                                        for(int k = 0; k < 5; k++) {
                                            damage.get(k).setText(logic.getDamages().get(k));
                                        }
                                    }
                                }
                            }
                            if(logic.gameOver()) {
                                for(int k = 0; k < 5; k++) {
                                    damage.get(k).setText(logic.getDamages().get(k));
                                }
                                if(true) {
                                    if(logic.winnerLoser()) {
                                        JOptionPane.showMessageDialog(frame, "Congratulations! You won!");
                                    } else {
                                        logic.setLostBoard();
                                        for(int i = 0; i < 10; i++) {
                                            for(int j = 0; j < 10; j++) {
                                                buttons[i][j].setIcon(getScaleImageIcon(logic.getFieldVisual().getImages(i, j), 100, 100));
                                            }
                                        }
                                        JOptionPane.showMessageDialog(frame, "I'm sorry;you lost.");
                                    }
                                }
                            }
                        }
                    }
                });
            }
        }



        frame.setLayout(new BorderLayout());
        frame.add(currentHealth, BorderLayout.NORTH);
        frame.add(grid, BorderLayout.CENTER);
        frame.add(damageDisplay, BorderLayout.SOUTH);

        frame.setSize(1000, 1000);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
