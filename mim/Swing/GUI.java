import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI implements ActionListener{
	
	private int count = 0;
	private JFrame frame;
	private JPanel panel;
	private	JButton button;
	private JLabel label;
	
	public GUI() {
		frame = new JFrame(); 
		
		button = new JButton("BigSad");
		button.addActionListener(this);
		
		label = new JLabel();
		
		panel = new JPanel();
		
		panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
		panel.setLayout(new GridLayout(0,1));
		panel.add(button);
		panel.add(label); 
		
		frame.add(panel,BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Our GUI");
		frame.pack();
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		new GUI();
	}
	
	public void actionPerformed(ActionEvent e) {
		count++;
		label.setText("sedlyf count: "+count+" days");
	}
	
}
