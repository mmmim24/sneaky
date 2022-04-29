import javax.swing.*;
import java.awt.*;

public class NewWindow{
    JFrame frame = new JFrame("sedFrem");
    JLabel label = new JLabel();
   public  NewWindow()
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setBackground(Color.BLACK);



        ImageIcon imageIcon = new ImageIcon("E:/Pictures/jaam.jpg");
        label.setIcon(imageIcon);
        label.setBounds(140,140,100,100);
        label.setOpaque(true);
        label.setBorder(BorderFactory.createMatteBorder(10,10,10,10,Color.black));


        frame.add(label);
        frame.setVisible(true);
    }
}