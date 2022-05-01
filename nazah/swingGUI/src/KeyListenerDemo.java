import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyListenerDemo extends JFrame implements KeyListener {
    JLabel label;
    ImageIcon imageIcon;
    public KeyListenerDemo() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setLayout(null);
        this.addKeyListener(this);

        imageIcon = new ImageIcon("E:/Pictures/snake.png");

        label = new JLabel();
        label.setBounds(0,0,100,100);
//        label.setBackground(Color.red);
//        label.setOpaque(true);
        label.setIcon(imageIcon);


        this.getContentPane().setBackground(Color.GRAY);
        this.add(label);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        new KeyListenerDemo();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        /// invoked when key is typed, char ooutput
        switch (e.getKeyChar())
        {
            case 'a':  label.setLocation(label.getX()-10,label.getY());
                break;

            case 'w': label.setLocation(label.getX(), label.getY()-10);
                break;

            case 's': label.setLocation(label.getX(),label.getY()+10);
                break;

            case 'd': label.setLocation(label.getX()+10,label.getY());
        }


    }

    @Override
    public void keyPressed(KeyEvent e) {
        /// when physical key is presssed down, int output
        switch (e.getKeyCode())
        {
            case 37:  label.setLocation(label.getX()-10,label.getY());
                break;

            case 38: label.setLocation(label.getX(), label.getY()-10);
                break;

            case 40: label.setLocation(label.getX(),label.getY()+10);
                break;

            case 39: label.setLocation(label.getX()+10,label.getY());
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        /// when a button is released
        System.out.println("You released key char: " + e.getKeyChar());
        System.out.println("You released key code:" + e.getKeyCode());
    }
}
