import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FieldJText extends JFrame implements ActionListener {
    JButton button;
    JTextField textField;
    public FieldJText ()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        button = new JButton("Submit");
        button.addActionListener(this);

        textField = new JTextField();
        textField.setPreferredSize(new Dimension(250,40));
        textField.setFont(new Font("Consolas",Font.PLAIN,35));
        textField.setForeground(new Color(0x0072B5));
        textField.setBackground(Color.DARK_GRAY);
        textField.setCaretColor(Color.white);
        textField.setEditable(false);


        this.add(textField);
        this.add(button);
        this.pack(); // size adjusts to components
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new FieldJText();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button)
        {
            System.out.println("welcome " + textField.getText());

        }
    }
}
