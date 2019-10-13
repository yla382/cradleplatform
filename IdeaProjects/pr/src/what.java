import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

/**
 * Created by John on 7/15/2016.
 */
public class what {
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



    public static void main(String[] args) {
        //Dimension dimensions = Toolkit.getDefaultToolkit().getScreenSize();

        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        ImageIcon icon = new ImageIcon("C:\\Users\\John\\Desktop\\sistars.jpg");

        JPanel panel = new JPanel(new GridLayout(10, 10));
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                JToggleButton button = new JToggleButton();
                button.setIcon(icon);
                panel.add(button);
            }
        }


        frame.add(panel, BorderLayout.CENTER);
        frame.setSize(1000, 1000);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
