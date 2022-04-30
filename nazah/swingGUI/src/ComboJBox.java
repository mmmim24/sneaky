import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComboJBox extends JFrame implements ActionListener {
    JComboBox comboBox;
    public ComboJBox()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        String[] animals = {"dog","cat","bird"};
        comboBox = new JComboBox(animals);
        comboBox.addActionListener(this);
        comboBox.setEditable(true); /// search for what we need
        comboBox.addItem("horse");
        comboBox.insertItemAt("pig",4);
        comboBox.setSelectedIndex(4); // item on the checkbox
        comboBox.removeItem("cat");



        this.add(comboBox);
        this.pack();
        this.setVisible(true);

    }

    public static void main(String[] args) {
        new ComboJBox();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==comboBox)
        {
            System.out.println(comboBox.getSelectedIndex());
        }
    }
}
