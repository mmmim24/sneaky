import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectFileDemo extends JFrame implements ActionListener {
    JButton button;
    public SelectFileDemo() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());



        button = new JButton("Select file");
        button.addActionListener(this);



        this.add(button);
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new SelectFileDemo();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==button)
        {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.showOpenDialog(null); // e;ecy fo;e to open

        }

    }
}
