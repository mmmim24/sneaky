import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LaunchPage implements ActionListener {
    JFrame frame = new JFrame();
    JButton button = new JButton("BigSed");

    public LaunchPage()
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setBackground(Color.DARK_GRAY);




        button.setBounds(100,160,200,75);
        button.setBackground(Color.GRAY);
        frame.add(button);
        button.setFocusable(false);
        button.addActionListener(this);



        frame.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.dispose();
        if(e.getSource()==button)
        {
            NewWindow sedWindow = new NewWindow();
        }
    }
}