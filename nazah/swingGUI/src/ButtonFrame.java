import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonFrame extends JFrame implements ActionListener{
    JButton button = new JButton();
    JLabel label;
    ButtonFrame()
    {
        ImageIcon imageIcon = new ImageIcon("E://Pictures//pic.png");
        ImageIcon imageIcon1 = new ImageIcon("E://Pictures//java.png");



        label = new JLabel();
        label.setIcon(imageIcon1);
        label.setBounds(150,250,150,150);
        label.setVisible(false);


        button.setBounds(100,100,250,100);
        button.addActionListener(this);
        button.setText("I am a button");
        button.setFocusable(false); //// text tar box shoray de
        button.setIcon(imageIcon);
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.BOTTOM);
        button.setFont(new Font("Comic Sans",Font.BOLD,25));
        button.setIconTextGap(-15);
        button.setForeground(Color.cyan);
        button.setBackground(Color.blue);
        button.setBorder(BorderFactory.createEtchedBorder());
//        button.setEnabled(false); // disable a button


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(500,500);
        this.setVisible(true);
        this.add(button);
        this.add(label);





    }
// to only make the button accessible once, you can add setEnabled(false) to the actionPerformed method so that it gets disabled after clicking on it once.
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button){
            label.setVisible(true);
        }
    }
}
