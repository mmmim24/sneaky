import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonJRadio extends JFrame implements ActionListener {

    JRadioButton pizzaButton = new JRadioButton("pizza");
    JRadioButton hamburgerButton = new JRadioButton("hamburger");
    JRadioButton hotdogButton = new JRadioButton("hotgot");
    public ButtonJRadio()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());


        /*
        you can click only one from choices
         */

        ButtonGroup group = new ButtonGroup();
        pizzaButton.setFocusable(false);
        pizzaButton.addActionListener(this);
        hamburgerButton.setFocusable(false);
        hamburgerButton.addActionListener(this);
        hotdogButton.setFocusable(false);
        hotdogButton.addActionListener(this);
        group.add(pizzaButton);
        group.add(hamburgerButton);
        group.add(hotdogButton);

         this.add(pizzaButton);
         this.add(hamburgerButton);
         this.add(hotdogButton);


        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new ButtonJRadio();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==pizzaButton)
        {
            System.out.println("pizza");
        }
        else if(e.getSource()==hamburgerButton)
        {
            System.out.println("hamburger");
        }
        else if(e.getSource()==hotdogButton)
        {
            System.out.println("hotgot");
        }
    }
}
