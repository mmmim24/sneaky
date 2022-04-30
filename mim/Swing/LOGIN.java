// package test;
import javax.swing.*;
import java.awt.event.*;



public class LOGIN implements ActionListener{
	
	private static JLabel userLabel;
	private static JLabel passwordLabel;
	private static JLabel success;
	private static JTextField userText;
	private static JPasswordField passwordText;
	private static JButton button;
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("LOGIN or SIGNUP");
		
		
		JPanel panel = new JPanel();
		frame.add(panel);
		panel.setLayout(null);
		
		userLabel = new JLabel("USER");
		userLabel.setBounds(20, 20, 80, 25);
		panel.add(userLabel);
		passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(20,50,80,25);
		panel.add(passwordLabel);
		
		userText = new JTextField();
		userText.setBounds(100,20,165,25);
		panel.add(userText);
		passwordText = new JPasswordField();
		passwordText.setBounds(100,50,165,25);
		panel.add(passwordText);
		
		button = new JButton("Login");
		button.setBounds(20, 100, 245, 25);
		button.addActionListener(new LOGIN());
		panel.add(button);
		
		success =  new JLabel("");
		success.setBounds(20, 133, 245, 25);
		panel.add(success);
		
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String user = userText.getText();
		String pass = passwordText.getText();
		System.out.println(user+","+pass);
		if(user.equals("MMMim")&&pass.contentEquals("119119")) {
			success.setText("Login successful!");
		}
		else {
			success.setText("Invalid username or password");
			
		}
	}

}
