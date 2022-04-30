import javax.swing.*;
import java.awt.*;

public class LayoutFlow {

    LayoutFlow()
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(100,100));
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(new FlowLayout()); /// panels use flowLayout by default




        /// frame.setLayout(new FLowLayout(FlowLayout._)) -> you can set where the components start from
        /// setting horizontal & components gaps-
        /// FLowLayout.CENTER, hgap, vgap;






        panel.add(new JButton("1"));
        panel.add(new JButton("2"));
        panel.add(new JButton("3"));
        panel.add(new JButton("4"));
        panel.add(new JButton("5"));
        panel.add(new JButton("6"));
        panel.add(new JButton("7"));
        panel.add(new JButton("8"));
        panel.add(new JButton("9"));



        frame.add(panel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new LayoutFlow();
    }
}
