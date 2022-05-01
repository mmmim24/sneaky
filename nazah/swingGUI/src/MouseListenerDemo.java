import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseListenerDemo extends JFrame implements MouseListener {
    JLabel label;
    public MouseListenerDemo()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);

        label = new JLabel();
        label.setBounds(0,0,100,100);
        label.setBackground(Color.red);
        label.setOpaque(true);
        label.addMouseListener(this);



        this.add(label);
        this.setLayout(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new MouseListenerDemo();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        System.out.println("You clicked the mouse");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("you pressed the mouse");
        label.setBackground(Color.BLUE);
    }

    @Override
    public void mouseReleased(MouseEvent e) {


    }

    @Override
    public void mouseEntered(MouseEvent e) {
        /// invoked when mouse enters a component
    }

    @Override
    public void mouseExited(MouseEvent e) {
    /// when mouse exits a component
    }
}
