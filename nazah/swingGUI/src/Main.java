import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main implements ActionListener {
    JButton button1;
    JButton button2;
    JButton button3;
    JLabel label;
    JPanel firstPanel;
    JPanel secondPanel;
    JPanel thirdPanel;
    public static void main(String[] args) {

        ImageIcon imageIcon = new ImageIcon("E://Pictures//snake.png");
        JLabel label = new JLabel();
        /// about layout:
        /*
        default frame layout - border layour
        panels use flow layout where they keep adding from top&&center until the row is filled, and they go to next row.

        so to manually add position, we can use border layout - and use setHorizontal & Vertical alignment to labels, and then add them to panels.
        if you do not wanna use any layout, use setBounds for label.

         */


        label.setIcon(imageIcon);
        label.setVerticalAlignment(JLabel.BOTTOM);
        label.setHorizontalAlignment(JLabel.RIGHT);
        label.setVisible(false);
        label.setBounds(0,0,75,75);


        JPanel headerPanel = new JPanel();
        headerPanel.setBounds(0,0,100,100);
        JButton button1 = new JButton();
        button1.setBounds(63,35,75,30);
        button1.setText("1");


        JButton button2 = new JButton();
        button2.setBounds(263,35,75,30);
        button2.setText("2");
        JButton button3 = new JButton();
        button3.setBounds(463,35,75,30);
        button3.setText("3");
        headerPanel.add(button1);
        headerPanel.add(button2);
        headerPanel.add(button3);

        JPanel firstPanel = new JPanel();
        firstPanel.setBackground(Color.LIGHT_GRAY);
        firstPanel.setBounds(0,100,300,200);
        firstPanel.setLayout(null);


        JPanel secondPanel = new JPanel();
        secondPanel.setBackground(Color.GRAY);
        secondPanel.setBounds(300,100,300,200);
        secondPanel.setLayout(null);
        secondPanel.add(label);

        JPanel thirdPanel = new JPanel();
        thirdPanel.setBackground(Color.DARK_GRAY);
        thirdPanel.setBounds(0,300,600,300);
        thirdPanel.setLayout(null);


        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); /// were doing it manually
        frame.setSize(600,600);
        frame.setVisible(true);

        headerPanel.setVisible(true);
        button1.setVisible(true);
        button2.setVisible(true);
        button3.setVisible(true);
        label.setVisible(false);

        frame.add(headerPanel);
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.add(firstPanel);
        frame.add(secondPanel);
        frame.add(thirdPanel);
        frame.add(label);




        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==button1)
                {

                    label.setVisible(true);
                    firstPanel.add(label);

                }
            }

        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==button2)
                {
                    label.setVisible(true);
                    secondPanel.add(label);

                }
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==button3)
                {
                    label.setVisible(true);
                    thirdPanel.add(label);

                }
            }
        });



    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button1)
        {
            firstPanel.add(label);
        }
        else if(e.getSource()==button2)
        {
            secondPanel.add(label);
        }
        thirdPanel.add(label);
    }

}