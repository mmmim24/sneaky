import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorChooserDemo extends JFrame implements ActionListener {

    JButton button;
    JLabel label;

    public ColorChooserDemo() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        button = new JButton("Pick a color");
        button.addActionListener(this);


        label = new JLabel("This is some text");
        label.setBackground(Color.WHITE);
        label.setFont(new Font("MV Boli", Font.PLAIN,100));
        label.setOpaque(true);


        this.add(button);
        this.add(label);
        this.pack();
        this.setVisible(true);

    }

    public static void main(String[] args) {
        new ColorChooserDemo();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button)
        {
            JColorChooser colorChooser = new JColorChooser();

            Color color = JColorChooser.showDialog(null,"Pick a color, i guess", Color.black);

            label.setForeground(color);

        }
    }
}
