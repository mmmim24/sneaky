import javax.swing.*;
import java.awt.*;

public class BorderLayoutGUI {
    /// center panel moves proportionally to the size of the fram
    /*
    the top and bottom borders expand horizontally, not vertically
    the left and right borders expand veritcally and not horizontally



     */
    BorderLayoutGUI()
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLayout(new BorderLayout(10,10));
        frame.setVisible(true);




        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.red);



        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.green);




        JPanel panel3 = new JPanel();
        panel3.setBackground(Color.yellow);


        JPanel panel4 = new JPanel();
        panel4.setBackground(Color.magenta);



        JPanel panel5 = new JPanel();
        panel5.setBackground(Color.blue);

        panel1.setPreferredSize(new Dimension(100,100));
        panel2.setPreferredSize(new Dimension(100,100));
        panel3.setPreferredSize(new Dimension(100,100));
        panel4.setPreferredSize(new Dimension(100,100));
        panel5.setPreferredSize(new Dimension(100,100));
        frame.add(panel1,BorderLayout.NORTH);
        frame.add(panel2,BorderLayout.WEST);
        frame.add(panel3,BorderLayout.EAST);
        frame.add(panel4,BorderLayout.SOUTH);
        frame.add(panel5,BorderLayout.CENTER);

    }
    public static void main(String[] args) {
        new BorderLayoutGUI();
    }
}
