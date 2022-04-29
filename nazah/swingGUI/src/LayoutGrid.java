import javax.swing.*;
import java.awt.*;

public class LayoutGrid {
    /*
    places components in a grid of cells,
    each component taakes all the avaialble sells within its cells,
    and each cell is the same size; matrix type


     frames initially use borderLayout, which means components take as much space as pissible, and
     the other components are left below the large component
     */
    LayoutGrid()
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLayout(new GridLayout(3,3,10,10));


        frame.add(new JButton("1"));
        frame.add(new JButton("2"));
        frame.add(new JButton("3"));
        frame.add(new JButton("4"));
        frame.add(new JButton("5"));
        frame.add(new JButton("6"));
        frame.add(new JButton("7"));
        frame.add(new JButton("8"));
        frame.add(new JButton("9"));
        frame.add(new JButton("10")); // tries to balance out





        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new LayoutGrid();
    }
}
