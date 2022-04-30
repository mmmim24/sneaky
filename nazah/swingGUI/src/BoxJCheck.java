import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoxJCheck extends JFrame implements ActionListener {

    JButton button;
    JCheckBox checkBox;

    public BoxJCheck()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());


        button = new JButton("Submit");
        button.addActionListener(this);



        checkBox = new JCheckBox();
        checkBox.setText("I am not not a robot");
        checkBox.setFocusable(false);
        checkBox.setFont(new Font(null, Font.PLAIN,35));


        this.add(button);
        this.add(checkBox);
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new BoxJCheck();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==button)
        {
            System.out.println(checkBox.isSelected());
        }

    }
}
